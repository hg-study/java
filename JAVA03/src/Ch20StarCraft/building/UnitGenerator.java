package Ch20StarCraft.building;

import Ch20StarCraft.unit.Unit;

// =======================================
// 유닛 생성 인터페이스
// 유닛을 만드는 규약
// =======================================

// 팩토리 패턴 : 유닛을 만드는 일을 별도 객체에 맡기는 인터페이스. 유닛 종류마다 생성기를 구현함
public interface UnitGenerator {

	public Unit Gen();
}
