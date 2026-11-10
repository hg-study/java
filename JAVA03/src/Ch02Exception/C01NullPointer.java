package Ch02Exception;

// =======================================
// NullPointerException
// try - catch 와 예외 객체의 정보 확인
// =======================================

// 예외 처리 ------
// 예외(Exception) : 프로그램 실행 중 발생하는 오류. 처리하지 않으면 프로그램이 즉시 종료됨
// try - catch : try 블록에서 예외가 발생하면 해당 예외를 받는 catch 블록으로 넘어가 처리하고 프로그램은 계속 실행됨
// NullPointerException : null 인 참조변수로 메서드나 필드를 사용할 때 발생하는 예외

public class C01NullPointer {

	public static void main(String[] args) {

		// 처리하지 않으면 아래처럼 예외 메시지를 출력하고 종료됨
		// Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.toString()" because "str" is null

		try {
		String str = null;
		System.out.println(str.toString());     // null 에 메서드를 호출해 예외 발생
		} catch(NullPointerException e) {
			// 예외 객체의 정보 ------
			System.out.println("예외객체: " + e);                  // 예외 종류와 메시지
			System.out.println("예외객체: " + e.getCause());       // 원인이 되는 예외(없으면 null)
			System.out.println("예외객체: " + e.getStackTrace());  // 호출 경로 배열(주소값으로 출력됨)
			for(StackTraceElement el : e.getStackTrace()) {
				System.out.println(el);                           // 호출 경로를 한 줄씩 출력
			}
			e.printStackTrace();    // 예외 종류, 메시지, 호출 경로를 한꺼번에 출력
		}

		// 예외를 처리했으므로 아래 코드는 정상 실행됨
		System.out.println("반드시 실행되어야 할 코드1");
		System.out.println("반드시 실행되어야 할 코드2");

	}

}
