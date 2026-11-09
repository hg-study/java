package Ch01Variable;

// =======================================
// 변수와 대입
// 변수 선언, 초기화, 대입 연산자의 처리 순서
// =======================================

public class C04Variable {

	public static void main(String[] args) {

		// 변수와 자료형 ------
		/*
			Data(수, 자료)는 먼저 저장하고 나중에 처리한다.
			변수      : 값을 저장하는 메모리 공간. 바뀔 수 있는 수를 이름 붙여 두면 유지보수에 유리하다
			변수명    : 저장된 변수 공간에 접근하기 위한 문자 형태의 주소
			자료형    : 저장할 공간의 크기를 정하고 저장할 값의 형태를 제한하는 예약어
			연산자 =  : lv(공간) = rv(값). rv를 먼저 처리(저장 또는 연산)한 다음 lv에 대입한다

			byte (1byte, signed)
			char (2byte, unsigned) 음수 저장 불가
			short (2byte, signed)
			int (4byte, signed) 정수 리터럴의 기본 자료형
			float (4byte)
			double (8byte) 실수 리터럴의 기본 자료형
		*/

		// 변수 선언과 대입 ------
		// 변수를 만들고 값을 넣어 두 수를 더한 결과를 출력하는 흐름
		int num1;						// num1을 int(정수)형 변수로 선언
		num1 = 10;						// 변수 num1에 10을 대입
		int num2 = 4;					// int형 변수 num2를 선언하고 4로 초기화
		int num3 = num1 + num2;			// num1 + num2, 즉 10 + 4 = 14를 num3에 저장
		System.out.println(num3);		// 14 출력

		// 각 줄이 메모리에서 하는 일 ------
		/*
		int num1;
		// int 크기(4byte)의 공간을 만들고 num1이라는 이름을 붙임(변수 선언)
		num1 = 10;
		// 10이라는 값(리터럴 상수)을 상수 pool에 저장하고 num1 공간에 복사(대입)
		int num2 = 4;
		// 4라는 값(리터럴 상수)을 상수 pool에 저장하고 4byte 정수 공간 num2를 초기화
		int num3 = num1 + num2;
		// num1과 num2 안의 값을 더한 결과(CPU 가산 처리)를 4byte 정수 공간 num3에 초기화
		System.out.println(num3);
		// num3 안의 값을 println 메서드로 넘겨 내부적으로 표준 출력 처리
		*/

	}

}
