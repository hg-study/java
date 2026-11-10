package Ch09Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// =======================================
// 1:1 채팅 서버
// 서버가 먼저 보내고 클라이언트의 답장을 받는 양방향 통신
// =======================================

public class C02ChatServer {

	public static void main(String[] args) throws IOException {
		// 서버 소켓 생성(7000번 포트 개방)
		ServerSocket server = new ServerSocket(7000); // IP: 서버IP(현재 컴퓨터) PORT: 7000
		System.out.println("[INFO] SERVER SOCKET LISTENING");
		
		// 클라이언트 접속 대기 및 수락
		// 여기서 멈춰 있다가 클라이언트가 접속하는 순간 다음 코드로
		// accept() : 클라이언트가 접속할 때까지 멈춰 있다가 접속하면 통신용 Socket 을 돌려줌
		Socket client = server.accept(); 	// 1회
		System.out.println("[INFO] 접속자 IP: "+ client.getInetAddress());
		
		// 양방향 통신 위해 스트림 설정
		InputStream in = client.getInputStream();  // 메시지를 받을 통로
		OutputStream out = client.getOutputStream();  // 메시지를 보낼 통로
			
		// 보조 스트림 연결
		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);
		
		// 입력, 송&수신 저장 설정
		Scanner sc = new Scanner(System.in); // 	키보드 입력
		String send = null; // 송신용 저장
		String recv = null; // 수신용 저장

		// 송수신 반복 : 서버가 먼저 보내고(writeUTF) 클라이언트의 답장을 받음(readUTF). 한쪽이 q 를 보내면 종료
		while(true){
			// 관리자의 키보드 입력
			System.out.print("[SERVER (q: 종료)]: ");
			send = sc.nextLine();
			
			// Server-> Client(송신)
			// 서버가 먼저 메시지를 보내야 클라이언트가 읽을 수 있음
			dout.writeUTF(send);
			dout.flush();
			
			// q 입력 시 루프 탈출
			if(send.equals("q"))
				break;
			
			// Client -> Sever(수신)
			
			try {
				// 클라이언트가 답장을 보낼 때까지 기다림
				recv = din.readUTF();				
			} catch(EOFException e) {
				System.out.println("[ERROR] 클라이언트가 연결을 끊었습니다.");
				break;
			}
			// q 입력 시 루프 탈출
			if(recv.equals("q"))
				break;
			}
		
			// 수신 메시지 출력
			System.out.print("[CLIENT]: "+ recv);
			
			sc.close();
			dout.close();
			din.close();
			out.close();
			in.close();
			client.close();
			server.close();
			System.out.println("[SERVER] 연결 종료합니다.");
			
			
		
	}

}
