package Ch12ChatGui;

import java.io.DataInputStream;
import java.io.EOFException;

// =======================================
// 서버 수신 스레드 (GUI)
// 클라이언트의 메시지를 받아 서버 화면에 출력
// =======================================

// 화면 객체를 받아 readUTF 로 받은 메시지를 대화 영역(area)에 추가함. 연결이 끊기거나 q 를 받으면 종료
public class ServerRecvThread implements Runnable{
	
	DataInputStream din;
	Sgui sgui;
	public ServerRecvThread(DataInputStream din) {
		this.din = din;
	}

	public ServerRecvThread(DataInputStream din, Sgui sgui) {
		this.din = din;
		this.sgui = sgui;
	}

	@Override
	public void run() {
		String recv = null; 	// 수신용
		while (true) {
			// 상대가 보낸 메시지 받기 ------
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
			System.out.println("[CLIENT] : " + recv+"\n");
			sgui.area.append("[CLIENT] : " + recv+"\n");
		}
		
		System.exit(-1);
		
	}

}
