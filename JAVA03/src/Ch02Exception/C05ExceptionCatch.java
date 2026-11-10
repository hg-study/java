package Ch02Exception;

// =======================================
// 상위 예외 클래스로 처리
// catch 블록이 여러 개일 때의 실행 규칙
// =======================================

// Exception ------
// Exception : 모든 예외 클래스의 상위 클래스. catch 에 쓰면 하위 예외를 모두 한 번에 받을 수 있음

public class C05ExceptionCatch {

	public static void main(String[] args) {

		try {
		String str = null;
		str.toString();         // NullPointerException 이 가장 먼저 발생해 아래 코드는 실행되지 않음

		int arr[] = {10,20,30};
		arr[4] = 10;            // ArrayIndexOutOfBoundsException

		Animal tori = new Dog();
		Cat down = (Cat)tori;   // ClassCastException

		} catch (Exception e) {  // 상위 클래스 Exception 으로 모든 예외를 받음
			e.printStackTrace();
		}
		System.out.println("이후 동작 여부 확인코드!");

		// catch 가 여러 개일 때 ------
		// catch 블록이 여러 개여도 단 하나의 블록만 실행됨. 예외가 발생하면 try 의 실행을 멈추고 맞는 catch 로 이동하기 때문
		// 상위 예외(Exception)는 가장 마지막 catch 에 써야 하위 예외 catch 가 실행됨
//		} catch (NullPointerException e1){
//			e1.printStackTrace();
//			System.out.println("NullPointerException 처리");
//
//		} catch (ArrayIndexOutOfBoundsException e2){
//			e2.printStackTrace();
//			System.out.println("ArrayIndexOutOfBoundsException 처리");
//
//		} catch (ClassCastException e3){
//			e3.printStackTrace();
//			System.out.println("ClassCastException 처리");
//		}

	}

}
