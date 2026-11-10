package Ch20StarCraft.unit;

import Ch20StarCraft.weapon.Gun;

// =======================================
// 해병
// 총을 쥐거나 기본 공격으로 싸우는 유닛
// =======================================

// Unit 을 상속한 해병. Gun 을 필드로 가지고(has-a) 공격 방식에 따라 총 또는 기본 공격을 선택함
public class Marine extends Unit {

	int base_damage;
	Gun myGun;
	
	int attackMethod;
	
	public final static int GUN_ATTACK=1;
	public final static int BASIC_ATTACK=2;
	
	public void attackMethod(int method) {
		this.attackMethod = method;
	}
	public Marine() {
		this.hp = 100;
		this.amor = 100;
		this.type = "해병";
		
		this.base_damage = 10;
		
	}
	
	public int getBase_damage() {
		return base_damage;
	}

	public void setBase_damage(int base_damage) {
		this.base_damage = base_damage;
	}

	public Gun getMyGun() {
		return myGun;
	}

	public void setMyGun(Gun myGun) {
		this.myGun = myGun;
	}

	
	// attack : 대상이 살아 있을 때만 공격. 총 사용이면 총의 fire, 아니면 기본 공격력으로 대상의 underAttack 을 호출함
	public void attack(Unit unit) {
		if(!unit.isDead) {
			
			if(this.attackMethod==this.GUN_ATTACK)
				myGun.fire(unit);
			else 
				unit.underAttack(this.base_damage);
			
		}
	}
	
	
	@Override
	public void move() {
		System.out.println(this.type + " 이 이동합니다");		
	}

	@Override
	// 피격 처리 : 방어력(amor)이 먼저 깎이고, 방어력이 모자라면 체력(hp)이 깎이며, 체력이 0 이 되면 사망 처리함
	public void underAttack(int damage) {
		//amor -> hp -> dead
		if(amor - damage > 0)
			amor -= damage;
		else if(hp - (amor - damage)>0) {
			hp = hp - (damage - amor);
			amor=0;
		}
		else {
			hp=0;amor=0;
			isDead = true;
			System.out.println("[경고] "+ this.type +"전사했습니다");
		}
		
	}

}
