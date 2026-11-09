package Ch06Loop;

import java.util.Scanner;

// =======================================
// while 반복문
// 탈출 변수, 조건식, 연산식과 합 구하기, 구구단
// =======================================

public class C01While {
    public static void main(String[] args) {

        // while 문 ------
        // while 문 : 조건식이 true인 동안 중괄호 안의 문장을 반복 실행하는 반복문
        // 반복을 끝내려면 탈출용 변수, 탈출 조건식, 탈출 연산식 세 가지가 필요함

        // while (조건식) {
        // 조건식이 true인 동안 실행되는 종속문장
        // }

        // HELLO WORLD 10회 출력 ------
        // 탈출용 변수: i=0
        // 탈출 조건식: i<10
        // 탈출 연산식: i++

        // int i = 0;
        // while (i<10) {
        //     System.out.println((i+1) +": HELLOWORLD");
        //     i++;
        // }


        // HELLO WORLD N회 출력 ------
        // 반복 횟수 N을 입력받아 출력하는 문제 (N>0)
        // N이 0보다 작으면 안내 후 System.exit(-1)로 프로그램을 강제 종료함

        // Scanner sc = new Scanner(System.in);

        // System.out.print("반복 횟수:");
        // int n = sc.nextInt();

        // if (n<0) {
        //     System.out.println("N은 0보다 커야합니다.");
        //     System.exit(-1);
        // }

        // int i = 0;
        // while (i<n) {
        //     System.out.println((i+1) +": HELLOWORLD");
        //      i++;
        // }

        // sc.close();

        // 1부터 10까지 합 구하기 ------
        // 합계를 담을 변수 sum 에 i 를 더하고 i 를 1 올리는 과정을 i<=10 동안 반복함
        // sum += i++ : i 를 더한 뒤에 i 를 1 올리는 후위 연산

        // int i = 1;
        // int sum = 0;

        // while (i<=10) {
        //     System.out.println("i: "+i);
        //     sum += i++;
        // }
        // System.out.println("합계: "+sum);


        // 문제 풀기 ------

        Scanner sc = new Scanner(System.in);

        // 1부터 N까지의 합 ------

        // System.out.print("1~N합- N값:");
        // int n = sc.nextInt();
        // int i = 1;

        // int sum = 0;

        // while (i<=n) {
        //     System.out.println("i: "+i);
        //     sum += i++;
        // }
        // System.out.printf("1~%d 합계: %d", n,sum);

        // N부터 M까지의 합 (N<M) ------
        // N 이 M 보다 크면 두 값을 바꿔 항상 작은 수에서 큰 수로 더함

        // System.out.print("N~M합- N값:");
        // int n = sc.nextInt();

        // System.out.print("N~M합- M값:");
        // int m = sc.nextInt();

        // int sum = 0;

        // if (n>m) {
        //     int temp = n;
        //     n = m;
        //     m = temp;
        // }
        // int i = n;

        // while (i<=m) {
        //     System.out.println("n: "+i);

        //     sum += i++;
        // }
        // System.out.printf("%d~%d 합계: %d", n,m,sum);


        // N부터 M까지 짝수의 합과 홀수의 합 (N<M) ------
        // 범위의 수를 하나씩 꺼내 2로 나눈 나머지로 짝수와 홀수를 나누어 각각 더함

        // System.out.print("N~M합- N값:");
        // int n = sc.nextInt();

        // System.out.print("N~M합- M값:");
        // int m = sc.nextInt();

        // int even = 0;
        // int odd = 0;

        // if (n>m) {
        //     int temp = n;
        //     n = m;
        //     m = temp;
        // }
        // int i = n;

        // while (i<=m) {

        //     if (i%2==0){ // 짝수면
        //     System.out.println("짝: "+i);
        //     even += i;
        //     }

        //     if (i%2==1){ // 홀수면
        //     System.out.println("홀: "+i);
        //     odd += i;
        //     }

        //     i++;
        // }
        // System.out.println("짝수 합계: "+even);
        // System.out.println("홀수 합계: "+odd);

        // 구구단 2단 ------
        // 2 x 1 = 2 부터 2 x 9 = 18 까지 출력함. %-2d 는 숫자를 두 칸 너비로 왼쪽 정렬함

        // int n = 2;
        // int i = 1;

        // while (i<=9) {
        //     System.out.printf("%d x %d = %-2d %n", n, i, n*i);
        //     i++;
        // }

        // 구구단 N단 ------
        // 입력받은 단을 출력함

        // System.out.print("구구단 몇단을 출력하시겠습니까? :");
        // int n = sc.nextInt();

        // int i = 1;

        // while (i<=9) {
        //     System.out.printf("%d x %d = %-2d %n", n, i, n*i);
        //     i++;
        // }


        // 구구단 2~9단 전부 출력 (개인학습) ------
        // 바깥 while 은 곱하는 수(i), 안쪽 while 은 단(n)을 올려 한 줄에 2~9단을 나란히 출력함
        // 안쪽 반복이 끝나면 println 으로 줄을 바꾸고, 다음 줄에서 n 을 다시 2로 되돌림

        // int i = 1;
        // int n = 2;

        // while (i<= 9) {
        //     n = 2;
        //     while (n<=9) {
        //         System.out.printf("%d x %d = %-2d \t", n, i, n*i);
        //         n++;
        //     }
        //     System.out.println();
        //     i++;
        // }

        sc.close();

    }
}
