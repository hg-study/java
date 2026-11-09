package Ch02TypeCast;

// =======================================
// char와 short 변환
// 부호 없는 char 값을 부호 있는 short로 바꿀 때 값이 바뀌는 이유
// =======================================

public class C06CharShortCast {
    public static void main(String[] args) {

        // 부호 없는 char ------
        char n1 = 60000;    // char는 부호가 없어 0 ~ 65535 그대로 저장됨. 비트열은 1110_1010_0110_0000
        System.out.println(Integer.toBinaryString(n1));

        // 부호 있는 short로 해석 ------
        short n2 = (short)n1; // short는 -32768 ~ 32767이라 같은 비트열을 부호 있는 수로 해석해 음수(-5536)가 됨
        System.out.println(n2);

        // short -> int ------
        int n3 = n2;          // short -> int 자동 형변환. 부호를 유지해 -5536
        System.out.println(n3);
    }
}
