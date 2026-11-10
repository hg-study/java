package Ch03Generic;

import java.util.ArrayList;

// =======================================
// 제네릭 연습 문제
// 자바의 정석 12장 연습 문제 풀이
// =======================================

// 참고 : https://velog.io/@9to0/%EC%9E%90%EB%B0%94%EC%9D%98-%EC%A0%95%EC%84%9D-3%ED%8C%90-12-%EC%97%B0%EC%8A%B5%EB%AC%B8%EC%A0%9C-%EC%A0%9C%EB%84%A4%EB%A6%AD%EC%8A%A4-%EC%97%B4%EA%B1%B0%ED%98%95-%EC%95%A0%EB%84%88%ED%85%8C%EC%9D%B4%EC%85%98

// 문제 12-1 ------
// 클래스 Box 가 아래와 같이 정의되어 있을 때 오류가 발생하는 문장은?
class Box<T> {
	T item;

	void setItem(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}
}
// 답 : a, b, c
// a. Box<Object> b = new Box<String>();           오류. 제네릭은 상속 관계가 있어도 타입 인자가 같아야 함
// b. Box<Object> b = (Object) new Box<String>();  오류. Object 를 Box<Object> 에 대입할 수 없음
// c. new Box<String>().setItem(new Object());     오류. String 을 받는 곳에 Object 를 넘김
// d. new Box<String>().setItem("ABC");            정상

// 문제 12-2 ------
// 제네릭 메서드 makeJuice() 를 올바르게 호출한 문장을 모두 고르는 문제 (Apple 과 Grape 는 Fruit 의 자손)
class Fruit { public String toString() { return "Fruit"; } }
class Apple extends Fruit { public String toString() { return "Apple"; } }
class Grape extends Fruit { public String toString() { return "Grape"; } }

class FruitBox<T extends Fruit> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }
	ArrayList<T> getList() { return list; }
}

class Juicer {
	static <T extends Fruit> String makeJuice(FruitBox<T> box) {
		String tmp = "";
		for (Fruit f : box.getList()) tmp += f + " ";
		return tmp;
	}
}
// 답 : c, d
// a. Juicer.<Apple>makeJuice(new FruitBox<Fruit>());   오류. 타입 인자 Apple 과 FruitBox<Fruit> 가 맞지 않음
// b. Juicer.<Fruit>makeJuice(new FruitBox<Grape>());   오류. 타입 인자 Fruit 와 FruitBox<Grape> 가 맞지 않음
// c. Juicer.<Fruit>makeJuice(new FruitBox<Fruit>());   정상
// d. Juicer.makeJuice(new FruitBox<Apple>());          정상. T 가 Apple 로 추론됨
// e. Juicer.makeJuice(new FruitBox<Object>());         오류. T 는 Fruit 계열이어야 하므로 Object 불가

// 문제 12-3 ------
// 올바르지 않은 문장을 모두 고르는 문제
// 답 : d, g
// a. Box<?> b = new Box();                       경고만 발생(원시 타입 사용)
// b. Box<?> b = new Box<>();                     정상
// c. Box<?> b = new Box<Object>();               정상
// d. Box<Object> b = new Box<Fruit>();           오류. 타입 인자가 달라 대입 불가
// e. Box b = new Box<Fruit>();                   경고만 발생
// f. Box<? extends Fruit> b = new Box<Apple>();  정상
// g. Box<? extends Object> b = new Box<? extends Fruit>();   오류. 와일드카드는 객체 생성에 쓸 수 없음

// 문제 12-4 ------
// 두 개의 ArrayList 를 하나로 병합하는 메서드를 제네릭 메서드로 바꾸는 문제
class MergeItem {}
class Tv extends MergeItem { public String toString() { return "Tv"; } }

public class C06GenericQuiz {

	// 풀이 : 반환형 앞에 <T extends MergeItem> 를 선언하고 매개변수와 반환형에 T 를 사용함
	public static <T extends MergeItem> ArrayList<T> merge(ArrayList<? extends T> list, ArrayList<? extends T> list2) {
		ArrayList<T> newList = new ArrayList<>(list);
		newList.addAll(list2);
		return newList;
	}

	public static void main(String[] args) {
		// 12-2 : 올바른 호출 확인
		FruitBox<Fruit> fb = new FruitBox<Fruit>();
		fb.add(new Apple());
		fb.add(new Grape());
		System.out.println(Juicer.<Fruit>makeJuice(fb));

		FruitBox<Apple> ab = new FruitBox<Apple>();
		ab.add(new Apple());
		System.out.println(Juicer.makeJuice(ab));

		// 12-4 : 병합 확인
		ArrayList<Tv> a = new ArrayList<Tv>();
		a.add(new Tv());
		ArrayList<Tv> b = new ArrayList<Tv>();
		b.add(new Tv());
		System.out.println(merge(a, b));
	}

}
