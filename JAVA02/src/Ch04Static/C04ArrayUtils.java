package Ch04Static;

import java.util.Arrays;

// =======================================
// static 메서드 문제
// 배열을 합치고 출력하는 유틸 클래스
// =======================================

// 문제 ------
// static 메서드 2개를 가진 ArrayUtils 클래스를 만드는 문제
// concat() : 두 배열을 연결한 새 배열을 돌려줌
// print() : 배열의 모든 요소를 한 줄에 띄어쓰기로 구분해 출력함 (예 : {10,20,30,40} -> 10 20 30 40)

class ArrayUtils {
	public static int[] concat(int[] a, int[] b) {
		// System.arraycopy(원본, 시작, 대상, 시작, 개수) : 배열의 일부를 다른 배열로 복사함
		int[] arr12 = new int[a.length + b.length];

		System.arraycopy(a,0,arr12,0,a.length);
		System.arraycopy(b,0,arr12,a.length,b.length);
		return arr12;

	}

	public static void print(int [] a) {
		Arrays.stream(a).forEach((el)->{System.out.print(el + " ");});
		// Arrays.stream(a).forEach(System.out::println);	// 메서드 참조로 줄바꿈 출력도 가능
		System.out.println();
	}
}

public class C04ArrayUtils {

	public static void main(String[] args) {
		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, 77 };
		int[] array3 = ArrayUtils.concat(array1, array2);
		System.out.println(Arrays.toString(array3));
		ArrayUtils.print(array3);
	}
}
