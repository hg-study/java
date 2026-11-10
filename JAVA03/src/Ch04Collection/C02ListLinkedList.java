package Ch04Collection;

import java.util.LinkedList;
import java.util.List;

// =======================================
// LinkedList
// List 구현 클래스를 바꿔도 같은 방식으로 사용
// =======================================

// 구현 클래스 선택 ------
// 변수 타입을 List 로 선언하면 ArrayList, LinkedList, Vector 중 어떤 것을 생성해도 같은 메서드로 사용할 수 있음
// LinkedList : 요소가 앞뒤 주소로 연결된 List. 중간 삽입과 삭제가 빠르고 조회는 느림
// Vector : ArrayList 와 구조가 같지만 동기화(멀티스레드 안전) 처리가 되어 조금 느림

public class C02ListLinkedList {

	public static void main(String[] args) {
		// List<String> list = new ArrayList();
		List<String> list = new LinkedList();
		// List<String> list = new Vector();

		// 추가
		list.add("HTML/CSS/JS");
		list.add("NODEJS");
		list.add("SCSS");
		list.add("REACT");
		list.add("JAVA");
		list.add("JSP/SERVLET");
		list.add("STS");
		list.add("SPRING BOOT");

		// 조회
		System.out.println("개수 확인: " + list.size());
		System.out.println("inx로 조회: " + list.get(2));
		System.out.println("Value로 idx확인: "+ list.indexOf("JAVA"));
		list.forEach(System.out::println);

		// 삭제
		list.remove(0);
		list.remove("REACT");
		System.out.println("--삭제 후 결과--");
		list.forEach(System.out::println);

		// 전체 삭제
		list.clear();
	}

}
