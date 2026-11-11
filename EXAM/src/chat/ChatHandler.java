package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

// =======================================
// 클라이언트 1명을 처리하는 스레드
// 닉네임을 받고 메시지를 읽어 모두에게 전달
// =======================================

// 채점 항목 ------
// 2-3 Thread, 2-4 broadcast 송신, 2-5 자원 해제
public class ChatHandler implements Runnable {

    private final Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String nickname = "guest";

    // 생성자 ------
    // 소켓의 입출력 스트림을 줄 단위로 읽고 쓰는 BufferedReader, PrintWriter 로 감쌈
    // UTF-8 을 명시해야 한글이 깨지지 않고, PrintWriter 의 true(autoFlush)는 println 할 때마다 바로 내보냄
    public ChatHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.in  = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
    }

    @Override
    public void run() {
        try {
            // 첫 줄은 닉네임 ------
            // 클라이언트가 접속하자마자 보내는 첫 줄을 닉네임으로 저장하고 입장을 알림
            String first = in.readLine();
            if (first != null && !first.trim().isEmpty()) {
                nickname = first.trim();
            }
            ChatServer.broadcast("[시스템] " + nickname + " 님이 입장했습니다.");

            // 메시지 수신 반복 ------
            // readLine() 이 null 이면 클라이언트가 연결을 끊은 것. 받은 줄은 닉네임을 붙여 모두에게 전달함
            String line;
            while ((line = in.readLine()) != null) {
                ChatServer.broadcast(nickname + " : " + line);
            }
        } catch (IOException e) {
            System.err.println("[ChatHandler] " + nickname + " 접속 종료: " + e.getMessage());
        } finally {
            // 자원 해제 ------
            // 접속자 목록에서 제거하고 스트림과 소켓을 닫은 뒤 퇴장을 알림
            ChatServer.remove(this);
            try { if (in != null) in.close(); } catch (IOException ignored) {}
            if (out != null) out.close();
            try { if (socket != null) socket.close(); } catch (IOException ignored) {}
            ChatServer.broadcast("[시스템] " + nickname + " 님이 퇴장했습니다.");
        }
    }

    // 이 핸들러가 맡은 클라이언트에게 한 줄을 보냄
    public void send(String message) {
        if (out != null) {
            out.println(message);
        }
    }

    public String getNickname() {
        return nickname;
    }
}
