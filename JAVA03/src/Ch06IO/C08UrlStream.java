package Ch06IO;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// =======================================
// URL 스트림
// 웹 페이지를 읽어 HTML 파일로 저장
// =======================================

public class C08UrlStream {
	
	public static void main(String[] args) throws URISyntaxException, IOException {
		// URL.openStream() : 주소의 내용을 바이트 입력 스트림으로 여는 메서드
		// 보조 스트림 : 기본 스트림에 덧붙여 기능을 더하는 스트림. BufferedInputStream 은 버퍼를, InputStreamReader 는 바이트를 문자로 바꾸는 기능을 더함
		URL url = (new URI("https://n.news.naver.com/mnews/article/025/0003521555")).toURL();
		
		InputStream in = url.openStream();
		
		BufferedInputStream buffIn = new BufferedInputStream(in);	// 보조스트림(버퍼 추가)
		Reader rin = new InputStreamReader(buffIn);		// 보조스트림(byte -> char) 추가
		
		// 저장할 파일에 쓰는 출력 스트림
		Writer fout = new FileWriter("C:\\IOTEST\\index.html");
		
		while(true) {
			int data = rin.read();
			if (data == -1)
				break;
			
			fout.write((char)data);
			fout.flush();
			
		}
		// 연 순서의 역순으로 닫음
		fout.close();
		rin.close();
		buffIn.close();
		in.close();
		
	}

}
