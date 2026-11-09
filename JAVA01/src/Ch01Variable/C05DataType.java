package Ch01Variable;

import java.nio.charset.StandardCharsets;

// =======================================
// 자료형별 저장 범위
// 정수, 실수, 문자, 논리, 문자열 자료형과 범위를 넘는 값의 처리
// =======================================

public class C05DataType {

	public static void main(String[] args) {
		// --------------------------------------
		// 정수 int : 4byte, 부호 있는 정수. 정수 리터럴의 기본 자료형
		// --------------------------------------
		
		int n1 = 0b10101101;   // 2진수 리터럴. 0b는 2진수를 의미하는 접두사
		int n2 = 173;   // 10진수 리터럴
		int n3 = 0255;   // 8진수 리터럴. 0은 8진수를 의미하는 접두사
		int n4 = 0xad;   // 16진수 리터럴. 0x는 16진수를 의미하는 접두사
		System.out.printf("%d %d %d %d\n",n1,n2,n3,n4);

		System.out.println("----------------------------");
		// --------------------------------------
		// 정수 byte : 1byte, 부호 있는 정수
		// --------------------------------------
		// 저장 범위는 -128 ~ 127
		// 범위를 넘는 값을 강제 형변환하면 넘치는 비트를 버려 데이터가 손실됨

		byte n5 = (byte)-129;		
		byte n6 = -30;
		byte n7 = 30;
		byte n8 = 127;
		byte n9 = (byte)129;		

		System.out.println("n5: " + n5);
		System.out.println(Integer.toBinaryString((-30)));   // -30의 2진수 비트열(2의 보수) 출력
		System.out.println("----------------------------");

		// --------------------------------------
		// 정수 short : 2byte, 부호 있는 정수 / char : 2byte, 부호 없는 정수(양수만)
		// --------------------------------------
		
		// 자동 형변환 방향 : byte(1) → short(2) → int(4) → long(8) → float(4) → double(8)
		// 자동 형변환 : 크기가 더 크거나 표현할 수 있는 값의 범위가 더 넓은 자료형으로 옮길 때 컴파일러가 자동으로 변환함
		// 데이터 손실 가능성이 있으면 자동으로 변환하지 않음


		char n10 = 65535;   // char의 범위 0 ~ 65535 (2^16 - 1)
		short n11 = 32767;   // short의 범위 -32768 ~ 32767 (-2^15 ~ 2^15 - 1)

		
		char n12 = 60000;
		short n13 = (short)n12;   // char 60000을 short로 강제 형변환. short가 담을 수 있는 범위를 넘어 -5536이 됨
		// 발생 원인 : 두 자료형이 다르고 short가 담을 수 없는 큰 값이라 데이터가 손실되는 것
		// short는 양수를 32767까지만 저장함

		byte n14 = 100;
		short n15 = n14;   // byte -> short 자동 형변환. 작은 자료형에서 큰 자료형으로 옮겨 손실이 없음

		System.out.printf("%d\n",n13);
		System.out.printf("%d\n",n15);
		System.out.println("----------------------------");

		// --------------------------------------
		// 정수 long : 8byte, 부호 있는 정수
		// --------------------------------------

		// 자바는 정수 리터럴을 무조건 int(4byte)로 간주함
		// int 범위 : 약 -21억 ~ +21억
		// l, L : long형 리터럴 접미사


		long n16 = 2150000000L;   // 21.5억은 int 범위를 넘어 L 접미사를 붙여 long 값으로 저장함
		long n17 = 20;   // int 20이 long으로 자동 형변환되어 대입됨
		
		long n18 = 10000000000L;   // int 범위를 넘으므로 L 접미사 필수
		long n19 = 1000000000;   // int 범위 안이라 접미사 없이도 long에 대입됨



		// --------------------------------------
		// 실수 float, double
		// --------------------------------------		

		// 실수 : 유리수와 무리수를 통칭하는, 소수점 이하 값을 가지는 수(123.456)
		// float : 4byte 실수 (정밀도 6~9자리)
		// double : 8byte 실수 (정밀도 15~18자리). 실수 리터럴의 기본 자료형

		// 정밀도 확인 : 같은 값을 float와 double에 넣어 저장되는 자릿수를 비교함
		float n20 = 0.123456789123456789F;   // f, F 접미사로 float 리터럴을 만듦
		double n21 = 0.123456789123456789;   // 접미사가 없으면 double 리터럴

		System.out.println(n20);
		System.out.println(n21);

/* 오차 확인 : 0.1F를 10만 번 더해 float의 누적 오차를 확인하는 코드(주석 처리)
		// 1E5 : 1 x 10^5 (100000)
		float num = 0.1F;
		for(int i=0; i<=1E5; i++){
			num = num + 0.1F;
			System.out.println(i);
		}
		System.out.println("num: " + num); */

		System.out.println("----------------------------");

		// 고정 소수점 : 저장이 빠르지만 메모리 공간을 낭비함
		// 부동 소수점(기본 방식) : 비교적 느리지만 메모리 공간을 효율적으로 씀


		// --------------------------------------
		// 단일 문자 char : 2byte. 문자를 유니코드 정수로 저장함
		// --------------------------------------	

		char ch1 = 'a';   // 문자 a를 저장. 실제로는 유니코드 값이 들어감
		System.out.println(ch1);
		System.out.println((int)ch1);   // 유니코드 값 97 출력
		System.out.println(Integer.toBinaryString(ch1));   // 유니코드 값의 2진수 출력

		System.out.println("----------------------------");

		char ch2 = 98;   // 정수 98이 유니코드 문자 b로 해석됨
		System.out.println(ch2);
		System.out.println((int)ch2);
		System.out.println(Integer.toBinaryString(ch2));

		System.out.println("----------------------------");

		char ch3 = 'b'+1;   // 리터럴끼리의 연산 결과가 char 범위 안이라 char에 바로 대입 가능. 문자 c
		System.out.println(ch3);
		System.out.println((int)ch3);
		System.out.println(Integer.toBinaryString(ch3));

		System.out.println("----------------------------");

		System.out.println((char)0b101011_00000_00000);   // 2진수 값을 char로 강제 형변환해 해당 유니코드 문자를 출력

		char ch4 = 0xac02;   // 16진수 0xac02에 해당하는 한글 문자
		System.out.println(ch4);
		System.out.println((int)ch4);
		System.out.println(Integer.toBinaryString(ch4));

		System.out.println("----------------------------");

		// \\u : 유니코드 이스케이프 문자. \\u 뒤의 16진수 4자리로 문자를 표현함
		System.out.printf("%c\n", 0xac03);   // 정수 0xac03에 해당하는 문자를 %c로 출력
		System.out.printf("%c\n", '\uac03');   // 유니코드 이스케이프로 같은 문자를 출력

		System.out.println("----------------------------");


		// --------------------------------------
		// boolean : 논리형. true 또는 false 저장
		// --------------------------------------	

		boolean flag = (10>11);   // 10 > 11은 거짓이라 false가 저장됨

		if(flag){   // flag가 true면 if 블록, false면 else 블록 실행
			System.out.println("참인 경우 실행");
		}else{
			System.out.println("거짓인 경우 실행");
		}

		// --------------------------------------
		// 문자열 String : 클래스 자료형
		// --------------------------------------

		// 기본 자료형(원시 타입) : 값 자체를 변수 공간에 저장함
		// byte n1;
		// short n2;
		// double n3;
		// long n4;

		// 클래스 자료형 : 객체를 다루는 자료형. 이 자료형으로 만든 변수를 참조변수라 함
		// 참조변수 : 데이터가 저장된 위치 정보(메모리 주소 값)를 저장하는 변수

		int a1 = 10;   // 기본 자료형 변수. 값 자체가 저장됨
		byte a2 = 20;   // byte 변수
		char a3 = 40;   // char 변수. 정수 40은 유니코드 문자 (로 해석됨

		// UTF-8에서 한글 한 글자는 3byte를 사용함
		String name = "홍길동";
		String job = "프로그래머";

		System.out.println("UTF-8기준 지정 크기: " + name.getBytes(StandardCharsets.UTF_8).length);   // 홍길동 3글자 x 3byte = 9byte
		System.out.println("UTF-8기준 지정 크기: " + job.getBytes(StandardCharsets.UTF_8).length);   // 프로그래머 5글자 x 3byte = 15byte

		// 크기 확인 : 같은 한글 한 글자를 char와 String에 저장해 사용하는 크기를 비교함
		char ch = '홍';   // char는 16bit(2byte) 사용
		String str= "홍";   // String은 UTF-8 기준 24bit(3byte) 사용

		// char는 숫자(유니코드)로 저장하는 단일 문자라 2byte
		// String은 객체라 UTF-8 기준 글자당 3byte
		
		System.out.println("ch 실제 크기(bit): " + Integer.toBinaryString(ch).length());   // char의 2진수 길이(bit) 출력
		System.out.println("str 실제 크기(byte): " + str.getBytes(StandardCharsets.UTF_8).length);   // String의 UTF-8 바이트 수 출력
		

		
	}

}
