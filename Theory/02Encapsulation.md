# Encapsulation

- [접근 한정자와 정보 은닉](#접근-한정자와-정보-은닉)
- [캡슐화](#캡슐화)
- [this와 this()](#this와-this)
- [String 비교](#string-비교)
- [String 메모리와 메서드](#string-메모리와-메서드)

<br>

---

### 접근 한정자와 정보 은닉

> 접근 한정자는 클래스와 멤버의 접근 범위를 제한하는 예약어이다.

<br>

| 한정자 | 접근 가능 범위 |
|---|---|
| `public` | 모든 클래스 |
| `protected` | 같은 패키지이거나 상속 관계인 클래스 |
| default(기본) | 같은 패키지의 클래스 |
| `private` | 해당 클래스 안 |

<br>

> 정보 은닉은 필드를 `private`로 숨기고 getter(값 읽기)와 setter(값 쓰기) 메서드로만 접근하게 하는 방법이다. 값을 바꾸는 경로를 한 곳으로 모아 잘못된 값이 들어오는 것을 막을 수 있다.

<br>

```java
private String name;

public String getName() { return this.name; }
public void setName(String name) { this.name = name; }
```

<br>

<span style="color:brown">이클립스에서는 오른쪽 마우스 - 소스작업 - Generate Getters and Setters, Generate Constructors using Fields로 자동 생성한다.</span>

<br>

- 예제 코드: [정보 은닉](../JAVA02/src/Ch02Encapsulation/C01InfoHiding.java)
- 예제 코드: [프로필 문제](../JAVA02/src/Ch02Encapsulation/C06Profile.java)

---

### 캡슐화

> 캡슐화는 특정 목적의 기능에 필요한 세부 기능들을 하나로 묶어 처리하는 방법이다. 세부 공정이 밖으로 노출되지 않도록 정보 은닉(`private`)과 함께 쓰는 경우가 많지만 필수는 아니다. 각 공정을 정확히 이해해야 묶을 수 있다.

<br>

```java
class Engine {
    private void intake() {...}
    private void compress() {...}
    private void explode() {...}
    private void exhaust() {...}

    public void engineStart() {     // 공정을 하나의 기능으로 묶음
        intake(); compress(); explode(); exhaust();
    }
}
```

<br>

> 사용하는 쪽은 세부 공정을 몰라도 `engineStart()` 하나로 실행한다.

<br>

- 예제 코드: [캡슐화](../JAVA02/src/Ch02Encapsulation/C02Encapsulation.java)

---

### this와 this()

> `this`는 생성된 객체 자기 자신의 위치 정보(메모리 주소)를 가리키는 예약어이다. `this.멤버변수명`은 멤버 변수와 같은 이름의 지역 변수를 구별할 때 쓰고, `this()`는 오버로딩된 다른 생성자를 호출할 때 쓴다.

<br>

```java
public C03Simple() {
    this(10, 10);                       // x, y 를 받는 생성자 호출
}
public C03Simple(int x, int y) {
    this.x = x;
    this.y = y;
}
```

<br>

<span style="color:brown">`this()`는 생성자의 첫 줄에만 쓸 수 있다. 호출된 안쪽 생성자가 먼저 끝나고 바깥 생성자의 나머지 코드가 이어서 실행된다.</span>

<br>

- 예제 코드: [this와 this()](../JAVA02/src/Ch02Encapsulation/C03This.java)

---

### String 비교

> 리터럴(`"java"`)은 문자열 상수 풀에 저장되어 같은 값이면 하나를 공유한다. `new String("java")`는 호출할 때마다 힙에 새 객체를 만든다. `==`는 참조형에서 주소값이 같은지 비교하고, `equals()`는 주소와 상관없이 문자열 내용이 같은지 비교한다.

<br>

```java
String str1 = "java";
String str2 = "java";
String str3 = new String("java");

str1 == str2        // true  : 상수 풀의 같은 주소
str1 == str3        // false : 상수 풀과 힙으로 주소가 다름
str1.equals(str3)   // true  : 내용이 같음
```

<br>

<span style="color:brown">문자열 내용을 비교할 때는 항상 `equals()`를 사용한다.</span>

<br>

- 예제 코드: [문자열 비교](../JAVA02/src/Ch02Encapsulation/C04StringCompare.java)

---

### String 메모리와 메서드

> 리터럴은 상수 풀에, `new`와 연산 결과(`+`, `concat`)는 힙에 저장된다. `+`로 문자열을 덧붙이면 더할 때마다 새 주소에 저장되어 메모리가 낭비된다. 덧붙일 때는 같은 주소에서 처리하는 `StringBuilder`(속도가 빠름)나 `StringBuffer`(스레드에 안전)를 쓴다.

<br>

| 메서드 | 설명 |
|---|---|
| `length()` | 문자 개수 |
| `charAt(i)` | i번째 문자 |
| `indexOf(c)`, `lastIndexOf(c)` | 앞에서, 뒤에서 처음 나오는 위치 |
| `contains(s)` | 포함하면 `true` |
| `substring(시작, 끝)` | 시작부터 끝 앞까지 자르기 |
| `split(구분자)` | 구분자로 잘라 문자열 배열로 반환 |

<br>

- 예제 코드: [문자열 메모리와 메서드](../JAVA02/src/Ch02Encapsulation/C05StringMethods.java)

---

### Link
[Java String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)
