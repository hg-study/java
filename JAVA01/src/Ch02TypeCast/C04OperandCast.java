package Ch02TypeCast;

// =======================================
// 연산식의 자동 형변환
// 연산에 참여하는 피연산자의 자료형이 맞춰지는 규칙
// =======================================

public class C04OperandCast {
    public static void main(String[] args) {

        // 상향 평준화 ------
        // 상향 평준화 : 연산에 참여하는 변수 중 가장 범위가 큰 자료형을 기준으로 모든 변수가 자동 형변환되는 규칙
        // int보다 작은 타입(byte, short, char)의 연산 : 컴파일러가 계산의 효율성과 정확도를 위해 먼저 int로 바꾼 뒤 계산함
        // int보다 큰 타입(long, float, double)이 섞인 연산 : 가장 큰 타입으로 자동 형변환됨

        // 작은 정수형끼리의 연산 ------
        // byte, short, char 사이의 산술 연산은 결과가 int가 됨
        byte x = 10;
        byte y = 20;
        byte result1 = (byte)(x + y);   // x + y는 이미 int로 계산되어 byte에 넣으려면 강제 형변환이 필요함
        int result2 = x + y;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println("----------");

        // 큰 정수형이 섞인 연산 ------
        // int보다 큰 long이 섞이면 결과는 long이 됨
        byte var1 = 10;
        int var2 = 100;
        long var3 = 1000L;
        int result = (int)(var1 + var2 + var3);   // 계산 결과가 long이라 int에 넣으려면 강제 형변환이 필요함

        System.out.println(result);

        // 실수가 섞인 연산 ------
        // 가장 큰 자료형으로 자동 형변환됨
        int intvar = 10;
        float flvar = 3.3F;
        double dbvar = 5.5;
        //int result3 = intvar + flvar + dbvar;     // 계산 결과가 가장 큰 double이라 int에 넣을 수 없어 오류
        double result4 = intvar + flvar + dbvar;
        System.out.println(result4);
    }
}
