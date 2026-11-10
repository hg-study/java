# Exception

- [예외 처리](#예외-처리)
- [자주 만나는 예외](#자주-만나는-예외)
- [catch 순서와 Exception](#catch-순서와-exception)
- [throw와 throws](#throw와-throws)

<br>

---

### 예외 처리

> 예외(Exception)는 프로그램 실행 중 발생하는 오류이다. 처리하지 않으면 프로그램이 즉시 종료된다. `try - catch`는 `try` 블록에서 예외가 발생하면 해당 예외를 받는 `catch` 블록으로 넘어가 처리하고 프로그램을 계속 실행하게 한다. `finally`는 예외 발생 여부와 상관없이 마지막에 항상 실행된다.

<br>

```java
try {
    String str = null;
    str.toString();
} catch (NullPointerException e) {
    e.printStackTrace();    // 예외 종류, 메시지, 호출 경로 출력
} finally {
    System.out.println("항상 실행");
}
```

<br>

> 예외 객체에서 `getCause()`(원인), `getStackTrace()`(호출 경로)를 얻을 수 있고 `printStackTrace()`가 한꺼번에 출력한다.

<br>

- 예제 코드: [NullPointerException](../JAVA03/src/Ch02Exception/C01NullPointer.java)
- 예제 코드: [ArrayIndexOutOfBoundsException과 finally](../JAVA03/src/Ch02Exception/C02ArrayIndexBounds.java)

---

### 자주 만나는 예외

| 예외 | 발생 상황 |
|---|---|
| `NullPointerException` | `null` 인 참조변수로 메서드나 필드를 사용 |
| `ArrayIndexOutOfBoundsException` | 배열 범위를 벗어난 인덱스 사용 |
| `ArithmeticException` | 정수를 0으로 나눔 |
| `ClassCastException` | 실제 객체와 맞지 않는 클래스로 다운캐스팅 |

<br>

- 예제 코드: [ArithmeticException](../JAVA03/src/Ch02Exception/C03ArithmeticDivide.java)
- 예제 코드: [ClassCastException](../JAVA03/src/Ch02Exception/C04ClassCast.java)

---

### catch 순서와 Exception

> `Exception`은 모든 예외 클래스의 상위 클래스라서 `catch`에 쓰면 하위 예외를 한꺼번에 받는다. `catch` 블록이 여러 개여도 하나의 블록만 실행되므로, 상위 예외는 가장 마지막 `catch`에 써야 한다.

<br>

```java
try { ... }
catch (NullPointerException e1) { ... }
catch (ArrayIndexOutOfBoundsException e2) { ... }
catch (Exception e3) { ... }        // 마지막에
```

<br>

- 예제 코드: [상위 예외로 처리](../JAVA03/src/Ch02Exception/C05ExceptionCatch.java)

---

### throw와 throws

> `throw`는 예외 객체를 직접 만들어 발생시키는 문장이고, `throws`는 메서드 선언부에 써서 그 메서드에서 발생할 수 있는 예외를 호출한 쪽에서 처리하도록 넘기는 키워드이다.

<br>

```java
void func() throws Exception {
    throw new ArithmeticException();
}
```

<br>

- 예제 코드: [throw와 throws](../JAVA03/src/Ch02Exception/C06ThrowThrows.java)

---

### Link
[Java 예외](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
