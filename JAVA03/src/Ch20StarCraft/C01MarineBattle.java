package Ch20StarCraft;

import Ch20StarCraft.unit.Marine;
import Ch20StarCraft.unit.Medic;
import Ch20StarCraft.weapon.Pistol;
import Ch20StarCraft.weapon.Rifle;

// =======================================
// 해병 전투 시뮬레이션
// 해병 2명과 의무병이 스레드로 동시에 공격하고 치료
// =======================================

public class C01MarineBattle {

	public static void main(String[] args) {
		// Marine 에 총(Gun)을 쥐여 주고 reload 로 장전한 뒤 attackMethod 로 공격 방식(GUN_ATTACK: 총 사용)을 정함
		Marine marine1 = new Marine();
		marine1.setMyGun(new Pistol());
		marine1.getMyGun().reload(100);
		marine1.attackMethod(Marine.GUN_ATTACK);
		
		Medic medic1 = new Medic();
		medic1.setType("medic1");
		marine1.setType("marine1");
		
		Marine marine2 = new Marine();
		marine2.setMyGun(new Rifle());
		marine2.getMyGun().reload(100);
		marine2.setType("marine2");
		marine2.attackMethod(Marine.GUN_ATTACK);
		
		//medic -> m1
		// 스레드 3개를 만들어 의무병이 1.5초마다 해병1을 치료하고, 해병1과 해병2가 1초마다 서로를 공격하게 함 (무한 반복)
		new Thread() {
			@Override
			public void run() {
				while(true) {
					medic1.setHealingPoint(marine1);
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		//m1 -> m2
		new Thread() {
			@Override
			public void run() {
				
				while(true) {
					marine1.attack(marine2);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}		
		}.start();
		//m2 -> m1
		new Thread() {
			@Override
			public void run() {
				while(true) {
					marine2.attack(marine1);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();;

	}

}
