package Ch08Team.Team0.Interfaces;

// =======================================
// 합 인터페이스
// sum 메서드를 매개변수 형태별로 오버로딩한 규약
// =======================================

public interface SumInterface {
	void sum(int a, int b);
	void sum(int a, int b, int c);
	void sum(int ...arg);
	void sum(String ...arg);
}
