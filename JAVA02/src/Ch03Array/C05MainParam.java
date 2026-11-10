package Ch03Array;

// =======================================
// main 의 매개변수
// 실행할 때 값 전달하기
// =======================================

public class C05MainParam {

	// args ------
	// args : 프로그램을 실행할 때 전달한 값(Program arguments)을 문자열 배열로 받는 main 의 매개변수
	// 전달 방법 : 파일 오른쪽 마우스 - Run As - Run Configurations... - Arguments 탭의 Program arguments 에 a b c d e 를 쓰고 Run
	public static void main(String[] args) {
		System.out.println("length: " + args.length);
		for(String param: args) {
			System.out.println(param);
		}

	}

}
