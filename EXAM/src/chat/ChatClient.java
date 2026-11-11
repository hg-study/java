package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.Consumer;

// =======================================
// 채팅 클라이언트
// 서버에 접속해 메시지를 보내고, 받은 메시지는 화면(UI)으로 전달
// =======================================

// 채점 항목 ------
// 2-2 Socket 접속과 I/O 스트림, 2-5 자원 해제
public class ChatClient {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Thread readerThread;

    // 받은 메시지를 처리하는 함수. 화면(ChatClientUI)이 채팅창에 추가하는 동작을 넘겨 줌
    private final Consumer<String> messageListener;
    private volatile boolean running = false;

    public ChatClient(Consumer<String> messageListener) {
        this.messageListener = messageListener;
    }

    // 서버 접속 ------
    // 접속하고 입출력 스트림을 UTF-8 로 만든 뒤, 첫 줄로 닉네임을 보내고, 수신 전용 스레드를 시작함
    public void connect(String host, int port, String nickname) throws IOException {
        socket = new Socket(host, port);
        in  = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

        out.println(nickname);

        // 데몬 스레드 : 프로그램이 끝나면 함께 종료되는 보조 스레드
        running = true;
        readerThread = new Thread(this::readLoop);
        readerThread.setDaemon(true);
        readerThread.start();
    }

    // 메시지 송신 : 한 줄을 서버로 보냄
    public void send(String message) {
        if (out != null) {
            out.println(message);
        }
    }

    // 수신 반복 : 서버가 보낸 줄을 읽어 화면으로 전달함. 연결이 끊기면 안내하고 정리함
    private void readLoop() {
        try {
            String line;
            while (in != null && (line = in.readLine()) != null) {
                messageListener.accept(line);
            }
        } catch (IOException e) {
            if (running) {
                messageListener.accept("[시스템] 서버와의 연결이 종료되었습니다: " + e.getMessage());
            }
        } finally {
            disconnect();
        }
    }

    // 연결 종료 ------
    // socket 을 먼저 닫아야 수신 스레드의 readLine 대기가 풀림
    // (Java 21 부터 BufferedReader 는 락으로 보호되어 순서를 잘못 닫으면 화면 스레드가 멈출 수 있음)
    public void disconnect() {
        running = false;
        try { if (socket != null) socket.close(); } catch (IOException ignored) {}
        try { if (in != null) in.close(); } catch (IOException ignored) {}
        if (out != null) out.close();
    }

    public boolean isConnected() {
        return socket != null && !socket.isClosed();
    }
}
