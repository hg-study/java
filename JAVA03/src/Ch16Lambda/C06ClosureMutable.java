package Ch16Lambda;

// =======================================
// 가변 클로저
// 배열, 객체 필드, static 변수로 캡처한 값을 바꾸는 방법
// =======================================

// 박스를 열어 안의 값 꺼내기 (읽기 전용 클로저)
// 캡처한 지역 변수는 바꿀 수 없으므로 값을 바꾸려면 배열 요소, 인스턴스 변수, static 변수처럼 참조로 접근하는 공간을 사용함
interface ClosureBox {
	String open();
}

// 인자 X / 반환 X - 단순 실행 작업 (필드 트릭 데모용)
interface Task {
	void run();
}

class Simple{
	int n;

	@Override
	public String toString() {
		return "Simple [n=" + n + "]";
	}
	
}

// 호출할 때마다 자기 안의 숫자를 1 증가시켜 반환 (가변 클로저)
interface TickBox {
	int tick();
}

public class C06ClosureMutable {
	
	public static int n;

	// 박스 공장 1: item 박제해서 박스 전환 (읽기 전용)
	private static ClosureBox makeBox(String item) {
		return () -> "박스 안: " + item;
	}
	
	// 박스 공장 2: start 부터 카운트하는 박스 반환 (가변)
	private static TickBox makeTicker(int start) {
		int[] n = { start };		// 람다가 캡처해서 들고 다닐 "주머니"
		return () -> n[0]++;		// 현재값 반환 후 +1
	}
	
	public static void main(String[] args) {
		// 읽기 전용 확인
//		ClosureBox box1 = makeBox("사과");
//		ClosureBox box2 = makeBox("바나나");
//		ClosureBox box3 = makeBox("포도");
//
//		System.out.println("(1) box1.open() = " + box1.open());		// 박스 안: 사과
//		System.out.println("(1) box2.open() = " + box2.open());		// 박스 안: 바나나
//		System.out.println("(1) box3.open() = " + box3.open());		// 박스 안: 포도

		// 2. 배열 트릭 사용
//		int n = 0;
//		Task addOne = ()->{n++;}; // 람다 내부에서 외부 변수 사용 시 final
			
		// 2. 배열 트릭 : 배열 자체는 바뀌지 않고 요소만 바뀌므로 람다 안에서 사용할 수 있음
		int n [] = {0};
		Task addOne = ()->{n[0]++;}; // 람다 내부에서 외부 변수 사용 시 final
		addOne.run();addOne.run();addOne.run();addOne.run();
		System.out.println("n[0]: "+n[0]);
		
		// 3. 인스턴스 변수 / static 변수 사용
		// 3. 인스턴스 변수와 static 변수 : 객체와 클래스에 속한 값이라 람다 안에서 바꿀 수 있음
		Simple ob = new Simple();
		
		Task addOne2 = () -> {ob.n++;};
		addOne2.run();addOne2.run();addOne2.run();addOne2.run();addOne2.run();
		System.out.println(ob);
		
		Task addOne3 = () -> {C06ClosureMutable.n++;};
		addOne3.run();addOne3.run();addOne3.run();addOne3.run();addOne3.run();addOne3.run();
		System.out.println(C06ClosureMutable.n);

		// 4. 가변 클로저(인터페이스 + 람다마다 고유 개별공간)
		// 4. 가변 클로저 : 람다마다 자기만의 배열(주머니)을 가지고 있어 호출할 때마다 값이 이어서 증가함
		TickBox ticker1 = makeTicker(10);
		System.out.println(ticker1.tick());
		System.out.println(ticker1.tick());
		System.out.println(ticker1.tick());
		System.out.println(ticker1.tick());
		
		TickBox ticker2 = makeTicker(100);
		System.out.println(ticker2.tick());
		System.out.println(ticker2.tick());
		System.out.println(ticker2.tick());
		System.out.println(ticker2.tick());

	}
	
	
}
