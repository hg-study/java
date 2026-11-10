package Ch20StarCraft.building;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ch20StarCraft.unit.Marine;
import Ch20StarCraft.unit.Medic;
import Ch20StarCraft.unit.Unit;

// =======================================
// 병영
// 해병과 의무병을 생성하는 건물
// =======================================

// Building 을 상속하고 ICanFly 를 구현한 병영. 유닛 이름(key)과 생성기를 Map 으로 보관함
public class Barrack extends Building implements ICanFly{
	
	//String : 생성할 유닛클래스명 , UnitGenerator - 생성Interface
	public Map<String, UnitGenerator> generator;
	
	public Barrack(){
		generator = new HashMap();
		generator.put("marine", new MarineGenerator());
		generator.put("medic", new MedicGenerator());
	}
	
	public UnitGenerator getGenerator(String key) {
		return generator.get(key);
	}
	// 해병, 의무병 한 명을 만드는 메서드. Map 에서 생성기를 꺼내 Gen() 을 호출함
	public Marine genMarine() {
		return (Marine)((MarineGenerator)generator.get("marine")).Gen();
	}
	public Medic genMedic() {
		return (Medic)((MedicGenerator)generator.get("medic")).Gen();
	}
	
	// 클래스 정보와 개수를 받아 리플렉션으로 기본 생성자를 호출해 유닛을 여러 개 만드는 메서드
	public <T extends Unit> List<Unit> genUnit(Class<?> clazz,int n){
		
		List<Unit> list = new ArrayList<>();
		
		try {
			Constructor con = clazz.getConstructor(null);
			for(int i=0;i<n;i++) {
				Object obj = con.newInstance(null);
				list.add((Unit)obj);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	
	@Override
	public void BuildStructure() {
		System.out.println("Barrack 건물 짓습니다.");
	}

	@Override
	public void UnderAttack(int damage) {
		System.out.println("Barrack 건물이 공격 당하고 있습니다.");

	}

	@Override
	public void Move() {
		
	}

	@Override
	public void Land() {
		
	}

	@Override
	public void Fly() {
		
	}

}
