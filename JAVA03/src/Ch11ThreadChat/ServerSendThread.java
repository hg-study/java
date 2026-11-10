package Ch11ThreadChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

// =======================================
// 서버 송신 스레드
// 키보드로 입력한 메시지를 클라이언트로 계속 전송
// =======================================

// nextLine() 이 키보드 입력을 기다리며 멈추므로 별도 스레드에서 반복해 보냄. 종료는 수신 스레드가 System.exit 로 처리함
public class ServerSendThread implements Runnable {

	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);

	public ServerSendThread(DataOutputStream dout) {
		this.dout = dout;
	}

	@Override
	public void run() {

		String send = null; // 송신용

		while (true) {
			System.out.print("[SERVER (q:종료)] : ");
			send = sc.nextLine();
			// Server->Client(송신)
			try {
				dout.writeUTF(send);
				dout.flush();
//				if (send.equals("q"))
//					break;

			} catch (IOException e) {
				System.out.print("[EXCEPTION] : " + e.getCause());
//				e.printStackTrace();
			}
			
		}
		
//		sc.close();

	}

}
