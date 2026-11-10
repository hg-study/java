package Ch05Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// =======================================
// ActionListener
// 버튼 클릭 이벤트 처리
// =======================================

// ActionListener : 버튼 클릭 같은 액션 이벤트를 받는 인터페이스. 구현하면 actionPerformed 메서드를 반드시 재정의해야 함
class C06GUI extends JFrame implements ActionListener
{
	
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	
	C06GUI(String title){
		
		// Frame 설정 ------
		super(title);
		setBounds(100,100,400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Panel 설정 ------
		JPanel panel = new JPanel();
// 패널 배경색 지정(주석 처리). Color(R, G, B)
//		Color col = new Color(255,255,0);
//		panel.setBackground(col);
		panel.setLayout(null);
		
		// Component 설정 ------
		JTextArea area1 = new JTextArea(); 
//		area1.setBounds(10,90,210,300);
		JScrollPane scroll = new JScrollPane(area1);
		scroll.setBounds(10,10,200,280);
		
		btn1 = new JButton("파일로저장");
		btn1.setBounds(230,10,120,30);
		btn2 = new JButton("1:1 요청");
		btn2.setBounds(230,50,120,30);
		btn3 = new JButton("대화기록보기");
		btn3.setBounds(230,90,120,30);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,300,200,30);
		btn4 = new JButton("입력");
		btn4.setBounds(230,300,120,30);
		
		// Event 처리 ------
		// addActionListener(this) : 버튼에 이벤트 처리 객체(자기 자신)를 연결. 클릭하면 actionPerformed 가 호출됨
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		// Panel 에 Component 추가 ------
//		panel.add(area1);
		panel.add(scroll);
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		
		panel.add(txt1);
		panel.add(btn4);

		
		// Frame 에 Panel 추가 ------
		add(panel);	
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("버튼 클릭됨: " + e.getSource());
		// getSource() : 이벤트가 발생한 컴포넌트. 어느 버튼인지 비교해 구분함
		if(e.getSource() == btn1) {
			System.out.println("파일로 저장 버튼 클릭");
		}else if(e.getSource() == btn2) {
			System.out.println("1:1요청 버튼 클릭");			
		}else if(e.getSource() == btn3) {
			System.out.println("대화기록보기 버튼 클릭");
		}else if(e.getSource() == btn4) {
			System.out.println("입력 버튼 클릭");
		}
		
	}
	
}
public class C06SwingActionEvent {
	public static void main(String[] args) {
		new C06GUI("Chatting");
	}
}
