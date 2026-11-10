package Ch06AbstractInterface;

// =======================================
// 인터페이스 다중 구현
// 클래스 상속은 하나, 인터페이스는 여러 개
// =======================================

// 다중 구현 ------
// 클래스는 하나만 상속(extends)할 수 있지만 인터페이스는 여러 개를 구현(implements)할 수 있음
// extends 를 먼저, implements 를 뒤에 쓰며 인터페이스는 쉼표로 구분함
interface A {}
interface B {}

class C {}
class D {}

class E extends C implements A,B {

}
public class C05InterfaceMulti {

	public static void main(String[] args) {

		// 하나의 객체를 상위 클래스와 인터페이스 타입으로 각각 업캐스팅할 수 있음
		E e = new E();
		C c = e;
		A a = e;
		B b = e;

	}

}
