package Ch05Inheritance;

// =======================================
// 업캐스팅 연습 2
// 업캐스팅 상태의 메서드 접근
// =======================================

class Vehicle {
    void start() {
        System.out.println("탈것의 시동을 겁니다");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("자동차의 시동을 겁니다");
    }

    void turboBoost() {
        System.out.println("자동차가 터보로 가속합니다!");
    }
}

public class C12UpcastMethodAccess {
    public static void main(String[] args) {
        System.out.println("=== 연습문제 2: 메서드 접근 ===");

        // 문제 ------
        // 1. Car 인스턴스를 생성하고 Vehicle 타입으로 업캐스팅함
        // 2. 업캐스팅된 참조로 start() 를 호출함
        // 3. 업캐스팅된 참조로 turboBoost() 호출을 시도함
        // 4. Car 타입으로 다운캐스팅한 뒤 turboBoost() 를 호출함
        // 실행 결과 : 자동차의 시동을 겁니다 / (turboBoost 는 컴파일 에러) / 자동차가 터보로 가속합니다!

        Vehicle car1 = new Car();
        car1.start();
        // car1.turboBoost();   // Vehicle 타입에서는 접근 불가라 컴파일 에러

        Car down = (Car) car1;
        down.turboBoost();

    }
}
