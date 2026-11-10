package Ch13ChatMulti;

import java.io.*;
import java.net.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// =======================================
// 서버 백그라운드
// 접속자 목록을 관리하고 메시지를 전달(브로드캐스트)
// =======================================

// 화면과 별개로 소켓 접속 처리와 접속자 관리를 맡는 클래스
public class ServerBackground {
	ServerSocket server;
	ServerUI gui;
	// 접속자 목록 : 닉네임을 키로, 그 접속자에게 보내는 출력 스트림을 값으로 저장하는 Map
	Map<String,DataOutputStream> ClientList; //!!
	Socket client;
	
	
	ServerBackground(ServerUI ui)
	{
		gui = ui;
		ClientList = new HashMap();
		Collections.synchronizedMap(ClientList);//컬렉션 동기화 
		
	}
	
	
	// 서버 소켓을 열고 접속을 계속 받으며, 접속마다 수신 스레드를 만들어 시작함
	public void Setting() {
		try {
			
			server = new ServerSocket(5555);

			while(true) {
				gui.area.append("서버 접속 요청 대기중....\n");
				client=server.accept();
				gui.area.append(client.getInetAddress()+" 에서 접속중..\n");
				
				//수신 스레드 처리 
				ServerRecvThread recv = new ServerRecvThread(client,this,gui);
				Thread th = new Thread(recv);
				th.start();
				
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	// 접속 알림을 모두에게 보내고 접속자 목록에 추가함
	public void addClient(String nick, DataOutputStream Dout) {
		broadCast(nick  + " 님이 접속하셨습니다" +client.getInetAddress()+"\n");
		ClientList.put(nick, Dout);
		
	}
	// 접속자 목록에서 제거함
	public void removeClient(String nick) {
		gui.area.append(nick + " 님이 퇴장하셨습니다\n");
		ClientList.remove(nick);
	}
	
	// broadCast : 접속한 모든 클라이언트에게 메시지를 보냄
	public void broadCast(String msg) {
	
		for(String key : ClientList.keySet()) {
			try {		
				ClientList.get(key).writeUTF(msg);
				ClientList.get(key).flush();		
			}catch(Exception e) {}
			
		}
		
		
		
	}
	
	// 보낸 사람(nick)을 제외한 모든 접속자에게 메시지를 보냄
	public void broadCast(String nick, String msg) throws IOException {

		for(String tmpnick : ClientList.keySet())
		{
			if(!nick.equals(tmpnick))
			{
				DataOutputStream out =  ClientList.get(tmpnick);	//nick에 대응되는 outputStream을 꺼냄
				out.writeUTF(msg);
				out.flush();
			}
			
		}
		
		
	}
	

}
