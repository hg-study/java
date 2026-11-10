package Ch20StarCraft.building;

// =======================================
// 건물 (추상 클래스)
// 모든 건물의 공통 속성과 동작
// =======================================

// 건물의 공통 속성(체력, 보호막, 방어력, 파괴 여부)과 건설, 피격 동작(추상 메서드)
public abstract class Building {
	
	public int hp;
	public int sheld;
	public int ammor;
	public boolean isDestoryed;
	
	public Building() {};
	
	public abstract void BuildStructure();
	public abstract void UnderAttack(int damage);
	
	
}
