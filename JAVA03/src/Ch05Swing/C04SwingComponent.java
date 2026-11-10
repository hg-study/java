package Ch05Swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// =======================================
// 컴포넌트 배치
// 버튼, 입력창, 대화 영역을 절대 좌표로 배치
// =======================================

class C04GUI extends JFrame{
	
	// 생성자 : 프레임 설정과 화면 구성을 함
	C04GUI(String title){
		
		// Frame 설정 ------
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		// Panel 설정 ------
		JPanel panel = new JPanel();
// 패널 배경색 지정(주석 처리). Color(R, G, B)
//		Color col = new Color(255, 255, 0);
//		panel.setBackground(col);
		// setLayout(null) : 배치관리자를 쓰지 않고 컴포넌트마다 setBounds(x, y, 너비, 높이)로 위치를 직접 지정하는 방식
		panel.setLayout(null);
		
		// Component 설정 ------
		JButton btn1 = new JButton("BTN01");
		btn1.setBounds(10, 10, 100, 30);
		JButton btn2 = new JButton("BTN02");
		btn2.setBounds(120, 10, 100, 30);
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,50,210,30);
		JTextArea area1 = new JTextArea();
//		area1.setBounds(10,90,210,300);
		// JScrollPane : 내용이 넘칠 때 스크롤바를 붙여 주는 컴포넌트. 텍스트 영역은 이것에 담아 add 함
		JScrollPane scroll = new JScrollPane(area1);
		scroll.setBounds(10,90,210,300);
		
		// Panel 에 Component 추가 ------
		panel.add(btn1);
		panel.add(btn2);		
		panel.add(txt1);
//		panel.add(area1);
		panel.add(scroll);		

		// Frame 에 Panel 추가 ------
		add(panel); 
		
		setVisible(true);		
	}
}

public class C04SwingComponent {
	
	public static void main(String[] args) {
	
		new C04GUI ("네번째 프레임 창입니다.");
	}
}
