package Ch02Exception;

import java.util.Scanner;

// =======================================
// ArithmeticException
// 0 으로 나눌 때의 예외 처리
// =======================================

// 문제 ------
// 두 정수를 입력받아 나눗셈 결과를 출력하는 문제
// 정수를 0 으로 나누면 ArithmeticException 이 발생하므로 예외를 처리함
public class C03ArithmeticDivide {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
		System.out.print("나눌 두 값을 입력하세요: ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		System.out.println("나눗셈 결과: " + n1/n2);   // n2 가 0 이면 예외 발생

		} catch(ArithmeticException e){
			System.out.println("예외객체: " + e);       // java.lang.ArithmeticException: / by zero
			e.printStackTrace();                        // 이클립스에서 클래스에 Ctrl+T 를 누르면 상속 관계를 볼 수 있음
		}

		sc.close();
	}

}
