# Control

- [if 조건문](#if-조건문)
- [switch 조건문](#switch-조건문)
- [while 반복문](#while-반복문)
- [break와 continue](#break와-continue)
- [for 반복문](#for-반복문)
- [향상된 for와 컬렉션 반복](#향상된-for와-컬렉션-반복)

<br>

---

### if 조건문

> 조건식이 참이면 실행할 문장을 고른다. `if`, `else if`, `else`로 여러 갈래를 만든다.

<br>

```java
int age = sc.nextInt();
if (age >= 8)
    System.out.println("학교에 다닙니다.");
else
    System.out.println("학교에 다니지 않습니다.");
```

<br>

- 예제 코드: [if 조건문](../JAVA01/src/Ch05Condition/C01If.java)

---

### switch 조건문

> `switch(변수)`는 여러 선택지 중 하나를 고르는 조건문이다. 값과 일치하는 `case`가 실행되고 `default`는 `if`의 `else`와 같다. `case`에는 조건식이 아니라 정해진 값만 쓸 수 있다.

<br>

<span style="color:brown">`break`를 쓰지 않으면 일치한 `case`부터 `break`를 만날 때까지 아래 문장을 모두 실행한다.</span>

<br>

- 예제 코드: [switch 조건문](../JAVA01/src/Ch05Condition/C02Switch.java)
- 예제 코드: [switch 활용](../JAVA01/src/Ch05Condition/C03SwitchPractice.java)

---

### while 반복문

> 조건식이 참인 동안 문장을 반복한다. 반복을 끝내려면 탈출용 변수, 탈출 조건식, 탈출 연산식(`i++`)이 필요하다.

<br>

```java
int i = 0;                           // 탈출용 변수
while (i < 10) {                     // 탈출 조건식
    System.out.println((i + 1) + ": HELLOWORLD");
    i++;                             // 탈출 연산식
}
```

<br>

**구구단** while 안에 while을 넣는 이중 반복으로 단(`dan`)과 곱하는 수(`i`)를 바꾼다.

```java
int dan = 2;
while (dan < 10) {
    int i = 1;
    while (i < 10) {
        System.out.printf("%d x %d = %d\n", dan, i, dan * i);
        i++;
    }
    System.out.println();
    dan++;
}
```

<br>

- 예제 코드: [while 기본, N회 반복](../JAVA01/src/Ch06Loop/C01While.java)
- 예제 코드: [구구단과 별 찍기](../JAVA01/src/Ch06Loop/C02WhileNested.java)

---

### break와 continue

> `break`는 반복문을 즉시 끝내고, `continue`는 이번 반복의 나머지를 건너뛰고 다음 반복으로 넘어간다.

<br>

```java
int sum = 0;
while (true) {
    int n = sc.nextInt();
    if (n == -1) break;    // -1을 입력하면 반복 종료
    sum += n;
}
```

<br>

- 예제 코드: [break와 continue](../JAVA01/src/Ch06Loop/C03BreakContinue.java)

---

### for 반복문

> 초기값, 조건식, 증감연산을 한 줄에 쓰는 반복문이다. 반복 횟수가 정해져 있을 때 편하다.

<br>

```java
for (int i = 0; i < 10; i++) {
    System.out.println((i + 1) + ": HELLOWORLD");
}
```

<br>

- 예제 코드: [for 반복문](../JAVA01/src/Ch06Loop/C04For.java)

---

### 향상된 for와 컬렉션 반복

> 컬렉션(List, Map)이나 배열의 요소를 처음부터 끝까지 차례로 꺼낼 때는 향상된 `for`(`for (요소 : 컬렉션)`)를 쓴다. 람다식은 메서드를 하나의 식으로 표현한 것으로 `stream().forEach()`와 함께 반복에도 쓴다.

<br>

```java
List<String> lists = new ArrayList<>();
lists.add("JAVA");
lists.add("JSP");

for (int i = 0; i < lists.size(); i++) {      // 기본 for. size()는 요소 개수
    System.out.println(lists.get(i));
}
for (String subject : lists) {                // 향상된 for
    System.out.println(subject);
}
lists.stream().forEach(item -> System.out.println(item));   // 람다식
```

<br>

- 예제 코드: [컬렉션 반복](../JAVA01/src/Ch06Loop/C05LoopEtc.java)

<br>

---

<br>

**Control 요약**

<aside>

> if, else if, else: 조건에 따라 실행 선택 <br>
switch: 값 비교, break가 없으면 아래 case까지 실행 <br>
while: 조건이 참인 동안 반복, 탈출 변수 필요 <br>
for: 초기값, 조건식, 증감연산, break와 continue로 흐름 변경 <br>
향상된 for: 컬렉션 요소를 차례로 꺼냄

</aside>

<br>

### Link
[Java 제어문](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
