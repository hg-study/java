package Ch05Inheritance;

// =======================================
// 메서드 오버라이딩
// 상위 클래스 메서드를 하위 클래스에서 재정의
// =======================================

// 오버라이딩 ------
// 오버라이딩(Method Overriding) : 상속을 전제로 상위 클래스의 메서드를 하위 클래스가 본문만 고쳐 다시 정의하는 문법
// 헤더(반환형, 이름, 매개변수)는 그대로 두고 본문({})만 바꿈
// 같은 메서드를 물려받아도 하위 클래스마다 다른 결과를 만들 수 있어 다형성의 근거가 됨
// @Override : 오버라이딩임을 컴파일러에게 알리는 어노테이션. 헤더가 다르면 오류를 내 실수를 막아 줌

// 오버로딩과 오버라이딩의 차이 ------
// 구분        | 오버로딩                          | 오버라이딩
// 상속        | 필요 없음                         | 필요함
// 헤더        | 매개변수가 달라짐(이름은 같음)    | 그대로 유지
// 본문        | 바꾸지 않음                       | 바꿈
// 목적        | 같은 이름으로 개발 편의성         | 다형성

class C03Animal{
    void sound() {System.out.println("소리낸다!");}
}

class C03Dog extends C03Animal{
    void sound() {System.out.println("멍멍 소리낸다!");}
}

class C03Cat extends C03Animal{
    @Override
    void sound() {System.out.println("야옹 소리낸다!");}
}

public class C03MethodOverriding {
    public static void main(String[] args) {

        C03Dog tori = new C03Dog();
        tori.sound();
        System.out.println("--------------");
        C03Cat navi = new C03Cat();
        navi.sound();
    }
}
