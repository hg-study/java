package Ch18FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// =======================================
// Function 인터페이스
// apply, andThen, 함수를 반환하는 함수
// =======================================

public class C03FunctionType {

	
	// Function<입력, 출력> : 하나의 인자를 받아 결과를 돌려주는 표준 함수형 인터페이스. apply() 로 실행하고 andThen() 으로 함수를 이어 붙임
	// func1 : 제곱
	public static Function<Integer, Integer> func1 = x -> x*x ;
	
	// func2 : 두 배
	public static Function<Integer, Integer> func2 = x -> x+x ;

	// func3 : 리스트의 누적합
	public static Function<List<Integer>, Integer> func3 = x -> x.stream().reduce(0,(sum,el) -> sum+el);
	
	// func4 : 리스트에서 String 만 골라내기
	public static Function<List<Object>, List<String>> func4 = x -> x.stream()
																	 .filter(obj -> obj instanceof String)
																	 .map(obj -> (String) obj)
																	 .collect(Collectors.toList());
	
	// 10 -> 10*10(func1 return) -> 100 + 100(func2 return)
	public static Function<Integer, Integer> func5 = func1.andThen(func2);
	
	// [10,20,30] -> 60(func3 return) -> 60+60(func2 return) -> 120*120(func1 return)
	public static Function<List<Integer>, Integer> func6 = func3.andThen(func2).andThen(func1);
	
	// 함수를 반환하는 함수 : 첫 인자 x 를 받아 두 번째 인자 n 을 받는 함수를 돌려줌. 안쪽 함수가 x 를 캡처함(클로저)
	public static Function< Integer, Function<Integer, Integer> > func7 = x -> {
		System.out.println("func7's x: " + x);
		return (n) -> { 
					System.out.println("func7's return function n: " + n);
					System.out.println("func7's return function x: " + x);
					return n + x;};
		};
		
	// func7 을 줄여 쓴 형태
	public static Function< Integer, Function<Integer, Integer> > func8 = x -> n -> n + x;
			

	
	public static void main(String[] args) {
		System.out.println("(1) 제곱: " + func1.apply(10)); 	// 100
		System.out.println("(2) 덧셈: " + func2.apply(10)); 	// 20
		System.out.println("(3) 누적합: " + func3.apply(Arrays.asList(10,20,30))); 	// 60
		System.out.println("(4) String만 꺼내기: " 
		+ func4.apply(Arrays.asList(11, 10.5, "TEST", true, "ㅎㅎ", new StringBuffer("HI"), 20, 40))); 	// [TEST, ㅎㅎ]
		
		System.out.println("(5) andThen 1단계: " + func5.apply(10)); 	// 200
		System.out.println("(6) andThen 2단계: " + func6.apply(Arrays.asList(10,20,30))); 	// 200
		System.out.println("(7) func7: " + func7.apply(10).apply(20)); 	// 200
		System.out.println("(8) func8: " + func8.apply(10).apply(20)); 	// 200
	}
	

}
