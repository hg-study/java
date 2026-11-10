package Ch06IO;

import java.io.FileReader;
import java.io.Reader;

// =======================================
// 버퍼를 이용한 읽기
// 문자 배열 버퍼로 읽는 횟수를 줄여 성능 높이기
// =======================================

public class C04BufferRead {

	public static void main(String[] args) throws Exception {

		// 입력 스트림 생성 ------
		Reader fin = new FileReader("C:\\IOTEST\\origin.txt");

		// currentTimeMillis() : 현재 시각을 밀리초(ms) 단위 long 으로 돌려줌. 시작과 끝 시각의 차로 걸린 시간을 잼
		long startTime = System.currentTimeMillis();

		// StringBuffer : 문자열을 덧붙이며 저장하는 임시 저장용 객체
		StringBuffer strBuffer = new StringBuffer();

// 방법 1 (비효율) : 한 글자씩 read 해 디스크에 여러 번 접근하므로 데이터가 클수록 오래 걸림
//		while(true) {
//			int data = fin.read();  
//			
//			if (data == -1) 
//				break;
//			
//			strBuffer.append((char)data);
//			
//		}
		
		// 방법 2 (버퍼 사용) : char 배열을 만들어 한 번에 여러 글자(4096)를 읽으면 접근 횟수가 줄어 훨씬 빠름
		// read(buff) : 읽어 온 글자 수를 돌려주고, 더 읽을 데이터가 없으면 -1
		char [] buff = new char[4096];
		while(true) {
			int data = fin.read(buff);  
			
			if (data == -1) // 더 읽을 데이터가 없으면 탈출
				break;
			
			// append(buff, 0, data) : 마지막 반복에서 이전 반복의 남은 글자가 섞이지 않도록 읽은 개수(data)까지만 추가함
			strBuffer.append(buff, 0, data);
			
		}	

		// length() : 저장된 글자 수
		System.out.println("총문자 길이: " + strBuffer.length());
		// 스트림 닫기 ------ : close() 로 자원을 반납함
		fin.close();		
		
		long endTime = System.currentTimeMillis();
		
		// 끝 시각 - 시작 시각 = 걸린 시간(ms)
		System.out.println("소요시간: " + (endTime - startTime) + " ms");
		
	}
}
