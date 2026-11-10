package Ch03Generic;

// =======================================
// 제네릭 클래스 문제
// 어떤 맛이든 담는 팝콘
// =======================================

// 문제 ------
// 맛 클래스 어떤 것이든 재료로 담을 수 있는 제네릭 클래스 PopCorn 을 만드는 문제
// 타입 제한이 없는 <T> 는 모든 클래스를 받을 수 있음
class Caramel{
	@Override
	public String toString() {
		return "캬라멜맛";
	}
}

class ButterCorn{
	@Override
	public String toString() {
		return "옥수수맛";
	}
}


class PopCorn <T> {
	private T flavor;

	PopCorn(T flavor){
		this.flavor = flavor;
	}

	@Override
	public String toString() {
		return "PopCorn [재료=" + flavor + "]";
	}
}

public class C02GenericPopcorn {

	public static void main(String[] args) {
		PopCorn<Caramel> ob1 = new PopCorn<Caramel> (new Caramel());
		System.out.println(ob1);

		PopCorn<ButterCorn> ob2 = new PopCorn<ButterCorn> (new ButterCorn());
		System.out.println(ob2);
	}

}
