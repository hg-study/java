package Ch03Generic;

// =======================================
// 제네릭 메서드
// 배열을 받아 요소를 출력하는 메서드
// =======================================

class Animal {
	String name;
}

class Panda extends Animal {

	Panda (String name) {this.name = name;}

	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}

}

class Tiger extends Animal {
	Tiger (String name) {this.name = name;}

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}
}


public class C04GenericMethod {

	// 제네릭 메서드 ------
	// 제네릭 메서드 : 반환형 앞에 <T> 를 선언해 메서드 단위로 타입을 지정하는 메서드. extends Animal 로 Animal 계열 배열만 받음
	public static <T extends Animal> void printGeneric(T [] arr) {
		for (T el: arr) {
			System.out.println(el);
			}
	}

	// Object 배열 : 모든 객체를 받을 수 있지만 타입을 제한할 수 없음
	public static void PrintByObject(Object [] arr) {
		for (Object el: arr) {
			System.out.println(el);
		}
	}


	public static void main(String[] args) {
		Tiger arr1 [] = {new Tiger ("시베리안 호랑이"), new Tiger("신사동 호랭이"), new Tiger("타이거JK")};
		printGeneric(arr1);

		Panda arr2 [] = {new Panda ("중국팬더"), new Panda("쿵푸팬더"), new Panda("래서팬더") };
		printGeneric(arr2);

		// Person 은 Animal 이 아니라 printGeneric 에 넘길 수 없고(컴파일 에러), extends Animal 을 지우면 가능함
		Object arr3 [] = {new Panda ("쿵푸팬더3"), new Tiger("호랑이"), new Panda("팬더"), new Person("가람", 20)};
		// printGeneric(arr3);
		PrintByObject(arr3);

	}

}
