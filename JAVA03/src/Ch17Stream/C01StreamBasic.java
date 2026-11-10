package Ch17Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// =======================================
// 스트림 기초
// filter, map, sorted, collect 로 컬렉션 처리
// =======================================

class Person{
	protected String name;
	protected Integer age;

	
	// 디폴트
	public Person() {};

	// 모든인자
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	// toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
		
}

class Employee extends Person{
	private String department;
	private String role;

	// 디폴트 생성자
	Employee(){}

	// 모든 인자
	public Employee(String name, Integer age, String department, String role) {
		super(name, age);
		this.department = department;
		this.role = role;
	}

	public Employee(Person person) {
		this.name = person.getName();
		this.age = person.getAge();
		this.department = "인턴";
		this.role = "ROLE_STAFF";
	}

	// getter and setter
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [department=" + department + ", role=" + role + ", name=" + name + ", age=" + age + "]";
	}

	
	// toString 재정의

}

public class C01StreamBasic {

	public static void main(String[] args) {
		
		// init
		// 스트림 만들기 : 컬렉션의 stream() 으로 스트림을 만들고 중개 연산을 연결한 뒤 collect 로 결과를 모음
		List<Integer> li1 = Arrays.asList(1,2,3,4,5);
		System.out.println("li1: " + li1);
		// filter
		// filter : 조건이 true 인 요소만 남김 (짝수만)
		List<Integer> li2 = li1	.stream()
								.filter( (n)->{return n%2==0;} )
								.collect(Collectors.toList());
		
		System.out.println("li2: " + li2);
		
		// map
		// map : 요소를 다른 값으로 변환함 (홀수를 골라 제곱)
		List<Integer> li3 = li1.stream()
							   .filter((n)->{return n%2 == 1;})  // 1,3,5
							   .map((n)->{return n*n;}) // 1, 9, 25
							   .collect(Collectors.toList());
		System.out.println("li3: " + li3);
		
		// sorted
		// sorted : 비교 방식을 람다식으로 넘겨 정렬함. forEach 는 최종 연산으로 요소마다 출력함
		List<Person> persons = Arrays.asList(	
			new Person("홍길동", 45),
			new Person("남길동", 44),
			new Person("서길동", 35),
			new Person("유재석", 53),
			new Person("서장훈..", 52),
			new Person("강호동", 27)
		);

		
		// 나이순 내림차순
		persons .stream()
				.sorted((a,b)->{return b.getAge() - a.getAge();})
				.forEach(System.out::println);
				
		// map(Person::getAge) : 메서드 참조로 객체에서 나이만 뽑아 List 로 모음
		List<Integer> ages = persons.stream()
									.map(Person::getAge)
									.collect(Collectors.toList());
				
		System.out.println(ages);
		

		// 문제		
		// 문제 : 이름을 추출한 뒤 길이로 바꿔 오름차순으로 정렬
		// 방법 1 : map 을 두 번 사용 (주석 처리)
		List<Integer> nameLengths = persons	.stream()
//											.map(Person::getName)
//											.map(String::length)
											// 방법 2 : 람다식 한 번으로 이름의 길이를 구함 (답)
											.map((el)->{return el.getName().length();})
											.sorted((a,b)->{return a-b;})
											.collect(Collectors.toList());

		System.out.println("이름 길이: "+ nameLengths);
		
		// persons의 Person 객체를 Employee로 변환해서 저장
		// Employee의 상위 클래스는 Person
		// 부서 속성(String department), 직책 속성(String role)추가
		// 디폴트 생성자, 모든 인자, getter and setter, toString 재정의 할 것
		
//		List<Employee> employees = persons .stream()
//											.map((el)->{
//												Employee ob = new Employee(
//														el.getName(),
//														el.getAge(),
//														null,
//														null
//														);
//												return ob;})
//											.collect(Collectors.toList());
		
		// 문제 : persons 의 Person 객체를 Employee 로 변환해 저장하는 문제. Employee 는 Person 을 상속하고 부서(department)와 직책(role) 속성을 추가하며 기본 생성자, 모든 인자 생성자, getter, setter, toString 을 갖춤
		List<Employee> employees = persons 	.stream()
											.map((person)->{return new Employee(person);})
											.collect(Collectors.toList());

		
		
		System.out.println("Employee 변환: ");
		employees.forEach(System.out::println);
	}

}
