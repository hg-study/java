# Thread

- [스레드](#스레드)
- [스레드 만들기](#스레드-만들기)
- [스레드 제어](#스레드-제어)
- [동기화](#동기화)

<br>

---

### 스레드

> 스레드(Thread)는 프로그램 안에서 실행되는 하나의 흐름이다. `main` 메서드는 메인 스레드에서 실행된다. 스레드가 하나면 작업이 차례로만 실행되므로 두 작업을 동시에 하려면 스레드를 나눠야 한다.

<br>

> `Thread.sleep(ms)`는 지정한 시간 동안 현재 스레드를 멈춘다. 멈춰 있는 동안 `interrupt()`되면 `InterruptedException`이 발생한다.

<br>

- 예제 코드: [스레드 없이 순차 실행](../JAVA03/src/Ch10Thread/C01ThreadSequential.java)

---

### 스레드 만들기

> 두 가지 방법이 있다. `Runnable`을 구현한 클래스를 만들어 `new Thread(객체)`로 감싸는 방법과, `Thread`를 상속(익명 클래스)해 `run()`을 재정의하는 방법이다. 둘 다 `start()`로 새 스레드를 만들어 `run()`을 실행한다.

<br>

```java
Thread th1 = new Thread(new C02WorkerA());   // Runnable 구현 객체
th1.start();

new Thread() {                               // Thread 상속
    @Override
    public void run() { ... }
}.start();
```

<br>

<span style="color:brown">`run()`을 직접 호출하면 새 스레드가 아니라 메인 스레드에서 실행된다. 반드시 `start()`를 호출한다.</span>

<br>

- 예제 코드: [스레드 나누기](../JAVA03/src/Ch10Thread/C02ThreadSplit.java)
- 예제 코드: [작업 A](../JAVA03/src/Ch10Thread/C02WorkerA.java)
- 예제 코드: [작업 B](../JAVA03/src/Ch10Thread/C02WorkerB.java)

---

### 스레드 제어

> 화면의 시작 버튼으로 스레드를 만들어 시작하고, 중지 버튼에서 `interrupt()`로 대기 중인 스레드에 예외를 일으켜 반복을 끝낸다. 스레드를 필드에 보관해 중복 실행을 막고 중지한 뒤에는 `null`로 비워 다시 시작할 수 있게 한다. `join()`은 해당 스레드가 끝날 때까지 호출한 스레드가 기다린다.

<br>

- 예제 코드: [스레드와 Swing](../JAVA03/src/Ch10Thread/C03ThreadSwing.java)
- 예제 코드: [작업 A (Swing)](../JAVA03/src/Ch10Thread/C03WorkerA.java)
- 예제 코드: [작업 B (Swing)](../JAVA03/src/Ch10Thread/C03WorkerB.java)

---

### 동기화

> 경쟁 상태(Race Condition)는 여러 스레드가 동기화 없이 같은 변수를 동시에 바꿔 값이 덮어써지는 현상이다. 스레드 4개가 공유 변수를 각각 100000번 증가시키면 400000이어야 하지만 그보다 작게 나온다.

<br>

> 동기화(`synchronized`)는 한 번에 하나의 스레드만 임계 영역(공유 자원을 쓰는 코드)에 들어가게 하는 것이다. 락(Lock) 객체를 기준으로 잠그고, `wait(ms)`는 락을 놓고 대기, `notifyAll()`은 대기 중인 다른 스레드를 깨운다.

<br>

```java
synchronized (Lock) {
    counter++;
    Lock.notifyAll();
    Lock.wait(5);
}
```

<br>

- 예제 코드: [스레드 경쟁 상태 문제](../JAVA03/src/Ch10Thread/C04ThreadRace.java)
- 예제 코드: [스레드 동기화](../JAVA03/src/Ch10Thread/C05ThreadSync.java)

---

### Link
[Java Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)
