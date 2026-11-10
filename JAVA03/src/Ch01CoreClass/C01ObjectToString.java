package Ch01CoreClass;

// =======================================
// Object 클래스의 toString
// 모든 클래스의 최상위 클래스
// =======================================

// Object ------
// Object : 모든 클래스의 최상위 클래스. 별도로 상속하지 않아도 자동으로 상속받아 equals, hashCode, toString 등을 물려받음
// toString() : 객체를 문자열로 바꿔 돌려주는 메서드. 재정의하지 않으면 클래스명@해시코드 형태로 출력됨

class A{
	int x;
	int y;

	@Override
	public String toString() {
		return "A [x=" + x + ", y=" + y + "]";
	}

}
public class C01ObjectToString {

	public static void main(String[] args) {
		A ob1 = new A();
		System.out.println(ob1.toString());
		System.out.println(ob1);            // println 에 객체를 넘기면 toString() 이 자동 호출됨

		Object ob2 = new Object();
		System.out.println(ob2);            // 재정의하지 않아 java.lang.Object@해시코드 로 출력됨
		System.out.println(ob2.toString());

	}

}
