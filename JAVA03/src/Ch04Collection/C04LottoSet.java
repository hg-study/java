package Ch04Collection;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

// =======================================
// 로또 번호 문제
// Set 으로 중복 없는 난수 만들기
// =======================================

// 문제 ------
// 1) 1 ~ 45 숫자 6개를 Random 으로 뽑아 Set 에 저장하고 출력하는 문제
//    Set 은 중복을 허용하지 않으므로 크기가 6이 될 때까지 반복하면 서로 다른 6개가 됨
// 2) 저장된 Set 을 오름차순으로 정렬하는 문제 (스트림 사용)
public class C04LottoSet {
	public static void main(String[] args) {

		Set<Integer> set = new HashSet();
		Random random = new Random();

		while (set.size()<6) {
			set.add(random.nextInt(45)+1);     // nextInt(45) 는 0~44 이므로 1 을 더함
		}

		for (Integer el: set) {
			System.out.println(el);
		}

		// 정렬 방법 1 : 스트림 ------
		// sorted() 로 오름차순 정렬한 뒤 collect(Collectors.toList()) 로 List 로 모음
		List<Integer> list = set.stream()
							   .sorted()
							   .collect(Collectors.toList());

		// 정렬 방법 2 : Collections.sort() ------
//		List<Integer> list = new ArrayList<>(set);
//		Collections.sort(list);

		System.out.println(list);
	}
}
