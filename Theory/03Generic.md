# Generic

- [제네릭](#제네릭)
- [타입 제한](#타입-제한)
- [제네릭 메서드](#제네릭-메서드)
- [제네릭과 리플렉션 Repository](#제네릭과-리플렉션-repository)
- [와일드카드와 연습 문제](#와일드카드와-연습-문제)

<br>

---

### 제네릭

> 제네릭(Generics)은 클래스나 메서드에서 사용할 자료형을 사용하는 시점에 지정하는 문법이다. 형변환 없이 타입 안정성을 얻는다. `<T>`처럼 타입 매개변수를 선언하고, 타입 매개변수는 쉼표로 여러 개 둘 수 있다.

<br>

```java
class PopCorn<T> {
    private T flavor;
    PopCorn(T flavor) { this.flavor = flavor; }
}
PopCorn<Caramel> ob = new PopCorn<Caramel>(new Caramel());
```

<br>

- 예제 코드: [제네릭 클래스](../JAVA03/src/Ch03Generic/C02GenericPopcorn.java)
- 예제 코드: [타입 매개변수 2개](../JAVA03/src/Ch03Generic/C03GenericCouple.java)

---

### 타입 제한

> `<T extends 상위클래스>`는 `T`에 올 수 있는 자료형을 상위 클래스와 그 하위 클래스로 제한한다. 상속 관계에 포함되지 않은 클래스를 넣으면 컴파일 에러가 난다.

<br>

```java
class Bun<T extends BunFilling> { ... }
Bun<RedBean> ok = new Bun<RedBean>(new RedBean());
// Bun<MintChoco> 는 BunFilling 을 상속하지 않아 에러
```

<br>

- 예제 코드: [타입 제한](../JAVA03/src/Ch03Generic/C01GenericBound.java)

---

### 제네릭 메서드

> 제네릭 메서드는 반환형 앞에 `<T>`를 선언해 메서드 단위로 타입을 지정하는 메서드이다. `Object[]`를 받는 방식과 달리 타입을 제한할 수 있다.

<br>

```java
public static <T extends Animal> void printGeneric(T[] arr) {
    for (T el : arr) System.out.println(el);
}
```

<br>

- 예제 코드: [제네릭 메서드](../JAVA03/src/Ch03Generic/C04GenericMethod.java)

---

### 제네릭과 리플렉션 Repository

> 엔티티 클래스(테이블 한 줄에 해당하는 데이터 클래스)의 필드 정보를 리플렉션으로 읽어 CREATE 문을 만들어 테이블을 자동 생성하는 Repository이다. `Class.forName`으로 클래스 정보를 얻고 `getDeclaredFields()`로 필드 이름과 자료형을 읽는다. 스프링 JPA의 동작 원리를 단순화한 연습이다.

<br>

- 예제 코드: [리플렉션으로 필드 읽기](../JAVA03/src/Ch03Generic/C05Reflection.java)
- 예제 코드: [제네릭 Repository](../JAVA03/src/Ch03Generic/C05GenericRepository.java)
- 예제 코드: [Repository 사용](../JAVA03/src/Ch03Generic/C05RepositoryMain.java)

---

### 와일드카드와 연습 문제

> 제네릭은 상속 관계가 있어도 타입 인자가 같아야 대입할 수 있다(`Box<Object> b = new Box<String>()`은 에러). `?`는 모든 타입을 뜻하는 와일드카드이고 `? extends T`는 T와 그 하위 타입만 받는다. 와일드카드는 객체 생성에는 쓸 수 없다.

<br>

> 자바의 정석 12장 연습 문제를 풀어 정답 근거를 정리했다. 두 리스트를 병합하는 메서드는 `<T extends Product> ArrayList<T> merge(ArrayList<? extends T>, ArrayList<? extends T>)` 형태의 제네릭 메서드로 만든다.

<br>

- 예제 코드: [제네릭 연습 문제](../JAVA03/src/Ch03Generic/C06GenericQuiz.java)

---

### Link
[Java Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
