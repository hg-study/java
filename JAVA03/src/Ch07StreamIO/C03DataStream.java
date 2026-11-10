package Ch07StreamIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// =======================================
// 데이터 스트림
// 자료형을 유지한 채 바이트 스트림으로 쓰고 읽기
// =======================================

public class C03DataStream {

	public static void main(String[] args) throws IOException {
		
		// DataOutputStream / DataInputStream : 문자열(writeUTF), 실수(writeDouble), 정수(writeInt) 같은 자료형을 그대로 쓰고 읽는 보조 스트림
		// 읽을 때는 쓴 순서와 자료형 그대로 읽어야 함
		FileOutputStream out = new FileOutputStream("C:\\IOTEST\\test3.txt");
		DataOutputStream dout = new DataOutputStream(out);
		dout.writeUTF("홍길동");
		dout.writeDouble(95.5);
		dout.writeInt(100);
		dout.flush();
		dout.close();
		
		// 읽기 : 쓴 순서(UTF, double, int)대로 꺼냄
		FileInputStream in = new FileInputStream("C:\\IOTEST\\test3.txt");
		DataInputStream din = new DataInputStream(in);
		String name = din.readUTF();
		System.out.println(name);
		double weight = din.readDouble();
		System.out.println(weight);
		int data = din.readInt();
		System.out.println(data);
	
		
	}

}
