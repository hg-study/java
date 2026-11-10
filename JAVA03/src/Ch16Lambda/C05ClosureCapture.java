package Ch16Lambda;

// =======================================
// 클로저 기초
// 람다식이 바깥 변수를 캡처해서 기억하기
// =======================================

// 클로저(Closure) : 람다식이 자신이 만들어진 곳 바깥의 변수를 캡처해 기억하고 사용하는 기능
// 캡처한 지역 변수는 값이 바뀌지 않는 변수(final 또는 사실상 final)여야 함
interface Greeter {
	String say();
}

public class C05ClosureCapture {

	// 이름을 받아 그 이름을 기억하는 Greeter 를 만들어 돌려주는 메서드. 메서드가 끝난 뒤에도 name 이 유지됨
	private static Greeter makeGreeter(String name) {
		return () -> {return "Closure: " + name;};
	}
	
	public static void main(String[] args) {
//		 1. 외부 변수 캡처
		String str = "Hello?";
		Greeter t1 = () -> {return str;};
		System.out.println("1. " + t1.say());

//		 2. 외부 변수 캡처
		int n = 100;
		Greeter t2 = ()->{return "2. " + n;}; // n --> final 지정
//		n = 200;
		System.out.println(t2.say());
		
//		3
		Greeter t3 = makeGreeter("hihi");
		Greeter t4 = makeGreeter("hello hello");
		
		System.out.println(t3.say());
		System.out.println(t4.say());
	}

}
