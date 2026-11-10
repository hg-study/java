package Ch05Inheritance;

// =======================================
// 업캐스팅 상태의 메서드 접근
// 재정의된 메서드와 추가된 메서드
// =======================================

class Parent{
    void func1(){System.out.println("Parent's func1() Call!!");}
    void func2(){System.out.println("Parent's func2() Call!!");}
}

class Son extends Parent{
    // 재정의
    void func2(){System.out.println("Son's func2() Call!!");}

    // 추가(확장)
    void func3(){System.out.println("Son's func3() Call!!");}
}

public class C08UpcastAccess {
    public static void main(String[] args) {

        // 형변환 없음 ------
        // Parent ob1 = new Parent();
        // ob1.func1();
        // ob1.func2();
        // System.out.println("--------------");

        // Son ob2 = new Son();
        // ob2.func1();
        // ob2.func2();
        // ob2.func3();
        // System.out.println("--------------");

        // 업캐스팅 ------
        Parent ob3 = new Son();
        ob3.func1();    // 물려받은 메서드
        ob3.func2();    // 재정의된 메서드 : Son 의 내용이 실행됨(다운캐스팅 불필요)

        // 접근 규칙 ------
        // 업캐스팅된 상태(상위형 변수 = 하위 객체)에서
        // 하위 클래스에 추가된 멤버(func3)에는 접근할 수 없음 -> 다운캐스팅이 필요
        // 하위 클래스에서 재정의한 메서드(func2)에는 접근할 수 있음 -> 다운캐스팅이 필요 없음
        ((Son) ob3).func3();

    }
}
