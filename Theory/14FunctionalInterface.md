# Functional Interface

- [함수형 프로그래밍](#함수형-프로그래밍)
- [함수형 인터페이스 직접 만들기](#함수형-인터페이스-직접-만들기)
- [Function](#function)
- [표준 함수형 인터페이스](#표준-함수형-인터페이스)
- [Predicate](#predicate)

<br>

---

### 함수형 프로그래밍

> 함수형 프로그래밍은 함수를 값처럼 변수에 담고 인자로 넘기고 반환하며 조합해 프로그램을 만드는 방식이다. 람다식과 스트림은 함수형 프로그래밍을 자바에서 쓰기 위한 문법이다.

<br>

- 예제 코드: [함수형 프로그래밍 개념](../JAVA03/src/Ch18FunctionalInterface/C00FunctionalInfo.java)

---

### 함수형 인터페이스 직접 만들기

> 추상 메서드가 하나뿐인 인터페이스를 함수형 인터페이스라 하고, `@FunctionalInterface`로 명시하면 추상 메서드를 둘 이상 만들 때 컴파일 에러가 난다. 가변 인자(`Integer ...args`)를 받는 인터페이스도 람다식으로 구현할 수 있다.

<br>

```java
@FunctionalInterface
interface Func2 { int sum(Integer ...args); }
Func2 func2 = arr -> Arrays.stream(arr).reduce(0, (sum, item) -> sum + item);
```

<br>

> 사칙연산 문제는 합, 차, 곱, 나눗셈을 가변 인자 람다식과 스트림으로 구현한다. 차와 나눗셈은 큰 수에서 작은 수 순으로 정렬한 뒤 앞에서부터 차례로 계산한다(예: `sub(1,4,2,9)` 는 9, 4, 2, 1 로 정렬해 9-4-2-1 = 2).

<br>

- 예제 코드: [함수형 인터페이스 직접 만들기](../JAVA03/src/Ch18FunctionalInterface/C01FunctionalInterface.java)
- 예제 코드: [사칙연산 문제](../JAVA03/src/Ch18FunctionalInterface/C02CalcQuiz.java)
- 예제 코드: [사칙연산 문제 답](../JAVA03/src/Ch18FunctionalInterface/C02CalcQuizAnswer.java)

---

### Function

> `Function<입력, 출력>`은 하나의 인자를 받아 결과를 돌려주는 표준 함수형 인터페이스이다. `apply()`로 실행하고 `andThen()`으로 함수를 이어 붙여 앞 함수의 결과를 뒤 함수에 넘긴다. 함수를 반환하는 함수(커링)는 첫 인자를 받아 두 번째 인자를 받는 함수를 돌려주며, 안쪽 함수가 첫 인자를 캡처한다(클로저).

<br>

```java
Function<Integer, Integer> func1 = x -> x * x;
Function<Integer, Integer> func2 = x -> x + x;
Function<Integer, Integer> func5 = func1.andThen(func2);    // 10 -> 100 -> 200
Function<Integer, Function<Integer, Integer>> func8 = x -> n -> n + x;
func8.apply(10).apply(20);                                   // 30
```

<br>

> 리스트를 가공하는 연습: 길이가 5 이상인 문자열 개수(`filter` + `count`), 숫자의 제곱합(`map` + `reduce`), 각 문자열의 첫 글자를 대문자로 추출(`map` + `substring`)을 `Function`으로 만든다.

<br>

- 예제 코드: [Function](../JAVA03/src/Ch18FunctionalInterface/C03FunctionType.java)
- 예제 코드: [Function 으로 List 가공](../JAVA03/src/Ch18FunctionalInterface/C04FunctionList.java)

---

### 표준 함수형 인터페이스

> 자바는 자주 쓰는 람다 모양을 `java.util.function` 패키지에 표준 함수형 인터페이스로 미리 만들어 두었다. 실무에서는 인터페이스를 직접 만들기보다 이것을 쓰고, Stream과 Optional API와 자연스럽게 결합한다.

<br>

| 인터페이스 | 시그니처 | 메서드 | 직접 만든 예 |
|---|---|---|---|
| `Function<T, R>` | T → R | `apply` | `StrToInt` |
| `Consumer<T>` | T → void | `accept` | `StrConsumer` |
| `Supplier<T>` | () → T | `get` | `ListFactory` |
| `Predicate<T>` | T → boolean | `test` | (새로 등장) |
| `BiFunction<T, U, R>` | (T, U) → R | `apply` | 두 값을 받는 비교, 덧셈 |

<br>

> 숫자 전용 변형(`IntFunction`, `IntConsumer`, `IntPredicate`, `LongFunction`, `DoubleFunction` 등)은 박싱 비용을 줄인다.

<br>

- 예제 코드: [표준 함수형 인터페이스](../JAVA03/src/Ch18FunctionalInterface/C05StandardFunctionalInterfaces.java)

---

### Predicate

> `Predicate<T>`는 T를 받아 `boolean`을 돌려주는 조건 검사용 함수형 인터페이스이다. `test()`로 실행하며 `Stream.filter`와 가장 잘 어울린다. 조합 메서드로 `and`(둘 다 참), `or`(하나라도 참), `negate`(반대)를 쓰고, `Predicate.isEqual(값)`은 값과 같은지 검사하는 Predicate를 만든다.

<br>

```java
Predicate<Integer> isPositive = n -> n > 0;
Predicate<Integer> isEven     = n -> n % 2 == 0;
nums.stream().filter(isPositive.and(isEven)).collect(Collectors.toList());
```

<br>

- 예제 코드: [Predicate 문제](../JAVA03/src/Ch18FunctionalInterface/C06PredicateQuiz.java)

---

### Link
[java.util.function](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)
