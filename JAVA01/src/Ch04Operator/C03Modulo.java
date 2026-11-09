package Ch04Operator;

import java.util.Random;

// =======================================
// 나머지 연산자 활용
// 짝홀수, 배수, 수의 범위, 난수, 끝자리 수 구하기
// =======================================

public class C03Modulo {

	public static void main(String[] args) throws InterruptedException {

		// 나머지 연산자 % ------
		// 나머지 연산자 % : 나눗셈의 나머지를 돌려주는 연산자. 짝홀수, 배수 판별과 난수 범위 지정, 끝자리 구하기에 활용함

		// 01 홀수와 짝수 ------
		// 정수를 입력받아 num1에 저장한 뒤 짝수인지 홀수인지 확인하는 문제

//		Scanner sc = new Scanner(System.in);
//		int num1 = sc.nextInt();
//
//		String result =  (num1%2==0)?"짝수입니다":"홀수입니다";
//		System.out.println("결과 : " + result);

		// 02 배수 구하기 ------
		// 세 정수를 받아 세 수의 합이 5의 배수이면 "5의배수입니다", 아니면 "5의배수가 아닙니다"를 출력하는 문제

//		Scanner sc = new Scanner(System.in);
//		int n1,n2,n3,sum;
//		n1=sc.nextInt();
//		n2=sc.nextInt();
//		n3=sc.nextInt();
//		sum=n1+n2+n3;
//		String result = (sum%5==0)?"5의배수입니다":"5의 배수가 아닙니다";
//		System.out.println("RESULT : " +result);

		// 03 나머지의 범위 ------
		/*
		 * N으로 나눈 나머지는 0부터 N-1까지다.
		 * N%2 = 0~1, N%3 = 0~2, N%4 = 0~3, N%9 = 0~8, N%10 = 0~9, N%100 = 0~99
		 */

		// 난수 생성 : Random ------
		// Random : 난수(무작위 수)를 만드는 클래스. nextInt(45)는 0 ~ 44 범위의 정수를 돌려주므로 + 1을 해 1 ~ 45를 만듦
		// Thread.sleep(500) : 0.5초 동안 실행을 멈추는 메서드
//		Random rnd = new Random();
//
//		while (true) {
//			System.out.println(rnd.nextInt(45)  + 1); // N%45와 같은 범위(0~44)
//			Thread.sleep(500);
//		}

		// 난수 생성 : Math.random() ------
		// Math.random() : 0 이상 1 미만의 실수를 돌려주는 메서드. 정수 범위로 만들 때는 곱한 뒤 % 연산을 함
//		while (true) {
//			System.out.println( (int)(Math.random()*100)%15 );
//		System.out.println((int)(Math.random()*100)%16);
//
// 		System.out.println(int)(Math.random() * 15);
//
//			Thread.sleep(500);
//		}

		// 04 끝자리 수 ------
		// % 10의 거듭제곱은 오른쪽 끝자리 수를, / 10의 거듭제곱은 왼쪽 앞자리 수를 구함
//		int num = 56789;
//
//		System.out.println("오른쪽 끝 1자리 : " + (num % 10));
//		System.out.println("오른쪽 끝 2자리 : " + (num % 100));
//		System.out.println("오른쪽 끝 3자리 : " + (num % 1000));
//		System.out.println("오른쪽 끝 4자리 : " + (num % 10000));
//		System.out.println();
//		System.out.println("왼쪽 끝 1자리 : " + (num / 10000));
//		System.out.println("왼쪽 끝 2자리 : " + (num / 1000));
//		System.out.println("왼쪽 끝 3자리 : " + (num / 100));
//		System.out.println("왼쪽 끝 4자리 : " + (num / 10));

		// 문제 : 정수 거꾸로 저장 ------
		// 정수 하나를 입력받아 거꾸로 저장하는 문제. 반복문을 배운 뒤 %, / 연산을 함께 써서 풂
		// 예) 입력 : 1234
		//     저장 : int reverse = 4321;
		//     출력 : 4321

		// 풀이 ------
		// 끝자리를 % 10으로 꺼내 reverse 뒤에 붙이고, / 10으로 끝자리를 버리는 과정을 반복함
//		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
//		int reverse = 0;
//		while (num > 0) {
//			reverse = reverse * 10 + num % 10;		// reverse를 한 자리 올리고 끝자리를 붙임
//			num /= 10;								// 끝자리를 버림
//		}
//		System.out.println("출력 : " + reverse);	// 입력 1234 -> 4321
//		sc.close();
	}

}
