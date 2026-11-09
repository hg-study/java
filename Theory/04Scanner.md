# Scanner

### Scanner

> `Scanner`는 키보드로 입력한 데이터를 읽는 클래스다. `System.in`(표준 입력 스트림, 키보드)에 연결해 객체를 만들고 `nextInt()`, `nextLine()` 같은 메서드로 값을 읽는다. 값을 입력하고 엔터를 누를 때까지 프로그램이 멈춰 기다린다.

<br>

```java
Scanner sc = new Scanner(System.in);   // 표준 입력 스트림에 연결한 Scanner 객체 생성
System.out.print("num1 입력: ");
int num1 = sc.nextInt();                // 정수 입력
sc.close();                             // 사용이 끝나면 닫는다
```

<br>

`new Scanner(System.in)`은 Heap 영역에 객체를 만들고, 그 객체의 위치(메모리 주소)를 main 메서드의 스택 영역에 있는 참조변수 `sc`에 저장한다.

<br>

| **메서드** | **설명** |
| --- | --- |
| `nextInt()` | 정수를 읽는다. 엔터와 스페이스바로 구분하므로 한 줄에 공백으로 나눠 입력할 수 있다 |
| `next()` | 문자열을 읽는다. 띄어쓰기 앞까지만 읽는다 |
| `nextLine()` | 한 줄 전체를 읽는다. 띄어쓰기를 포함한다 |

<br>

<span style="color:brown">`nextInt()` 뒤에 `nextLine()`을 쓰면 정수 뒤에 남은 엔터(`\n`)를 `nextLine()`이 바로 읽어서 입력을 기다리지 않고 지나간다. 사이에 `sc.nextLine();`을 한 번 더 호출해 남은 엔터를 비운다.</span>

<br>

**정리**

| **구분** | **설명** |
| --- | --- |
| `System.out.print()` | 기본 출력 |
| `System.out.printf()` | 서식문자를 쓰는 출력 |
| `System.out.println()` | 줄바꿈을 포함한 출력 |
| `Scanner` | 키보드 입력을 읽는 클래스 |

<br>

**문제**

1. `Scanner`로 입력한 두 수를 더해 출력한다. 문자열로 읽어 `Integer.parseInt()`로 바꾸는 방법도 있다.
2. 이름, 주민번호 앞 6자리, 전화번호를 입력받아 입력한 내용을 출력한다.

<br>

- 예제 코드: [정수 입력](../JAVA01/src/Ch03Input/C01ScannerInt.java)
- 예제 코드: [문자열 입력과 엔터 처리](../JAVA01/src/Ch03Input/C02ScannerLine.java)
- 예제 코드: [이름, 나이, 주소 입력](../JAVA01/src/Ch03Input/C03ScannerInfo.java)
- 예제 코드: [정리 문제](../JAVA01/src/Ch03Input/C04Review.java)

<br>

---

<br>

**Scanner 요약**

<aside>

> Scanner: new Scanner(System.in)로 키보드 입력을 읽음 <br>
nextInt는 정수, next는 단어, nextLine은 한 줄 <br>
nextInt 뒤 nextLine은 남은 엔터를 먼저 비워야 함

</aside>

<br>

### Link
[Scanner (Java SE 21)](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html)
