package Ch01Class;

import java.util.Scanner;

// =======================================
// 성적 평균 문제
// private 필드와 생성자, average 메서드
// =======================================

// 문제 ------
// 수학, 과학, 영어 점수 3개를 입력받아 평균을 출력하는 문제
// Grade 클래스에 int 타입 math, science, english 필드를 private 로 선언하고
// 생성자와 세 과목의 평균을 리턴하는 average() 메서드를 작성함
// 실행 예) 수학, 과학, 영어 순으로 3개의 정수 입력 >> 90 88 96
//          평균은 91
class Grade{
    private int math;
    private int science;
    private int english;


    public Grade(int math, int science, int english){
        this.math = math;
        this.science = science;
        this.english = english;

    }

    public double average() {
        return (double)(math+science+english)/3;
    }
}


public class C11Grade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
        int math = sc.nextInt();
        int science = sc.nextInt();
        int english = sc.nextInt();
        Grade me = new Grade(math, science, english);
        System.out.println("평균은 "+me.average()); // average()는 평균을 계산하여 리턴

        sc.close();
    }

}
