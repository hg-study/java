package Ch06IO;

import java.io.FileReader;
import java.io.Reader;

// =======================================
// Reader
// 문자 입력 스트림으로 파일 읽기
// =======================================

public class C02FileReader {

	public static void main(String[] args) throws Exception {
		
		// 입력 스트림 생성 ------
		// Reader : 문자 단위 입력 스트림의 최상위 클래스. FileReader 는 파일에서 읽어 옴
		Reader fin = new FileReader("C:\\IOTEST\\test1.txt");

		while(true) {
			// 방법 1 : 무한 반복으로 읽기
			// read() : 한 글자(char)를 읽어 int 로 돌려줌. 더 읽을 데이터가 없으면 -1
			int data = fin.read();  // 한 글자씩 읽기
			
			if (data == -1) // 더 읽을 데이터가 없으면 루프 탈출
				break;
			
			System.out.print((char)data); // int를 char로 형변환
		}
		

		// 방법 2 : 조건식 안에서 읽어 대입하고 -1 인지 바로 비교해 방법 1 을 줄인 형태
		// int data = 0;
		// while( (data = fin.read()) != -1) {	
		// 	System.out.print((char)data);
		// }	
		
		// 방법 3 : for 문. data 가 0 으로 초기화되어 첫 글자를 읽지 못할 수 있어 while 문을 더 권장함
		// for(int data= 0; data != -1; data = fin.read()) {	
		// 	System.out.print((char)data);
		// }
		
		// 스트림 닫기 ------ : close() 로 자원을 반납함
		fin.close();
	}

}
