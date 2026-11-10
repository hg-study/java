package Ch20StarCraft.weapon;

import Ch20StarCraft.unit.Unit;

// =======================================
// 총 (추상 클래스)
// 모든 총의 공통 속성과 동작
// =======================================

// 총알 수와 공격력을 가지고 발사(fire)와 재장전(reload)은 총마다 다르므로 추상 메서드로 둠
public abstract class Gun {
	
	int maxBuillitCnt;
	int curBuillitCnt;
	int power;
	
	abstract public void fire(Unit unit);
	abstract public void reload(int bullit);

}
