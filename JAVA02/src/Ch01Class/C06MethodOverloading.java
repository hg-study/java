package Ch01Class;

import java.util.Scanner;

// =======================================
// 메서드 오버로딩
// 이름이 같고 매개변수가 다른 메서드
// =======================================

class Cal{
    // 속성
    Scanner sc = new Scanner(System.in);

    // 오버로딩 ------
    // 오버로딩(Overloading) : 같은 이름의 메서드를 매개변수의 개수나 자료형을 달리해 여러 개 정의하는 문법
    // 호출할 때 넘기는 인자에 맞는 메서드가 선택되며, 반환형만 다른 경우는 오버로딩이 아님
    public int sum(int n1, int n2){
        System.out.println("int sum(int n1, int n2) CALL");
        return n1 + n2;
    }
    public int sum() {
        System.out.println("int sum() CALL");
        return sc.nextInt() + sc.nextInt();
    }

    public int sum(int n1, int n2, int n3){
        System.out.println("int sum(int n1, int n2, int n3) CALL");
        return n1 + n2 + n3;
    }
    public int sum(int n1, int n2,int n3, int n4) {
        System.out.println("int sum(int n1, int n2,int n3, int n4) CALL");
        return n1 + n2 + n3 + n4;
    }
}

public class C06MethodOverloading {
    public static void main(String[] args) {
        Cal cal = new Cal();
        System.out.println("SUM1: " + cal.sum(10, 20) );
        System.out.println("SUM2: " + cal.sum() );
        System.out.println("SUM1: " + cal.sum(10, 20, 30) );
        System.out.println("SUM1: " + cal.sum(10, 20, 30, 40) );
    }
}
