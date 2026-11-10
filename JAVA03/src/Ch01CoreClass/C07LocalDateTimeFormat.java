package Ch01CoreClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// =======================================
// DateTimeFormatter
// LocalDate, LocalDateTime 과 문자열을 서로 변환
// =======================================

// 날짜 포맷 ------
// DateTimeFormatter : 패턴 문자열로 LocalDate, LocalDateTime 과 문자열을 서로 바꾸는 클래스
// parse(문자열, 포매터) : 문자열을 날짜 객체로 변환(입력용)
// format(날짜) : 날짜 객체를 지정한 패턴의 문자열로 변환(출력용)
public class C07LocalDateTimeFormat {

	public static void main (String[] args) {

		// 날짜만 다루는 방법(LocalDate) ------
//		Scanner sc = new Scanner(System.in);
//		System.out.print("YYYY/MM/DD 입력: ");
//		String ymd = sc.next();
//
//		System.out.println("문자열: " + ymd);
//
//		DateTimeFormatter fmtin = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		LocalDate date = LocalDate.parse(ymd,fmtin);
//		System.out.println("fmtin: " + date);
//
//		DateTimeFormatter fmtout = DateTimeFormatter.ofPattern("yyyy~MM~dd");
//		System.out.println("출력포맷 :" + fmtout.format(date));
//		sc.close();

		// 날짜와 시간을 함께 다루는 방법(LocalDateTime) ------
		// 공백이 포함된 한 줄을 받으므로 nextLine() 을 사용함
		Scanner sc = new Scanner(System.in);
		System.out.print("YYYY/MM/DD HH:mm:ss 입력: ");
		String ymd = sc.nextLine();

		System.out.println("문자열: " + ymd);

		// 입력용 포매터
		DateTimeFormatter fmtin = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(ymd,fmtin);
		System.out.println("fmtin: " + date);

		// 출력용 포매터
		DateTimeFormatter fmtout = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		System.out.println("출력포맷 :" + fmtout.format(date));
		sc.close();

	}
}
