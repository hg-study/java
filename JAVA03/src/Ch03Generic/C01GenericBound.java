package Ch03Generic;

// =======================================
// 제네릭 클래스와 타입 제한
// 호빵 재료를 상속 관계로 제한하기
// =======================================

// 제네릭 ------
// 제네릭(Generics) : 클래스나 메서드에서 사용할 자료형을 사용하는 시점에 지정하는 문법. 형변환 없이 타입 안정성을 얻음
// 타입 제한 <T extends 상위클래스> : T 에 올 수 있는 자료형을 상위 클래스와 그 하위 클래스로 제한함
// 참고 : https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%A0%9C%EB%84%A4%EB%A6%ADGenerics-%EA%B0%9C%EB%85%90-%EB%AC%B8%EB%B2%95-%EC%A0%95%EB%B3%B5%ED%95%98%EA%B8%B0

class BunFilling {

}

class RedBean extends BunFilling {

	@Override
	public String toString() {
		return "단팥";
	}

}

class Vegetable extends BunFilling {

	@Override
	public String toString() {
		return "야채";
	}
}

class Pizza extends BunFilling {

	@Override
	public String toString() {
		return "피자";
	}
}

// BunFilling 을 상속하지 않아 Bun 에 넣을 수 없는 클래스
class MintChoco {

	@Override
	public String toString() {
		return "민트초코";
	}
}

class Bun <T extends BunFilling> {
	private T filling;

	Bun(T filling){
		this.filling = filling;
	}

	@Override
	public String toString() {
		return "호빵 [재료=" + filling + "]";
	}

}

public class C01GenericBound {

	public static void main(String[] args) {
		Bun<RedBean> ob1 = new Bun<RedBean>(new RedBean());
		System.out.println(ob1);

		Bun<Vegetable> ob2 = new Bun<Vegetable>(new Vegetable());
		System.out.println(ob2);

		Bun<Pizza> ob3 = new Bun<Pizza>(new Pizza());
		System.out.println(ob3);

		// 상속 관계에 포함되지 않아 컴파일 에러
//		Bun<MintChoco> ob4 = new Bun<MintChoco>(new MintChoco());
//		System.out.println(ob4);
	}

}
