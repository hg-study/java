package Ch01CoreClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// =======================================
// SimpleDateFormat
// Date 와 문자열을 서로 변환
// =======================================

// 날짜 포맷 ------
// SimpleDateFormat : 패턴 문자열로 Date 와 문자열을 서로 바꾸는 클래스
// parse(문자열) : 문자열을 Date 로 변환(입력용). 형식이 맞지 않으면 ParseException 이 발생함
// format(Date) : Date 를 지정한 패턴의 문자열로 변환(출력용)
public class C06SimpleDateFormat {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.print("YYYY/MM/DD 입력: ");
		String ymd = sc.next();

		System.out.println("문자열: " + ymd);

		// 입력용 포매터
		SimpleDateFormat fmtin = new SimpleDateFormat("yyyy/MM/dd");
		Date date = fmtin.parse(ymd);
		System.out.println("fmtin: " + date);

		// 출력용 포매터
		SimpleDateFormat fmtout = new SimpleDateFormat("yyyy~MM~dd");
		System.out.println(fmtout.format(date));

		sc.close();
	}

}
