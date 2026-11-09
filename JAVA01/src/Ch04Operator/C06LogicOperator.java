package Ch04Operator;

// =======================================
// 논리 연산자
// &&, || 단락 평가와 증감 연산자의 조합
// =======================================

public class C06LogicOperator {
	public static void main(String[] args) {

		// 단락 평가 ------
		// 단락 평가 : || 는 왼쪽이 true면 오른쪽 식을 실행하지 않고, && 는 왼쪽이 false면 오른쪽 식을 실행하지 않음
		// 오른쪽 식에 ++, -- 가 있으면 실행 여부에 따라 변수 값이 달라짐
		int a=0,b=0;
		boolean c;

		// 왼쪽이 true인 경우 ------
		// ++a 로 a가 2가 되어 왼쪽이 true, 오른쪽 식은 실행되지 않아 b는 1 그대로임
		a = 1;
		b = 1;
		c =(++a>0)||(++b>0) ; // a=2, b=1, c=true

		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

		// 오른쪽 식에 감소 연산이 있어도 실행되지 않으므로 결과는 위와 같음
		a = 1;
		b = 1;
		c = (++a>0)||(--b>0) ; // a=2, b=1, c=true
		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

		// 왼쪽이 false인 경우 ------
		// --a 로 a가 0이 되어 왼쪽이 false, 오른쪽 식을 실행해 b가 2가 되고 true라 c는 true
		a = 1;
		b = 1;
		c = (--a>0)||(++b>0) ; // a=0, b=2, c=true
		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

		// 후위 연산자 : b-- 는 비교할 때는 현재 값 1을 쓰고(1>0 이라 true) 비교 뒤에 b를 0으로 줄임
		a = 1;
		b = 1;
		c = (--a>0)||(b-->0) ; // a=0, b=0, c=true
		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);
	}
}
