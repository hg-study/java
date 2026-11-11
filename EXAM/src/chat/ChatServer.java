package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// =======================================
// 채팅 서버
// ServerSocket 으로 접속을 받아 클라이언트마다 스레드를 만들고 메시지를 모두에게 전달
// =======================================

// 채점 항목 ------
// 2-1 ServerSocket bind / accept, 2-3 Thread 다중 접속, 2-5 try - catch - finally 와 자원 해제
public class ChatServer {

    public static final int PORT = 9999;

    // 접속한 모든 클라이언트 핸들러 ------
    // 여러 스레드가 동시에 접근하므로 Collections.synchronizedSet 으로 스레드 안전하게 만듦
    public static final Set<ChatHandler> clients =
            Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            // 서버 소켓 생성 ------
            // ServerSocket(PORT) : 포트를 열고 클라이언트의 접속을 기다리는 객체
            server = new ServerSocket(PORT);
            System.out.println("[ChatServer] 서버 시작 = PORT: " + PORT);

            // 접속 수락 반복 ------
            // accept() 가 접속을 받으면 Socket 을 돌려줌. 핸들러로 감싸 접속자 목록에 넣고 새 스레드로 시작함
            while (true) {
                Socket client = server.accept();
                ChatHandler handler = new ChatHandler(client);
                clients.add(handler);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            System.err.println("[ChatServer] 오류: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 자원 해제 : 서버 소켓이 열려 있으면 닫음
            if (server != null) {
                try { server.close(); } catch (IOException ignored) {}
            }
        }
    }

    // 브로드캐스트 ------
    // 접속한 모든 클라이언트에게 메시지를 보냄. 목록을 순회하는 동안 다른 스레드가 바꾸지 못하도록 synchronized 로 잠금
    public static void broadcast(String message) {
        synchronized (clients) {
            for (ChatHandler h : clients) {
                h.send(message);
            }
        }
    }

    // 클라이언트 접속이 끝나면 접속자 목록에서 제거함
    public static void remove(ChatHandler handler) {
        clients.remove(handler);
    }
}
