# Socket Chat

- [요구사항](#요구사항)
- [서버](#서버)
- [클라이언트 핸들러](#클라이언트-핸들러)
- [클라이언트](#클라이언트)
- [시연](#시연)

<br>

---

### 요구사항

> 직원 2명 이상이 동시에 접속해 채팅할 수 있는 다중 클라이언트 시스템이다. 서버는 `ServerSocket(9999)`을 열고 `accept()` 반복으로 접속을 받아 `Thread`로 클라이언트를 처리하며 메시지를 모두에게 전달(브로드캐스트)한다. 클라이언트는 `Socket`으로 접속해 Swing 채팅창에서 보내고 받는다. 예외는 `try - catch - finally`와 `close()`로 처리한다.

<br>

| 체크리스트 | 구현 위치 |
|---|---|
| ServerSocket bind와 accept | `ChatServer` |
| Socket connect와 I/O 스트림 | `ChatClient` |
| Thread 다중 접속 | `ChatHandler` |
| broadcast 송신 | `ChatServer.broadcast()`, `ChatHandler.send()` |
| try - catch - finally와 close | `chat` 패키지 전체 |

<br>

---

### 서버

> `ChatServer.main()`은 서버 소켓을 만들고 무한 반복으로 `accept()`한다. 받은 `Socket`을 `ChatHandler`로 감싸 접속자 목록(`clients`)에 넣고 새 `Thread`로 시작한다. 접속자 목록은 여러 스레드가 동시에 쓰므로 `Collections.synchronizedSet`으로 만들고, `broadcast()`는 `synchronized (clients)` 안에서 순회하며 각 핸들러의 `send()`를 호출한다.

<br>

```java
ServerSocket server = new ServerSocket(PORT);
while (true) {
    Socket client = server.accept();
    ChatHandler handler = new ChatHandler(client);
    clients.add(handler);
    new Thread(handler).start();
}
```

<br>

- 예제 코드: [채팅 서버](../EXAM/src/chat/ChatServer.java)

---

### 클라이언트 핸들러

> `ChatHandler`는 접속한 클라이언트 1명을 맡는 스레드이다. 생성자에서 입출력 스트림을 `BufferedReader`와 `PrintWriter`로 감싸고 한글이 깨지지 않도록 UTF-8을 명시하며 `autoFlush`를 `true`로 둔다. `run()`은 첫 줄을 닉네임으로 받아 입장을 알리고, `readLine()` 반복으로 받은 줄을 `닉네임 : 내용`으로 브로드캐스트한다. `finally`에서 접속자 목록에서 제거하고 자원을 닫은 뒤 퇴장을 알린다.

<br>

- 예제 코드: [채팅 핸들러](../EXAM/src/chat/ChatHandler.java)

---

### 클라이언트

> `ChatClient`는 `connect(host, port, nickname)`에서 접속하고 스트림을 UTF-8로 만든 뒤 첫 줄로 닉네임을 보내고, 수신 전용 데몬 스레드를 시작한다. 받은 줄은 생성자로 전달받은 `Consumer<String>`(화면이 채팅창에 추가하는 동작)에 넘긴다. 연결을 끊을 때는 `socket`을 먼저 닫아야 수신 스레드의 `readLine` 대기가 풀리고, 순서를 잘못 닫으면 화면 스레드가 멈출 수 있다.

<br>

<span style="color:brown">화면 코드(`ChatClientUI`)는 제공된 파일이라 수정하지 않는다. `ChatClient`의 `connect`, `send`, `disconnect`, `isConnected` 시그니처를 그대로 유지해야 한다.</span>

<br>

- 예제 코드: [채팅 클라이언트](../EXAM/src/chat/ChatClient.java)
- 예제 코드: [채팅 클라이언트 화면 (제공)](../EXAM/provided/chat/ChatClientUI.java)

---

### 시연

> 서버를 실행하고 클라이언트 화면을 2개 이상 띄워 서로 다른 닉네임으로 접속하면, 입장 알림과 대화가 양쪽 창에 모두 나타나고 한쪽을 닫으면 퇴장 알림이 나타난다.

<br>

---

### Link
[Java Sockets](https://docs.oracle.com/javase/tutorial/networking/sockets/index.html)
