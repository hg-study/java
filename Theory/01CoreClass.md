# Core Class

- [Object 클래스](#object-클래스)
- [equals와 hashCode](#equals와-hashcode)
- [래퍼 클래스](#래퍼-클래스)
- [날짜와 시간](#날짜와-시간)

<br>

---

### Object 클래스

> Object는 모든 클래스의 최상위 클래스이다. 별도로 상속하지 않아도 자동으로 상속받아 `equals`, `hashCode`, `toString` 등을 물려받는다. `toString()`은 객체를 문자열로 바꿔 주는 메서드로, 재정의하지 않으면 `클래스명@해시코드` 형태로 출력된다.

<br>

```java
class A {
    int x, y;
    @Override
    public String toString() { return "A [x=" + x + ", y=" + y + "]"; }
}
System.out.println(new A());    // println 에 객체를 넘기면 toString() 이 자동 호출됨
```

<br>

- 예제 코드: [Object 의 toString](../JAVA03/src/Ch01CoreClass/C01ObjectToString.java)

---

### equals와 hashCode

> `equals()`는 두 객체가 같은지 비교하는 메서드이다. 기본 동작은 주소값 비교(`==`)라서 필드 값이 같아도 다른 객체로 본다. 필드 값을 비교하도록 재정의해서 값이 같으면 같은 객체로 판단하게 만든다.

<br>

> `hashCode()`는 객체를 구별하는 정수값을 돌려준다. `HashSet`, `HashMap`은 `hashCode`와 `equals`를 함께 사용해 같은 객체인지 판단하므로, `equals`가 `true`인 두 객체는 `hashCode`도 같아야 한다.

<br>

```java
@Override
public boolean equals(Object obj) {
    if (obj instanceof C02Simple) {
        C02Simple down = (C02Simple) obj;
        return down.n == this.n;
    }
    return false;
}
@Override
public int hashCode() { return Objects.hash(this.n); }
```

<br>

<span style="color:brown">`equals`를 재정의하면 `hashCode`도 반드시 같은 필드로 재정의한다.</span>

<br>

- 예제 코드: [equals](../JAVA03/src/Ch01CoreClass/C02ObjectEquals.java)
- 예제 코드: [hashCode](../JAVA03/src/Ch01CoreClass/C03ObjectHashCode.java)

---

### 래퍼 클래스

> 래퍼 클래스는 기본 자료형의 값을 객체로 포장하는 클래스이다(`Integer`, `Double`, `Boolean` 등). 기본형을 객체로 바꾸는 것을 Boxing, 객체에서 기본형 값을 꺼내는 것을 UnBoxing이라 하고, `new` 없이 대입만으로 자동으로 하는 것을 Auto Boxing이라 한다.

<br>

```java
Integer ob3 = Integer.valueOf("300");   // Boxing
int n3 = ob3.intValue();                // UnBoxing
Integer ob4 = 100;                      // Auto Boxing
int n4 = ob3 + ob4;                     // 연산에서는 자동으로 UnBoxing
```

<br>

- 예제 코드: [래퍼 클래스](../JAVA03/src/Ch01CoreClass/C04Wrapper.java)

---

### 날짜와 시간

> `Date`와 `Calendar`는 연도에 1900을 더하고 월이 0부터 시작하는 등 불편해서 지금은 자바 8의 `LocalDateTime`을 쓴다. `LocalDateTime`은 날짜와 시간을 함께 다루고 월은 1~12, 요일은 `DayOfWeek` 열거형으로 읽는다.

<br>

> 문자열과 날짜는 포매터로 서로 바꾼다. `DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")`로 패턴을 만들고, `parse`는 문자열을 날짜로(입력용), `format`은 날짜를 문자열로(출력용) 바꾼다. 옛 클래스에는 `SimpleDateFormat`이 있다.

<br>

```java
LocalDateTime now = LocalDateTime.now();
int month = now.getMonthValue();        // 1~12
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
String s = fmt.format(now);
```

<br>

- 예제 코드: [Date, Calendar, LocalDateTime](../JAVA03/src/Ch01CoreClass/C05DateCalendar.java)
- 예제 코드: [SimpleDateFormat](../JAVA03/src/Ch01CoreClass/C06SimpleDateFormat.java)
- 예제 코드: [DateTimeFormatter](../JAVA03/src/Ch01CoreClass/C07LocalDateTimeFormat.java)

---

### Link
[Java Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)
