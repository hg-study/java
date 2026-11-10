package Ch05Inheritance;

// =======================================
// 업캐스팅 연습 5
// 상속과 여러 인터페이스를 함께 쓰는 계층 구조
// =======================================

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("새가 날아갑니다");
    }
}

class Duck extends Bird implements Swimmable {
    public void fly() {
        System.out.println("오리가 날아갑니다");
    }

    public void swim() {
        System.out.println("오리가 수영합니다");
    }

    void quack() {
        System.out.println("오리가 꽥꽥거립니다");
    }
}

public class C15UpcastComplex {
    public static void main(String[] args) {
        System.out.println("=== 연습문제 5: 복합 계층구조 ===");

        // 문제 ------
        // 1. Duck 인스턴스를 생성함
        // 2. Bird, Flyable, Swimmable 타입으로 각각 업캐스팅함
        // 3. 각 타입의 참조로 사용 가능한 메서드를 호출함
        // 4. 각 타입에서 다시 Duck 으로 다운캐스팅해 quack() 을 호출함

        Duck duck = new Duck();

        // Bird 타입 : fly() 사용 가능(재정의된 Duck 의 fly 실행)
        Bird bird = duck;
        bird.fly();
        ((Duck) bird).quack();

        // Flyable 타입 : fly() 만 사용 가능
        Flyable flyable = duck;
        flyable.fly();
        ((Duck) flyable).quack();

        // Swimmable 타입 : swim() 만 사용 가능
        Swimmable swimmable = duck;
        swimmable.swim();
        ((Duck) swimmable).quack();

    }
}
