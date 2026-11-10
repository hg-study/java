package Ch18FunctionalInterface;

// =======================================
// Function 과 Stream 으로 List 가공
// 문자열 개수 세기, 제곱합, 첫 글자 추출
// =======================================

// 문제 ------
// func1 : List<String> 에서 길이가 5 이상인 문자열의 개수를 반환
// func2 : List<Integer> 의 각 숫자를 제곱해서 누적합을 반환
// func3 : List<String> 의 각 문자열에서 첫 글자만 대문자로 뽑은 리스트를 반환
// 기대 출력 :
//   (1) 길이 5 이상 개수 : 3
//   (2) 제곱 합          : 55
//   (3) 첫 글자 대문자   : [K, P, L, C]

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class C04FunctionList {

	// Function<입력, 출력> : 하나의 인자를 받아 결과를 돌려주는 함수형 인터페이스. apply() 로 실행함
	// func1 : filter 로 길이 5 이상만 남기고 count 로 개수를 셈 (count 는 long 이라 int 로 변환)
	public static Function<List<String>, Integer> func1 =
			list -> (int) list.stream().filter(s -> s.length() >= 5).count();

	// func2 : map 으로 제곱한 뒤 reduce 로 누적합을 구함
	public static Function<List<Integer>, Integer> func2 =
			list -> list.stream().map(n -> n * n).reduce(0, (sum, n) -> sum + n);

	// func3 : map 으로 첫 글자만 뽑아 대문자로 바꾸고 List 로 모음
	public static Function<List<String>, List<String>> func3 =
			list -> list.stream()
						.map(s -> s.substring(0, 1).toUpperCase())
						.collect(Collectors.toList());

	public static void main(String[] args) {
		List<String>  words = Arrays.asList("apple", "hi", "banana", "cat", "elephant");
		List<Integer> nums  = Arrays.asList(1, 2, 3, 4, 5);
		List<String>  names = Arrays.asList("kim", "park", "lee", "choi");

		System.out.println("(1) 길이 5 이상 개수 : " + func1.apply(words));
		System.out.println("(2) 제곱 합          : " + func2.apply(nums));
		System.out.println("(3) 첫 글자 대문자   : " + func3.apply(names));
	}
}
