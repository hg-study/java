package Ch03Generic;

// =======================================
// 타입 매개변수가 두 개인 제네릭
// 커플 클래스
// =======================================

// 다중 타입 매개변수 ------
// <M extends Person, W extends Person> : 타입 매개변수를 쉼표로 여러 개 선언하고 각각 타입 제한을 걸 수 있음
class Person{
	String name;
	int age;

	// 모든 인자를 받는 생성자
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
}

class Man extends Person{

	Man(String name, int age){
		super(name,age);
	}

	@Override
	public String toString() {
		return this.name;
	}

}

class Woman extends Person{

	Woman(String name, int age) {
		super(name, age);
	}

	@Override
	public String toString() {
		return this.name;
	}

}

class Couple <M extends Person, W extends Person>{
	private M role_man;
	private W role_woman;

	Couple(M role_man,W role_woman){
		this.role_man = role_man;
		this.role_woman = role_woman;
	}

	@Override
	public String toString() {
		return "Couple [role_man=" + role_man + ", role_woman=" + role_woman + "] (은)는 커플입니다.";
	}

}

public class C03GenericCouple {

	public static void main(String[] args) {

		Couple<Man, Woman> couple1 = new Couple<Man, Woman>(new Man("철수", 20), new Woman("영희", 20));
		System.out.println("커플: " + couple1);
		// 두 타입 모두 Person 을 상속하면 되므로 같은 성별끼리도 가능
		Couple<Man, Man> couple2 = new Couple<Man, Man>(new Man("홍석천", 55), new Man("풍자", 40));
		System.out.println("커플: " + couple2);
	}

}
