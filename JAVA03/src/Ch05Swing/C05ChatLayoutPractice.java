package Ch05Swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// =======================================
// 채팅 화면 문제 (다른 배치)
// 폭 365 로 입력창과 버튼 위치를 조금 다르게 배치
// =======================================

// 문제 : 앞의 채팅 화면과 같은 구성을 좌표만 달리해 만드는 문제
class C05bGUI extends JFrame{
	
	// 생성자 : 프레임 설정과 화면 구성을 함
	C05bGUI(String title){
		
		// Frame 설정 ------
		super(title);
		setBounds(100,100,365,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Panel 설정 ------
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		// Component 설정 ------
		
		// 왼쪽 : 대화 영역과 입력창
		// JTextArea : 여러 줄을 보여 주는 대화 영역. JScrollPane 에 담아야 스크롤바가 생김
		JTextArea area1 = new JTextArea();		
		JScrollPane scroll = new JScrollPane(area1);
		scroll.setBounds(10,10,210,300);		// x, y, W, H		
		
		// JTextField : 한 줄 입력창
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,320,210,30);
		
		// 오른쪽 : 버튼
		// JButton : 버튼
		JButton btn1 = new JButton("파일로 저장");
		btn1.setBounds(230, 10, 110, 30);
		JButton btn2 = new JButton("1:1 요청");
		btn2.setBounds(230, 50, 110, 30);
		JButton btn3 = new JButton("대화기록보기");
		btn3.setBounds(230, 90, 110, 30);

		JButton btn4 = new JButton("입력");
		btn4.setBounds(230, 320, 110, 30);
		
		// Panel 에 Component 추가 ------
		panel.add(scroll);		
		panel.add(txt1);		
		panel.add(btn1);
		panel.add(btn2);	
		panel.add(btn3);
		panel.add(btn4);		

		// Frame 에 Panel 추가 ------
		add(panel); 
		
		setVisible(true);		
	}
}

public class C05ChatLayoutPractice {

	public static void main(String[] args) {
		new C05bGUI ("Chatting Server");

	}

}
