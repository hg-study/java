package Ch18FunctionalInterface;

import java.util.Arrays;
import java.util.Comparator;

// =======================================
// 사칙연산 문제
// 가변 인자 함수형 인터페이스와 Stream, 람다식으로 구현
// =======================================

/* ----------------------------------------------------------
   2. [학생용 문제] 사칙연산 함수형 인터페이스 + Stream + Lambda
   ----------------------------------------------------------
   조건 :
     - sum / sub / mul / div 람다를 람다 + Stream 으로 구현
     - 모든 인자를 받을 수 있도록 가변인자 처리
     - 뺄셈 / 나눗셈은 큰 수 → 작은 수로 정렬 후 누적 감산 / 누적 제산
       (예: sub(1,4,2,9) → 정렬 9,4,2,1 → 9-4-2-1 = 2)

   정답 참고 : C02CalcQuizAnswer.java
   ---------------------------------------------------------- */

@FunctionalInterface
interface Functional {
	Integer execute(int ...args);
}

class Calc {
	Functional sum;   // 합
	Functional sub;   // 차
	Functional mul;   // 곱
	Functional div;   // 나누기

	Calc() {
		// sum : 모든 인자를 더함
		sum = args -> Arrays.stream(args).sum();

		// sub : 큰 수에서 작은 수 순으로 정렬한 뒤 앞에서부터 차례로 뺌
		sub = args -> Arrays.stream(args)
							.boxed()	
							.sorted(Comparator.reverseOrder())
							.reduce((a,b)->a-b)
							.orElse(0);
		
		
		// mul : reduce(1, 곱셈) 으로 누적해 곱함
		mul = args -> Arrays.stream(args).reduce(1, (a,b) -> a*b);
		
		// div : 큰 수에서 작은 수 순으로 정렬한 뒤 앞에서부터 차례로 나눔 (정수 나눗셈)
		div = args -> Arrays.stream(args)
							.boxed() 
							.sorted(Comparator.reverseOrder())
							.reduce((a,b)->a/b)
							.orElse(0);
		
	}
}

public class C02CalcQuiz {

	public static void main(String[] args) {
		Calc calc = new Calc();

		// 람다 채우면 아래 실행 가능
		// 기대 출력 :
		//   합     : 210
		//   차     : 2
		//   곱     : 720000000
		//   나눗셈 : 0

		System.out.println("합: " + calc.sum.execute(1,2,6,1));
		 System.out.println("차: " + calc.sub.execute(1,2,3,50));       
		System.out.println("곱: " + calc.mul.execute(12,19,1));
		 System.out.println("나눗셈: " + calc.div.execute(1,20,9,888));

	}
}
