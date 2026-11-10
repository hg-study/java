package Ch06IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

// =======================================
// 바이트 출력 스트림
// OutputStream 으로 바이트와 문자열 쓰기
// =======================================

public class C06FileOutputStream {

	public static void main(String[] args) throws IOException {

		// OutputStream : 바이트 단위 출력 스트림의 최상위 클래스. FileOutputStream 은 파일로 바이트를 내보냄
		OutputStream fout = new FileOutputStream("C:\\IOTEST\\test2.txt");
		
		// getBytes(UTF_8) : 문자열을 UTF-8 바이트 배열로 바꿔 씀. 한글은 문자 1개가 3바이트
		fout.write("가나다".getBytes(StandardCharsets.UTF_8));
		// 문자 하나를 바이트로 쓰면 영문은 1바이트
		fout.write('a');
		fout.write('b');
		fout.write('c');
		fout.flush();
		fout.close();
	}

}
