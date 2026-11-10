package Ch11ThreadChat;

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
// 스레드 채팅 클라이언트
// 송신 스레드와 수신 스레드를 나눠 동시에 주고받는 클라이언트
// =======================================

public class ClientMain {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// Socket(서버 주소, 포트) : 서버에 접속함. 127.0.0.1 은 내 컴퓨터
		Socket server = new Socket("127.0.0.1",9000);
		System.out.println("[CLIENT] SERVER와의 연결이 완료되었습니다");
		
		InputStream in = server.getInputStream();
		OutputStream out = server.getOutputStream();
		
		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);
		
		// 송수신 스레드 만들기 ------
		// 수신 스레드와 송신 스레드를 따로 만들어 서로 기다리지 않고 동시에 처리함
		ClientRecvThread recvThread = new ClientRecvThread(din);
		ClientSendThread sendThread = new ClientSendThread(dout);
		Thread th1 = new Thread(recvThread);
		Thread th2 = new Thread(sendThread);
		
		th1.start();
		th2.start();
		
		// join() : 두 스레드가 끝날 때까지 메인 스레드가 기다린 뒤 자원을 닫음
		th1.join();
		th2.join();
		
		
// 이전 방식(주석 처리) : 서버의 메시지를 받은 뒤에만 입력할 수 있던 코드. 송신 스레드와 수신 스레드로 나눠 어느 쪽이든 먼저 보낼 수 있게 함
//		Scanner sc = new Scanner(System.in);	//키보드입력
//		String send = null; 	// 송신용
//		String recv = null; 	// 수신용
//		//
//		//
//		while(true) {
//			//Server->Client(수신) - 
//			try {
//				recv = din.readUTF();
//			}catch(EOFException e){
//				System.out.println("[ERROR] 서버가 연결을 끊었습니다.");
//				break;
//			}
//			if(recv.equals("q"))
//				break;
//			System.out.println("[SERVER] : "+recv);
//			System.out.print("[CLIENT (q:종료)] : ");
//			send = sc.nextLine();
//			//Client->Server(송신)
//			dout.writeUTF(send);
//			dout.flush();
//			if(send.equals("q"))
//				break;
//		}
//		sc.close();
		
		
		dout.close();
		din.close();
		out.close();
		in.close();
		server.close();
		System.out.println("[CLIENT] 연결 종료합니다");
		
	}

}
