package Ch20StarCraft.building;

import Ch20StarCraft.unit.Medic;
import Ch20StarCraft.unit.Unit;

// =======================================
// 의무병 생성기
// Medic 을 만들어 돌려줌
// =======================================

public class MedicGenerator implements UnitGenerator{

	@Override
	public Unit Gen() {
		return new Medic();
	}

}
