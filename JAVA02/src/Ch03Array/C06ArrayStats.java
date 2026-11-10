package Ch03Array;

import java.util.Arrays;
import java.util.Scanner;

// =======================================
// 배열 통계 문제
// 정수 5개의 최대값, 최소값, 합
// =======================================

public class C06ArrayStats {

	public static void main(String[] args) {

		// 문제 ------
		// 5개의 정수를 입력받아 int 배열에 저장하고 최대값, 최소값, 전체합을 출력하는 문제
		Scanner sc = new Scanner(System.in);

		int num [] = new int[5];

		for(int i=0; i<num.length; i++){
			num[i] = sc.nextInt();
		}

		// 최대값, 최소값, 전체합은 스트림의 max(), min(), sum() 으로 구함
		System.out.println("최대값: " + Arrays.stream(num).max().getAsInt());
		System.out.println("최소값: " + Arrays.stream(num).min().getAsInt());
		System.out.println("전체합: " + Arrays.stream(num).sum());

		sc.close();
	}

}
