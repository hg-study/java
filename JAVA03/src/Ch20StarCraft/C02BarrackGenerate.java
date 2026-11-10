package Ch20StarCraft;

import java.util.List;

import Ch20StarCraft.building.Barrack;
import Ch20StarCraft.unit.Marine;
import Ch20StarCraft.unit.Medic;
import Ch20StarCraft.unit.Unit;

// =======================================
// 병영에서 유닛 생성
// 생성 전용 객체(UnitGenerator)와 리플렉션으로 유닛 만들기
// =======================================

public class C02BarrackGenerate {

	public static void main(String[] args) throws ClassNotFoundException {
		// Barrack 이 해병과 의무병을 만드는 생성기(UnitGenerator)를 가지고 있어 genMarine, genMedic 으로 유닛을 얻음
		Barrack barrack = new Barrack();
		Marine m1 = barrack.genMarine();
		Medic m2 = barrack.genMedic();
		
		System.out.println(m1);
		System.out.println(m2);
		
		System.out.println("----------------");
		// genUnit(클래스, 개수) : 리플렉션으로 클래스 이름만 받아 원하는 개수의 유닛을 만들어 List 로 돌려줌
		List<Unit> li1 = barrack.genUnit(Class.forName("Ch20StarCraft.unit.Marine"), 5);
		li1.forEach((el)->{System.out.println((Marine)el);});

		
	}

}
