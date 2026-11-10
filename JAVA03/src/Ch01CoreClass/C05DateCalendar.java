package Ch01CoreClass;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

// =======================================
// 날짜와 시간 클래스
// Date, Calendar, LocalDateTime
// =======================================

public class C05DateCalendar {

	public static void main(String[] args) {

		// Date ------
		// Date : 현재 시각을 나타내는 옛 클래스. 연도는 1900 을 더하고 월은 0 부터 시작하는 등 불편해 대부분 사용하지 않음
//		Date d1 = new Date();
//		System.out.println(d1);
//		System.out.println(d1.getYear()+1900);
//		System.out.println(d1.getMonth()+1);
//		System.out.println(d1.getDay());    // 요일 0~6(일~토)
//		System.out.println(d1.getHours());
//		System.out.println(d1.getMinutes());
//		System.out.println(d1.getSeconds());
//		System.out.println(d1.getTime());   // 1970년 1월 1일부터 지난 시간(밀리초)

		// Calendar ------
		// Calendar : Date 를 보완한 추상 클래스. new 대신 getInstance() 로 객체를 얻음(싱글톤 패턴)
//		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
//		System.out.println(cal.get(Calendar.YEAR));
//		System.out.println(cal.get(Calendar.MONTH)+1);
//		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK));  // 요일 1~7(일~토)
//		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
//		System.out.println(cal.get(Calendar.MINUTE));
//		System.out.println(cal.get(Calendar.SECOND));

		// LocalDateTime ------
		// LocalDateTime : 날짜와 시간을 함께 다루는 자바 8 이후의 클래스(중요). 월은 1~12, 요일은 DayOfWeek 열거형으로 읽음
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		int year = now.getYear();
		int month = now.getMonthValue();  // 월 (1~12)
		int day = now.getDayOfMonth();    // 일 (1~31)
		int hour = now.getHour();         // 시 (0~23)
		int minute = now.getMinute();     // 분 (0~59)
		int second = now.getSecond();     // 초 (0~59)
		DayOfWeek dayOfWeek = now.getDayOfWeek();

		System.out.println("연: " + year);
		System.out.println("월: " + month);
		System.out.println("일: " + day);
		System.out.println("시: " + hour);
		System.out.println("분: " + minute);
		System.out.println("초: " + second);
		System.out.println("요일: " + dayOfWeek);

	}

}
