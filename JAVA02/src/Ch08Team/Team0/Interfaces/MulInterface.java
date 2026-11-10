package Ch08Team.Team0.Interfaces;

// =======================================
// 곱 인터페이스
// mul 메서드를 매개변수 형태별로 오버로딩한 규약
// =======================================

public interface MulInterface {
	void mul(int a, int b);
	void mul(int a, int b, int c);
	void mul(int ...arg);
	void mul(String ...arg);
}
