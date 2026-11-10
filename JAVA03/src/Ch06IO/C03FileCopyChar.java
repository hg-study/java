package Ch06IO;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

// =======================================
// 파일 복사 (문자 스트림)
// Reader 로 읽고 Writer 로 쓰기
// =======================================

public class C03FileCopyChar {

	// 파일 경로 상수 선언(유지보수성)
	// 파일 경로를 상수로 선언해 한 곳에서 관리함
	private static final String PATH = "C:\\IOTEST\\";
	public static void main(String[] args) throws IOException {
		
		// args[0]: 원본 파일명(source filename) -> 파일에서 데이터 읽어옴
		// args[1]: 대상 파일명(destination filename) -> 파일에서 데이터 기록함
		// 실행할 때 전달한 값(args)으로 파일을 지정함
		// args[0] : 원본 파일명, args[1] : 대상 파일명
		Reader fin = new FileReader(PATH + args[0]);
		Writer fout = new FileWriter(PATH + args[1]);
	
		int data= 0;

		// while 통한 반복으로 read() 한글자씩 읽어와 더 읽을 값이 없을 때까지(-1) 반복
		// 한 글자씩 읽어 -1(더 읽을 값 없음)이 나올 때까지 반복하며 대상 파일에 씀
		while( (data = fin.read()) != -1) {	
			System.out.print((char)data); // 읽은 데이터 콘솔 출력
			fout.write((char)data); // 읽은 데이터 대상 파일에 입력
			fout.flush(); // 비우기는 루프 밖에서 한 번만 하는 것이 정석
			
		}

		// 스트림은 연 순서의 역순으로 닫는 것이 관례
		fout.close();
		fin.close();
	}
}
