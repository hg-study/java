package Ch05Swing;

import javax.swing.JFrame;

// =======================================
// JFrame 상속
// 프레임 설정을 클래스에 모아 객체를 만들 때 창이 뜨게 하기
// =======================================

// JFrame 상속 : 창 설정을 생성자에 모아 두면 new 로 객체를 만드는 순간 창이 표시됨
class C02GUI extends JFrame{
	
	// 생성자 : 프레임 설정과 화면 구성을 함
	C02GUI(String title){
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class C02SwingClass {
	
	public static void main(String[] args) {
	
		new C02GUI ("두번째 프레임 창입니다.");
	}
}
