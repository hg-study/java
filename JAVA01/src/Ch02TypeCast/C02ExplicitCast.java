package Ch02TypeCast;

// =======================================
// 강제 형변환
// 캐스트 연산자로 큰 자료형을 작은 자료형에 넣을 때의 데이터 손실
// =======================================

public class C02ExplicitCast {
    public static void main(String[] args) {

        // 강제 형변환 ------
        /*
            강제 형변환 : 좁은 범위의 공간에 큰 자료형의 값을 넣으려 할 때 프로그래머가 (자료형)을 붙여 강제로 바꾸는 것이다.
            기본적으로는 큰 자료형을 작은 자료형에 넣을 수 없다. 컴파일러는 변수의 자료형 크기만 확인하므로 값이 충분히 들어갈 숫자라도 오류가 난다.
            강제로 바꾸면 데이터 손실이 생길 수 있다.

            byte > short, char > int > long > float > double
        */

        // 정수끼리 ------
        int intValue = 20000;
        char charValue = (char)intValue;   // int -> char 강제 형변환 필요
        System.out.println((int)charValue);

        long longValue = 500;
        intValue = (int)longValue;         // long -> int 강제 형변환
        System.out.println(intValue);

        // 실수에서 정수로 ------
        double doubleValue = 3.14;
        intValue = (int)doubleValue;       // 소수점 이하가 버려지는 데이터 손실이 생김
        System.out.println(intValue);

    }

}
