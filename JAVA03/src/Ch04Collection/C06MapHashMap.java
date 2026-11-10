package Ch04Collection;

import java.util.HashMap;
import java.util.Map;

// =======================================
// Map 과 HashMap
// 키와 값 쌍으로 저장
// =======================================

// Map ------
// Map : 키(Key)와 값(Value)을 한 쌍으로 저장하는 컬렉션. 키는 중복될 수 없고 같은 키로 저장하면 값이 덮어써짐
// HashMap : 해시 구조 Map. 순서가 없음

public class C06MapHashMap {

	public static void main(String[] args) {

		Map<String,Integer> map = new HashMap();

		// 추가 : put(키, 값)
		map.put("aaa",1111);
		map.put("bbb",2222);
		map.put("ccc",3333);
		map.put("ddd",4444);
		map.put("ddd",5555);    // 같은 키라 값이 5555 로 바뀜

		// 전체 확인 : keySet() 은 모든 키를 모은 Set, get(키) 로 값을 꺼냄
		for(String key : map.keySet())
			System.out.println("KEY : " + key + " VALUE : " +map.get(key));

		// 삭제 : remove(키)
		map.remove("aaa");

		// 확인
		System.out.println("SIZE : "  + map.size());
		System.out.println("단건 : "  + map.get("bbb"));
	}

}
