package Ch01Class;

// =======================================
// 변수의 종류와 유효 범위
// 멤버 변수와 지역 변수의 이름이 같을 때
// =======================================

// 변수의 종류 ------
// 범위가 넓은 순서 : 전역 변수 > 클래스 변수 > 멤버 변수(인스턴스 변수) > 지역 변수
// 지역 변수 : 메서드나 {} 안에 선언. 호출될 때 생성되고 끝나면 소멸하며 그 안에서만 쓸 수 있음(매개변수 포함)
// 멤버 변수 : 클래스 안, 메서드 밖에 선언. 객체가 생성될 때 만들어져 객체마다 따로 값을 가짐
// 클래스 변수 : static 이 붙은 멤버 변수. 같은 클래스의 모든 객체가 공유하고 객체 없이도 사용 가능
// 전역 변수 : 클래스와 메서드 밖에서 선언해 프로그램 어디서든 쓰는 변수(자바에는 없는 개념)

class Simple{
    // 속성
    int num = 10;   // 멤버 변수

    // 기능
    void Func1() {
        num++;      // 멤버 변수 증가
        System.out.println("num: " + num);
        int num= 20;// 같은 이름의 지역 변수를 정의함. 이후 num 은 지역 변수를 가리킴
        num++;      // 지역 변수 증가
        this.num++; // this 를 붙이면 멤버 변수를 가리킴
        System.out.println("num: "+ num);
    }

    void Func2() {
        System.out.println("num: "+ num);
        if (num>0) {
            int num = 100;  // if 블록 안의 지역 변수
            System.out.println("num: "+ num);   // 지역 변수 출력
        }
        System.out.println("num: "+ num);       // 블록을 벗어나 다시 멤버 변수 출력
        // 조건식의 num 은 멤버 변수(10)인데 반복 안에서는 지역 변수만 바뀌어 멤버 변수가 변하지 않으므로 무한 반복함
        while (num<15) {
            int num = 100;
            System.out.println("num: "+ num);
        }
    }

    // 매개변수 이름은 n 인데 num 을 대입하므로 멤버 변수가 자기 자신에게 대입되는 코드가 됨
    void Func3(int n){
        this.num=num;

    }

}

public class C05LocalVarMain {
    public static void main(String[] args) {

    }
}
