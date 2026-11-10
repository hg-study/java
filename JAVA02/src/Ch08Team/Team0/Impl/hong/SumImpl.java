package Ch08Team.Team0.Impl.hong;

import Ch08Team.Common.Information;
import Ch08Team.Team0.Interfaces.SumInterface;

// =======================================
// 합 구현 클래스
// 인터페이스의 오버로딩 메서드 4개를 구현
// =======================================

public class SumImpl implements SumInterface, Information {

	// 두 수 : 매개변수 2개 형태
	@Override
	public void sum(int a, int b) {
		sum(new int[] {a, b});
	}

	// 세 수 : 매개변수 3개 형태
	@Override
	public void sum(int a, int b, int c) {
		sum(new int[] {a, b, c});
	}

	// 가변 인자 : 첫 값을 기준으로 나머지 값을 차례로 계산함. 다른 형태는 이 메서드를 호출해 중복을 줄임
	@Override
	public void sum(int... arg) {
		int result = arg[0];
		for (int i = 1; i < arg.length; i++) {
			int v = arg[i];
			result += v;
		}
		System.out.println("합 결과: " + result);
	}

	// 문자열 가변 인자 : 숫자 문자열을 정수로 바꿔 가변 인자 메서드를 호출함
	@Override
	public void sum(String... arg) {
		int[] nums = new int[arg.length];
		for (int i = 0; i < arg.length; i++) {
			nums[i] = Integer.parseInt(arg[i]);
		}
		sum(nums);
	}

	@Override
	public String getTeamName() {
		return "Team0";
	}

	@Override
	public String getUsername() {
		return "hong";
	}

}
