package Ch01CoreClass;

// =======================================
// 래퍼 클래스
// 기본 자료형을 객체로 감싸는 Boxing 과 UnBoxing
// =======================================

// 래퍼 클래스 ------
// 래퍼 클래스(Wrapper Class) : 기본 자료형의 값을 객체로 포장하는 클래스(Integer, Double, Boolean 등)
// Boxing : 기본 자료형 값을 래퍼 클래스의 객체로 변환
// UnBoxing : 래퍼 객체에 저장된 값을 기본 자료형으로 변환
// Auto Boxing : new 없이 대입만으로 자동으로 객체를 만드는 문법

public class C04Wrapper {
	public static void main(String[] args) {
		// Boxing
		// new Integer(...) 는 더 이상 권장하지 않는 방식이라 valueOf 를 사용함
		Integer ob1 = new Integer(100);
		Integer ob2 = new Integer("100");
		Integer ob3 = Integer.valueOf("300");   // 문자열을 Integer 객체로 변환
		System.out.println(ob1 + ob2 + ob3);

		// UnBoxing : 래퍼 객체 -> 기본 자료형
		int n1 = ob1.intValue();
		int n2 = ob2.intValue();
		int n3 = ob3.intValue();
		System.out.println(ob1 + ob2 + ob3);

		// Auto Boxing : new 없이 값을 바로 대입하면 객체가 자동으로 만들어짐
		Integer ob4 = 100;

		// Auto UnBoxing : 연산에서는 래퍼 객체가 자동으로 기본 자료형 값으로 바뀜
		int n4 = ob1 + ob2 + ob3 + ob4;

	}
}
