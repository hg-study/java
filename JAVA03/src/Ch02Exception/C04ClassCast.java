package Ch02Exception;

// =======================================
// ClassCastException
// 잘못된 다운캐스팅
// =======================================

// ClassCastException : 실제 객체와 맞지 않는 클래스로 다운캐스팅할 때 발생하는 예외
class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}

public class C04ClassCast {

	public static void main(String[] args) {

		Animal poppi = new Dog();  // 업캐스팅
		Animal tori = new Cat();   // 업캐스팅
		try {
		Dog down1 = (Dog)poppi;    // 실제 객체가 Dog 라서 성공
		Dog down2 = (Dog)tori;     // 실제 객체가 Cat 이라 ClassCastException 발생
		} catch(ClassCastException e){
			e.printStackTrace();   // 실무에서는 로그 라이브러리(lombok 의 @Slf4j 등)로 기록함
		}

	}

}
