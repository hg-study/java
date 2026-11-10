# Class

- [객체와 클래스](#객체와-클래스)
- [클래스 선언과 객체 생성](#클래스-선언과-객체-생성)
- [자바의 메모리 영역](#자바의-메모리-영역)
- [메서드](#메서드)
- [변수의 종류와 유효 범위](#변수의-종류와-유효-범위)
- [메서드 오버로딩](#메서드-오버로딩)
- [가변 인자](#가변-인자)
- [생성자](#생성자)
- [클래스의 구성 요소](#클래스의-구성-요소)
- [매개변수와 반환값의 자료형](#매개변수와-반환값의-자료형)

<br>

---

### 객체와 클래스

> 객체(Object)는 독립된 공간을 차지하는 존재 또는 사물이다. 객체는 구별되는 데이터인 속성(Attribute)과 수행하는 동작인 기능(Function)으로 이루어진다. 속성은 변수로 저장하고 기능은 메서드로 처리한다.

<br>

> 객체 지향은 현실 객체의 정보 중 문제 해결에 필요한 일부만 추려(추상화) 메모리에 저장하는 문법 체계이다. 클래스(Class)는 같은 종류의 객체를 만들기 위해 속성과 기능을 선언해 둔 자료형이다.

<br>

<span style="color:brown">클래스는 선언만으로는 메모리를 차지하지 않는다. `new`로 객체를 만드는 순간 선언한 속성과 기능대로 공간이 생긴다.</span>

<br>

- 예제 코드: [객체와 클래스 개념](../JAVA02/src/Ch01Class/C00ObjectInfo.java)

---

### 클래스 선언과 객체 생성

> 클래스에 필드(멤버 변수)를 선언하고 `클래스명 참조변수 = new 클래스명();` 으로 객체를 만든다. 객체 안의 값은 `참조변수.속성`으로 읽고 바꾼다. 값을 넣지 않은 필드는 자료형별 기본값(`null`, `0`, `0.0`)을 가진다.

<br>

```java
public class C01Person {
    public String name;     // null(기본값)
    public int age;         // 0
}

C01Person hong = new C01Person();
hong.name = "홍길동";
hong.age  = 15;
```

<br>

> 외부 클래스는 `public` 클래스와 같은 파일의 바깥에 선언한 보조 클래스이다. 파일 이름과 같은 클래스만 `public`으로 쓸 수 있다.

<br>

- 예제 코드: [클래스 선언](../JAVA02/src/Ch01Class/C01Person.java)
- 예제 코드: [객체 생성과 속성 사용](../JAVA02/src/Ch01Class/C01PersonMain.java)
- 예제 코드: [외부 클래스](../JAVA02/src/Ch01Class/C02PersonMain.java)

---

### 자바의 메모리 영역

> 스택 영역은 `{}` 안에서 만들어지고 사라지는 변수와 참조변수를 둔다. 클래스(메서드) 영역은 생성자, 일반 메서드, `static` 메서드와 `static` 변수를 둔다. 힙 영역은 `new`로 만든 객체를 저장한다.

<br>

```java
Scanner sc = new Scanner(System.in);
```

- `new` : 힙 영역에 객체를 저장한다
- `Scanner(System.in)` : 생성자를 호출해 객체 생성에 필요한 초기값을 부여한다
- `Scanner sc` : 스택의 참조변수이며 힙에 만들어진 객체의 시작 주소값을 저장한다

<br>

- 예제 코드: [객체와 클래스 개념](../JAVA02/src/Ch01Class/C00ObjectInfo.java)

---

### 메서드

> 메서드는 객체가 수행하는 동작을 정의한 코드 블록이다. 매개변수와 반환값의 유무에 따라 네 가지 형태로 나뉜다. 메서드 안의 `this`는 메서드를 호출한 객체 자신을 가리킨다.

<br>

| 형태 | 매개변수 | 반환값 |
|---|---|---|
| `int sum1(int a, int b)` | 있음 | 있음 |
| `int sum2()` | 없음 | 있음 |
| `void sum3(int a, int b)` | 있음 | 없음 |
| `void sum4()` | 없음 | 없음 |

<br>

> `toString()`은 객체의 정보를 문자열로 돌려주는 메서드이다. 재정의하지 않으면 주소값이 출력된다. 이클립스에서는 오른쪽 마우스 - 소스작업 - Generate toString()으로 자동 생성한다.

<br>

- 예제 코드: [메서드와 toString](../JAVA02/src/Ch01Class/C03PersonMain.java)
- 예제 코드: [메서드의 형태](../JAVA02/src/Ch01Class/C04MethodMain.java)

---

### 변수의 종류와 유효 범위

> 변수는 선언 위치에 따라 범위가 다르다. 범위가 넓은 순서는 전역 변수, 클래스 변수, 멤버 변수(인스턴스 변수), 지역 변수이다.

<br>

| 종류 | 선언 위치 | 생명주기 | 특징 |
|---|---|---|---|
| 지역 변수 | 메서드나 `{}` 안 | 호출될 때 생성, 끝나면 소멸 | 그 안에서만 사용(매개변수 포함) |
| 멤버 변수 | 클래스 안, 메서드 밖 | 객체 생성 시 생성, 소멸 시 소멸 | 객체마다 따로 값을 가짐 |
| 클래스 변수 | 클래스 안, `static` | 프로그램 시작 시 생성, 종료 시 소멸 | 모든 객체가 공유, 객체 없이 사용 |

<br>

<span style="color:brown">멤버 변수와 이름이 같은 지역 변수를 선언하면 그 범위 안에서는 지역 변수가 우선한다. 멤버 변수를 가리키려면 `this.`를 붙인다.</span>

<br>

```java
void Func1() {
    int num = 20;   // 같은 이름의 지역 변수
    num++;          // 지역 변수
    this.num++;     // 멤버 변수
}
```

<br>

> 반복문 안에서 `int num = 100;` 처럼 같은 이름을 다시 선언하면 새 지역 변수가 만들어질 뿐 멤버 변수는 바뀌지 않는다. 그래서 멤버 변수를 조건식에 쓴 `while` 문은 조건이 변하지 않아 끝나지 않는다.

<br>

- 예제 코드: [변수의 종류와 유효 범위](../JAVA02/src/Ch01Class/C05LocalVarMain.java)

---

### 메서드 오버로딩

> 오버로딩(Overloading)은 같은 이름의 메서드를 매개변수의 개수나 자료형을 달리해 여러 개 정의하는 문법이다. 호출할 때 넘기는 인자에 맞는 메서드가 선택된다.

<br>

```java
public int sum(int n1, int n2) { ... }
public int sum() { ... }
public int sum(int n1, int n2, int n3) { ... }
```

<br>

<span style="color:brown">반환형만 다른 메서드는 오버로딩이 아니다. 매개변수의 개수나 자료형이 달라야 한다.</span>

<br>

- 예제 코드: [메서드 오버로딩](../JAVA02/src/Ch01Class/C06MethodOverloading.java)

---

### 가변 인자

> 가변 인자는 자료형 뒤에 `...`을 붙여 인자를 몇 개든 받는 매개변수이다. 메서드 안에서는 배열로 다룬다.

<br>

```java
int sum(int ...arg) {
    int s = 0;
    for (int item : arg) s += item;
    return s;
}
obj.sum(10, 20, 30);
```

<br>

- 예제 코드: [가변 인자](../JAVA02/src/Ch01Class/C07VarArgs.java)

---

### 생성자

> 생성자는 객체를 만들 때 한 번만 호출되어 필요한 공간을 만들고 초기값을 넣는 메서드이다. 이름은 클래스 이름과 같고 반환 자료형을 쓰지 않는다. 만든 객체 안에서는 다시 호출할 수 없다.

<br>

> 기본 생성자는 클래스에 생성자를 쓰지 않으면 컴파일러가 자동으로 넣어 주는 생성자이다. 생성자를 하나라도 직접 쓰면 기본 생성자는 넣어 주지 않는다.

<br>

<span style="color:brown">매개변수 생성자를 만들고 기본 생성자도 필요하다면 기본 생성자를 직접 함께 작성해야 한다.</span>

<br>

- 예제 코드: [생성자](../JAVA02/src/Ch01Class/C08ConstructorMain.java)

---

### 클래스의 구성 요소

> 클래스는 바깥 구성 요소와 안쪽 구성 요소로 나뉜다.

<br>

| 구분 | 요소 | 설명 |
|---|---|---|
| 외부 | 패키지(package) | 클래스를 묶어 관리하는 물리적 폴더 |
| 외부 | 임포트(import) | 다른 패키지의 클래스를 가져다 쓰는 선언 |
| 외부 | 외부 클래스 | `public` 클래스 바깥에 작성한 보조 클래스 |
| 내부 | 필드(field) | 객체의 속성값을 저장하는 변수 |
| 내부 | 메서드(method) | 객체의 기능을 정의한 코드 블록 |
| 내부 | 생성자(constructor) | 객체 생성 시 필드를 초기화하는 특수 블록 |
| 내부 | 내부 클래스 | 클래스 안에 선언한 종속 클래스 |
| 내부 | `this`, `this()` | 자기 자신의 주소값, 같은 클래스의 다른 생성자 호출 |

<br>

- 예제 코드: [클래스의 구성 요소와 TV 문제](../JAVA02/src/Ch01Class/C09ClassStructure.java)

---

### 매개변수와 반환값의 자료형

> 기본형 매개변수는 값 자체를 복사해 전달한다. 참조형 매개변수는 객체의 주소값을 전달한다. 반환 자료형을 `Object`로 쓰면 어떤 객체든 반환할 수 있다.

<br>

```java
public static void func1(int num)       // 값 복사
public static void func2(Person obj)    // 주소값 전달
public static Object func3(String name, int age) { return new Person(name, age); }
```

<br>

> 객체끼리 메서드를 주고받는 문제로 연습한다. 구매자 객체가 판매자 객체의 메서드에 금액을 넘기면 판매자가 개수를 계산해 돌려주고, 두 객체의 보유 금액과 재고가 각자 갱신된다.

<br>

- 예제 코드: [매개변수와 반환값](../JAVA02/src/Ch01Class/C10ParamType.java)
- 예제 코드: [성적 평균 문제](../JAVA02/src/Ch01Class/C11Grade.java)
- 예제 코드: [사과 구매 문제](../JAVA02/src/Ch01Class/C12AppleShop.java)
- 예제 코드: [책 구매 문제](../JAVA02/src/Ch01Class/C13BookShop.java)
- 예제 코드: [커피 주문 문제](../JAVA02/src/Ch01Class/C14CafeOrder.java)
- 예제 코드: [영화표 예매 문제](../JAVA02/src/Ch01Class/C15TicketReserve.java)

---

### Link
[Java 클래스와 객체](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)
