package Ch06AbstractInterface;

// =======================================
// final
// 변경 불가 변수, 재정의 불가 메서드, 상속 불가 클래스
// =======================================

// final ------
// final 변수 : 값을 한 번 정하면 바꿀 수 없는 상수(심볼릭 상수)
// final 메서드 : 하위 클래스에서 재정의(오버라이딩)할 수 없는 메서드
// final 클래스 : 상속할 수 없는 클래스

class Parent{
	int n1 = 100;
	final int n2 = 200;	// final 변수

	void setN1(int n1) {
		this.n1 = n1;
	}
	void setN2(int n2) {
//		this.n2 = n2;	// final 변수의 값은 바꿀 수 없어 컴파일 에러
	}

	final void func1() {
		System.out.println("Parent's final void func1 !");
	}
}
final class Son extends Parent{
	// 상위 클래스의 메서드가 final 이면 하위 클래스에서 재정의할 수 없음
//	final void func1() {
//		System.out.println("Parent's final void func1 !");
//	}
}
// final 로 지정된 클래스는 부모로 둘 수 없음
//class endPoint extends Son
//{
//
//}


public class C07Final {

	public static void main(String[] args) {
		// final 메서드는 재정의할 수 없을 뿐 하위 객체에서 그대로 호출할 수 있음
		Parent p = new Son();
		p.func1();
	}

}
