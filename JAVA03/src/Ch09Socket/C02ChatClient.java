package Ch09Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

// =======================================
// 1:1 채팅 클라이언트
// 서버와 연결해 메시지를 받고 답장하는 양방향 통신
// =======================================

public class C02ChatClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		// --- TCP 소켓 생성 및 연결 요청 ---
		// Socket(IP, Port) 생성: 대상 서버의 IP주소와 개방된 포트번호를 인자로 전달하여 연결 시도
		// 연결이 완료되면 통신을 위한 Socket 객체 생성
		Socket server = new Socket("127.0.0.1",7000);
		System.out.println("[CLIENT] SERVER와 연결되었습니다.");
		
		// --- 원시 입출력 스트림 설정 ---
		// getInputStream(): 소켓으로부터 넘어오는 데이터를 받기 위한 바이트 단위 입력 스트림(통로) 개설
		// getOutputStream(): 소켓을 통해 데이터를 내보내기 위한 바이트 단위 출력 스트림(통로) 개설
		InputStream in = server.getInputStream(); 
		OutputStream out = server.getOutputStream(); 
			
		// --- 데이터 처리 보조 스트림 연결 ---
		// DataInputStream(in): 바이트 단위 데이터를 java 기본 자료형으로 해석해 읽기 쉽게 만들어주는 보조 스트림 연결
		// DataOutputStream(out): java 기본 자료형 데이터를 네트워크 전송 가능한 바이트 데이터로 직렬화해 전송하는 보조스트림 연결
		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);
		
		// 입력, 송&수신 저장 설정
		Scanner sc = new Scanner(System.in); // 	키보드 입력
		String send = null; // 송신용 저장
		String recv = null; // 수신용 저장
		
		// 송수신 반복 : 서버의 메시지를 먼저 받고(readUTF) 답장을 보냄(writeUTF). readUTF 는 데이터가 올 때까지 멈춤(Blocking)
		while(true){
			
		
			// Server -> Client(수신)
			try {
				// 서버가 답장을 보낼 때까지 기다림
				recv = din.readUTF();				
			} catch(EOFException e) {
				System.out.println("[ERROR] 서버가 연결을 끊었습니다.");
				break;
			}
			// q 입력 시 루프 탈출
			if(recv.equals("q"))
				break;	
			// 수신 메시지 출력
			System.out.println("[SERVER] : "+recv);
			
			// 관리자의 키보드 입력
			System.out.print("[CLIENT (q: 종료)]: ");
			send = sc.nextLine();
			
			// Server-> Client(송신)
			// 서버가 먼저 메시지를 보내야 클라이언트가 읽을 수 있음
			dout.writeUTF(send);
			dout.flush();
			
			// q 입력 시 루프 탈출
			if(send.equals("q"))
				break; 
			
			}
			sc.close();
			dout.close();
			din.close();
			out.close();
			in.close();
			server.close();
			System.out.println("[CLIENT] 연결 종료합니다.");

	}

}
