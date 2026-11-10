package Ch11ThreadChat;

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
// 스레드 채팅 서버
// 송신 스레드와 수신 스레드를 나눠 동시에 주고받는 서버
// =======================================

public class ServerMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		// 서버 소켓 생성 ------
		ServerSocket server = new ServerSocket(9000);// IP: 서버IP(현재컴퓨터) PORT : 9000
		System.out.println("[INFO] SERVER SOCKET LISTENING");

		// accept() : 클라이언트가 접속할 때까지 멈춰 있다가 접속하면 통신용 Socket 을 돌려줌
		Socket client = server.accept();	// 1회
		System.out.println("[INFO] 접속자 IP : " + client.getInetAddress());
		
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		
		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);
		
		// 송수신 스레드 만들기 ------
		// 수신 스레드와 송신 스레드를 따로 만들어 서로 기다리지 않고 동시에 처리함
		ServerRecvThread recvThread = new ServerRecvThread(din);
		ServerSendThread sendThread = new ServerSendThread(dout);
		Thread th1 = new Thread(recvThread);
		Thread th2 = new Thread(sendThread);
		
		th1.start();
		th2.start();
		
		// join() : 두 스레드가 끝날 때까지 메인 스레드가 기다린 뒤 자원을 닫음
		th1.join();
		th2.join();
		
//		//
// 이전 방식(주석 처리) : 한 흐름에서 보내기와 받기를 번갈아 하던 코드. 한쪽이 입력을 기다리는 동안 상대 메시지를 읽지 못해 송신 스레드와 수신 스레드로 나눔
//		Scanner sc = new Scanner(System.in);	//키보드입력
//		String send = null; 	// 송신용
//		String recv = null; 	// 수신용
//		//
//		while(true) {
//			System.out.print("[SERVER (q:종료)] : ");
//			send = sc.nextLine();
//			//Server->Client(송신)
//			dout.writeUTF(send);
//			dout.flush();
//			if(send.equals("q"))
//				break;
//			//Client->Sever(수신) - 
//			try {
//				recv = din.readUTF();
//			}catch(EOFException e){
//				System.out.println("[ERROR] 클라이언트가 연결을 끊었습니다.");
//				break;
//			}
//			if(recv.equals("q"))
//				break;
//			System.out.println("[CLIENT] : "+recv);
//		}
		
//		sc.close();
		
		dout.close();
		din.close();
		out.close();
		in.close();
		client.close();
		server.close();
		System.out.println("[SERVER] 연결 종료합니다");
		
		
	}

}
