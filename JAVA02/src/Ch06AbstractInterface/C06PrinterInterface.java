package Ch06AbstractInterface;

// =======================================
// 인터페이스 문제
// Printer 인터페이스와 구현 클래스
// =======================================

// 문제 ------
// Printer 인터페이스를 만들고 Inkjet 과 Laser 가 구현해 같은 변수로 출력하는 문제
interface Printer{
	void print();
}

class Inkjet implements Printer{

	@Override
	public void print() {
		System.out.println("Inkjet 프린터 출력");

	}
}
class Laser implements Printer{

	@Override
	public void print() {
		System.out.println("Laser 프린터 출력");
	}
}

public class C06PrinterInterface {

	public static void main(String[] args) {

		Printer p = new Inkjet();
		p.print(); // "Inkjet 프린터 출력"
		p = new Laser();
		p.print(); // "Laser 프린터 출력"

	}
}
