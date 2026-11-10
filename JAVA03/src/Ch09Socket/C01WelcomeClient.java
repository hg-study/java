package Ch09Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.Socket;

// =======================================
// 소켓 클라이언트 (메시지 수신)
// 서버에 접속해 메시지를 받는 TCP 클라이언트
// =======================================

public class C01WelcomeClient {

	public static void main(String[] args) throws IOException {
		
		// Socket 생성: 서버의 IP주소와 Port번호를 인자로 넣어 연결 시도
		// new Socket(서버의 목적지 주소,서버가 열어둔 대기 포트)
		// 연결 실패 시(서버가 안 켜졌거나 IP가 틀림 등) IOException 발생
		// Socket(서버 주소, 포트) : 서버에 접속을 시도하는 객체. 127.0.0.1 은 내 컴퓨터를 뜻하며 다른 컴퓨터의 서버에 접속하려면 그 IP 를 씀
		Socket server = new Socket("127.0.0.1",7000);
				
		// getInputStream(): 서버로부터 넘어오는 데이터 받는 통로 개설(바이트 단위)
		InputStream in = server.getInputStream();
		// DataInputStream(in): 바이트 단위 데이터를 java 기본 자료형으로 쉽게 변환하기 위해 보조 스트림 연결
		DataInputStream din = new DataInputStream(in);
		
		// readUTF(): 스트림으로부터 UTF-8 형식으로 인코딩된 문자열을 읽어옴
		// 서버에서 writeUTF()로 보내면 짝을 맞춰 readUTF()로 받아야 함
		// 데이터가 올 때까지 Blocking(실행 멈춤)
		String recv = din.readUTF();
		// 서버로부터 받은 문자열 콘솔 출력
		System.out.println("메시지: " + recv);
	
		// 자원 해제(생성의 역순으로)
		din.close();
		in.close();
		server.close();
	}

}
