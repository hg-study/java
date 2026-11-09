package Ch01Variable;

// =======================================
// 상수
// 리터럴 상수와 심볼릭 상수(final), 리터럴 접미사
// =======================================

public class C06Constant {
    public static void main(String[] args) {

        // 상수 ------
        // 상수 : 항상 같은 값을 가지는 수
        // 리터럴 상수 : 이름 없이 값 그대로 쓰는 상수. 상수 pool에 저장됨
        // 심볼릭 상수 : 이름을 붙인 상수. final 예약어로 만듦

        // 리터럴 접미사 ------
        // 리터럴 접미사 : 리터럴 상수가 저장될 자료형을 지정하는 문자
        // l, L : long 자료형
        // f, F : float 자료형

        // 문자 상수와 정수 ------
        int a = 'a';                       // char -> int 자동 형변환. 'a'의 유니코드 값 97이 저장됨
        System.out.println(a);
        System.out.println((char)a);       // int -> char 강제 형변환. 97을 다시 문자 a로 출력

        // 리터럴 상수와 심볼릭 상수 ------
        int n1 = 100;                      // 100은 리터럴 상수
        final int n2 = 200;                // n2는 심볼릭 상수. 한 번 정하면 바꿀 수 없음

        final double PI = 3.14;            // final : 값을 한 번 정하면 바꿀 수 없게 하는 예약어. 상수 이름은 대문자로 씀

        double result = PI*4*4;            // 반지름 4인 원의 넓이 계산에 상수를 사용함

    }
}
