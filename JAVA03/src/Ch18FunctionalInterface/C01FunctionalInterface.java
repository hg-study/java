package Ch18FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// =======================================
// 함수형 인터페이스 직접 만들기
// @FunctionalInterface 와 가변 인자 람다식
// =======================================

// (1) 인자O / 반환X - 표준 Consumer<String>과 모양 같음
@FunctionalInterface  // 함수형 인터페이스임을 명시 -> 추상 메서드는 하나만 생성 가능
// @FunctionalInterface : 함수형 인터페이스임을 명시하는 어노테이션. 추상 메서드를 둘 이상 만들면 컴파일 에러가 남
interface Func1{
	void say(String message);
}

// (2) 가변인자 Integer ...받아 int 변환
@FunctionalInterface
interface Func2{
	int sum(Integer ...args);
}

//(3) 가변인자 Integer ...받아 List<Integer> 변환
@FunctionalInterface
interface Func3{	
	List<Integer> sum(Object ...args);
}

public class C01FunctionalInterface {

	public static void main(String[] args) {
		
		// (1) 인자O / 반환X
		Func1 func1 = (message) -> System.out.println(message + "_!");
		func1.say("HELLO WORLD");
		
		// (2) 가변인자 Integer ...받아 int 변환
		Func2 func2 = arr -> Arrays	.stream(arr) .reduce(0,(sum,item)->sum+item); 
		
		System.out.println("func2(sum) = " + func2.sum(10,20,30,40,50,60));
		
		//(3) 가변인자 Integer ...받아 List<Integer> 변환
		Func3 func3 = (arr) -> Arrays.stream(arr)
						 			 .filter(el->el instanceof Integer)
									 .map(el->(Integer)el)
									 .collect(Collectors.toList());
			
			
		System.out.println("func3(sum) = " + func3.sum(10,20,30.5,"길동",true));

		
	}

}
