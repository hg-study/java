package Ch12ChatGui;

import java.io.DataInputStream;
import java.io.EOFException;

// =======================================
// 클라이언트 수신 스레드 (GUI)
// 서버의 메시지를 받아 클라이언트 화면에 출력
// =======================================

// 화면 객체를 받아 readUTF 로 받은 메시지를 대화 영역(area)에 추가함. 연결이 끊기거나 q 를 받으면 종료
public class ClientRecvThread  implements Runnable{

	DataInputStream din;
	Cgui cgui;
	public ClientRecvThread(DataInputStream din) {
		this.din = din;
	}

	public ClientRecvThread(DataInputStream din, Cgui cgui) {
		this.din = din;
		this.cgui = cgui;
	}

	@Override
	public void run() {
		String recv = null; 	// 수신용
		while (true) {
			// 상대가 보낸 메시지 받기 ------
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
			System.out.println("[SERVER] : " + recv+"\n");
			cgui.area.append("[SERVER] : " + recv+"\n");
		}
		
		System.exit(-1);
		
	}

}
