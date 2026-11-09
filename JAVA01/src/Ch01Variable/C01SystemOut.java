package Ch01Variable;

// =======================================
// System.out 표준 출력 클래스 및 서식문자 활용
// 다양한 메서드와 제어 문자 학습
// =======================================

// 표준 출력 스트림(Standard Output Stream)
// System.out은 자바에서 기본적으로 제공하는 표준 출력 객체로 콘솔 창에 데이터를 표시할 때 사용된다.

// 이스케이프 문자(Escape Sequence)
// 역슬래시(\)와 특정 문자가 결합하여 특별한 기능을 수행하는 문자다. 
// 출력물 내에서 줄 바꿈, 탭 이동 등의 제어를 담당한다.

// 서식문자(Format Specifier)
// printf 메서드에서 사용되며, 데이터가 들어갈 자리를 만들고 데이터의 타입을 지정한다.

public class C01SystemOut {  	

	public static void main(String[] args) {

		// =================================
        // 기본 출력 메서드: print(), println()
        // =================================

		// --- 출력 및 제어 문자 활용 ---
		// \n: New Line. 개행, 줄바꿈
        // \b: Backspace. 한 칸 뒤로 이동
        // \t: Tab. 탭 길이(기본 8칸)만큼 커서 이동, 데이터 정렬 시 유용

		System.out.print("HelloWorld");     // print: 줄 바꿈 없이 인자값만 출력
        System.out.println("HelloWorld");   // println: 인자값 출력 후 마지막에 자동 줄 바꿈
        System.out.print("HelloWorld\n");   // \n을 수동으로 입력하여 println과 동일한 줄바꿈 효과

		
		// =================================
        // 형식화된 출력: printf()
        // =================================
		
		// printf: Print Formatted의 약자
		// format: 형식, 서식

		// System.out.printf(); : 지시자(예: %d, %s)를 포함한 일정한 형식(Format)을 미리 정해두고, 그 자리에 값을 채워 넣어 출력하는 메서드
		// %d	 : 10진수 정수 서식문자
		// %f	 : 10진수 실수 서식문자(소수점 가진 데이터타입)
		// %c	 : 한문자 서식문자('')
		// %s	 : 문자열 서식문자("")
		System.out.printf("%d %d %d \n", 10, 20, 30);
		System.out.printf("10,20,30,\n");
		System.out.printf("%f %f %f \n", 10.1, 20.1, 30.1);
		System.out.printf("%c %c %c \n", 'A','b','c');
		System.out.printf("%s %s %s \n", "This is ", "String ", "Test");
		System.out.printf("%d.%s : %d\n", 1, "국어", 100);
		
		
	}

}
