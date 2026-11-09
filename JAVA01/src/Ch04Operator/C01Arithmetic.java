package Ch04Operator;

import java.util.Scanner;

// =======================================
// 기본 산술 연산자
// 사칙 연산과 나머지 연산, 두 수를 입력받는 문제
// =======================================

public class C01Arithmetic {

	public static void main(String[] args) {

		// 기본 산술 연산자 ------
		// 산술 연산자 : 사칙 연산(+, -, *, /)과 나머지(%)를 계산하는 연산자. 정수끼리 나누면 몫만 남음
		// 두 변수로 각 연산의 결과를 출력하는 코드(주석 처리)
//		int a = 10, b = 20, c;
//		System.out.println("a+b="+ (a + b));
//		System.out.println("a-b="+ (a - b));
//		System.out.println("a*b="+ (a * b));
//		System.out.println("b/a="+ (b / a)); // 나누기 : 몫
//		System.out.println("a%b="+ (a % b)); // 나누기 : 나머지. 짝홀수 구분, 배수 구분, 자릿수 제한, 끝자리 구하기에 활용함
//		System.out.println("-a="+ -a);

		// 문제 ------
		// 두 수를 입력받아 두 수의 합, 차(n1>n2), 곱을 출력하는 프로그램을 만드는 문제
		// 첫 번째 풀이 : 첫 번째 수가 두 번째 수보다 작으면 뺄 수 없다는 안내를 출력함

// 		Scanner sc = new Scanner(System.in);

// 		System.out.print("숫자1:");
// 		int n1 = sc.nextInt();
// 		System.out.print("숫자2:");
// 		int n2 = sc.nextInt();

// 		System.out.printf("\n합: %d", n1+n2);

// 		if (n1>=n2){
// 			System.out.printf("\n차: %d", n1-n2);
// 		}else{
// 			System.out.print("\n첫번째 값이 두번째 값보다 적어 뺄 수 없습니다.");
// 		}

// 		System.out.printf("\n곱: %d", n1*n2);

// //		sc.close();

// 		// 다른 풀이 : 삼항 연산자로 큰 수에서 작은 수를 빼 차를 항상 양수로 출력함

// 		int n1 = sc.nextInt();
// 		int n2 = sc.nextInt();

// 		System.out.println("합: "+ (n1+n2));
// 		System.out.println("차: "+ ( (n1>n2)? n1-n2:n2-n1 ));
// 		System.out.println("곱: "+ (n1*n2));

// 		sc.close();


		// 대입 연산자 ------
		// 대입 연산자 = : 오른쪽 값을 먼저 처리해 왼쪽 공간에 저장하는 연산자
		// LV = RV;
		// 공간 = 값(우선 처리);

		// 복합 대입 연산자 ------
		// 복합 대입 연산자 : 기본 산술 연산과 대입을 한 번에 하는 연산자(+=, -=, *=, /=, %=)
//		int a = 10;
//		a = a + 10;
//		a += 10;  // a = a + 10; 과 같음
//		a -= 5;   // a = a - 5; 와 같음
//		a *= 3;   // a = a * 3; 과 같음
//		System.out.println("a="+a);

		// 비교 연산자 ------
		// 비교 연산자 : 두 값을 비교해 참(true) 또는 거짓(false)을 돌려주는 연산자(==, !=, >, <, >=, <=)
//		int a =10;
//		int b=20;
//		System.out.println("A == B : "+ (a == b)); // a와 b가 같은지 비교
//		System.out.println("A  > B : "+ (a > b));
//		System.out.println("A  < B : "+ (a < b));
//		System.out.println("A >= B : "+ (a >= b));
//		System.out.println("A <= B : "+ (a <= b));
//		System.out.println("A != B : "+ (a != b));

		// 논리 연산자 ------
		// AND 연산자 && : 왼쪽, 오른쪽이 둘 다 true일 때만 true
		// OR 연산자 || : 왼쪽, 오른쪽 중 하나만 true여도 true
		// ! 연산자 : true는 false로, false는 true로 뒤집음

		// int a=10; int b=20;
		// System.out.println((a>=b)&&(a>5));
		// System.out.println((a!=b)&&(b>15));

		// System.out.println((a>=b)||(a>5));
		// System.out.println((a!=b)||(b>15));
		// System.out.println((a==b)||(a<=5));

		// 논리 연산 진리표 출력
		// System.out.println("true AND true = " + (true && true));
		// System.out.println("false AND true = " + (false && true));
		// System.out.println("true AND false = " + (true && false));
		// System.out.println("false AND false =  " + (false && false));

		// 단락 평가 확인 : 왼쪽이 false면 오른쪽 식(n2++)은 실행되지 않아 n2는 그대로 200
		// int n1 = 100;
		// int n2 = 200;
		// boolean n3 = (n1<100) && (n2++>0);
		// System.out.printf("%d %d %b\n",n1,n2,n3);

		// 논리 부정 연산자 ------
		// ! 연산자를 쓸 때마다 true와 false가 서로 바뀜
//		boolean play = true;
//		System.out.println(play);
//
//		play = !play;
//		System.out.println(play);
//
//		play = !play;
//		System.out.println(play);
//


		// 증감 연산자 ------
		// 전치 연산자 ++a(--a) : 먼저 값을 1 증가(1 감소)한 뒤 다른 연산을 처리
		// 후치 연산자 a++(a--) : 다른 연산을 먼저 처리한 뒤 1 증가(1 감소)
		// int a = 10, b = 10, c, d=0;

		// c = --a + b++;
		// d = a-- + ++b;
		// System.out.printf("a=%d , b=%d , c=%d, d=%d", a, b, c, d);

		// 삼항 연산자 ------
		// 삼항 연산자 : (조건식) ? 참일 때 실행 코드 : 거짓일 때 실행 코드;
		// 점수에 따라 등급을 고르는 중첩 삼항 연산자
		int score = 85;
		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
		System.out.println(score + "점은 " + grade + "등급입니다.");

	}

}
