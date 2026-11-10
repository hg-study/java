package Ch12ChatGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// =======================================
// GUI 채팅 클라이언트
// 1:1 채팅 클라이언트 화면. 서버에 접속하고 수신 스레드로 메시지를 받음
// =======================================

// 화면(JFrame) 클래스가 서버 접속까지 담당하는 클라이언트
class Cgui extends JFrame implements ActionListener,KeyListener
{
	
	JTextArea area;
	JScrollPane scroll;
	JTextField txt1;
	
	// 소켓 통신용 스트림
	DataInputStream din;
	DataOutputStream dout;
	
	Cgui() throws Exception {
		super("Chat Client");	//프레임창 제목		
		JPanel pannel = new JPanel(); //패널 생성		
		pannel.setLayout(null);	//Layout 설정 x	

		area = new JTextArea();	//텍스트영역창
		area.setEditable(false);
		//area.setBounds(10,10,260,240);	//스크롤 추가시 생략	
		scroll = new JScrollPane(area); //area에 스크롤 추가하기
		scroll.setBounds(10,10,260,240);		

		txt1 = new JTextField();			//텍스트입력창 
		txt1.setBounds(10,260,260,30);		//크기
		txt1.addKeyListener(this);			//이벤트 추가(키보드)
	 

		pannel.add(txt1);
		//pannel.add(area);		//스크롤 추가시 생략
		pannel.add(scroll);
		
		add(pannel);			//프레임에 패널 추가
		
		setBounds(100,100,300,350);	//프레임창 위치
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료버튼 사용가능상태
		setVisible(true);	//프레임창 보여주기
		
		// 소켓 연결 요청 ------
		Socket server = new Socket("127.0.0.1",6000);
		System.out.println("[CLIENT] SERVER와의 연결이 완료되었습니다");
		area.append("[CLIENT] SERVER와의 연결이 완료되었습니다\n");
		
		InputStream in = server.getInputStream();
		OutputStream out = server.getOutputStream();
		
		din = new DataInputStream(in);
		dout = new DataOutputStream(out);
		
		// 수신 스레드에 화면 객체(this)를 넘겨 받은 메시지를 대화 영역에 출력하게 함
		ClientRecvThread recvThread = new ClientRecvThread(din,this);
		Thread th1 = new Thread(recvThread);
		th1.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
	}

	// keyTyped : 문자가 입력될 때 호출됨 (유니코드 지원, 실행하는 코드 없음)
	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("KEYTPYED함수 : " + e.getKeyChar());
		
	}
	// keyPressed : 키를 누를 때 호출됨. 엔터(코드 10)면 입력창의 글을 대화 영역에 추가하고 전송함
	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == 10) // 엔터키 입력
		{
			System.out.println("Enter key 입력");
			// 입력창의 내용을 대화 영역에 추가
			area.append("[CLIENT] : " + txt1.getText() + "\n");

			try {
				dout.writeUTF(txt1.getText());
				dout.flush();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			txt1.setText("");
		}
	}
	// keyReleased : 키에서 손을 뗄 때 호출됨 (실행하는 코드 없음)
	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("KEYRELEASED함수 : "+e.getKeyChar());
		
	}

	 
}

public class ClientUI {

	public static void main(String[] args) throws Exception{
		new Cgui();
	}

}
