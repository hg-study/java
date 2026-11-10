package Ch03Array;

import java.util.Arrays;

// =======================================
// 배열 복사
// 얕은 복사와 깊은 복사
// =======================================

public class C02ArrayCopy {

	public static void main(String[] args) {

		// 얕은 복사 ------
		// 얕은 복사 : 배열의 주소값만 복사하는 방법. 두 변수가 같은 배열을 가리켜 한쪽을 바꾸면 다른 쪽도 바뀜
		int arr1 [] = {10,20,30};
		int arr2 [];

		arr2 = arr1;
		arr1[0] = 100;

		// 주소값이 같음
		System.out.printf("%x\n", System.identityHashCode(arr1));
		System.out.printf("%x\n", System.identityHashCode(arr2));
		System.out.println("------------------");

		Arrays.stream(arr1).forEach((el)->{System.out.println(el);});
		System.out.println("------------------");
		Arrays.stream(arr2).forEach((el)->{System.out.println(el);});

		// 깊은 복사 ------
		// 깊은 복사 : 새 배열을 만들어 값을 하나씩 복사하는 방법. 서로 다른 배열이라 영향을 주지 않음
		int arr3 [] = new int[3];
		for(int i=0; i<arr1.length; i++) {
			arr3[i] = arr1[i];
		}

		// Arrays.copyOf ------
		// Arrays.copyOf(원본, 길이) : 지정한 길이의 새 배열로 복사해 돌려주는 API(깊은 복사)
		int arr4[] = Arrays.copyOf(arr1, arr1.length);

		// 전체 주소값 확인 : arr1 과 arr2 만 같고 arr3, arr4 는 다름
		System.out.println("arr1: " + arr1);
		System.out.println("arr2: " + arr2);
		System.out.println("arr3: " + arr3);
		System.out.println("arr4: " + arr4);

	}

}
