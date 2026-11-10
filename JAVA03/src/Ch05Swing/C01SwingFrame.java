package Ch05Swing;

import javax.swing.JFrame;

// =======================================
// Swing 프레임
// JFrame 으로 창 만들기
// =======================================

public class C01SwingFrame {

	public static void main(String[] args) {
		// Swing : 자바의 GUI(화면) 라이브러리
		// JFrame : 창(프레임)을 만드는 클래스. 제목을 생성자로 받음
		JFrame frame = new JFrame("첫번째 프레임 창입니다.");
		frame.setBounds(100,100,500,500); // x축, y축, width, height
		// setDefaultCloseOperation : 창을 닫을 때의 동작. EXIT_ON_CLOSE 는 프로그램도 함께 종료
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setVisible(true) : 창을 화면에 표시
		frame.setVisible(true);
	}

}
