package Ch06AbstractInterface;

// =======================================
// 인터페이스의 활용
// 타이어를 인터페이스로 만들어 교체 가능하게 하기
// =======================================

// 인터페이스 활용 ------
// 부품(Tire)을 인터페이스 타입으로 선언하면 같은 규약을 구현한 어떤 타이어로도 바꿔 끼울 수 있음
// 사용하는 쪽(Car)의 코드를 고치지 않고 부품만 교체하는 것이 인터페이스의 장점

interface Tire{
	void run();
}

class HankookTire implements Tire{

	@Override
	public void run() {
		System.out.println("한국 타이어가 굴러갑니다.");
	}

}

class KumhoTire implements Tire{

	@Override
	public void run() {
		System.out.println("금호 타이어가 굴러갑니다.");
	}

}


class Car{
	Tire FL;
	Tire FR;
	Tire BL;
	Tire BR;

	Car(){
		FL = new HankookTire();
		FR = new HankookTire();
		BL = new HankookTire();
		BR = new HankookTire();
	}

	void start() {
		FL.run();
		FR.run();
		BL.run();
		BR.run();
	}

}


public class C04InterfaceTire {

	public static void main (String[] args) {

		Car car = new Car();
		car.start();

		System.out.println("----------------");

		// 타이어 교체 : 두 개를 금호 타이어로 바꿈
		car.FR = new KumhoTire();
		car.BL = new KumhoTire();
		car.start();

	}
}
