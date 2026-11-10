package Ch11ThreadChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

// =======================================
// 클라이언트 송신 스레드
// 키보드로 입력한 메시지를 서버로 계속 전송
// =======================================

// nextLine() 이 키보드 입력을 기다리며 멈추므로 별도 스레드에서 반복해 보냄
public class ClientSendThread  implements Runnable{

	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);

	public ClientSendThread(DataOutputStream dout) {
		this.dout = dout;
	}

	@Override
	public void run() {

		String send = null; // 송신용

		while (true) {
			System.out.print("[CLIENT (q:종료)] : ");
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
//		System.out.println("!!!");
//		sc.close();

	}

}
