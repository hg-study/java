package Ch16Lambda;

import java.util.ArrayList;
import java.util.List;

// =======================================
// 람다식으로 정렬과 순회
// List 의 객체를 나이 기준 내림차순으로 정렬하고 출력
// =======================================

// 람다식(Lambda Expression) : 이름 없는 함수를 식 하나로 표현한 문법. (매개변수) -> { 실행문 } 형태이며 컬렉션의 정렬, 순회에 자주 쓰임
class Person{
	// --- 필드(멤버 변수) 정의 ---
    // private: 캡슐화 원칙에 따라 데이터 직접 접근 제한	
	private String name;
	private int age;
	private String addr;

	// --- 디폴트 생성자 ---
    // Person(): 인자 없는 생성자.
	Person(){}
	
	// --- 모든 인자 생성자 ---
    // 객체 생성 & 필드 값을 초기화
	public Person(String name, int age, String addr) {
		super();			// 부모 클래스 생성자 호출
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	// --- Getter & Setter ---
    // 무결성 유지 & 외부에서 private 필드 접근할 수 있도록 허용
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	// --- toString 재정의 ---
    // @Override: 부모의 메서드를 덮어씀. 
	// 객체 출력 시 주소값 대신 필드 내용을 문자열로 반환
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}	
}

public class C01LambdaSort {

	public static void main(String[] args) {

		// --- 리스트 인스턴스 생성 ---
        // List<Person>: Person 객체만 담는 동적 배열 리스트 생성
		List<Person> list = new ArrayList();
		
		// --- 데이터 삽입 ---
        // add(): 리스트의 순서를 유지하며 객체 추가
		list.add(new Person("홍길동",55,"대구"));
		list.add(new Person("남길동",45,"창원"));
		list.add(new Person("서길동",35,"울산"));
		
		// --- 람다 표현식 단계별 변화 ---
//		list.forEach((el)->{System.out.println(el);});	// 기본 람다식
//		list.forEach(el->{System.out.println(el);});	// 파라미터 괄호 생략
//		list.forEach(el->System.out.println(el));		// 중괄호와 세미콜론 생략
//		list.forEach(System.out::println);				// 메서드 참조 방식
		
		// --- 정렬 로직 ---
		// list.sort(): List 인터페이스에서 제공하는 정렬 메서드
		// (b - a): 내림차순 정렬.
		// (a - b): 오름차순 정렬. 
		list.sort((a,b)->{return b.getAge()-a.getAge();});

		// --- 결과 출력 ---
		// list.forEach(): 컬렉션 내부에서 모든 요소를 순회하며 특정 동작을 수행하는 메서드
        // list의 각 요소를 인자로 전달하여 순차 출력
		list.forEach(System.out::println);
		
	}

}
