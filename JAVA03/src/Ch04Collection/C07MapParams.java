package Ch04Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// =======================================
// Map 으로 값 주고받기
// 배열, 리스트, 문자열, 숫자를 한 Map 에 담기
// =======================================

// 문제 ------
// 여러 자료형의 값을 Map<String,Object> 에 담아 setter 로 저장하고 getter 로 꺼내 출력하는 문제
// 값의 자료형이 Object 라 꺼낸 뒤 instanceof 로 실제 자료형을 확인해 나눠 처리함
public class C07MapParams {

	// 속성
	static Map<String,Object> map = new HashMap();

	// setter : 전달받은 Map 의 모든 키와 값을 저장
	static void setMap(Map<String,Object> param) {

		for(String key : param.keySet()) {
			Object value = param.get(key);
			map.put(key, value);
		}

	}
	// getter
	static Map<String,Object> getMap(){
		return map;
	}

	public static void main(String[] args) {
		// 파라미터 객체 생성
		Map<String,Object> params = new HashMap();

		// 자격증 정보 : 배열
		String [] values1 = {"정보처리기사","웹디자인기능사","SQLD","네트워크관리사"};
		params.put("자격증",values1);

		// 취미 정보 : 리스트
		List<String> values2 = new ArrayList();
		values2.add("등산");
		values2.add("게임");
		values2.add("영화감상");
		params.put("취미",values2);

		// 개인정보 : 문자열과 숫자
		params.put("이름", "홍길동");
		params.put("나이", 20);
		params.put("주소", "대구광역시 남구");

		// setter 로 저장
		setMap(params);

		// getter 로 꺼내 자료형별로 출력
		Map<String,Object> response = getMap();
		for(String key : response.keySet()) {

			Object value = response.get(key);

			if(value instanceof String[]) {
				String [] arr = (String [])value;
				Arrays.stream(arr).forEach(el->{System.out.println("배열 : "+el);});
			}
			else if(value instanceof List) {
				List list = (List)value;
				list.forEach(el->{System.out.println("리스트 : "+el);});
			}else {
				System.out.println("KEY : " + key + " VALUE : " + value);
			}

		}

	}

}
