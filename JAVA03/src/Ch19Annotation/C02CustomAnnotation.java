package Ch19Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// =======================================
// 사용자 정의 어노테이션 (주입용)
// 클래스에 값을 붙여 두고 필드로 자동 주입할 때 사용
// =======================================

@Retention(RetentionPolicy.RUNTIME)	// RUNTIME : 실행 중에도 유지되어 리플렉션으로 읽을 수 있음
// 적용 대상 : TYPE(클래스, 인터페이스, enum), FIELD(멤버 변수), METHOD(메서드) 중에서 지정함
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface C02CustomAnnotation {
	String value() default "HELLO WORLD";
	int number() default 1;
	boolean isOpen() default false;
}
