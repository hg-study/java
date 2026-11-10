package Ch10Thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// =======================================
// 스레드와 Swing
// 버튼으로 스레드를 시작하고 interrupt 로 중지
// =======================================

// 화면의 시작 버튼을 누르면 스레드를 만들어 시작하고, 중지 버튼은 interrupt() 로 스레드를 멈춤
// interrupt() : 대기(sleep) 중인 스레드에 InterruptedException 을 일으켜 반복을 끝내게 하는 메서드
class C03GUI extends JFrame implements ActionListener, KeyListener {
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JTextField txt1;
	JTextArea area1;
	JTextArea area2;

	// 실행 중인 스레드를 필드에 보관해 중복 실행을 막고 중지할 때 사용함
	Thread th1;
	Thread th2;
	
	C03GUI() {
		// JFrame 의 기본 생성자를 호출하고 제목은 setTitle 로 지정
		super(); // 상위클래스 생성자 호출

		setTitle("THREAD 확인하기");

		// 패널 추가
		JPanel pan1 = new JPanel();

		// 컴포넌트 객체 생성 ------
		btn1 = new JButton("시작");
		btn2 = new JButton("중지");

		btn3 = new JButton("시작");
		btn4 = new JButton("중지");
		txt1 = new JTextField();
		area1 = new JTextArea();
		area2 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		JScrollPane scroll2 = new JScrollPane(area2);

		// 컴포넌트 위치 지정 ------
		scroll1.setBounds(50, 50, 190, 280);
		scroll2.setBounds(300, 50, 190, 280);
		// area1.setBounds(50,50,190,280); // Scroll추가시 제거
		txt1.setBounds(50, 350, 190, 30);
		btn1.setBounds(50, 400, 80, 30);
		btn2.setBounds(160, 400, 80, 30);
		btn3.setBounds(300, 400, 80, 30);
		btn4.setBounds(410, 400, 80, 30);

		// 이벤트 리스너 등록 ------
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		txt1.addKeyListener(this);

		// 기타 설정 ------
		area1.setEditable(false);

		// 패널에 컴포넌트 추가 ------
		pan1.add(btn1);
		pan1.add(btn2);
		pan1.add(btn3);
		pan1.add(btn4);
		pan1.add(txt1);
		// pan1.add(area1); // Scroll추가시 제거
		pan1.add(scroll1);
		pan1.add(scroll2);

		// 레이아웃 null : 좌표로 직접 배치
		pan1.setLayout(null);

		// 프레임에 패널 추가 ------
		add(pan1);
		setBounds(100, 100, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			System.out.println("btn1..clicked");	// 시작 버튼
			if(th1 == null) {
				C03WorkerA w1 = new C03WorkerA(this);
				th1 = new Thread(w1);
				th1.start();				
			}
		}
		if (e.getSource() == btn2) {
			System.out.println("btn2..clicked");	// 중지 버튼
			
			if(th1 != null) {
				// 스레드를 중지하고 null 로 비워 다시 시작할 수 있게 함
				th1.interrupt();
				th1=null;
			}
	
		}
		if (e.getSource() == btn3) {
			System.out.println("btn3..clicked");
			if(th2 == null) {
				C03WorkerB w2 = new C03WorkerB(this);
				th2 = new Thread(w2);
				th2.start();				
			}
			
			
		}
		if (e.getSource() == btn4) {
			System.out.println("btn4..clicked");	

			if(th2 != null) {
				th2.interrupt();
				th2=null;
			}
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println(e.getKeyChar());
		// System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 10) // 엔터키 입력
		{
			String tmp = txt1.getText();
			area1.append(tmp + "\n");
			txt1.setText("");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
public class C03ThreadSwing {

	public static void main(String[] args) {
		new C03GUI();
		

	}

}
