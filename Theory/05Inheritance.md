# Inheritance

- [상속](#상속)
- [super와 생성자 호출 순서](#super와-생성자-호출-순서)
- [메서드 오버라이딩](#메서드-오버라이딩)
- [오버로딩과 오버라이딩](#오버로딩과-오버라이딩)
- [업캐스팅과 다운캐스팅](#업캐스팅과-다운캐스팅)
- [instanceof](#instanceof)
- [업캐스팅 상태의 메서드 접근](#업캐스팅-상태의-메서드-접근)
- [상속 연습 문제](#상속-연습-문제)

<br>

---

### 상속

> 상속(Inheritance)은 상위(부모, Super) 클래스의 속성과 기능을 하위(자식, Sub) 클래스가 그대로 물려받아 쓰게 하는 문법이다. `extends` 예약어를 사용한다. 하위 클래스는 물려받은 것 외에 속성과 기능을 추가(확장)할 수 있고, 물려받은 기능을 고쳐 쓸 수 있다(오버라이딩).

<br>

```java
class Point2D { int x; int y; }
class Point3D extends Point2D { int z; }    // x, y 를 물려받고 z 를 추가
```

<br>

<span style="color:brown">하위 클래스 객체를 만들면 상위 클래스의 생성자가 먼저 호출된다. 자바는 클래스의 다중 상속을 허용하지 않는다.</span>

<br>

- 예제 코드: [상속 개념](../JAVA02/src/Ch05Inheritance/C00InheritanceInfo.java)
- 예제 코드: [상속 기초](../JAVA02/src/Ch05Inheritance/C01InheritanceBasic.java)

---

### super와 생성자 호출 순서

> `super(...)`는 상위 클래스의 생성자를 호출하는 문법이다. 생성자의 첫 줄에 쓰며, 쓰지 않으면 `super()`가 자동으로 들어간다. 상위 클래스에 기본 생성자가 없으면 하위 생성자에서 `super(...)`로 값을 직접 넘겨야 한다.

<br>

```java
class Point3D extends Point2D {
    Point3D(int x, int y, int z) {
        super(x, y);    // 상위 생성자 호출
        this.z = z;
    }
}
```

<br>

> 객체를 만들면 상위 생성자가 먼저 끝나고 하위 생성자가 이어서 끝난다. 상위 필드는 `super.x`나 `this.x`로 접근할 수 있지만, 값을 넘기는 방식으로 `super(x)`를 주로 쓴다.

<br>

- 예제 코드: [super 생성자](../JAVA02/src/Ch05Inheritance/C02InheritanceSuper.java)

---

### 메서드 오버라이딩

> 오버라이딩(Method Overriding)은 상속을 전제로 상위 클래스의 메서드를 하위 클래스가 본문만 고쳐 다시 정의하는 문법이다. 헤더(반환형, 이름, 매개변수)는 그대로 두고 본문 `{}`만 바꾼다. 같은 메서드를 물려받아도 하위 클래스마다 다른 결과를 낼 수 있어 다형성의 근거가 된다.

<br>

```java
class Animal { void sound() { System.out.println("소리낸다!"); } }
class Cat extends Animal {
    @Override
    void sound() { System.out.println("야옹 소리낸다!"); }
}
```

<br>

<span style="color:brown">`@Override`를 붙이면 헤더가 상위 메서드와 다를 때 컴파일러가 오류를 내 실수를 막아 준다.</span>

<br>

- 예제 코드: [메서드 오버라이딩](../JAVA02/src/Ch05Inheritance/C03MethodOverriding.java)

---

### 오버로딩과 오버라이딩

| 구분 | 오버로딩 | 오버라이딩 |
|---|---|---|
| 상속 | 필요 없음 | 필요함 |
| 헤더 | 매개변수가 달라짐(이름은 같음) | 그대로 유지 |
| 본문 | 바꾸지 않음 | 바꿈 |
| 목적 | 같은 이름으로 개발 편의성 | 다형성 |

<br>

> 반환형만 다른 경우는 오버로딩이 아니다. 매개변수의 개수나 자료형이 하나라도 다르면 새 메서드를 추가하는 오버로딩이고, 상위 클래스와 헤더가 완전히 같으면 오버라이딩이다.

<br>

- 예제 코드: [오버로딩과 오버라이딩 구분](../JAVA02/src/Ch05Inheritance/C04OverloadVsOverride.java)

---

### 업캐스팅과 다운캐스팅

> 업캐스팅(Upcasting)은 상위 클래스형 참조변수에 하위 클래스형 객체를 연결하는 것이다. 하위 객체는 상위 멤버를 모두 가지고 있어 자동 형변환이 된다. 상속 관계의 모든 하위 객체를 하나의 상위형 변수로 연결할 수 있고, 재정의된 메서드에도 접근할 수 있다. 다만 하위 클래스에 추가된 멤버에는 접근할 수 없다.

<br>

> 다운캐스팅(Downcasting)은 업캐스팅한 변수를 하위 클래스형으로 강제 형변환하는 것이다. 업캐스팅한 객체를 되돌릴 때만 안전하다.

<br>

```java
Super ob3 = new Sub();      // 업캐스팅
// ob3.n2 = 20;             // 추가된 멤버는 접근 불가
Sub down = (Sub) ob3;       // 다운캐스팅
down.n2 = 200;
```

<br>

<span style="color:brown">처음부터 상위 객체였던 것을 다운캐스팅하면 컴파일은 되지만 실행할 때 `ClassCastException`이 난다.</span>

<br>

- 예제 코드: [업캐스팅과 다운캐스팅](../JAVA02/src/Ch05Inheritance/C06UpDownCasting.java)

---

### instanceof

> `instanceof`는 변수가 실제로 가리키는 객체가 해당 클래스(또는 그 하위)의 객체이면 `true`를 돌려주는 연산자이다. 다운캐스팅하기 전에 확인하면 `ClassCastException` 없이 하위 멤버에 접근할 수 있다.

<br>

```java
if (obj instanceof B) {
    B down = (B) obj;
    down.b = 200;
}
```

<br>

> 최상위 `A` 형 매개변수로 모든 하위 객체를 받고, 객체 종류에 따라 값을 채우는 메서드로 연습한다.

<br>

- 예제 코드: [계층 구조의 캐스팅](../JAVA02/src/Ch05Inheritance/C07CastingHierarchy.java)

---

### 업캐스팅 상태의 메서드 접근

> 업캐스팅된 상태에서 하위 클래스가 재정의한 메서드는 다운캐스팅 없이 호출되고 하위 클래스의 내용이 실행된다. 하위 클래스에 새로 추가한 메서드는 다운캐스팅해야 호출할 수 있다.

<br>

```java
Parent ob3 = new Son();
ob3.func2();            // 재정의된 Son 의 func2 실행
((Son) ob3).func3();    // 추가된 메서드는 다운캐스팅 필요
```

<br>

- 예제 코드: [업캐스팅 상태의 메서드 접근](../JAVA02/src/Ch05Inheritance/C08UpcastAccess.java)

---

### 상속 연습 문제

> 상속과 캐스팅을 연습하는 문제 모음이다. 인터페이스를 쓰는 문제 4, 5번은 다음 장에서 인터페이스를 배운 뒤 이해하면 된다.

<br>

- 예제 코드: [TV를 상속한 ColorTV](../JAVA02/src/Ch05Inheritance/C05ColorTV.java)
- 예제 코드: [직원 상속 문제](../JAVA02/src/Ch05Inheritance/C09EmployeePractice.java)
- 예제 코드: [직원 상속 관계도](../JAVA02/src/Ch05Inheritance/C09EmployeePractice.drawio)
- 예제 코드: [직원 상속 문제 답](../JAVA02/src/Ch05Inheritance/C10EmployeeAnswer.java)
- 예제 코드: [업캐스팅 연습 1](../JAVA02/src/Ch05Inheritance/C11UpcastBasic.java)
- 예제 코드: [업캐스팅 연습 2](../JAVA02/src/Ch05Inheritance/C12UpcastMethodAccess.java)
- 예제 코드: [업캐스팅 연습 3](../JAVA02/src/Ch05Inheritance/C13UpcastMultiLevel.java)
- 예제 코드: [업캐스팅 연습 4](../JAVA02/src/Ch05Inheritance/C14UpcastInterface.java)
- 예제 코드: [업캐스팅 연습 5](../JAVA02/src/Ch05Inheritance/C15UpcastComplex.java)

---

### Link
[Java 상속](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
