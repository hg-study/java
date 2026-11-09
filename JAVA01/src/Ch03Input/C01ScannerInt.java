package Ch03Input;

import java.util.Scanner;

// =======================================
// Scanner 정수 입력
// 키보드로 정수 세 개를 입력받는 방법
// =======================================

public class C01ScannerInt {
    public static void main(String[] args) {

        // Scanner 정의 ------
        // Scanner : 키보드로 들어오는 데이터를 읽어주는 도구(클래스)
        // System.in : 시스템의 입력 장치, 즉 키보드를 가리키는 표준 입력 스트림
        // System.out : 표준 출력 스트림. 콘솔에 출력함
        // 스트림 : 데이터가 흘러가는 통로
        // sc.nextInt() : 정수를 읽는 메서드. 사용자가 숫자를 입력하고 엔터를 누를 때까지 프로그램이 멈춰 기다림
        // sc.close() : 사용이 끝난 Scanner를 닫는 메서드

        // Scanner 객체 생성 ------
        // new Scanner(System.in)은 표준 입력 스트림에 연결한 Scanner 객체를 만듦
        // 객체는 HEAP 영역에 생성되고, 그 객체의 위치값(메모리 주소)은 main 메서드의 스택 영역에 있는 참조변수 sc에 저장됨
        Scanner sc = new Scanner(System.in);

        // 정수 입력 ------
        // 값은 엔터(\n) 또는 스페이스바로 구분됨. 안내 문구(printf) 없이 스페이스바로만 구분해 한 줄에 입력해도 됨
        System.out.printf("num1 입력: ");
        int num1 = sc.nextInt();

        System.out.printf("num2 입력: ");
        int num2 = sc.nextInt();

        System.out.printf("num3 입력: ");
        int num3 = sc.nextInt();

        System.out.printf("%d %d %d\n", num1, num2, num3);
        sc.close();
    }
}
