# Abstract & Interface

- [추상 클래스](#추상-클래스)
- [인터페이스](#인터페이스)
- [인터페이스 활용](#인터페이스-활용)
- [final](#final)
- [인터페이스를 이용한 팀 과제](#인터페이스를-이용한-팀-과제)

<br>

---

### 추상 클래스

> 추상 클래스(abstract class)는 추상 메서드를 하나 이상 가진 클래스이다. 직접 객체를 만들 수 없고 상속해서 사용한다. 추상 메서드는 선언만 있고 구현(몸체)이 없는 메서드이며 하위 클래스가 반드시 오버라이딩해야 한다.

<br>

> 공통 기능은 상위 클래스에 구현해 두고, 특정 기능은 하위 클래스가 반드시 구현하도록 강제해 같은 역할의 메서드 이름이 제각각이 되지 않게 하는 것이 목적이다.

<br>

```java
abstract class Parent2 {
    abstract void func();       // 추상 메서드
}
class Son2 extends Parent2 {
    @Override
    void func() { ... }         // 반드시 구현
}

// Parent2 ob = new Parent2();  // 객체 생성 불가
Parent2 ob6 = new Son2();       // 업캐스팅은 가능
```

<br>

<span style="color:brown">추상 클래스 안에서 흐름(`run()`)은 정해 두고 단위 이름과 계산은 하위 클래스가 채우는 구조로 자주 쓴다.</span>

<br>

- 예제 코드: [추상 클래스](../JAVA02/src/Ch06AbstractInterface/C01AbstractClass.java)
- 예제 코드: [Converter 문제](../JAVA02/src/Ch06AbstractInterface/C02Converter.java)

---

### 인터페이스

> 인터페이스(interface)는 클래스가 구현해야 할 메서드의 규약(계약)을 정의한 추상적인 타입이다. `implements`로 클래스가 구현하며, 클래스와 달리 여러 개를 동시에 구현할 수 있다(다중 상속). 인터페이스의 변수는 `public static final` 상수이고 메서드는 기본이 추상 메서드이다.

<br>

> 자바 8부터는 디폴트 메서드와 정적 메서드, 자바 9부터는 `private` 메서드도 가질 수 있다.

<br>

```java
interface Remocon {
    int MAX_VOL = 100;          // 상수
    void powerOn();             // 추상 메서드
}
class Tv implements Remocon {
    @Override
    public void powerOn() { ... }
}
class SmartTv extends Tv implements Browser { ... }   // 상속 + 구현
```

<br>

<span style="color:brown">`extends`를 먼저, `implements`를 뒤에 쓰고 인터페이스는 쉼표로 구분한다. 인터페이스를 구현한 메서드는 `public`이어야 한다.</span>

<br>

- 예제 코드: [인터페이스](../JAVA02/src/Ch06AbstractInterface/C03Interface.java)
- 예제 코드: [인터페이스 다중 구현](../JAVA02/src/Ch06AbstractInterface/C05InterfaceMulti.java)
- 예제 코드: [Printer 문제](../JAVA02/src/Ch06AbstractInterface/C06PrinterInterface.java)

---

### 인터페이스 활용

> 부품을 인터페이스 타입으로 선언하면 같은 규약을 구현한 어떤 부품으로도 바꿔 끼울 수 있다. 사용하는 쪽의 코드를 고치지 않고 부품만 교체할 수 있는 것이 장점이다. 인터페이스 매개변수에는 구현한 모든 클래스의 객체를 넘길 수 있다.

<br>

```java
Tire FL;
FL = new HankookTire();
FL = new KumhoTire();       // 사용하는 코드는 그대로, 부품만 교체
```

<br>

- 예제 코드: [타이어 교체](../JAVA02/src/Ch06AbstractInterface/C04InterfaceTire.java)

---

### final

> `final` 변수는 값을 한 번 정하면 바꿀 수 없는 상수(심볼릭 상수)이다. `final` 메서드는 하위 클래스에서 재정의할 수 없고, `final` 클래스는 상속할 수 없다.

<br>

| 대상 | 의미 |
|---|---|
| 변수 | 값 변경 불가 |
| 메서드 | 오버라이딩 불가 |
| 클래스 | 상속 불가 |

<br>

- 예제 코드: [final](../JAVA02/src/Ch06AbstractInterface/C07Final.java)

---

### 인터페이스를 이용한 팀 과제

> 팀 과제는 인터페이스로 규약을 정해 두고 팀원마다 구현 클래스를 만드는 방식이다. 사용하는 `Main`은 인터페이스 타입으로만 객체를 다루므로 구현 클래스를 바꿔도 코드를 고치지 않는다. `Information` 인터페이스로 팀명과 작성자를 알려 준다.

<br>

```java
static SumInterface sum1 = new Ch08Team.Team0.Impl.hong.SumImpl();
sum1.sum(10, 20);
```

<br>

- 예제 코드: [팀 공통 인터페이스](../JAVA02/src/Ch08Team/Common/Information.java)
- 예제 코드: [합 인터페이스](../JAVA02/src/Ch08Team/Team0/Interfaces/SumInterface.java)
- 예제 코드: [합 구현 클래스](../JAVA02/src/Ch08Team/Team0/Impl/hong/SumImpl.java)
- 예제 코드: [차 인터페이스](../JAVA02/src/Ch08Team/Team0/Interfaces/SubInterface.java)
- 예제 코드: [차 구현 클래스](../JAVA02/src/Ch08Team/Team0/Impl/hong/SubImpl.java)
- 예제 코드: [곱 인터페이스](../JAVA02/src/Ch08Team/Team0/Interfaces/MulInterface.java)
- 예제 코드: [곱 구현 클래스](../JAVA02/src/Ch08Team/Team0/Impl/hong/MulImpl.java)
- 예제 코드: [나눗셈 인터페이스](../JAVA02/src/Ch08Team/Team0/Interfaces/DivInterface.java)
- 예제 코드: [나눗셈 구현 클래스](../JAVA02/src/Ch08Team/Team0/Impl/hong/DivImpl.java)
- 예제 코드: [팀 과제 실행](../JAVA02/src/Ch08Team/Team0/Main.java)

---

### Link
[Java 인터페이스](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
