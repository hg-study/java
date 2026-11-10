package Ch06IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// =======================================
// Writer
// 문자 출력 스트림으로 파일에 쓰기
// =======================================

public class C01FileWriter {

	public static void main(String[] args) throws IOException {

		// 스트림 : 데이터가 흐르는 통로. Writer 는 문자 단위로 내보내는 출력 스트림의 최상위 클래스
		// FileWriter(경로, true) : 파일로 내보내는 스트림. true 면 기존 내용 뒤에 이어쓰기(Append), false(기본값)면 지우고 새로 쓰기(Overwrite)
		// C:\IOTEST 폴더를 미리 만들어 두어야 함
		Writer fout = new FileWriter("C:\\IOTEST\\test1.txt",true); // 추가하기
		

		// write() : 내용을 내부 버퍼에 임시 저장함
		fout.write("HELLOWORLD\n");
		fout.write("HELLOWORLD\n");
		fout.write("HELLOWORLD\n");
		
		// flush() : 버퍼에 남은 내용을 파일로 내보내고 비움
		fout.flush(); 

		// close() : 스트림을 닫고 자원을 반납함. 닫을 때 flush 도 자동으로 호출됨
		fout.close();
	}
	
}
