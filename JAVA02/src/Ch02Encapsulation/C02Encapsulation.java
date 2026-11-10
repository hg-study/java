package Ch02Encapsulation;

// =======================================
// 캡슐화
// 엔진의 세부 공정을 숨기고 하나의 기능으로 묶기
// =======================================

// 캡슐화 ------
// 캡슐화 : 특정 목적의 기능에 필요한 세부 기능들을 하나로 묶어 처리하는 방법
// 세부 공정이 밖으로 노출되지 않도록 정보 은닉(private)과 함께 쓰는 경우가 많으나 필수는 아님
// 각 공정을 정확히 이해해야 묶을 수 있음

class Engine{
    // 세부 공정 : 밖에서 직접 부르지 못하도록 private
    private void intake() {System.out.println("외부로부터 공기를 빨아들인다.");}
    private void compress() {System.out.println("가둔 공기를 압축시킨다.");}
    private void explode() {System.out.println("일정 수준 압축되면 폭발!");}
    private void exhaust() {System.out.println("가스를 외부로 보낸다.");}

    // 캡슐화 : 순서가 정해진 공정을 하나의 public 메서드로 묶어 노출함
    public void engineStart() {
        intake();
        compress();
        explode();
        exhaust();
    }
}

class Car{
    private Engine engine;
    Car(){
        this.engine = new Engine();
    }
    void run(){
        engine.engineStart();
    }
}

public class C02Encapsulation {
    public static void main(String[] args) {
        Car car = new Car();
        car.run();      // 사용하는 쪽은 세부 공정을 몰라도 run() 하나로 실행함
    }
}
