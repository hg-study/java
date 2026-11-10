package Ch06IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// =======================================
// 바이트 입력 스트림
// InputStream 으로 바이너리 파일 읽기와 성능 측정
// =======================================

public class C05FileInputStream {

	public static void main(String[] args) throws IOException {

		// InputStream : 바이트 단위 입력 스트림의 최상위 클래스. 이미지, 동영상, PDF 같은 바이너리 파일에 사용함
		// FileInputStream : 파일에서 바이트를 읽는 스트림
		// 참고 : https://wikidocs.net/287496
		InputStream fin = new FileInputStream("C:\\IOTEST\\test.pdf");
		
		long startTime = System.currentTimeMillis();

		// 바이트 스트림이라 byte 배열을 버퍼로 사용함 (1024byte = 1KB)
		byte[] buffer = new byte[1024];
		
		while(true) {
			// read(buffer) : 버퍼 크기만큼 읽어 담고 읽은 바이트 수를 돌려줌. 더 읽을 파일이 없으면 -1
			int data = fin.read(buffer);  // read(buffer): buffer 크기 만큼 데이터 읽어와 담고 반환
			
			if (data == -1) // 더 읽어올 파일 없으면 루프 종료
				break;
		}

		fin.close();
	
		// 끝 시각 - 시작 시각 = 걸린 시간(ms)
		long endTime = System.currentTimeMillis();
		
		System.out.println("소요시간: " + (endTime - startTime) + " ms");
	}

}
