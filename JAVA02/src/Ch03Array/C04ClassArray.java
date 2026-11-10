package Ch03Array;

// =======================================
// 객체 배열
// 클래스 자료형으로 만든 배열
// =======================================

class C04Person{
	String name;
	int age;

	// 기본 생성자
	C04Person(){}

	// 모든 인자를 받는 생성자
	public C04Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// toString 재정의
	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}

}


public class C04ClassArray {

	public static void main(String[] args) {

		// 객체 배열 ------
		// 객체 배열 : 객체의 주소를 저장하는 참조변수를 요소로 가지는 배열. 배열만 만들면 요소는 null 이라 객체를 따로 만들어 넣어야 함
		C04Person list[] = new C04Person[3];

		// 각 칸에 객체의 주소값을 넣어줌
		list[0] = new C04Person();
		list[1] = new C04Person();
		list[2] = new C04Person();

		// 요소 삽입
		list[0].name="홍길동";
		list[0].age=55;

		list[1].name="김영희";
		list[1].age=35;

		list[2].name="김범수";
		list[2].age=40;

		for(C04Person person : list)
			System.out.println(person);
	}

}
