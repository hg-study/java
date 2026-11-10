package Ch20StarCraft.unit;

// =======================================
// 유닛 (추상 클래스)
// 모든 유닛의 공통 속성과 동작
// =======================================

// 공통 속성(체력 hp, 방어력 amor, 종류 type, 사망 여부)을 가지고, 이동과 피격 방식은 유닛마다 다르므로 추상 메서드로 둠
public abstract class Unit {
	int hp;
	int amor;
	String type;
	public boolean isDead;
	
	abstract public void move();
	abstract public void underAttack(int damage);
	
	
	public int getHp() {
		return hp;
	}
	public int getAmor() {
		return amor;
	}
	public String getType() {
		return type;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setAmor(int amor) {
		this.amor = amor;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
