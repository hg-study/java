# Type Cast

- [형변환](#형변환)
- [자동 형변환](#자동-형변환)
- [강제 형변환](#강제-형변환)
- [연산 중 형변환](#연산-중-형변환)
- [문자열과 형변환](#문자열과-형변환)

<br>

---

### 형변환

> 연산할 때 자료형이 서로 다르면 자료형을 맞추는 작업이 필요하다. 시스템이 알아서 바꾸는 자동(암시적) 형변환과 프로그래머가 직접 지정하는 강제(명시적) 형변환이 있다.

---

### 자동 형변환

> 값의 범위가 더 넓은 자료형으로 옮길 때는 데이터 손실이 없어서 자동으로 변환된다.

<br>

```
byte(1) → short(2) → int(4) → long(8) → float(4) → double(8)
                       ↑
                     char(2)
```

<br>

```java
int intValue = byteValue;          // byte → int
long longValue = intValue;         // int → long
float floatValue = longValue;      // long → float
double doubleValue = floatValue;   // float → double
```

<br>

- 예제 코드: [자동 형변환](../JAVA01/src/Ch02TypeCast/C01AutoCast.java)

---

### 강제 형변환

> 범위가 넓은 자료형을 좁은 자료형에 넣으려면 캐스트 연산자 `(자료형)`을 붙인다. 넘치는 비트를 버리기 때문에 데이터 손실이 생길 수 있다.

<br>

```java
int num1 = 129;               // 00000000 00000000 00000000 1000_0001
byte ch1 = (byte) num1;       // 뒤 8비트만 남아 -128 + 1 = -127
```

<br>

<span style="color:brown">`char n1 = 60000`을 `(short) n1`로 바꾸면 `short`의 최대값(32767)을 넘어 음수(-5536)가 된다. 비트열은 같지만 부호가 있는 타입으로 해석하기 때문이다.</span>

<br>

- 예제 코드: [강제 형변환](../JAVA01/src/Ch02TypeCast/C02ExplicitCast.java)
- 예제 코드: [비트 손실](../JAVA01/src/Ch02TypeCast/C03ByteOverflow.java)
- 예제 코드: [char와 short](../JAVA01/src/Ch02TypeCast/C06CharShortCast.java)

---

### 연산 중 형변환

> 연산에 참여하는 변수 중 가장 범위가 큰 자료형을 기준으로 모두 자동 변환된다. `int`보다 작은 타입(`byte`, `short`, `char`)은 계산의 효율과 정확도를 위해 먼저 `int`로 바꾼 뒤 계산한다.

<br>

| **연산** | **결과 타입** |
| --- | --- |
| `byte + byte`, `short + short`, `char + int` | `int` |
| `int + long` | `long` |
| `int + double` | `double` |

<br>

```java
byte result1 = (byte)(x + y);     // x + y는 이미 int. 다시 byte에 넣으려면 캐스트 필요
double dnum1 = (double)num1 / num2;   // int끼리 나누면 소수점이 버려지므로 하나를 double로 바꿔 2.5
double dnum2 = (num1 * 1.0) / num2;   // 1.0을 곱해 double로 바꾸는 방법
```

<br>

- 예제 코드: [연산 중 형변환](../JAVA01/src/Ch02TypeCast/C04OperandCast.java)
- 예제 코드: [정수 나눗셈과 실수](../JAVA01/src/Ch02TypeCast/C05IntDivision.java)

---

### 문자열과 형변환

> 문자열과 다른 타입을 `+`로 연결하면 숫자도 문자열로 바뀌어 이어 붙는다. 문자열을 숫자로 바꾸려면 Wrapper 클래스의 메서드(`Integer.parseInt()` 등)를 사용한다. 웹 폼에서 전달받은 값은 모두 문자열이라 이 변환이 자주 필요하다.

<br>

| **코드** | **결과** |
| --- | --- |
| `"문자열1" + "문자열2"` | `문자열1문자열2` |
| `"문자열1" + 2` | `문자열12`(숫자를 문자열로 이어 붙임) |
| `',' + '!' + "문자열"` | `77문자열`(문자끼리는 유니코드 값 `44 + 33`을 더함) |
| `"10" + "20"` | `1020` |
| `Integer.parseInt("10")` | 정수 `10` |

<br>

- 예제 코드: [문자열과 형변환](../JAVA01/src/Ch02TypeCast/C07StringCast.java)
- 예제 코드: [확인 문제](../JAVA01/src/Ch02TypeCast/C08Review.java)

<br>

---

<br>

**Type Cast 요약**

<aside>

> 자동: 범위가 넓은 타입으로 옮길 때, byte → short → int → long → float → double <br>
강제: (자료형) 캐스트, 데이터 손실 주의 <br>
연산: int보다 작은 타입은 int로, 가장 큰 타입 기준으로 변환 <br>
문자열: + 연결은 문자열로, 숫자 변환은 Integer.parseInt()

</aside>

<br>

### Link
[Java 형변환](https://docs.oracle.com/javase/specs/jls/se21/html/jls-5.html)
