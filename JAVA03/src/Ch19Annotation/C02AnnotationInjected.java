package Ch19Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// =======================================
// 어노테이션 값 자동 주입
// 부모 생성자에서 클래스 어노테이션의 값을 필드에 채우는 추상 클래스
// =======================================

// 상속받은 클래스를 만들 때 부모 생성자가 호출되어 하위 클래스의 어노테이션 값을 리플렉션으로 읽고 @BindFrom 이 붙은 필드에 채워 넣음 (스프링 같은 프레임워크가 값을 주입하는 원리)
abstract class C02AnnotationInjected {

    protected C02AnnotationInjected() {
        injectFromClassAnnotation();
    }

    private void injectFromClassAnnotation() {
        Class<?> clazz = this.getClass();
        C02CustomAnnotation ann = clazz.getAnnotation(C02CustomAnnotation.class);
        if (ann == null) return; // 어노테이션이 없으면 아무것도 하지 않음

        // 어노테이션의 속성 메서드를 찾을 것이므로 대상 타입을 어노테이션 클래스로 고정함
        Class<?> annType = C02CustomAnnotation.class;

        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);

            C02BindFrom bind = f.getAnnotation(C02BindFrom.class);
            String attrName = (bind != null) ? bind.value() : f.getName();

            try {
                Method m = annType.getMethod(attrName); // CustomAnnotation의 속성 메서드
                Object attrVal = m.invoke(ann);

                if (isAssignable(f.getType(), attrVal)) {
                    f.set(this, attrVal);
                }
            } catch (NoSuchMethodException ignore) {
                // 필드명/매핑명이 애노테이션 속성에 없으면 스킵
            } catch (Exception e) {
                throw new RuntimeException("필드 주입 실패: " + f.getName(), e);
            }
        }
    }

    // 어노테이션 속성값을 필드에 넣을 수 있는지 확인함. int 와 Integer 처럼 기본형과 래퍼형은 서로 넣을 수 있는 것으로 처리함
    private static boolean isAssignable(Class<?> fieldType, Object val) {
        if (val == null) return !fieldType.isPrimitive();
        Class<?> valType = val.getClass();
        if (fieldType.isAssignableFrom(valType)) return true;
        if (!fieldType.isPrimitive()) return false;

        return (fieldType == int.class && valType == Integer.class)
            || (fieldType == boolean.class && valType == Boolean.class)
            || (fieldType == long.class && valType == Long.class)
            || (fieldType == double.class && valType == Double.class)
            || (fieldType == float.class && valType == Float.class)
            || (fieldType == char.class && valType == Character.class)
            || (fieldType == byte.class && valType == Byte.class)
            || (fieldType == short.class && valType == Short.class);
    }
}
