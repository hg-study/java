package Ch05Swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

// =======================================
// JPanel
// 프레임에 패널 추가
// =======================================

class C03GUI extends JFrame{
	
	// 생성자 : 프레임 설정과 화면 구성을 함
	C03GUI(String title){
		
		// Frame 설정 ------
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		// Panel 설정 ------
		// JPanel : 컴포넌트(버튼 등)를 올려 배치하는 판. Frame 에 add 해서 사용함
		JPanel panel = new JPanel();
// 패널 배경색 지정(주석 처리). Color(R, G, B)
//		Color col = new Color(255, 255, 0);
//		panel.setBackground(col);
		
		add(panel); // Frame에 Panel 추가
	}
}

public class C03SwingPanel {
	
	public static void main(String[] args) {
	
		new C03GUI ("세번째 프레임 창입니다.");
	}
}
