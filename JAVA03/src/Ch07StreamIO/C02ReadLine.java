package Ch07StreamIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

// =======================================
// 한 줄 쓰기와 한 줄 읽기
// PrintWriter 로 줄 단위로 쓰고 BufferedReader 로 줄 단위로 읽기
// =======================================

// 보조 스트림 ------
// BufferedWriter : 버퍼를 더해 쓰기 성능을 높임
// PrintWriter : println 으로 줄바꿈을 포함해 한 줄씩 쓰는 보조 스트림
// BufferedReader : readLine() 으로 한 줄씩 읽음. 더 읽을 줄이 없으면 null

public class C02ReadLine {

	public static void main(String[] args) throws IOException {

		// 파일 내용 쓰기 ------
		// 기본 스트림(FileWriter)에 보조 스트림을 차례로 감싸 줄 단위로 씀
		Writer out = new FileWriter("C:\\IOTEST\\test2.txt");
		BufferedWriter bout = new BufferedWriter(out);
		PrintWriter pout = new PrintWriter(bout);
		pout.println("HELLOWORLD");
		pout.println("HELLOWORLD");
		pout.println("HELLOWORLD");
		pout.println("HELLOWORLD");

		pout.flush();
		// 연 순서의 역순으로 닫음
		pout.close();
		bout.close();
		out.close();

		// 파일 내용 읽어오기 ------
		Reader in = new FileReader("C:\\IOTEST\\test2.txt");
		BufferedReader bin = new BufferedReader(in);

		while(true) {
			// 기본 Reader 로는 한 글자씩 읽어야 함
//			int data = in.read();
//			if (data == -1)
//				break;
//			System.out.print((char)data);

			// BufferedReader 는 한 줄씩 읽을 수 있음
			String msg = bin.readLine();
			if(msg == null)
				break;
			System.out.println(msg);
		}

		bin.close();
		in.close();
	}
}
