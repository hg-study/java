package Ch07StreamIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

// =======================================
// 문자 변환 스트림
// 바이트 스트림을 문자 스트림으로 바꾸고 버퍼를 더하는 보조 스트림
// =======================================

public class C01CharConvertStream {

	public static void main(String[] args) throws IOException {
		
		// 보조 스트림 : 기본 스트림에 덧붙여 기능을 더하는 스트림
		// OutputStreamWriter / InputStreamReader : 바이트 스트림을 문자 스트림으로 바꿔 문자열을 바로 쓰고 읽게 함
		// BufferedWriter / BufferedReader : 버퍼를 더해 성능을 높이고 BufferedReader 는 한 줄 읽기(readLine)도 제공함
		String str = "문자 변환 스트림테스트!";
		// 출력 : 바이트 스트림 -> 문자 변환 스트림 -> 버퍼 스트림 순으로 감싸 문자열을 씀
		// 쓴 뒤에 flush() 를 호출하지 않으면 버퍼에 남아 파일이 비어 있게 됨
		OutputStream out = new FileOutputStream("C:\\IOTEST\\test.txt");
		out.write(str.getBytes());		// String -> byte[] 변환
		
		OutputStreamWriter wout = new OutputStreamWriter(out);
//		wout.write(str);
//		wout.flush();
		
		BufferedWriter bout = new BufferedWriter(wout);
		bout.write(str);
		bout.flush();
		
		out.close();

		
		// 입력 : 바이트 스트림을 InputStreamReader 로 문자 스트림으로 바꾸고 BufferedReader 로 감싸 읽음
		InputStream in = new FileInputStream("C:\\IOTEST\\test.txt");
		InputStreamReader rin = new InputStreamReader(in);
		BufferedReader bin = new BufferedReader(rin);
		
		while(true) {
			int data = bin.read();
			if (data == -1) 
				break;
			System.out.print((char)data);
		}
		
	}

}
