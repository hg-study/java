# Variable

- [변수](#변수)
- [자료형](#자료형)
- [상수](#상수)

<br>

---

### 변수

> 변수는 값을 저장하는 메모리 공간에 이름을 붙인 것이다. 자료형은 공간의 크기와 저장할 수 있는 값의 형태를 정하고, 변수명은 그 공간에 접근하는 이름이다. 대입 연산자 `=`는 오른쪽 값을 먼저 처리(저장 또는 연산)한 다음 왼쪽 공간에 넣는다.

<br>

```java
int num1;                  // int(4byte) 크기의 공간을 만들고 num1이라는 이름을 붙임(선언)
num1 = 10;                 // 리터럴 상수 10을 상수 pool에 저장하고 num1 공간에 복사(대입)
int num2 = 4;              // 선언과 초기화를 한 번에
int num3 = num1 + num2;    // num1과 num2를 더한 결과를 num3 공간에 저장
System.out.println(num3);  // 14
```

<br>

- 예제 코드: [변수](../JAVA01/src/Ch01Variable/C04Variable.java)

---

### 자료형

> 자료형은 데이터를 저장할 공간을 만들고 저장할 값의 형태를 제한하는 예약어다. 기본 자료형은 정수, 실수, 문자, 논리 타입으로 나뉜다.

<br>

| **분류** | **자료형** | **크기** | **설명** |
| --- | --- | --- | --- |
| 정수 | `byte` | 1byte | -128 ~ 127 |
| 정수 | `short` | 2byte | -32768 ~ 32767 |
| 정수 | `int` | 4byte | 약 -21억 ~ 21억. 정수 리터럴의 기본 타입 |
| 정수 | `long` | 8byte | 리터럴에 접미사 `L` 필요 |
| 문자 | `char` | 2byte | 0 ~ 65535. 부호 없음(음수 불가), 문자의 유니코드 값 |
| 실수 | `float` | 4byte | 정밀도 6~9자리. 리터럴에 접미사 `F` 필요 |
| 실수 | `double` | 8byte | 정밀도 15~18자리. 실수 리터럴의 기본 타입 |
| 논리 | `boolean` | 1byte | `true`, `false`만 가능(0과 1 불가) |

<br>

<span style="color:brown">자바는 정수 리터럴을 무조건 `int`로 본다. `int` 범위를 넘는 값(예: `2150000000`)은 `L`을 붙여야 `long`으로 인식한다.</span>

<br>

**범위를 넘는 값**

`byte`에 `(byte)129`처럼 강제로 넣으면 넘치는 비트를 버려 `-127`이 된다. 데이터 손실 가능성이 있으면 자동으로 변환하지 않는다.

<br>

**실수의 저장 방식** 고정 소수점은 빠르지만 메모리를 낭비하고, 부동 소수점(기본)은 비교적 느리지만 공간을 효율적으로 쓴다. 실수는 오차가 생길 수 있어 `float`보다 `double`을 기본으로 쓴다.

<br>

**char와 정수** `char ch = 'a'`를 `(int)`로 바꾸면 유니코드 값 97이 나오고, 거꾸로 `char ch = 98`은 `'b'`다.

<br>

- 예제 코드: [자료형](../JAVA01/src/Ch01Variable/C05DataType.java)

---

### 상수

> 상수는 항상 같은 값이다. 이름이 없는 리터럴 상수와 이름이 있는 심볼릭 상수가 있다.

<br>

| **종류** | **설명** | **예시** |
| --- | --- | --- |
| 리터럴 상수 | 이름 없이 상수 pool에 저장되는 값 | `100`, `3.14`, `'a'` |
| 심볼릭 상수 | 이름을 붙이고 `final`로 변경을 막은 값 | `final double PI = 3.14;` |
| 리터럴 접미사 | 리터럴이 저장될 자료형을 지정 | `L`(long), `F`(float) |

<br>

**확인 문제**

| **코드** | **결과** | **이유** |
| --- | --- | --- |
| `byte var = 200;` | 오류 | `byte`는 127까지 |
| `char var = 'AB';` | 오류 | `char`는 한 문자만 |
| `char var = 65;` | 가능 | 정수를 유니코드 값으로 저장 |
| `float var = 3.14;` | 오류 | 실수 리터럴은 `double`이라 `3.14f` 필요 |
| `boolean var = 0;` | 오류 | `true`, `false`만 가능 |
| `int v2 = 1e2;` | 오류 | `1e2`는 실수(`double`) |

<br>

- 예제 코드: [상수](../JAVA01/src/Ch01Variable/C06Constant.java)
- 예제 코드: [확인 문제](../JAVA01/src/Ch01Variable/C07Review.java)

<br>

---

<br>

**Variable 요약**

<aside>

> 변수: 이름 붙인 메모리 공간, 선언 후 값을 대입 <br>
자료형: byte, short, int, long, char, float, double, boolean <br>
리터럴: 정수는 int, 실수는 double이 기본, long은 L, float는 F <br>
상수: final로 심볼릭 상수 선언

</aside>

<br>

### Link
[Java 기본 자료형](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
