package Ch02TypeCast;

// =======================================
// byte 범위를 넘는 값
// int 129, 130을 byte로 바꿀 때 남는 비트 확인
// =======================================

public class C03ByteOverflow {
    public static void main(String[] args) {

        // 넘치는 비트 버리기 ------
        // int 값을 byte로 강제 형변환하면 뒤 8비트만 남기고 나머지는 버림
        int num1 = 129;         // 00000000 00000000 00000000 1000_0001
        int num2 = 130;         // 00000000 00000000 00000000 1000_0010

        byte ch1 = (byte)num1;  // 뒤 8비트 1000_0001의 맨 앞 비트 1이 부호로 해석되어 -128 + 1
        byte ch2 = (byte)num2;  // 1000_0010 = -128 + 2

        System.out.printf("%d\n", ch1);   // -127
        System.out.printf("%d\n", ch2);   // -126
    }
}
