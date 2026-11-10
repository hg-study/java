package Ch01Class;

// =======================================
// 매개변수와 반환값의 자료형
// 기본형 값 전달과 참조형 주소 전달
// =======================================

class Person{

	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

}
public class C10ParamType {
	// 기본형 매개변수 ------
	// 기본형(Primitive) : 데이터값 자체를 복사해 전달함
	public static void func1(int num)
	{
		System.out.println(num);
	}
	// 참조형 매개변수 ------
	// 참조형(Reference) : 객체의 주소값을 전달함. toString 이 없으면 주소 형태로 출력됨
	public static void func2(Person obj)
	{
		System.out.println(obj);
	}

	// 객체 반환 ------
	// 반환 자료형을 Object 로 쓰면 어떤 객체든 반환할 수 있음
	public static Object func3(String name, int age) {
		return new Person(name,age);
	}

	public static void main(String[] args)
	{
		func1(10);
		func2(new Person("홍길동",10));
		Object ob=func3("티모",100);
	}
}
