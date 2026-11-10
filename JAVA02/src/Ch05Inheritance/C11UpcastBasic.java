package Ch05Inheritance;

// =======================================
// 업캐스팅 연습 1
// 기본 업캐스팅과 다운캐스팅
// =======================================

class Animal {
    void makeSound() {
        System.out.println("동물이 소리를 냅니다");
    }

}

class Dog extends Animal {
    // 재정의
    void makeSound() {
        System.out.println("멍멍!");
    }
    // 확장
    void fetch() {
        System.out.println("강아지가 공을 가져옵니다!");
    }

}

public class C11UpcastBasic {
    public static void main(String[] args) {
        System.out.println("=== 연습문제 1: 기본 업캐스팅 ===");

        // 문제 ------
        // 1. Dog 인스턴스를 생성함
        // 2. 생성한 Dog 인스턴스를 Animal 타입으로 업캐스팅함
        // 3. 업캐스팅된 참조로 makeSound() 를 호출함
        // 4. 업캐스팅된 참조로 fetch() 를 호출해 결과를 확인함

        Dog dog1 = new Dog();
        Animal ani = dog1;

        ani.makeSound();        // 재정의된 메서드라 "멍멍!" 이 출력됨

        // ani.fetch();         // Animal 에는 fetch 가 없어 접근 불가 -> 다운캐스팅이 필요
        Dog down = (Dog)ani;
        down.fetch();

        ((Dog)ani).fetch();     // 변수에 담지 않고 바로 형변환해 호출하는 방법

    }
}
