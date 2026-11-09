
// =======================================
// 1장 정리 문제
// 자료형 크기와 대입 가능 여부 확인 문제
// =======================================

/* 확인 문제 1 : 자료형의 크기
	정수 타입
	1byte : byte
	2byte : char, short
	4byte : int (정수 리터럴의 기본 자료형)
	8byte : long

	실수 타입
	4byte : float
	8byte : double (실수 리터럴의 기본 자료형)

	논리 타입
	1byte : boolean


   확인 문제 2 : 맞는 코드(O)와 틀린 코드(X) 구분
	byte var = 200;								( X )	// byte 범위(-128 ~ 127)를 넘음
	char var = 'AB';							( X )	// char는 문자 한 개만 저장함
	char var = 65;								( O )	// 정수는 유니코드 값으로 저장됨
	long var = 500_0000_0000;					( X )	// 정수 리터럴은 기본 int(약 -21억 ~ 21억)라 범위를 넘음. 끝에 L을 붙여야 long 리터럴이 됨
	float var = 3.14;							( X )	// 실수 리터럴은 기본 double이라 float에 바로 넣을 수 없음. 3.14f로 써야 함
	double var = 100.0;							( O )
	String var = "나의직업은 "개발자" 입니다.";	  ( X )	  // 문자열 안의 큰따옴표는 \" 로 써야 함
	boolean var = 0;							( X )	// boolean은 true, false만 저장함
	int v2 = 1e2;								( X )	// 1e2는 실수(double) 리터럴(1.0 x 10^2)이라 int에 넣을 수 없음
	float var = 1e2f;							( O )	// 접미사 f로 float 리터럴이 됨
*/
