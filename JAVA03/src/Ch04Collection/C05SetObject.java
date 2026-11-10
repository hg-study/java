package Ch04Collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// =======================================
// Set 에 객체 저장
// hashCode 와 equals 로 중복 판단
// =======================================

// 객체의 중복 판단 ------
// HashSet 은 hashCode 가 같고 equals 가 true 일 때 같은 객체로 보고 중복 저장하지 않음
// 두 메서드를 재정의하지 않으면 필드 값이 같아도 주소가 달라 서로 다른 객체로 저장됨
class Person{
	String name;
	int age;
	// 기본 생성자
	Person(){}
	// 모든 인자를 받는 생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	// toString 재정의
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	// hashCode 재정의 : 비교할 필드(name, age)로 해시값을 만듦
	@Override
	public int hashCode() {
		return Objects.hash(this.name,this.age);
	}

	// equals 재정의 : name 과 age 가 모두 같으면 같은 객체
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person down = (Person)obj;
			return this.name.equals(down.name) && this.age == down.age;
		}
		return false;
	}
}

public class C05SetObject {

	public static void main(String[] args) {

		Set<Person> set = new HashSet();
		Person ob1 = new Person("홍길동",55);
		Person ob2 = new Person("남길동",35);
		Person ob3 = new Person("홍길동",55);

		System.out.println(ob1.equals(ob2));    // false
		System.out.println(ob1.equals(ob3));    // true

		set.add(ob1);
		set.add(ob2);
		set.add(ob3);                           // ob1 과 같은 객체로 판단되어 저장되지 않음

		System.out.println("SIZE : " + set.size());     // 2
	}
}
