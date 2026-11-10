package Ch08Team.Team0.Interfaces;

// =======================================
// 차 인터페이스
// sub 메서드를 매개변수 형태별로 오버로딩한 규약
// =======================================

public interface SubInterface {
	void sub(int a, int b);
	void sub(int a, int b, int c);
	void sub(int ...arg);
	void sub(String ...arg);
}
