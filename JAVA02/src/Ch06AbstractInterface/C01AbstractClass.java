package Ch06AbstractInterface;

// =======================================
// 추상 클래스
// 추상 메서드와 일반 클래스 상속과의 차이
// =======================================

// 추상 클래스 ------
// 추상 클래스(abstract class) : 추상 메서드를 하나 이상 가진 클래스. 직접 객체를 만들 수 없고 상속해서 사용함
// 추상 메서드 : 선언만 있고 구현(몸체)이 없는 메서드. 하위 클래스가 반드시 오버라이딩해야 함
// 목적 : 공통 기능은 상위 클래스에 구현해 두고, 특정 기능은 하위 클래스가 반드시 구현하도록 강제해 같은 역할의 메서드 이름이 제각각이 되지 않게 함

// 일반 클래스 상속 관계
class Parent1 {
    void func() {}
}

class Son1 extends Parent1{
    // 재정의
    void func() {
        System.out.println("Son1's 에서 재정의한 func..");
    }
}

// 추상 클래스 상속 관계
abstract class Parent2 {

    abstract void func();
}

class Son2 extends Parent2{
    @Override
    void func() {
        System.out.println("Son2's 에서 재정의한 func..");
    }
}

class Son3 extends Parent2{
    @Override
    void func() {
        System.out.println("Son3's 에서 재정의한 func..");
    }
}

public class C01AbstractClass {
    public static void main(String[] args) {
        // 일반 클래스 상속 관계 ------
        Parent1 ob1 = new Parent1();    // 상위 클래스형 객체 생성 가능
        Son1    ob2 = new Son1();       // 하위 클래스형 객체 생성 가능

        Parent1 ob3 = new Son1();       // 업캐스팅 연결 가능
        ob3.func();                     // 재정의된 func() 접근 가능

        // 추상 클래스 상속 관계 ------
        // Parent2 ob4 = new Parent2(); // 추상 클래스는 미완성 클래스라 객체를 만들 수 없음
        Son2 ob5 = new Son2();          // 추상 메서드를 재정의한 하위 클래스는 객체 생성 가능
        Parent2 ob6 = new Son2();       // 업캐스팅 연결 가능
        ob6.func();

        ob6 = new Son3();               // 같은 변수에 다른 하위 객체를 연결하면 다른 동작을 함
        ob6.func();
    }
}
