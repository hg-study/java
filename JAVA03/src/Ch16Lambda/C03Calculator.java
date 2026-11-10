package Ch16Lambda;

// =======================================
// 계산기 함수형 인터페이스
// 사칙연산을 람다식으로 구현
// =======================================

// 덧셈 , 뺄셈 , 곱셈 , 나눗셈을 수행하는 함수형 인터페이스를 정의
// 문제 : 덧셈, 뺄셈, 곱셈, 나눗셈을 수행하는 함수형 인터페이스를 정의하고 람다식으로 구현하는 문제
// 출력 결과 : 30, 20, 200, 20
interface Calculator{
	int calculate(int num1, int num2);
}
public class C03Calculator {

	public static void main(String[] args) {
		Calculator add = (a,b)->{return a+b;};
		Calculator sub = (a,b)->{return a-b;};
		Calculator mul = (a,b)->{return a*b;};
		Calculator div = (a,b)->{return a/b;};
		
		// 결과 출력
		System.out.println(add.calculate(10,20));// 덧셈
		System.out.println(sub.calculate(30,10));// 뺄셈
		System.out.println(mul.calculate(10,20));// 곱셈
		System.out.println(div.calculate(100,5));// 나눗셈
		//출력결과
//		30
//		20
//		200
//		20

	}	

}
