package Ch05Condition;

import java.util.Scanner;

// =======================================
// switch 메뉴 프로그램
// while과 switch를 함께 써서 반복하는 메뉴 선택
// =======================================

public class C03SwitchPractice {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = 0;

		// 메뉴 반복 ------
		// while(true) : 조건이 항상 참이라 끝나지 않는 무한 반복. 4번을 선택해 System.exit()가 실행될 때 멈춤
		while(true) {
			System.out.println("---------- JOIN MENU ----------");
			System.out.println("1 이메일 인증");
			System.out.println("2 개인정보 입력");
			System.out.println("3 회원가입 요청");
			System.out.println("4 종료");
			System.out.println("---------- JOIN MENU ----------");
			System.out.print("번호 입력 : " );
			num = sc.nextInt();

			// 메뉴 분기 ------
			// 입력한 메뉴 번호에 따라 처리할 작업을 switch 로 고름
			switch(num)
			{
				case 1:
					System.out.println("이메일 인증처리 작업 - ");
					break;
				case 2:
					System.out.println("이메일 개인정보 입력 작업 - ");
					break;
				case 3:
					System.out.println("회원가입 처리 작업 - ");
					break;
				case 4:
					System.out.println("JOIN 메뉴 종료 - ");
					System.exit(-1);   // System.exit(상태값) : JVM을 종료하는 메서드. 0은 정상 종료, 그 외 값은 비정상 종료
					break;
				default :
					System.out.println("잘못된 메뉴번호를 입력하셨습니다 - ");
					break;
			}
		}
	}

}
