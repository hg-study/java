package Ch20StarCraft.weapon;

import Ch20StarCraft.unit.Unit;

// =======================================
// 소총
// 공격력 50, 최대 100발
// =======================================

public class Rifle extends Gun{

	public Rifle() {
		this.power = 50;
		this.curBuillitCnt=0;
		this.maxBuillitCnt=100;
	}
	@Override
	// 발사 : 총알이 없으면 경고하고, 있으면 대상에게 공격력만큼 피해를 주고 총알을 하나 줄임
	public void fire(Unit unit) {
		
		if(curBuillitCnt==0) {
			System.out.println("[경고] 재장전이 필요합니다");
			return ;
		}
		unit.underAttack(this.power);
		curBuillitCnt--;
		System.out.println("[정보] "+ unit.getType() + " 에게 "+this.power+" 만큼 피해를 입혔습니다. 현재HP :"+ unit.getHp() + "현재AMOR : " + unit.getAmor());
	}

	@Override
	public void reload(int bullit) {
		
		if(this.maxBuillitCnt>(bullit+this.curBuillitCnt))
			this.curBuillitCnt=maxBuillitCnt;
		else
			this.curBuillitCnt+=bullit;
		
		System.out.println("[정보] 재장전 완료");
	}

}
