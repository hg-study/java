package Ch05Swing;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// =======================================
// MouseListener
// 대화 영역을 클릭해 클릭한 줄 읽기
// =======================================

// MouseListener : 마우스 이벤트 인터페이스(클릭, 누름, 뗌, 들어옴, 나감). 쓰지 않는 메서드도 모두 구현해야 함
class C08GUI extends JFrame implements ActionListener,KeyListener,MouseListener
{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	
	JTextField txt1;
	JTextArea area1;
	
	C08GUI(String title){
		
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
		area1 = new JTextArea(); 
//		area1.setBounds(10,90,210,300);
		JScrollPane scroll = new JScrollPane(area1);
		scroll.setBounds(10,10,200,280);
		
		btn1 = new JButton("파일로저장");
		btn1.setBounds(230,10,120,30);
		btn2 = new JButton("1:1 요청");
		btn2.setBounds(230,50,120,30);
		btn3 = new JButton("대화기록보기");
		btn3.setBounds(230,90,120,30);
		
		txt1 = new JTextField();
		txt1.setBounds(10,300,200,30);
		btn4 = new JButton("입력");
		btn4.setBounds(230,300,120,30);
		
		// Event 처리 ------
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		txt1.addKeyListener(this);
		
		// addMouseListener(this) : 대화 영역에 마우스 이벤트 처리 객체를 연결
		area1.addMouseListener(this);
		
		
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
//		System.out.println("버튼 클릭됨 : " + e.getSource());
		if(e.getSource() == btn1) 
		{
			System.out.println("파일로 저장 버튼 클릭");
		}
		else if(e.getSource() == btn2)
		{
			System.out.println("1:1 요청 버튼 클릭");
		}
		else if(e.getSource() == btn3)
		{
			System.out.println("대화기록보기 버튼 클릭");
		}
		else if(e.getSource() == btn4)
		{
			System.out.println("입력 버튼 클릭");
			String message = txt1.getText();
			area1.append(message + "\n");
			System.out.println("message : " + txt1.getText());
			txt1.setText("");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// 문자가 입력될 때 호출됨 (실행하는 코드 없음)
//		System.out.println("keyTyped...");
//		System.out.println("keyTyped..."+e.getKeyChar());
//		System.out.println("keyTyped..."+e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 키를 누르는 동안 호출됨 (실행하는 코드 없음)
//		System.out.println("keyPressed..."+e.getKeyChar());
//		System.out.println("keyPressed..."+e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 키에서 손을 뗄 때 호출됨. 엔터면 입력창의 글을 대화 영역에 추가함
//		System.out.println("keyReleased...");
//		System.out.println("keyReleased..."+e.getKeyChar());
//		System.out.println("keyReleased..."+e.getKeyCode());
		
		if(e.getSource()==txt1) {
			if(e.getKeyChar() == 10) {
				String message = txt1.getText();
				area1.append(message + "\n");
				System.out.println("message : " + txt1.getText());
				txt1.setText("");
			}
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
//			System.out.println("mouseClicked..." + e);
			Point point =  e.getPoint();
//			System.out.println("point : " + point);
			// 클릭 좌표 -> 글자 위치(offset) -> 줄 번호 -> 줄의 시작과 끝 위치 -> 그 줄의 글자 순으로 구해 읽음
			int offset = area1.viewToModel(point);
			System.out.println("offset : " + offset);
			int row = area1.getLineOfOffset(offset);
			System.out.println("row : " + row);
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
			System.out.printf("start : %d - end : %d\n" , startOffset,endOffset);
			String str = area1.getText(startOffset,endOffset - startOffset);
			System.out.println("str : " + str);
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
public class C08SwingMouseEvent {
	public static void main(String[] args) {
		new C08GUI("Chatting");
	}
}
