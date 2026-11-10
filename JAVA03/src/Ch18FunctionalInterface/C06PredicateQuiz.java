package Ch18FunctionalInterface;

// =======================================
// Predicate 문제
// 조건 정의와 and, or, negate 조합, filter 연결
// =======================================

// 학습 목표 ------
// Predicate<T> 람다를 정의하고, and / or / negate 로 조건을 조합하고, Stream 의 filter 와 연결해 데이터를 가공함

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class C06PredicateQuiz {

	public static void main(String[] args) {
		List<Integer> nums  = Arrays.asList(-5, -3, 0, 2, 7, 8, 11, 13, 15, 20);
		List<String>  words = Arrays.asList("apple", "ant", "banana", "cherry", "", "kiwi", "berry");

		// Predicate ------
		// Predicate<T> : T 를 받아 boolean 을 돌려주는 조건 검사용 함수형 인터페이스. test() 로 실행하며 filter 와 잘 어울림
		// 조합 메서드 : and(둘 다 참), or(하나라도 참), negate(반대)

		// 문제 1. 정수용 Predicate 3개를 정의하고 nums 에 대해 7가지 조건으로 걸러 List 로 출력
		// isPositive(양수), isEven(짝수), lessThan10(10 미만)
		Predicate<Integer> isPositive = n -> n > 0;
		Predicate<Integer> isEven     = n -> n % 2 == 0;
		Predicate<Integer> lessThan10 = n -> n < 10;

		System.out.println("(1) 양수만            : " + nums.stream().filter(isPositive).collect(Collectors.toList()));
		System.out.println("(2) 짝수만            : " + nums.stream().filter(isEven).collect(Collectors.toList()));
		System.out.println("(3) 10 미만만         : " + nums.stream().filter(lessThan10).collect(Collectors.toList()));
		System.out.println("(4) 양수 AND 짝수     : " + nums.stream().filter(isPositive.and(isEven)).collect(Collectors.toList()));
		System.out.println("(5) 양수 OR 짝수      : " + nums.stream().filter(isPositive.or(isEven)).collect(Collectors.toList()));
		System.out.println("(6) NOT 양수          : " + nums.stream().filter(isPositive.negate()).collect(Collectors.toList()));
		System.out.println("(7) 양수 & 10미만 & 짝수 : " + nums.stream().filter(isPositive.and(lessThan10).and(isEven)).collect(Collectors.toList()));

		// 문제 2. 문자열용 Predicate 3개를 정의하고 words 에 대해 걸러 출력
		// isEmpty(빈 문자열), startsWithA(a 로 시작), lenGE5(길이 5 이상)
		Predicate<String> isEmpty     = String::isEmpty;
		Predicate<String> startsWithA = s -> s.startsWith("a");
		Predicate<String> lenGE5      = s -> s.length() >= 5;

		System.out.println("(1) 비어있지 않은 것  : " + words.stream().filter(isEmpty.negate()).collect(Collectors.toList()));
		System.out.println("(2) a 로 시작         : " + words.stream().filter(startsWithA).collect(Collectors.toList()));
		System.out.println("(3) 길이 5 이상       : " + words.stream().filter(lenGE5).collect(Collectors.toList()));

		// 문제 3. "apple" 과 같은지 판단하는 Predicate 를 정의해 같은 것과 같지 않은 것을 출력
		// Predicate.isEqual(값) : 값과 같은지 검사하는 Predicate 를 만드는 정적 메서드
		Predicate<String> isApple = Predicate.isEqual("apple");

		System.out.println("(1) apple 과 같은 것  : " + words.stream().filter(isApple).collect(Collectors.toList()));
		System.out.println("(2) apple 과 다른 것  : " + words.stream().filter(isApple.negate()).collect(Collectors.toList()));
	}
}
