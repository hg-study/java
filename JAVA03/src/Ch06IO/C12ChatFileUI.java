package Ch06IO;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// =======================================
// 채팅 화면의 파일 저장과 불러오기
// JFileChooser 와 스트림으로 대화 내용을 파일로 저장하고 읽기
// =======================================

// JFileChooser : 파일 탐색기 창을 띄워 저장하거나 열 파일을 고르게 하는 컴포넌트
// try-with-resources : try (스트림 생성) 형태로 쓰면 블록이 끝날 때 스트림이 자동으로 닫힘
class C12GUI extends JFrame implements ActionListener,KeyListener,MouseListener
{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	
	JTextField txt1;
	JTextArea area1;
	
	C12GUI(String title){
		
		// Frame 설정 ------
		super(title);
		setBounds(100,100,400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		// Panel 설정 ------
		JPanel panel = new JPanel();
// 패널 배경색 지정(주석 처리)
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
			
			
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
			// 저장 내용 : 현재 시각을 첫 줄에 쓰고 대화 영역의 글을 이어 붙임
			String contents = LocalDateTime.now().format(fmt).toString()+"\n";
			
			contents += area1.getText();

			// 파일 탐색기(JFileChooser) 만들기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일 저장 위치를 선택하세요.");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			// 탐색기가 처음 열릴 폴더를 지정 (폴더가 있을 때만)
			File defaultDirPath = new File("C:\\IOTEST");
			if (defaultDirPath.exists()) {
				fileChooser.setCurrentDirectory(defaultDirPath);
			}
			
			// 파일 탐색기를 띄우고 사용자가 누른 버튼을 받음
			int selectedVal = fileChooser.showSaveDialog(null);
			
			if (selectedVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("저장 버튼 클릭");
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile: " + selectedFile);
			
				// 확장자 추가
				String filePath = selectedFile.toString();
				if(!selectedFile.toString().endsWith(".txt")) {
					filePath += ".txt";
				}
				System.out.println("filePath: " + filePath);
				
				// 저장하기
				try (Writer out = new FileWriter(filePath)){
					 out.write(contents);
					 out.flush();
					 
				} catch (IOException e1) {
					e1.printStackTrace();
					
				} 	
			}
			
			
			
			
		}
		else if(e.getSource() == btn2)
		{
			System.out.println("1:1 요청 버튼 클릭");
		}
		else if(e.getSource() == btn3)
		{
			System.out.println("대화기록보기 버튼 클릭");
			

			// 파일 탐색기(JFileChooser) 만들기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("불러올 파일을 선택하세요.");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			// 탐색기가 처음 열릴 폴더를 지정 (폴더가 있을 때만)
			File defaultDirPath = new File("C:\\IOTEST");
			if (defaultDirPath.exists()) {
				fileChooser.setCurrentDirectory(defaultDirPath);
			}
			
			// 파일 탐색기를 띄우고 사용자가 누른 버튼을 받음
			int selectedVal = fileChooser.showOpenDialog(null);
			
			if (selectedVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("불러오기 버튼 클릭");
				
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile: " + selectedFile);
	
				StringBuffer buffer = new StringBuffer();
				
				try (Reader in = new FileReader(selectedFile)) {
		
					int data;
					while((data = in.read()) != -1) {
						buffer.append((char)data);
					}
					area1.setText(buffer.toString());
					
				} catch(Exception e2) {
					e2.printStackTrace();	
				}
			}
		}
		
		else if(e.getSource() == btn4){
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
public class C12ChatFileUI {
	public static void main(String[] args) {
		new C12GUI("Chatting");
	}
}
