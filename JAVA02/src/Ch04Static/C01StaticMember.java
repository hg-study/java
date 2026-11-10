package Ch04Static;

// =======================================
// static 변수
// 객체 없이 만들어지고 모든 객체가 공유하는 변수
// =======================================

// static ------
// static : 공유 메모리(클래스 영역)에 변수나 메서드를 올리는 예약어
// 객체를 만들기 전에 공간이 할당되므로 클래스명으로 접근할 수 있고, 모든 객체가 같은 값을 공유함

class C01Simple{
	static int n1;      // 클래스 변수 : 모든 객체가 공유
	int n2;             // 인스턴스 변수 : 객체마다 따로 가짐

	// 기본 생성자
	C01Simple(){}

	// 모든 인자를 받는 생성자
	public C01Simple(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	// toString
	@Override
	public String toString() {
		return "C01Simple [n1=" + n1 + ", n2=" + n2 + "]";
	}
}

public class C01StaticMember {

	public static void main(String[] args) {

		C01Simple.n1 = 1000;	// static 은 객체 없이 클래스명으로 접근함
//		C01Simple.n2 = 10;		// 일반 변수는 객체가 만들어져야 생기므로 클래스명으로 접근할 수 없음

		C01Simple ob1 = new C01Simple();
		C01Simple ob2 = new C01Simple();

		System.out.println("ob1: "+ob1);
		System.out.println("ob2: "+ob2);
		System.out.println("-----------------------");

		// 공유 확인 : 한 객체로 n1 을 바꾸면 다른 객체의 n1 도 같이 바뀜
		ob1.n1=2233;
		System.out.println("ob1: "+ob1);
		System.out.println("ob2: "+ob2);
		System.out.println("-----------------------");

		ob2.n1 = 56789;
		System.out.println("ob1: "+ob1);
		System.out.println("ob2: "+ob2);

	}

}
