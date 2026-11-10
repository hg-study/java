package Ch19Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// =======================================
// 필드 연결 어노테이션
// 필드에 붙여 주입할 어노테이션 속성의 이름을 지정
// =======================================

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
// 필드 이름과 어노테이션 속성 이름이 다를 때 value 로 연결할 속성 이름을 지정함
public @interface C02BindFrom {
	String value();
}
