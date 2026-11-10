package Ch04Collection;

import java.util.HashSet;
import java.util.Set;

// =======================================
// Set 과 HashSet
// 중복을 허용하지 않는 컬렉션
// =======================================

// Set ------
// Set : 순서가 없고 중복을 허용하지 않는 컬렉션
// HashSet : 해시 구조 Set. 추가와 삭제, 중복 확인이 가장 빠름

public class C03SetHashSet {

	public static void main(String[] args) {
		Set<String> set = new HashSet();

		// 추가 ------
		set.add("HTML/CSS/JS");
		set.add("NODEJS");
		set.add("SCSS");
		set.add("REACT");
		// 중복 값을 추가해도 한 개만 저장됨(add 는 false 를 돌려주고 기존 값을 유지)
		set.add("JAVA");
		set.add("JAVA");

		set.add("JSP/SERVLET");
		set.add("STS");
		set.add("SPRING BOOT");
		set.add("SPRING BOOT");

		// 삭제 ------
		// remove(값) : 인덱스가 없으므로 값으로 삭제
		set.remove("REACT");

		// size() : 중복을 제외한 실제 저장 요소 개수
		System.out.println("개수 확인: " + set.size());

		// 탐색 : Iterator ------
		// Iterator : 컬렉션의 요소를 차례로 꺼내는 반복자. 인덱스가 없는 Set 은 for 문으로 접근할 수 없어 사용함
		// hasNext() : 꺼낼 요소가 남았는지 확인(true, false)
		// next() : 요소를 꺼내 돌려주고 다음 위치로 이동
//		Iterator<String> iter = set.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}

		// 탐색 : 향상된 for 문 ------
		// 향상된 for 문은 내부적으로 Iterator 를 사용하므로 더 간단하게 쓸 수 있음
		for (String el: set) {
			System.out.println(el);
		}

		// 전체 삭제
		set.clear();

	}

}
