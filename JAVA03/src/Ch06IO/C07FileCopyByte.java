package Ch06IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// =======================================
// 파일 복사 (바이트 스트림)
// 버퍼를 사용해 모든 종류의 파일 복사
// =======================================

public class C07FileCopyByte {

	// 바이트 스트림은 텍스트뿐 아니라 이미지, PDF 같은 모든 파일을 복사할 수 있음
	private static final String PATH = "C:\\IOTEST\\";
		
	public static void main(String[] args) throws IOException {
		
			// args[0] : 원본 파일명, args[1] : 대상 파일명
			InputStream fin = new FileInputStream(PATH + args[0]);
			OutputStream fout = new FileOutputStream(PATH + args[1]);
		
			long startTime = System.currentTimeMillis();

			int data= 0;
			
			// 4096 바이트씩 읽어 한 번에 쓰는 버퍼
			byte [] buff = new byte[4096];
			
			while( (data = fin.read(buff)) != -1) {	
				
				// write(buff, 0, data) : 읽은 개수(data)만큼만 씀. 마지막 반복의 남은 값이 섞이지 않게 함
				fout.write(buff,0,data);
				fout.flush();
			}
			
			fout.close();
			fin.close();

			long endTime = System.currentTimeMillis();
			System.out.println("소요시간: " + (endTime - startTime) + " ms");	
			
	}

}
