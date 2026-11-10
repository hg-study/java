package Ch02Exception;

// =======================================
// ArrayIndexOutOfBoundsException
// finally 블록
// =======================================

// finally ------
// finally : 예외 발생 여부와 상관없이 마지막에 항상 실행되는 블록. 자원 해제처럼 반드시 해야 할 작업에 사용함
// ArrayIndexOutOfBoundsException : 배열의 범위를 벗어난 인덱스를 사용할 때 발생하는 예외

public class C02ArrayIndexBounds {

	public static void main(String[] args) {

		try {
		int [] arr = {10, 20, 30};
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);     // 인덱스는 0~2 라서 예외 발생
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 처리!");
		} finally {
			System.out.println("예외 발생과는 무관하게 실행되는 코드!");
		}

		System.out.println("반드시 실행되어야 할 코드1");
		System.out.println("반드시 실행되어야 할 코드2");
	}

}
