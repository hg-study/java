package Ch02TypeCast;

// =======================================
// 정수 나눗셈과 실수 결과
// int끼리 나누면 소수점이 버려지는 것과 실수로 계산하는 방법
// =======================================

public class C05IntDivision {
    public static void main(String[] args) {

        // 정수 나눗셈 ------
        // int끼리 나누면 몫만 남고 소수점 이하는 버려짐. 소수점까지 구하려면 한쪽을 실수로 바꿔서 나눔
        int num1 = 10, num2 = 4;
        double dnum1 = (double)num1 / num2;   // num1을 double로 강제 형변환해 실수 나눗셈이 되므로 2.5
        double dnum2 = (num1*1.0) / num2;     // 1.0을 곱해 double로 바꾸는 방법. 2.5
        double dnum3 = num1 / num2;           // int끼리 나누면 몫 2만 남고, 이 값이 double에 담겨 2.0

        System.out.println("dnum1: "+dnum1);
        System.out.println("dnum2: "+dnum2);
        System.out.println("dnum3: "+dnum3);

    }
}
