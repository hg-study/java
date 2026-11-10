# Array

- [배열](#배열)
- [배열 순회](#배열-순회)
- [배열 복사](#배열-복사)
- [2차원 배열](#2차원-배열)
- [객체 배열](#객체-배열)
- [main의 매개변수](#main의-매개변수)

<br>

---

### 배열

> 배열은 같은 자료형의 값을 연속된 칸에 모아 저장하는 자료구조이다. 칸 번호(인덱스)는 0부터 시작하고 배열형 참조변수에는 배열의 주소가 저장된다.

<br>

```java
int arr1[] = new int[5];    // int(4byte) 칸 5개
arr1[0] = 10;
int arr2[] = {10, 20, 30};  // 선언과 동시에 값 지정
```

<br>

- 예제 코드: [배열 기초](../JAVA02/src/Ch03Array/C01ArrayBasic.java)

---

### 배열 순회

> `length`는 배열의 칸 수를 알려 주는 필드이다. 괄호가 없다. 기본 `for` 문, 향상된 `for` 문, 스트림으로 요소를 차례로 꺼낼 수 있다.

<br>

```java
for (int i = 0; i < arr.length; i++) System.out.println(arr[i]);
for (int el : arr) System.out.println(el);
Arrays.stream(arr).forEach((el) -> { System.out.println(el); });
```

<br>

> 최대값과 최소값은 첫 요소를 기준값으로 잡고 하나씩 비교해 구하거나, 스트림의 `max()`, `min()`으로 구한다. 스트림은 `OptionalInt`를 돌려주므로 `getAsInt()`로 값을 꺼낸다.

<br>

```java
Arrays.stream(arr).max().getAsInt();
Arrays.stream(arr).min().getAsInt();
Arrays.stream(arr).sum();
```

<br>

- 예제 코드: [배열 순회와 최대값 최소값](../JAVA02/src/Ch03Array/C01ArrayBasic.java)
- 예제 코드: [배열 통계 문제](../JAVA02/src/Ch03Array/C06ArrayStats.java)

---

### 배열 복사

> 얕은 복사는 배열의 주소값만 복사하는 방법이다. 두 변수가 같은 배열을 가리켜 한쪽을 바꾸면 다른 쪽도 바뀐다. 깊은 복사는 새 배열을 만들어 값을 복사하는 방법으로 서로 영향을 주지 않는다.

<br>

```java
int arr2[] = arr1;                               // 얕은 복사(주소 복사)
int arr3[] = new int[3];                         // 깊은 복사(값 복사)
for (int i = 0; i < arr1.length; i++) arr3[i] = arr1[i];
int arr4[] = Arrays.copyOf(arr1, arr1.length);   // API를 이용한 깊은 복사
```

<br>

- 예제 코드: [배열 복사](../JAVA02/src/Ch03Array/C02ArrayCopy.java)

---

### 2차원 배열

> 2차원 배열은 1차원 배열을 요소로 가지는 배열이며 `arr[행][열]`로 접근한다. `arr.length`는 행의 개수, `arr[i].length`는 i번째 행의 열 개수이다. 행마다 열의 길이가 다른 가변 배열도 만들 수 있다.

<br>

```java
int arr[][] = {
    {10, 20, 30},
    {40, 50, 60, 65, 67},
};
arr.length      // 2
arr[0].length   // 3
```

<br>

> 학생별 합계와 평균은 행 단위로, 과목별 합계와 평균은 열 단위로 더해서 구한다. 평균은 합계를 더한 개수(학생별은 과목 수, 과목별은 학생 수)로 나눈다.

<br>

- 예제 코드: [2차원 배열](../JAVA02/src/Ch03Array/C03Array2D.java)
- 예제 코드: [성적표 문제](../JAVA02/src/Ch03Array/C07ScoreTable.java)

---

### 객체 배열

> 객체 배열은 객체의 주소를 저장하는 참조변수를 요소로 가지는 배열이다. 배열만 만들면 각 칸은 `null`이므로 객체를 따로 만들어 넣어야 한다.

<br>

```java
C04Person list[] = new C04Person[3];
list[0] = new C04Person();
list[0].name = "홍길동";
```

<br>

- 예제 코드: [객체 배열](../JAVA02/src/Ch03Array/C04ClassArray.java)

---

### main의 매개변수

> `main`의 `args`는 프로그램을 실행할 때 전달한 값(Program arguments)을 문자열 배열로 받는 매개변수이다. 이클립스에서는 파일 오른쪽 마우스 - Run As - Run Configurations - Arguments 탭의 Program arguments에 `a b c d e`처럼 쓰고 실행한다.

<br>

- 예제 코드: [main의 매개변수](../JAVA02/src/Ch03Array/C05MainParam.java)

---

### Link
[Java 배열](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
