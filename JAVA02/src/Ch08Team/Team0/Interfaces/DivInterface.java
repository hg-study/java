package Ch08Team.Team0.Interfaces;

// =======================================
// 나눗셈 인터페이스
// div 메서드를 매개변수 형태별로 오버로딩한 규약
// =======================================

public interface DivInterface {
	void div(int a, int b);
	void div(int a, int b, int c);
	void div(int ...arg);
	void div(String ...arg);
}
