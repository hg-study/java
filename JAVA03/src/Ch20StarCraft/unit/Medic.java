package Ch20StarCraft.unit;

// =======================================
// 의무병
// 아군의 체력을 회복시키는 유닛
// =======================================

// Unit 을 상속한 의무병. 공격하지 않고 setHealingPoint 로 대상 유닛의 체력을 회복시킴
public class Medic extends Unit{

	private int HealingPoint;
	
	public Medic(){
		this.hp = 100;
		this.amor = 100;
		this.HealingPoint = 20;
		this.type = "의무병";
	}
	
	
	
	public int getHealingPoint() {
		return HealingPoint;
	}

	public void setHealingPoint(Unit unit) {
		unit.hp +=this.HealingPoint;
		System.out.println("대상 " + unit.type + " HP 를 회복시킵니다. 현재 HP : " + unit.hp);
	}

	@Override
	public void move() {
		System.out.println(this.type + " 이 이동합니다");
	}
	
	@Override
	public void underAttack(int damage) {
		//amor -> hp -> dead
		if(amor - damage > 0)
			amor -= damage;
		else if(hp - (amor - damage)>0)
			hp = hp - (amor -damage);
		else {
			hp=0;amor=0;
			isDead = true;
			System.out.println("[경고] "+ this.type +"전사했습니다");
		}
		
	}

}
