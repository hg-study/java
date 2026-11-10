# Static

- [static 변수](#static-변수)
- [static 메서드](#static-메서드)
- [싱글톤 패턴](#싱글톤-패턴)

<br>

---

### static 변수

> `static`은 공유 메모리(클래스 영역)에 변수나 메서드를 올리는 예약어이다. 객체를 만들기 전에 공간이 할당되므로 클래스명으로 접근할 수 있고, 같은 클래스의 모든 객체가 같은 값을 공유한다.

<br>

```java
class C01Simple {
    static int n1;  // 클래스 변수 : 모든 객체가 공유
    int n2;         // 인스턴스 변수 : 객체마다 따로
}

C01Simple.n1 = 1000;    // 객체 없이 접근
```

<br>

<span style="color:brown">한 객체로 `static` 변수를 바꾸면 다른 객체에서도 바뀐 값이 보인다. 일반 변수는 객체가 만들어져야 생기므로 클래스명으로 접근할 수 없다.</span>

<br>

- 예제 코드: [static 변수](../JAVA02/src/Ch04Static/C01StaticMember.java)

---

### static 메서드

> `static` 메서드는 객체 생성 전에 만들어지므로 `static` 변수와 지역 변수만 사용할 수 있다. 객체가 만들어져야 생기는 일반 변수는 사용할 수 없다.

<br>

```java
static void func2() {
    n1 = 300;       // static 변수 : 가능
    int n3 = 500;   // 지역 변수 : 가능
    // n2 = 400;    // 일반 변수 : 컴파일 에러
}
```

<br>

> 두 배열을 연결하는 `concat()`과 요소를 출력하는 `print()`처럼 객체의 상태가 필요 없는 기능은 `static` 메서드로 만들어 클래스명으로 호출한다. `System.arraycopy(원본, 시작, 대상, 시작, 개수)`는 배열의 일부를 다른 배열로 복사한다.

<br>

- 예제 코드: [static 메서드](../JAVA02/src/Ch04Static/C02StaticMethod.java)
- 예제 코드: [배열 유틸 문제](../JAVA02/src/Ch04Static/C04ArrayUtils.java)

---

### 싱글톤 패턴

> 싱글톤 패턴은 객체 생성을 제한해 하나의 객체만 만들고 공유하는 디자인 패턴이다. `private` 생성자로 외부에서 `new`를 막고, `static` 변수에 유일한 객체의 주소를 저장하며, `getInstance()`가 객체가 없을 때만 새로 만들어 돌려준다.

<br>

```java
class Company {
    private static Company instance;
    private Company() {}

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }
}

Company com1 = Company.getInstance();
Company com2 = Company.getInstance();   // com1 == com2
```

<br>

<span style="color:brown">`public` 생성자를 하나라도 남겨 두면 외부에서 객체를 더 만들 수 있어 싱글톤이 깨진다.</span>

<br>

- 예제 코드: [싱글톤 패턴](../JAVA02/src/Ch04Static/C03Singleton.java)
- 예제 코드: [싱글톤 문제](../JAVA02/src/Ch04Static/C05ShopService.java)

---

### Link
[Java 클래스 멤버](https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)
