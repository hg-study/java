# Swing

- [프레임](#프레임)
- [패널과 컴포넌트](#패널과-컴포넌트)
- [이벤트 처리](#이벤트-처리)

<br>

---

### 프레임

> Swing은 자바의 GUI(화면) 라이브러리이다. `JFrame`은 창(프레임)을 만드는 클래스로 제목을 생성자로 받는다. `setBounds(x, y, 너비, 높이)`로 위치와 크기를 정하고, `setDefaultCloseOperation(EXIT_ON_CLOSE)`는 창을 닫을 때 프로그램도 종료하며, `setVisible(true)`로 화면에 표시한다.

<br>

```java
JFrame frame = new JFrame("첫번째 프레임 창입니다.");
frame.setBounds(100, 100, 500, 500);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
```

<br>

> `JFrame`을 상속한 클래스를 만들어 설정을 생성자에 모아 두면 `new`로 객체를 만드는 순간 창이 뜬다.

<br>

- 예제 코드: [JFrame](../JAVA03/src/Ch05Swing/C01SwingFrame.java)
- 예제 코드: [JFrame 상속](../JAVA03/src/Ch05Swing/C02SwingClass.java)

---

### 패널과 컴포넌트

> `JPanel`은 컴포넌트(버튼 등)를 올려 배치하는 판이고 프레임에 `add`해서 쓴다. `setLayout(null)`은 배치관리자를 쓰지 않고 컴포넌트마다 `setBounds`로 위치를 직접 지정하는 방식이다.

<br>

| 컴포넌트 | 설명 |
|---|---|
| `JButton` | 버튼 |
| `JTextField` | 한 줄 입력창 |
| `JTextArea` | 여러 줄 텍스트 영역 |
| `JScrollPane` | 내용이 넘칠 때 스크롤바를 붙여 주는 컴포넌트. 텍스트 영역은 이것에 담아 `add` |
| `JFileChooser` | 파일 탐색기 창으로 저장하거나 열 파일을 고름 |

<br>

- 예제 코드: [JPanel](../JAVA03/src/Ch05Swing/C03SwingPanel.java)
- 예제 코드: [컴포넌트 배치](../JAVA03/src/Ch05Swing/C04SwingComponent.java)
- 예제 코드: [채팅 화면 문제](../JAVA03/src/Ch05Swing/C05ChatServerUI.java)
- 예제 코드: [채팅 화면 문제 다른 배치](../JAVA03/src/Ch05Swing/C05ChatLayoutPractice.java)

---

### 이벤트 처리

> 이벤트는 클릭이나 키 입력처럼 사용자가 화면에서 일으키는 동작이다. 리스너 인터페이스를 구현하고 컴포넌트에 `addXXXListener(this)`로 연결하면 이벤트가 발생할 때 해당 메서드가 호출된다. `e.getSource()`는 이벤트가 발생한 컴포넌트이다.

<br>

| 리스너 | 메서드 | 용도 |
|---|---|---|
| `ActionListener` | `actionPerformed` | 버튼 클릭 |
| `KeyListener` | `keyTyped`, `keyPressed`, `keyReleased` | 키보드 입력. 엔터의 코드는 10 |
| `MouseListener` | `mouseClicked` 외 4개 | 마우스 클릭, 누름, 뗌, 들어옴, 나감 |

<br>

<span style="color:brown">리스너 인터페이스를 구현하면 쓰지 않는 메서드도 모두 재정의해야 한다.</span>

<br>

> 대화 영역의 클릭한 줄은 클릭 좌표를 글자 위치(offset)로 바꾸고, 줄 번호와 줄의 시작, 끝 위치를 구해 읽는다.

<br>

- 예제 코드: [ActionListener](../JAVA03/src/Ch05Swing/C06SwingActionEvent.java)
- 예제 코드: [KeyListener](../JAVA03/src/Ch05Swing/C07SwingKeyEvent.java)
- 예제 코드: [MouseListener](../JAVA03/src/Ch05Swing/C08SwingMouseEvent.java)

---

### Link
[Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/index.html)
