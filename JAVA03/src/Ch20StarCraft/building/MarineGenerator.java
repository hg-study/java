package Ch20StarCraft.building;

import Ch20StarCraft.unit.Marine;
import Ch20StarCraft.unit.Unit;

// =======================================
// 해병 생성기
// Marine 을 만들어 돌려줌
// =======================================

public class MarineGenerator implements UnitGenerator{

	@Override
	public Unit Gen() {
		return new Marine();
	}

}
