package Ch04Collection;

import java.util.ArrayList;
import java.util.List;

// =======================================
// List 와 ArrayList
// 추가, 조회, 삭제
// =======================================

// List ------
// List : 순서가 있고 중복을 허용하는 컬렉션. 인덱스로 요소에 접근함
// ArrayList : 배열 기반 List. 조회가 빠르고 중간 삽입과 삭제는 느림

public class C01ListArrayList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();  // 오른쪽 타입이 같으면 <> 안의 타입은 생략 가능

		// 추가 ------
		// add(값) : 리스트 맨 뒤에 요소를 추가
		list.add("HTML/CSS/JS");
		list.add("NODEJS");
		list.add("SCSS");
		list.add("REACT");
		list.add("JAVA");
		list.add("JSP/SERVLET");
		list.add("STS");
		list.add("SPRING BOOT");

		// 조회 ------
		// size() : 담긴 요소의 총 개수
		System.out.println("개수 확인: " + list.size());
		// get(index) : 해당 인덱스의 요소
		System.out.println("inx로 조회: " + list.get(2));
		// indexOf(value) : 값이 있는 인덱스. 없으면 -1
		System.out.println("Value로 idx확인: "+ list.indexOf("JAVA"));

		// 전체 출력 ------
		// forEach 에 람다식 또는 메서드 참조(System.out::println)를 넘겨 간결하게 출력함
		// list.forEach((el) -> {System.out.println(el);});
		// list.forEach(el -> System.out.println(el));
		list.forEach(System.out::println);

		// 삭제 ------
		// remove(index) : 해당 인덱스의 요소를 삭제하고 뒤의 요소를 앞으로 당김
		list.remove(0);
		// remove(Object) : 해당 값을 가진 첫 요소를 삭제. 성공하면 true
		list.remove("REACT");
		System.out.println("--삭제 후 결과--");
		list.forEach(System.out::println);

		// 전체 삭제 ------
		// clear() : 모든 요소를 비움(size 가 0 이 됨)
		list.clear();
	}

}
