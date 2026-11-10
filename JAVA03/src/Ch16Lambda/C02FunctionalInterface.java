package Ch16Lambda;

// =======================================
// 함수형 인터페이스와 람다식
// 추상 메서드가 하나뿐인 인터페이스를 람다식으로 구현
// =======================================

// 함수형 인터페이스 ------
// 함수형 인터페이스 : 추상 메서드가 하나뿐인 인터페이스. 람다식으로 구현할 수 있음
// 람다식은 인터페이스 메서드의 매개변수와 반환형에 맞춰 작성함 (인자는 있고 반환값은 없는 경우, 반환값이 있는 경우)
interface Printer{
	void print(String name);	// 추상 메서드. 인자는 있고 반환값은 없음
	// String print(String name);   // 반환값이 있는 형태로 바꿔서 두 번째 예제를 확인할 수 있음
}
public class C02FunctionalInterface {

	public static void main(String[] args) {

		// 예제 1 : 반환값 없음 ------
		// 람다식 { 실행문 } 으로 구현하거나 메서드 참조(System.out::println)로 구현함
		Printer printer = (name)->{System.out.println("01 " + name);};
		// Printer printer = System.out::println;
		printer.print("HELLO WORLD");

		// 예제 2 : 반환값 있음 (주석 처리) ------
		// 인터페이스를 String print(String name); 으로 바꾸면 람다식이 return 으로 값을 돌려줘야 함
		// Printer printer = (name)->{return "02 " + name;};
		// String str2 = printer.print("HELLO WORLD");
		// System.out.println(str2);
	}
}
