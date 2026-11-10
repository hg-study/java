package Ch07StreamIO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

// =======================================
// 객체 스트림
// 직렬화로 객체를 파일에 저장하고 다시 읽기
// =======================================

// 직렬화 : 객체를 바이트로 바꿔 파일이나 네트워크로 보낼 수 있게 하는 것. Serializable 인터페이스를 구현하면 가능하고 serialVersionUID 로 버전을 구분함
// ObjectOutputStream / ObjectInputStream : 객체를 통째로 쓰고 읽는 스트림
class Board implements Serializable {	// 직렬화
	
	private static final long serialVersionUID = 1L;
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date date;		// java.util.Date

	// 디폴트 생성자
	Board(){}
	
	// 모든 인자 생성자
	public Board(int bno, String title, String content, String writer, Date date) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}	
	
	// getter and setter
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}	
	// tostring 재정의
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", date="
				+ date + "]";
	}
}

public class C04ObjectStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Board board1 = new Board(1, "제목1", "내용1", "작성자1", new Date());
		Board board2 = new Board(2, "제목2", "내용2", "작성자2", new Date());
		Board board3 = new Board(3, "제목3", "내용3", "작성자3", new Date());
		
		FileOutputStream out = new FileOutputStream("C:\\IOTEST\\board.db");
		ObjectOutputStream oout = new ObjectOutputStream(out);
		oout.writeObject(board1);
		oout.writeObject(board2);
		oout.writeObject(board3);
		oout.flush();
		oout.close();
		out.close();
		
		FileInputStream in = new FileInputStream("C:\\IOTEST\\board.db");
		ObjectInputStream oin = new ObjectInputStream(in);
		
		Object obj = oin.readObject();
		Board down = (Board)obj;
		System.out.println(down);

		Object obj2 = oin.readObject();
		Board down2 = (Board)obj2;
		System.out.println(down2);
		
		Object obj3 = oin.readObject();
		Board down3 = (Board)obj3;
		System.out.println(down3);
		
		// 더 읽을 객체가 없을 때 readObject 를 호출하면 EOFException 이 발생함. 예외를 처리해 읽기를 끝냄
		try {
			Object obj4 = oin.readObject();
		} catch (EOFException e) {
			System.out.println("더 읽을 객체가 없어 EOFException 이 발생함");
		}
		
		oin.close();
		in.close();
	}

}
