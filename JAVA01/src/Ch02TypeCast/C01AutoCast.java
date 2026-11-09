package Ch02TypeCast;

// =======================================
// 자동 형변환
// 작은 자료형의 값을 큰 자료형 변수에 넣을 때 자동으로 변환되는 방향
// =======================================

public class C01AutoCast {

    public static void main(String[] args) {

        // 형변환 ------
        /*
        (자료) 형변환 : 연산할 때 일치하지 않는 자료형을 일치시키는 작업이다.

        자동 형변환(암시적 형변환) : 컴파일러가 자동으로 바꾸는 형변환
        강제 형변환(명시적 형변환) : 프로그래머가 직접 지정해 바꾸는 형변환

        자동 형변환(=)은 다음 경우에 일어난다.
        - 변수를 대입할 때 범위가 넓은 공간에 작은 값을 넣는 경우
        - 리터럴 상수를 연산할 때 리터럴 값에 따라 형변환 여부가 결정되는 경우

        자동 형변환 방향
        byte > short, char > int > long > float > double
        */

        // 정수, 문자 -> int ------
        byte byteValue = 10;
        int intValue = byteValue;   // byte -> int 자동 형변환
        System.out.println("intValue: " + intValue);

        char charValue = '가';
        intValue = charValue;       // char -> int 자동 형변환. 문자의 유니코드 값이 저장됨
        System.out.println("가 의 유니코드: " + intValue);

        // 큰 자료형으로 ------
        intValue = 50;
        long longValue = intValue;      // int -> long 자동 형변환
        System.out.println("longValue: "+longValue);

        longValue = 100;
        float floatValue = longValue;   // long -> float 자동 형변환. long이 float보다 크지만 표현 범위는 float이 더 넓음
        System.out.println("floatValue: "+floatValue);

        floatValue = 100.5F;
        double doubleValue = floatValue;   // float -> double 자동 형변환
        System.out.println("doubleValue: "+doubleValue);

    }
}
