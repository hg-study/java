package Ch03Array;

// =======================================
// 2차원 배열
// 행마다 길이가 다른 배열
// =======================================

public class C03Array2D {

	public static void main(String[] args) {

		// 2차원 배열 ------
		// 2차원 배열 : 1차원 배열을 요소로 가지는 배열. arr[행][열] 로 접근함
		// 행마다 열의 길이를 다르게 만들 수 있음(가변 배열)
		int arr[][] = {
				{10,20,30},
				{40,50,60,65,67},
				{70,80,90,96,11,56},
				{100,110,120,15,22,33,44},
		};

		// arr.length : 행의 개수(1차원 배열 요소의 개수)
		System.out.println("arr[][]'s 배열 요소 개수: "+ arr.length);   // 4

		// arr[i].length : i번째 행의 열 개수. 2차원 배열의 요소는 1차원 배열
		System.out.println("arr[0]'s 배열 요소 개수: "+ arr[0].length);	// 3
		System.out.println("arr[1]'s 배열 요소 개수: "+ arr[1].length);	// 5
		System.out.println("arr[2]'s 배열 요소 개수: "+ arr[2].length);	// 6
		System.out.println("arr[3]'s 배열 요소 개수: "+ arr[3].length);	// 7

		// 3차원 배열의 요소는 2차원 배열이며, 같은 방식으로 한 단계씩 길이를 확인함

	}

}
