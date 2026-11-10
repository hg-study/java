package Ch04Static;

// =======================================
// static 메서드
// static 메서드에서 쓸 수 있는 변수
// =======================================

class C02Simple{

    static int n1;
    int n2;

    // 일반 메서드 : static 변수와 일반 변수를 모두 사용할 수 있음
    void func1(){
        n1 = 100;
        n2 = 200;

    }

    // static 메서드 ------
    // static 메서드는 객체 생성 전에 만들어지므로 static 변수와 지역 변수만 사용할 수 있음
    static void func2(){

        n1 = 300;       // static 변수
        int n3 = 500;   // 지역 변수

        //n2 = 400;     // n2 는 객체가 만들어져야 생기는데 static 메서드는 그보다 먼저 만들어져 사용할 수 없음

    }

}
public class C02StaticMethod {
    public static void main(String[] args) {

    }
}
