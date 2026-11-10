package Ch11ThreadChat;

import java.io.DataInputStream;
import java.io.EOFException;

// =======================================
// 클라이언트 수신 스레드
// 서버가 보낸 메시지를 계속 받아 출력
// =======================================

// readUTF() 는 메시지가 올 때까지 멈추므로 별도 스레드에서 반복해 받음
public class ClientRecvThread  implements Runnable{

	DataInputStream din;
	
	
	public ClientRecvThread(DataInputStream din) {
		this.din = din;
	}

	@Override
	public void run() {
		String recv = null; 	// 수신용
		while (true) {
			// Server->Client(수신)
			try {
				
				recv = din.readUTF();
				
			} catch (EOFException e) {
				System.out.println("[ERROR] 서버가 연결을 끊었습니다.");
				break;
			}catch(Exception e2) {
				System.out.println("[ERROR] 기타 예외발생 : " + e2.getCause());
				break;
			}
			if (recv.equals("q"))
				break;
			System.out.println("\n[SERVER] : " + recv);
		}
		
		System.exit(-1);
		
	}

}
