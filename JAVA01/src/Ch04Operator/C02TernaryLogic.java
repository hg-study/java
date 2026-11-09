package Ch04Operator;

import java.util.Scanner;

// =======================================
// 삼항 연산자와 논리 연산자 문제
// 점수 합격 판정과 두 수의 합이 짝수인지 판정
// =======================================

public class C02TernaryLogic {
    public static void main(String[] args) {

        // 문제 1 : 삼항 연산자와 논리 연산자 ------
        // 키보드로 국어, 영어, 수학 점수를 입력받아
        // 각 과목이 40점 이상이고 평균이 70점 이상이면 '합격', 아니면 '불합격'을 출력하는 문제

        Scanner sc = new Scanner(System.in);

        System.out.print("국어 점수 입력: ");
        int n1 = sc.nextInt();

        System.out.print("영어 점수 입력: ");
        int n2 = sc.nextInt();

        System.out.print("수학 점수 입력: ");
        int n3 = sc.nextInt();

        // 과목별 점수와 평균을 중첩 삼항 연산자로 판정함
        // 먼저 &&로 세 과목이 모두 40점 이상인지 확인하고, 통과하면 평균 70점 이상인지 다시 확인함
        String pri =
            ( n1>=40 && n2>=40 && n3>=40 ) ?
            ( (n1+n2+n3)/3 >=70 ) ? "합격"
            : "평균 70점 이하, 불합격"
            :  "과락, 불합격"  ;

        System.out.println(pri);

        // 같은 판정을 if 문으로 쓴 코드(주석 처리)

        // if (n1>=40 && n2>=40 && n3>=40) {

        //     if ( (n1+n2+n3)/3 >=70 ){
        //         System.out.println("합격");
        //     }else{
        //         System.out.println("평균 70점 이하, 불합격");
        //     }

        // }else{
        //     System.out.println("과락, 불합격");
        // }


        // 다른 풀이 ------
        // 조건을 나누지 않고 &&로 과목별 40점 이상과 평균 70점 이상을 한 번에 확인함
        // (double)(...) / 3 : 합계를 double로 바꿔 평균의 소수점까지 계산함
        int kor = sc.nextInt();
        int eng = sc.nextInt();
        int math = sc.nextInt();
        double avg = (double)(kor+eng+math) / 3;

        String result =
            ( kor>=40 && eng>=40 && math>=40  &&  avg >=70  )
            ? "합격"
            : "불합격";

        System.out.println("시험결과: "+result);

        // 문제 2 : 나머지 연산자 ------
        // 키보드로 정수 2개를 입력받아 두 수의 합이 짝수면 "짝수입니다", 홀수면 "홀수입니다"를 출력하는 문제
        // 짝수 판별은 2로 나눈 나머지가 0인지(N % 2 == 0) 확인함

        System.out.print("정수1 :");
        int n4 = sc.nextInt();

        System.out.print("정수2 :");
        int n5 = sc.nextInt();

        String pri2 = ((n4+n5)%2==0) ? "짝수입니다." : "홀수입니다.";
        System.out.println(pri2);

        // 같은 판정을 if 문으로 쓴 코드(주석 처리)

        // if ( (n4+n5)%2==0 ){
        //     System.out.println("짝수입니다.");
        // } else{
        //     System.out.println("홀수입니다.");
        // }

        sc.close();

    }
}
