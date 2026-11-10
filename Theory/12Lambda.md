# Lambda

- [람다식](#람다식)
- [함수형 인터페이스](#함수형-인터페이스)
- [메서드 참조](#메서드-참조)
- [클로저](#클로저)

<br>

---

### 람다식

> 람다식(Lambda Expression)은 이름 없는 함수를 식 하나로 표현한 문법이다. `(매개변수) -> { 실행문 }` 형태이며 컬렉션의 정렬과 순회에 자주 쓰인다. 매개변수가 하나면 괄호를, 실행문이 한 줄이면 중괄호와 세미콜론을 생략할 수 있다.

<br>

```java
list.forEach((el) -> { System.out.println(el); });    // 기본 형태
list.forEach(el -> System.out.println(el));           // 괄호와 중괄호 생략
list.forEach(System.out::println);                    // 메서드 참조
list.sort((a, b) -> b.getAge() - a.getAge());         // 나이 내림차순 정렬
```

<br>

- 예제 코드: [람다식으로 정렬과 순회](../JAVA03/src/Ch16Lambda/C01LambdaSort.java)

---

### 함수형 인터페이스

> 함수형 인터페이스는 추상 메서드가 하나뿐인 인터페이스이고, 람다식으로 구현할 수 있다. 람다식은 인터페이스 메서드의 매개변수와 반환형에 맞춰 작성한다. 사칙연산 문제처럼 같은 형태의 연산을 람다식으로 바꿔 끼울 수 있다.

<br>

```java
interface Calculator { int calculate(int num1, int num2); }
Calculator add = (a, b) -> { return a + b; };
add.calculate(10, 20);      // 30
```

<br>

- 예제 코드: [함수형 인터페이스와 람다식](../JAVA03/src/Ch16Lambda/C02FunctionalInterface.java)
- 예제 코드: [계산기 함수형 인터페이스](../JAVA03/src/Ch16Lambda/C03Calculator.java)

---

### 메서드 참조

> 메서드 참조(`::`)는 람다식이 기존 메서드를 호출하기만 할 때 `클래스::메서드` 형태로 줄여 쓰는 문법이다.

<br>

| 종류 | 예 |
|---|---|
| 정적 메서드 | `Integer::parseInt` |
| 인스턴스 메서드 | `String::toUpperCase`, `System.out::println` |
| 생성자 | `ArrayList::new`, `Person::new` |

<br>

- 예제 코드: [메서드 참조](../JAVA03/src/Ch16Lambda/C04MethodReference.java)

---

### 클로저

> 클로저(Closure)는 람다식이 자신이 만들어진 곳 바깥의 변수를 캡처해 기억하고 사용하는 기능이다. 캡처한 지역 변수는 값이 바뀌지 않는 변수(`final` 또는 사실상 `final`)여야 한다. 메서드가 끝난 뒤에도 캡처한 값이 유지된다.

<br>

> 값을 바꾸려면 참조로 접근하는 공간을 쓴다. 배열 요소(배열 트릭), 인스턴스 변수, `static` 변수는 람다 안에서 바꿀 수 있고, 람다마다 자기만의 배열(주머니)을 가지면 호출할 때마다 값이 이어서 증가하는 가변 클로저가 된다.

<br>

```java
private static TickBox makeTicker(int start) {
    int[] n = { start };        // 람다가 캡처해 들고 다닐 주머니
    return () -> n[0]++;        // 현재값을 돌려주고 1 증가
}
```

<br>

> 자바스크립트에서도 같은 개념을 쓴다. 함수가 만들어진 환경의 변수(`count`)를 반환된 함수가 기억해 호출할 때마다 1씩 늘린다.

<br>

- 예제 코드: [클로저 기초](../JAVA03/src/Ch16Lambda/C05ClosureCapture.java)
- 예제 코드: [가변 클로저](../JAVA03/src/Ch16Lambda/C06ClosureMutable.java)
- 예제 코드: [자바스크립트 클로저 카운터](../JAVA03/src/Ch16Lambda/C07ClosureCounter.html)

---

### Link
[Java Lambda](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
