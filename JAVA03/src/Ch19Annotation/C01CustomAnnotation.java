package Ch19Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// =======================================
// 사용자 정의 어노테이션
// @interface 로 값(value, number, isOpen)을 가진 어노테이션 정의
// =======================================

@Retention(RetentionPolicy.RUNTIME) // RUNTIME : 실행 중에도 유지되어 리플렉션으로 읽을 수 있음
@Target({ElementType.TYPE,ElementType.METHOD})  // 적용 대상 : 클래스(TYPE)와 메서드(METHOD)

// @interface : 어노테이션을 정의하는 키워드. 속성은 메서드 모양으로 선언하고 default 로 기본값을 줌
public @interface C01CustomAnnotation {
	String value() default "HELLO WORLD";
	int number() default 1;
	boolean isOpen() default false;
}

// ElementType.TYPE: 클래스, 인터페이스, 열거형(enum)... 적용
// ElementType.FIELD: 멤버 변수에 적용
// ElementType.METHOD: 메서드에 적용
