package Ch09Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// =======================================
// 소켓 서버 (환영 메시지)
// ServerSocket 으로 접속을 기다렸다가 메시지를 보내는 TCP 서버
// =======================================

public class C01WelcomeServer {

	public static void main(String[] args) throws IOException {
		
		// 서버 소켓 생성 
		// new ServerSocket(포트번호)
		// 현재 PC의 7000번 포트를 열기
		// 소켓(Socket) : 네트워크로 연결된 두 프로그램이 데이터를 주고받는 끝점. IP 주소로 컴퓨터를, 포트 번호로 프로그램을 찾음
		// ServerSocket(포트) : 서버가 해당 포트를 열고 클라이언트의 접속을 기다리는 객체
		ServerSocket server = new ServerSocket(7000); // IP: 서버IP(현재 컴퓨터) PORT: 7000
		System.out.println("[INFO] SERVER SOCKET LISTENING");
		
//		// 단일 접속 처리
		// 클라이언트 1명만 처리하고 서버 종료
//		Socket client = server.accept(); 	// 1회
//		OutputStream out = client.getOutputStream();
//		DataOutputStream dout = new DataOutputStream(out);
//		System.out.println("접속자 IP: "+ client.getInetAddress());
//		dout.writeUTF("[SERVER] WELCOME TO SERVER + " + new Date());
//		dout.flush();
//		server.close();
//		System.out.println("[INFO] SERVER EXIT");	
		
		// 서버 무한 루프
		// 서버 무한 반복 : 접속자를 계속 받아 환영 메시지를 보내고 연결을 닫음 (위의 주석 처리한 코드는 1명만 처리하고 종료하는 방식)
		while(true) { 
			// accept(): 클라이언트 접속 요청 대기
			Socket client = server.accept(); 
			// getOutputStream(): 클라이언트 출력용 스트림 생성
			OutputStream out = client.getOutputStream();
			// DataOutputStream(out): 문자열 쉽게 처리하기 위한 보조스트림 생성
			DataOutputStream dout = new DataOutputStream(out);
			
			// getInetAddress(): 접속한 클라이언트 IP 주소 반환
			System.out.println("접속자 IP: "+  client.getInetAddress());
			
			// writeUTF(): 문자열 데이터를 UTF 형식으로 전송
			dout.writeUTF("[SERVER] WELCOME TO SERVER + " + new Date());
			// flush(): 버퍼 강제 전송(저장 데이터 모두 비우기)
			dout.flush();
			// close(): 자원 해제
			dout.close();
			out.close();
			client.close();
		}
	}

}
