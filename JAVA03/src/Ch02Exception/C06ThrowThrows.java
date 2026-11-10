package Ch02Exception;

// =======================================
// throw 와 throws
// 예외를 직접 발생시키고 호출한 쪽으로 넘기기
// =======================================

// throw 와 throws ------
// throw : 예외 객체를 직접 만들어 발생시키는 문장
// throws : 메서드 선언부에 써서 이 메서드에서 발생할 수 있는 예외를 호출한 쪽에서 처리하도록 넘기는 키워드
class A{
	void func() throws NullPointerException {
		System.out.println("A class func() call!");
		String str = null;
		str.toString();
	}
}
class B{
	void func() throws Exception {      // 모든 예외를 넘길 수 있음
		System.out.println("B class func() call!");
		throw new ArithmeticException(); // 예외를 직접 발생시킴
	}
}

public class C06ThrowThrows {

	public static void main(String[] args) {

		A ob1 = new A();
		B ob2 = new B();

		try {
			// ob1.func();
			ob2.func();     // throws 로 넘어온 예외를 호출한 쪽에서 try - catch 로 처리함
		} catch(NullPointerException e1) {
			e1.printStackTrace();
		} catch(Exception e2) {         // ArithmeticException 은 여기서 처리됨
			e2.printStackTrace();
		}
	}

}
