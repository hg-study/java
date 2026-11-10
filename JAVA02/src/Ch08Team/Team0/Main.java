package Ch08Team.Team0;

import Ch08Team.Team0.Interfaces.DivInterface;
import Ch08Team.Team0.Interfaces.MulInterface;
import Ch08Team.Team0.Interfaces.SubInterface;
import Ch08Team.Team0.Interfaces.SumInterface;

// =======================================
// 팀 과제 실행 클래스
// 인터페이스 타입으로 팀원이 만든 구현 클래스 연결
// =======================================

public class Main {

	// 구현 클래스를 인터페이스 타입으로 연결 : 팀원이 바뀌어도 이 줄의 클래스만 바꾸면 됨
	static SumInterface sum1 = new Ch08Team.Team0.Impl.hong.SumImpl();
	static SubInterface sub1 = new Ch08Team.Team0.Impl.hong.SubImpl();
	static MulInterface mul1 = new Ch08Team.Team0.Impl.hong.MulImpl();
	static DivInterface div1 = new Ch08Team.Team0.Impl.hong.DivImpl();

	public static void Team0CalTest() {
		sum1.sum(10, 20);
		sum1.sum(10, 20, 30);
		sub1.sub(100, 30, 20);
		mul1.mul(2, 3, 4);
		div1.div(100, 5);
		div1.div("1000", "10", "5");
	}

	public static void main(String[] args) {
		Team0CalTest();
	}
}
