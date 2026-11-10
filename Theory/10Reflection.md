# Reflection

- [리플렉션](#리플렉션)
- [클래스 정보 읽기](#클래스-정보-읽기)
- [객체 생성과 호출](#객체-생성과-호출)
- [어노테이션](#어노테이션)
- [사용자 정의 어노테이션](#사용자-정의-어노테이션)
- [어노테이션 값 주입](#어노테이션-값-주입)

<br>

---

### 리플렉션

> 리플렉션(Reflection)은 실행 중인 프로그램의 클래스, 인터페이스, 메서드, 필드 정보를 동적으로 얻고 조작하는 API이다. 컴파일할 때 알 수 없는 클래스의 정보도 얻고, 그 클래스의 메서드와 필드에 접근해 호출할 수 있다. `java.lang.reflect` 패키지를 사용한다.

<br>

| 클래스 | 설명 |
|---|---|
| `Class` | 클래스의 메타데이터. 이름, 필드, 메서드, 생성자 정보를 얻음 |
| `Field` | 필드. 이름, 자료형, 접근 제어자를 얻고 값을 읽거나 바꿈 |
| `Method` | 메서드. 이름, 매개변수, 반환형을 얻고 호출(`invoke`)함 |
| `Constructor` | 생성자. 호출해 객체를 만듦(`newInstance`) |

<br>

> 일반 개발에서는 자주 쓰지 않지만 프레임워크, 라이브러리, 테스트 도구처럼 동적인 환경이 필요한 곳에서 유용하다. 성능 문제가 있으므로 가능하면 정적인 방법으로 코드를 작성한다.

<br>

- 예제 코드: [리플렉션 개념](../JAVA03/src/Ch14Reflection/C00ReflectionInfo.java)

---

### 클래스 정보 읽기

> `Class.forName("클래스 이름")`으로 `Class` 객체를 얻고 `getDeclaredFields()`, `getDeclaredConstructors()`, `getDeclaredMethods()`로 `private`을 포함한 필드, 생성자, 메서드 목록을 읽는다.

<br>

```java
Class<?> clazz = Class.forName("java.lang.String");
for (Field field : clazz.getDeclaredFields()) System.out.println(field);
```

<br>

- 예제 코드: [리플렉션 기초](../JAVA03/src/Ch14Reflection/C01ReflectionBasic.java)

---

### 객체 생성과 호출

> 생성자는 `getConstructors()`로 찾아 `newInstance(값...)`로 객체를 만들고, 메서드는 `getDeclaredMethod(이름, 매개변수 타입...)`로 찾아 `invoke(객체, 값...)`로 실행하며, 필드는 `getDeclaredField(이름)`으로 찾아 `set(객체, 값)`으로 바꾼다. `private` 필드는 `setAccessible(true)`를 먼저 호출해야 접근할 수 있다. 클래스 정보만 받아 객체를 만드는 방식은 프레임워크가 객체를 만들 때 쓰는 방식이다.

<br>

```java
Class<?> clazz = Class.forName("Ch14Reflection.Simple");
Object ob = clazz.getConstructors()[0].newInstance("홍길동", 30, "대구");
Method setName = clazz.getDeclaredMethod("setName", String.class);
setName.invoke(ob, "티모");
```

<br>

- 예제 코드: [리플렉션으로 객체 만들기와 호출](../JAVA03/src/Ch14Reflection/C02ReflectionInvoke.java)

---

### 어노테이션

> 어노테이션(Annotation, `@`)은 다른 프로그램에게 유용한 정보를 제공하는 표시이다. 주석처럼 보이지만 컴파일러와 실행 환경이 읽어 동작에 쓴다. 컴파일러에게 문법 검사 정보를 주고, 빌드할 때 코드를 자동 생성하게 하고, 실행 중에 특정 기능을 수행하게 한다(리플렉션으로 읽음).

<br>

| 종류 | 어노테이션 |
|---|---|
| 표준 | `@Override`(오버라이딩), `@Deprecated`(사용하지 않을 대상), `@FunctionalInterface`, `@SuppressWarnings`(경고 숨김), `@SafeVarargs` |
| 메타 | `@Target`(적용 대상), `@Retention`(유지 기간), `@Documented`, `@Inherited`, `@Repeatable` |
| 사용자 정의 | `@interface` 로 직접 정의 |

<br>

- 예제 코드: [어노테이션 개념](../JAVA03/src/Ch19Annotation/C00AnnotationInfo.java)

---

### 사용자 정의 어노테이션

> `@interface`로 어노테이션을 정의한다. 속성은 메서드 모양으로 선언하고 `default`로 기본값을 준다. `@Retention(RUNTIME)`이어야 실행 중에 읽을 수 있고, `@Target`은 `TYPE`(클래스), `FIELD`(멤버 변수), `METHOD`(메서드) 중에서 적용 대상을 정한다. 클래스에 붙은 어노테이션은 `getAnnotation(어노테이션.class)`로 읽고 속성값은 메서드처럼 호출한다.

<br>

```java
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface C01CustomAnnotation {
    String value() default "HELLO WORLD";
    int number() default 1;
}
```

<br>

- 예제 코드: [사용자 정의 어노테이션](../JAVA03/src/Ch19Annotation/C01CustomAnnotation.java)
- 예제 코드: [어노테이션 값 읽기](../JAVA03/src/Ch19Annotation/C01AnnotationRead.java)

---

### 어노테이션 값 주입

> 부모 클래스의 생성자에서 하위 클래스에 붙은 어노테이션 값을 리플렉션으로 읽고, `@C02BindFrom`이 붙은 필드에 채워 넣는다. 필드 이름과 어노테이션 속성 이름이 다르면 `BindFrom`의 값으로 연결한다. 기본형과 래퍼형(`int`와 `Integer`)은 서로 넣을 수 있게 처리한다. 스프링 같은 프레임워크가 값을 주입하는 원리를 단순화한 연습이다.

<br>

- 예제 코드: [주입용 어노테이션](../JAVA03/src/Ch19Annotation/C02CustomAnnotation.java)
- 예제 코드: [필드 연결 어노테이션](../JAVA03/src/Ch19Annotation/C02BindFrom.java)
- 예제 코드: [값 자동 주입 클래스](../JAVA03/src/Ch19Annotation/C02AnnotationInjected.java)
- 예제 코드: [어노테이션 주입 사용](../JAVA03/src/Ch19Annotation/C02AnnotationInject.java)

---

### Link
[Java Reflection](https://docs.oracle.com/javase/tutorial/reflect/index.html)
