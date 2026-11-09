package Ch05Condition;

import java.util.Scanner;

// =======================================
// switch 조건문
// case, break, default로 값에 따라 분기
// =======================================

public class C02Switch {
    public static void main(String[] args) {

        // switch 문 ------
        // switch(변수) : 여러 가지 선택지 중 하나를 고를 때 사용하는 조건문. 변수 값과 일치하는 case가 실행됨
        // case 값 : 비교할 값. 조건식은 쓸 수 없고 정해진 값만 쓸 수 있음
        // break : switch 문을 빠져나가는 키워드. 없으면 다음 break가 나올 때까지 아래 case를 모두 실행함
        // default : 어떤 case와도 맞지 않을 때 실행되는 구간. if 문의 else와 같음
        /*
            switch(값) {
            case 값1:
                구현부;
                break;
            case 값2:
                구현부;
                break;
            default:
                구현부;
                break;
            }
        */

        // 메달 색상 문제 ------
        // 등수를 입력받아 1등은 G, 2등은 S, 3등은 B, 그 외는 C를 출력하는 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("등수: ");
        int ranking = sc.nextInt();

        char medalColor;   // 등수에 따라 G, S, B, C 중 하나가 저장됨
        switch (ranking) {
            case 1:
                medalColor = 'G';
                System.out.println("메달 색상: G");
                break;
            case 2:
                medalColor = 'S';
                System.out.println("메달 색상: S");
                break;
            case 3:
                medalColor = 'B';
                System.out.println("메달 색상: B");
                break;
            default:
                medalColor = 'C';
                System.out.println("메달 색상: C");
                break;
        }
        System.out.println(ranking + "등 메달의 색은 " + medalColor + "입니다.");

        sc.close();


    }
}
