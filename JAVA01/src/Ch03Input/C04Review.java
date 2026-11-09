package Ch03Input;

import java.util.Scanner;

// =======================================
// 3장 정리 문제
// Scanner 입력 문제와 풀이
// =======================================

public class C04Review {
    public static void main(String[] args) {

        // 정리 ------
        // System.out.print : 기본 출력 메서드
        // System.out.printf : 서식문자를 사용할 수 있는 출력 메서드
        // System.out.println : 줄바꿈을 포함한 출력 메서드
        // Scanner : 키보드로부터 입력받는 장치를 만들 때 쓰는 클래스 자료형

        // 문제 1 ------
        // Scanner로 키보드에서 입력한 두 수를 더해 결과를 출력하는 문제
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자1: ");
        int num1 = sc.nextInt();
        System.out.print("숫자2: ");
        int num2 = sc.nextInt();

        System.out.println(num1+num2);

        // 문제 2 ------
        // Scanner로 이름, 주민번호 앞 6자리, 전화번호를 키보드에서 입력받고 출력하는 문제
        // [예시]
        // ----------------------------
        // [필수 정보 입력]
        // 1. 이름 : ______________ENTER
        // 2. 주민번호 6자리 : ______________ENTER
        // 3. 전화번호 : ____________ENTER
        // [입력한 내용]
        // 이름 : 홍길동
        // 주민번호 : 123456
        // PH : 010-222-3333
        // ----------------------------
        System.out.println("----------------------------");
        System.out.println("[필수 정보 입력]");

        System.out.print("1. 이름 : ");
        String name = sc.next();

        System.out.print("2. 주민번호 6자리 : ");
        String rrn = sc.next();

        System.out.print("3. 전화번호 : ");
        String num = sc.next();

        System.out.printf("[입력한 내용]%n이름: %s %n주민번호: %s %nPH: %s", name, rrn, num);


        sc.close();

        // [답]
        // 1.
        //  Scanner scanner = new Scanner(System.in);
        //  System.out.print("첫번째 수:");
        //  String strNum1 = scanner.nextLine();
        //  System.out.print("두번째 수:");
        //  String strNum2 = scanner.nextLine();
        //  int num1 = Integer.parseInt(strNum1);
        //  int num2 = Integer.parseInt(strNum2);
        //  int result = num1 + num2;
        //  System.out.println("덧셈 결과:" + result);
        // 2.
        //  Scanner scanner = new Scanner(System.in);
        //  System.out.println("[필수 정보 입력]");
        //  System.out.print("1. 이름: ");
        //  String name = scanner.nextLine();
        //  System.out.print("2. 주민번호 앞 6자리: ");
        //  String ssn = scanner.nextLine();
        //  System.out.print("3. 전화번호: ");
        //  String tel = scanner.nextLine();
        //  System.out.println();
        //  System.out.println("[입력된 내용]");
        //  System.out.println("1. 이름: " + name);
        //  System.out.println("2. 주민번호 앞 6자리: " + ssn);
        //  System.out.println("3. 전화번호: " + tel);
    }
}
