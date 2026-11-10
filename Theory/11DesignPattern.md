# Design Pattern

- [디자인 패턴](#디자인-패턴)
- [생성 패턴](#생성-패턴)
- [구조 패턴](#구조-패턴)
- [행위 패턴](#행위-패턴)
- [스타크래프트 설계](#스타크래프트-설계)

<br>

---

### 디자인 패턴

> 디자인 패턴은 소프트웨어를 설계할 때 반복해서 나타나는 문제에 대한 검증된 해결 방식을 이름 붙여 정리한 것이다. 객체를 만드는 방식(생성), 클래스와 객체를 조합하는 방식(구조), 객체 사이의 역할과 동작(행위) 세 가지로 나눈다.

<br>

- 예제 코드: [디자인 패턴 개념](../JAVA03/src/Ch15DesignPattern/C00DesignPatternInfo.java)

---

### 생성 패턴

| 패턴 | 설명 |
|---|---|
| 싱글톤 | 인스턴스를 하나만 만들어 어디서든 같은 객체를 쓰게 보장. 설정, 로거, DB 커넥션 풀 |
| 빌더 | 복잡한 객체를 단계별로 조립. 생성자 매개변수가 많을 때 `.체이닝`으로 깔끔하게 |
| 프로토타입 | 기존 객체를 `clone()` 으로 복제해 새 객체를 만듦. 생성 비용이 큰 객체 |
| 팩토리 메서드 | 객체 생성을 서브 클래스(공장)에 맡김. 조건에 따라 다른 객체를 만들 때 |
| 추상 팩토리 | 서로 관련된 객체의 세트를 한 번에 만듦. OS별 GUI 세트 |

<br>

```java
class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }
}
```

<br>

- 예제 코드: [싱글톤](../JAVA03/src/Ch15DesignPattern/creational/C01Singleton.java)
- 예제 코드: [빌더](../JAVA03/src/Ch15DesignPattern/creational/C02Builder.java)
- 예제 코드: [프로토타입](../JAVA03/src/Ch15DesignPattern/creational/C03Prototype.java)
- 예제 코드: [팩토리 메서드](../JAVA03/src/Ch15DesignPattern/creational/C04FactoryMethod.java)
- 예제 코드: [추상 팩토리](../JAVA03/src/Ch15DesignPattern/creational/C05AbstractFactory.java)

---

### 구조 패턴

| 패턴 | 설명 |
|---|---|
| 어댑터 | 호환되지 않는 인터페이스를 변환해 함께 동작하게 함. 외부 라이브러리, 레거시 코드 |
| 데코레이터 | 기존 객체를 감싸 기능을 동적으로 추가. 입출력 보조 스트림이 이 방식 |
| 프록시 | 실제 객체 대신 대리인을 두어 접근을 제어. 지연 로딩, 접근 제어, 캐싱 |

<br>

- 예제 코드: [어댑터](../JAVA03/src/Ch15DesignPattern/structural/C01Adapter.java)
- 예제 코드: [데코레이터](../JAVA03/src/Ch15DesignPattern/structural/C02Decorator.java)
- 예제 코드: [프록시](../JAVA03/src/Ch15DesignPattern/structural/C03Proxy.java)

---

### 행위 패턴

| 패턴 | 설명 |
|---|---|
| 옵저버 | 한 객체(Subject)의 상태가 바뀌면 등록된 여러 객체(Observer)에 자동으로 알림. 이벤트 리스너 |
| 전략 | 알고리즘을 캡슐화해 실행 중에 교체. `if-else` 로 알고리즘을 고르던 코드를 정리 |
| 커맨드 | 요청을 객체로 만들어 전달, 저장, 실행. 작업 큐, 실행 취소, 호출자와 실행자 분리 |

<br>

- 예제 코드: [옵저버](../JAVA03/src/Ch15DesignPattern/behavioral/C01Observer.java)
- 예제 코드: [전략](../JAVA03/src/Ch15DesignPattern/behavioral/C02Strategy.java)
- 예제 코드: [커맨드](../JAVA03/src/Ch15DesignPattern/behavioral/C03Command.java)

---

### 스타크래프트 설계

> 객체지향 설계를 종합한 연습이다. 추상 클래스(`Unit`, `Building`, `Gun`)로 공통 속성과 동작을 정하고, 하위 클래스(`Marine`, `Medic`, `Barrack`, `Pistol`, `Rifle`)가 구체적으로 구현한다. `Marine`은 `Gun`을 필드로 가져(has-a) 총 또는 기본 공격을 고르고, 건물은 `UnitGenerator` 인터페이스(팩토리 패턴)로 유닛 생성을 분리하며, `ICanFly` 인터페이스로 비행 능력을 분리한다. 리플렉션으로 클래스 이름만 받아 유닛을 여러 개 만들고, 스레드로 전투와 치료를 동시에 반복한다.

<br>

- 예제 코드: [해병 전투 시뮬레이션](../JAVA03/src/Ch20StarCraft/C01MarineBattle.java)
- 예제 코드: [병영에서 유닛 생성](../JAVA03/src/Ch20StarCraft/C02BarrackGenerate.java)
- 예제 코드: [유닛](../JAVA03/src/Ch20StarCraft/unit/Unit.java)
- 예제 코드: [해병](../JAVA03/src/Ch20StarCraft/unit/Marine.java)
- 예제 코드: [의무병](../JAVA03/src/Ch20StarCraft/unit/Medic.java)
- 예제 코드: [건물](../JAVA03/src/Ch20StarCraft/building/Building.java)
- 예제 코드: [병영](../JAVA03/src/Ch20StarCraft/building/Barrack.java)
- 예제 코드: [비행 인터페이스](../JAVA03/src/Ch20StarCraft/building/ICanFly.java)
- 예제 코드: [유닛 생성 인터페이스](../JAVA03/src/Ch20StarCraft/building/UnitGenerator.java)
- 예제 코드: [해병 생성기](../JAVA03/src/Ch20StarCraft/building/MarineGenerator.java)
- 예제 코드: [의무병 생성기](../JAVA03/src/Ch20StarCraft/building/MedicGenerator.java)
- 예제 코드: [총](../JAVA03/src/Ch20StarCraft/weapon/Gun.java)
- 예제 코드: [권총](../JAVA03/src/Ch20StarCraft/weapon/Pistol.java)
- 예제 코드: [소총](../JAVA03/src/Ch20StarCraft/weapon/Rifle.java)
- 예제 코드: [클래스 다이어그램](../JAVA03/src/Ch20StarCraft/ClassDiagram.drawio)
- 예제 코드: [스타크래프트 설계도](../JAVA03/src/Ch20StarCraft/StarCraft.drawio)

---

### Link
[디자인 패턴](https://refactoring.guru/ko/design-patterns)
