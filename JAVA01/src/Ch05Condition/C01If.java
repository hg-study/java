package Ch05Condition;

import java.util.Scanner;

// =======================================
// if 조건문
// 단순 if, if-else, if-else if-else와 문제 풀이
// =======================================

public class C01If {
    public static void main(String[] args) {

        // 단순 if ------
        // if 문 : 조건식이 참(true)일 때만 아래 문장을 실행하는 조건문. 실행할 문장이 하나면 중괄호를 생략할 수 있음
        // 나이가 8 이상이면 학교에 다니고, 8 미만이면 다니지 않는 두 개의 if 문(주석 처리)

        // Scanner sc = new Scanner(System.in);

        // System.out.print("나이: ");
        // int age = sc.nextInt();
        // if (age >= 8)
        //     System.out.println("학교에 다닙니다.");

        // System.out.println("첫번째 IF 코드 블럭 종료...");

        // if(age < 8)
        //     System.out.println("학교에 다니지 않습니다.");

        // System.out.println("두번째 IF 코드 블럭 종료...");

        // System.out.println("프로그램을 종료합니다.");

        // sc.close();

        // if - else ------
        // if - else 문 : 조건식이 참이면 if 쪽, 거짓이면 else 쪽을 실행하는 조건문. 둘 중 하나는 반드시 실행됨

        // Scanner sc = new Scanner(System.in);

        // System.out.print("나이: ");
        // int age = sc.nextInt();
        // if (age >= 8)
        //     System.out.println("학교에 다닙니다.");
        // else
        //     System.out.println("학교에 다니지 않습니다.");

        // System.out.println("프로그램을 종료합니다.");

        // sc.close();

        // 문제 1 ------
        // 정수 한 개를 입력받아 3의 배수면 해당 수를 출력하는 문제
        // 3의 배수이면서 5의 배수면 해당 수를 출력한 뒤 "3의 배수이면서 5의 배수입니다."를 이어서 출력함
        // 순서도는 draw.io로 그림

        // Scanner sc = new Scanner(System.in);


        // System.out.print("정수 입력: ");
        // int num1 = sc.nextInt();

        // 3의 배수일 때만 안쪽에서 5의 배수인지 한 번 더 확인함
        // if (num1%3==0) {

        //     System.out.println(num1);

        //     if (num1%5==0)
        //         System.out.println("3의 배수이면서 5의 배수입니다.");

        // }

        // sc.close();

        // 문제 2 ------
        // 두 개의 정수를 입력받아 큰 수를 출력하는 문제

        // Scanner sc = new Scanner(System.in);

        // System.out.print("정수1: ");
        // int n1 = sc.nextInt();
        // System.out.print("정수2: ");
        // int n2 = sc.nextInt();

        // if (n1>n2) System.out.println(n1);

        // else System.out.println(n2);

        // sc.close();

        // 문제 3 (중요) ------
        // 세 개의 정수를 입력받아 가장 큰 수를 출력하는 문제
        // 첫 번째 수가 나머지 두 수보다 크거나 같은지 먼저 확인하고, 아니면 나머지 두 수만 비교함

        // Scanner sc = new Scanner(System.in);

        // System.out.print("정수1: ");
        // int n1 = sc.nextInt();
        // System.out.print("정수2: ");
        // int n2 = sc.nextInt();
        // System.out.print("정수3: ");
        // int n3 = sc.nextInt();

        // if (n1>=n2 && n1>=n3)
        //     System.out.println(n1);

        // else if (n2>=n3)
        //     System.out.println(n2);

        // else System.out.println(n3);

        // sc.close();

        // 문제 4 ------
        // 세 개의 정수를 입력받아 합과 평균을 출력하는 문제
        // int끼리 나누면 소수점이 버려지므로 합을 double로 바꿔 3으로 나눔

        // Scanner sc = new Scanner(System.in);

        // System.out.print("정수1: ");
        // int n1 = sc.nextInt();
        // System.out.print("정수2: ");
        // int n2 = sc.nextInt();
        // System.out.print("정수3: ");
        // int n3 = sc.nextInt();
        // double nn = (double)(n1+n2+n3)/3;

        // System.out.println("합계: " + (n1+n2+n3));

        // System.out.println("평균: " + nn);
        // sc.close();

        // 문제 5 ------
        // 입력한 수가 짝수이면서 3의 배수면 출력 (n%2==0 && n%3==0)
        // 입력한 수가 홀수이면서 5의 배수면 출력 (n%2==1 && n%5==0)

        // Scanner sc = new Scanner(System.in);

        // System.out.print("수 입력: ");
        // int n = sc.nextInt();

        // if (n%2==0 && n%3==0)
        //     System.out.println("짝수, 3의 배수 "+ n);

        // else if (n%2==1 && n%5==0)
        //     System.out.println("홀수, 5의 배수 "+ n);

        // sc.close();

        // if - else if - else ------
        // if - else if - else 문 : 위에서부터 조건을 차례로 확인해 처음 참인 한 곳만 실행하고, 모두 거짓이면 else를 실행하는 조건문

        // 합격 판정 문제 ------
        // 과목 1, 2, 3, 4 중 하나라도 40점 미만이면 불합격
        // 과목 평균이 100점 만점 기준으로 60점 미만이면 불합격
        // 그 외에는 합격

        // Scanner sc = new Scanner(System.in);

        // System.out.print("과목1: ");
        // int n1 = sc.nextInt();
        // System.out.print("과목2: ");
        // int n2 = sc.nextInt();
        // System.out.print("과목3: ");
        // int n3 = sc.nextInt();
        // System.out.print("과목4: ");
        // int n4 = sc.nextInt();
        // double avg = (double)(n1+n2+n3+n4)/4 ;

        // 첫 번째 풀이 : 불합격 조건을 ||로 묶어 한 번에 확인함
        // if (n1<40||n2<40||n3<40||n4<40||avg<60){
        //     System.out.println("불합격");
        // }
        // else{
        //     System.out.println("합격");
        // }

        // 두 번째 풀이 : 불합격 조건을 if - else if로 하나씩 나누어 확인함
        // if(n1<40)
        //     System.out.println("불합격");
        // else if(n2<40)
        //     System.out.println("불합격");
        // else if(n3<40)
        //     System.out.println("불합격");
        // else if(n4<40)
        //     System.out.println("불합격");
        // else if(avg<60)
        //     System.out.println("불합격");
        // else
        //     System.out.println("합격");

        // sc.close();

        // 점수 등급 문제 ------
        // 시험 점수를 입력받아 아래 기준으로 등급을 출력하는 문제
        // 90 ~ 100점은 A,      ->  점수 >= 90
        // 80 ~ 89점은  B,      ->  점수 < 90 && 점수 >= 80
        // 70 ~ 79점은  C,      ->  점수 < 80 && 점수 >= 70
        // 60 ~ 69점은  D,      ->  점수 < 70 && 점수 >= 60
        // 나머지 점수는 F      ->  점수 < 60
        // 위에서부터 차례로 확인하므로 아래 조건에서는 위 조건의 범위(< 90 등)를 다시 쓰지 않아도 됨
        Scanner sc = new Scanner(System.in);

        System.out.print("시험 점수 입력: ");
        int n = sc.nextInt();

        if (n >= 90){
            System.out.println("A");
        }
        else if (n >= 80){
            System.out.println("B");
        }
        else if (n >= 70){
            System.out.println("C");
        }
        else if (n >= 60){
            System.out.println("D");
        }
        else{
            System.out.println("F");
        }

        sc.close();

    }
}
