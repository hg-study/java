package Ch03Array;

import java.util.Arrays;
import java.util.Scanner;

// =======================================
// 배열 기초
// 배열 생성과 순회, 최대값 최소값 구하기
// =======================================

public class C01ArrayBasic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 배열 생성 ------
		// 배열 : 같은 자료형의 값을 연속된 칸에 모아 저장하는 자료구조. 칸 번호(인덱스)는 0부터 시작함
		// int [] arr1 = 로 써도 같음. arr1 은 배열의 주소를 저장하는 배열형 참조변수
		int arr1 [] = new int[5];   // int(4byte) 크기의 칸 5개인 배열 생성
		arr1[0] = sc.nextInt();
		arr1[1] = sc.nextInt();
		arr1[2] = sc.nextInt();
		arr1[3] = sc.nextInt();
		arr1[4] = sc.nextInt();

		// 배열 순회 ------
		// length : 배열의 칸 수. 괄호가 없는 필드임
		System.out.println("배열길이: " + arr1.length);

		for(int i=0; i<arr1.length;i++)
			System.out.println(arr1[i]);
		System.out.println("------------");

		// 향상된 for 문 : 인덱스 없이 요소를 처음부터 끝까지 하나씩 꺼냄
		for(int el : arr1)
			System.out.println(el);
		System.out.println("------------");

		// 스트림 : 배열에는 stream 메서드가 없으므로 Arrays.stream 으로 스트림으로 바꾼 뒤 forEach 를 사용함
		Arrays.stream(arr1).forEach((el)->{System.out.println(el);});

		// 최대값, 최소값 구하기 ------
		// 문제 : 저장된 배열의 숫자 중 최대값과 최소값을 구하는 문제

		// 고전적인 방법 : 첫 요소를 기준값으로 잡고 하나씩 비교해 더 크거나 작으면 바꿈
		int max = arr1[0];
		int min = arr1[0];

		for (int el : arr1) {

			if (el>max) {
				max = el;
			}

			if (el<min) {
				min=el;
			}
		}
		System.out.println(max);
		System.out.println(min);

		// 스트림 방법 : max(), min() 이 OptionalInt 를 돌려주므로 getAsInt() 로 값을 꺼냄
		System.out.println("MAX: " + Arrays.stream(arr1).max().getAsInt());
		System.out.println("MIN: " + Arrays.stream(arr1).min().getAsInt());

		sc.close();
	}
}
