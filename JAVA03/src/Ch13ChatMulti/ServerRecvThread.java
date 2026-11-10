package Ch13ChatMulti;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

// =======================================
// 서버 수신 스레드 (다중 접속)
// 접속한 클라이언트 1명을 맡아 메시지를 받고 전달
// =======================================

// 접속한 클라이언트 1명마다 만들어지는 수신 스레드. 첫 메시지로 닉네임을 받아 접속자 목록에 등록하고, 이후 받은 메시지를 다른 접속자에게 전달함
public class ServerRecvThread  implements Runnable{

	Socket client;
	DataInputStream Din;
	DataOutputStream Dout;
	ServerBackground background;
	ServerUI gui;
	String nick;
	
	public ServerRecvThread(Socket client,ServerBackground background,ServerUI gui){
		this.client=client;
		this.background = background;
		this.gui = gui;
		
		try {
			Din = new DataInputStream(client.getInputStream());
			Dout = new DataOutputStream(client.getOutputStream());
			String nick = Din.readUTF();
			this.nick = nick;
			System.out.println("닉네임 : " + nick + "님이 접속");
			this.background.addClient(nick,Dout);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			String recv;
			while(true)
			{
				recv=Din.readUTF(); //클라이언트의 전달 메시지를 수신
				if(recv!=null) {
					background.broadCast(nick,recv);
					gui.area.append(recv+"\n");
					gui.area.setCaretPosition(gui.area.getDocument().getLength()); //스크롤 하단으로 내리기
				}	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			background.removeClient(nick);
		}
		
	}

}
