package Ch03Input;

import java.util.Scanner;

// =======================================
// Scanner 문자열 입력
// next()와 nextLine()의 차이와 남은 엔터 처리
// =======================================

public class C02ScannerLine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 숫자 입력 ------
        System.out.print("정수 입력: ");
        int num1 = sc.nextInt();
        System.out.println("입력된 정수 값: "+num1);

        System.out.print("실수 입력: ");
        double num2 = sc.nextDouble();          // nextDouble() : 실수를 읽는 메서드
        System.out.println("입력된 실수 값: "+num2);

        // 남은 엔터 처리 ------
        // nextInt(), nextDouble()은 입력 값만 읽고 마지막에 누른 엔터(\n)는 버퍼에 남겨 둠
        // nextLine()은 한 줄 전체를 읽으므로 남은 엔터를 바로 읽어 빈 문자열로 끝나 버림
        sc.nextLine();                          // 남아있는 엔터를 이 줄이 대신 읽어서 비움

        // 문자열 입력 ------
        System.out.print("문자열 입력: ");
        // next() : 공백 앞까지 한 단어만 읽는 메서드. 띄어쓰기를 포함할 수 없음
        // String str1 = sc.next();
        // nextLine() : 띄어쓰기를 포함한 한 줄 전체를 읽는 메서드
        String str1 = sc.nextLine();
        System.out.println("입력된 문자열: "+str1);

        sc.close();

    }
}
