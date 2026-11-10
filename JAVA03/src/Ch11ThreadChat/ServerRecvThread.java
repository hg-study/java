package Ch11ThreadChat;

import java.io.DataInputStream;
import java.io.EOFException;

// =======================================
// 서버 수신 스레드
// 클라이언트가 보낸 메시지를 계속 받아 출력
// =======================================

// readUTF() 는 메시지가 올 때까지 멈추므로 별도 스레드에서 반복해 받음. q 를 받거나 연결이 끊기면 반복을 끝내고 프로그램을 종료함
public class ServerRecvThread implements Runnable{
	
	DataInputStream din;
	
	public ServerRecvThread(DataInputStream din) {
		this.din = din;
	}

	@Override
	public void run() {
		String recv = null; 	// 수신용
		while (true) {
			// Client->Sever(수신) -
			try {
				
				recv = din.readUTF();
				
			} catch (EOFException e) {
				System.out.println("[ERROR] 클라이언트가 연결을 끊었습니다.");
				break;
			}catch(Exception e2) {
				System.out.println("[ERROR] 기타 예외발생 : " + e2.getCause());
				break;
			}
			if (recv.equals("q")) {
				System.out.println("CLIENT q 입력함..while종료!");
				break;
			}
			System.out.println("\n[CLIENT] : " + recv);
		}
		
		System.exit(-1);
		
	}

}
