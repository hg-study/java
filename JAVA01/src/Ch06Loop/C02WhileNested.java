package Ch06Loop;

import java.util.Scanner;

// =======================================
// 중첩 while
// 구구단 범위 출력과 별 찍기
// =======================================

public class C02WhileNested {
	
	public static void main(String[] args) {
		
		// 2~9단 출력 ------
		// 단(dan)을 바깥 반복, 곱하는 수(i)를 안쪽 반복으로 두고 아래 표로 변수와 조건을 먼저 정리함
		
//		dan		i
//		2		1
//				2
//				..
//				9
//		--------------------
//		dan=2		i=1
//		dan++		i++
//		dan<10		i<10
		
//		int dan = 2;
//		while(dan<10) {
//			
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i++;
//			}
//			
//			System.out.println();

//			dan++;
//		}
		
		// N~9단 출력 ------
		// 시작 단 N을 입력받아 9단까지 출력함
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int dan = n;
//		while(dan<10) {
//			
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i++;
//			}
//			
//			System.out.println();
//			dan++;
//		}
//		sc.close();
		
		// N~M단 출력 ------
		// 시작 단 N과 끝 단 M을 입력받아 출력함 (N<M, N>=2 && N<=9, M>2 && M<10)
		
		// Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		// int m = sc.nextInt();
		
		// 유효성 검증 : 입력이 조건에 맞지 않으면 다시 입력받음
		// 조건에 맞지 않는 경우 : (N>=M) || (N<2 || N>9) || (M<=2 || M>=10)
		// while((n>=m) ||  (n<2 || n>9) || (m<=2 || m>=10)) {
		// 	System.out.print("n,m 다시 입력 : ");
		// 	n = sc.nextInt();
		// 	m = sc.nextInt();
		// }
		
		// int dan = n;
		// while(dan<(m+1)) {
			
		// 	int i=1;
		// 	while(i<10) {
		// 		System.out.printf("%d x %d = %d\n", dan,i,dan*i);
		// 		i++;
		// 	}
			
		// 	System.out.println();
		// 	dan++;
		// }
		// sc.close();
		

		// N~M단 거꾸로 출력 ------
		// M단부터 N단까지 단을 줄여가고, 각 단은 9부터 1까지 줄여가며 출력함 (9 x 9, 9 x 8 ...)
	
//		dan		i
//		n , m(n<m)
//		m		9
//				8
//				..
//				1
//		m-1		1
//				2
//				..
//				9
//
//		n		9
//				8
//				..
//				1
//		--------------------
//		dan=m		i=9
//		dan--		i--
//		dan>n-1		i>0
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		
// 유효성 검증 : 입력이 조건에 맞지 않으면 다시 입력받음
// 조건에 맞지 않는 경우 : (N>=M) || (N<2 || N>9) || (M<=2 || M>=10)
//		while((n>=m) ||  (n<2 || n>9) || (m<=2 || m>=10)) {
//			System.out.print("n,m 다시 입력 : ");
//			n = sc.nextInt();
//			m = sc.nextInt();
//		}
//		
//		int dan = m;
//		while(dan>n-1) {
//			
//			int i=9;
//			while(i>0) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i--;
//			}
//			
//			System.out.println();
//			dan--;
//		}
//		sc.close();
		
		
    // 별 찍기 1 : 고정 높이 직사각형 ------
    // 행(i) 안에서 별(j)을 반복 출력함. 높이 4, 폭 5로 고정
    // *****
    // *****
    // *****
    // *****
		
//		i(행)	j(별)
//		0		0-4
//		1		0-4
//		2		0-4
//		3		0-4
//		---------------
//		i=0		j=0
//		i++		j++
//		i<4		j<5
		
//		int i=0;
//		while(i<4) {
//			
//			int j=0;
//			while(j<5) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		
		
		// 별 찍기 2 : 높이를 입력받는 직사각형 ------
		// 출력 예) 높이 4
		// *****
		// *****
		// *****
		// *****
//		높이 : h
//
//		i(행)	j(별)
//		0		0-4
//		1		0-4
//		2		0-4
//		3		0-4
//		..
//		h-1		0-4
//		---------------
//		i=0		j=0
//		i++		j++
//		i<h		j<5


//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		int i=0;
//		while(i<h) {
//			
//			int j=0;
//			while(j<5) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
//		sc.close();
		

		// 별 찍기 3 : 고정 높이 직각삼각형 ------
		// 행 번호(i)만큼 별(j)이 늘어남. 높이 4로 고정
		// * 
		// ** 
		// *** 
		// **** 
		
//		i(행)	j(별)
//		0		0-0
//		1		0-1
//		2		0-2
//		3		0-3
//		------------------
//		i=0		j=0
//		i++		j++
//		i<4		j<=i
		
//		int i=0;
//		while(i<4) {
//			
//			int j=0;
//			while(j<=i) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		// 별 찍기 4 : 높이를 입력받는 직각삼각형 ------
		// 출력 예) 높이 4
		// * 
		// ** 
		// *** 
		// ****
		
//		i(행)	j(별)
//		0		0-0
//		1		0-1
//		2		0-2
//		3		0-3
//		..
//		h-1		0-(h-1)
//		------------------
//		i=0		j=0
//		i++		j++
//		i<h		j<=i
		
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		int i=0;
//		while(i<h) {
//			
//			int j=0;
//			while(j<=i) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
//		sc.close();
		
		
		// 별 찍기 5 : 거꾸로 된 직각삼각형 ------
		// 행이 내려갈수록 별이 하나씩 줄어듦
		// 출력 예) 높이 4
		//****
		//***
		//**
		//*		

//		i(행)		j(별)
//		0			0-(h-1)
//		1			0-(h-1)-1
//		2			0-(h-1)-2
//		3			0-(h-1)-3
//		..
//		h-1			0-0
//		---------------------
//		i=0			j=0
//		i++			j++
//		i<h			j<=(h-1)-i
				
		// Scanner sc = new Scanner(System.in);
		// int h = sc.nextInt();
		// int i=0;
		// while(i<h) {
			
		// 	int j=0;
		// 	while(j<=(h-1)-i) {
		// 		System.out.print("*");
		// 		j++;
		// 	}
			
		// 	System.out.println();
		// 	i++;
		// }
		// sc.close();
		
		// 별 찍기 6 : 피라미드 ------
		// 행마다 공백을 먼저 출력하고 별을 출력함. 공백은 하나씩 줄고 별은 2개씩 늘어남
		// 출력 예) 높이 4
		//   *
		//  ***
		// *****
		//*******

// 높이 4로 고정했을 때의 규칙
//		i(행)		j(공백)		k(별)
//		0			0-2			0-0
//		1			0-1			0-2
//		2			0-0			0-4
//		3			x			0-6
//		-------------------------------------
//		i=0			j=0			k=0
//		i++			j++			k++
//		i<4			j<3-i		k<=i*2

        
		// int i = 0;
        // while (i<4) {
        //     // 공백 출력
        //     int j = 0;
        //     while(j<3-i) {
        //         System.out.print(" ");
        //         j++;
        //     }
        //     // 별 출력
        //     int k = 0;
        //     while (k<= i*2) {
        //         System.out.print("*");
        //         k++;                
        //     }
        //     System.out.println();
        //     i++;
        // }


// 높이를 h로 일반화한 규칙
//		i(행)		j(공백)		k(별)
//		0			0-2			0-0
//		1			0-1			0-2
//		2			0-0			0-4
//		3			x			0-6
//		-------------------------------------
//		i=0			j=0			k=0
//		i++			j++			k++
//		i<4			j<3-i		k<=i*2
// (마지막 행 i=h-1 에서 공백이 0개가 되도록 공백은 (h-1)-i 개)

//      i<h         j<(h-1)-i   k<=i*2
	

        // Scanner sc = new Scanner(System.in);

        // System.out.print("높이: ");
        // int h = sc.nextInt();
		// int i = 0;

        // while (i<h) {
        //     // 공백 출력
        //     int j = 0;
        //     while(j< (h-1)-i) {
        //         System.out.print(" ");
        //         j++;
        //     }
        //     // 별 출력
        //     int k = 0;
        //     while (k<= i*2) {
        //         System.out.print("*");
        //         k++;                
        //     }
        //     System.out.println();
        //     i++;
        // }

        // sc.close();


		// 별 찍기 7 : 거꾸로 된 피라미드 ------
		// 행마다 공백은 하나씩 늘고 별은 2개씩 줄어듦
		// 출력 예) 높이 4
		//*******
		// *****
		//  ***
		//   *

        // 풀이 1 : 별 개수를 (h-i)*2-1 로 계산함

        // Scanner sc = new Scanner(System.in);
        // System.out.print("높이: ");
        // int h = sc.nextInt();

        // int i = 0; // 행 번호
        // // int h = 4; // 높이(입력받지 않을 때 직접 지정)

        
        // while (i<h) { // 행 반복

        //     int j = 0; // 공백 개수 변수

        //     while (j < i) { // 공백은 0개부터 하나씩 늘어남
        //         System.out.print(" ");
        //         j++;
        //     }


        //     int k = 0; // 별 개수 변수

        //     while (k < (h-i)*2 -1 ) { // 별은 2개씩 줄어듦
        //         System.out.print("*");
        //         k++;
        //     }
        //     System.out.println();
        //     i++;
        // }
        
        // sc.close();



        // 풀이 2 : 별 개수를 ((h-1)*2)-2*i 에 <= 를 써서 계산함. 풀이 1과 개수가 같음
        // Scanner sc = new Scanner(System.in);
        // System.out.print("높이: ");
        // int h = sc.nextInt();

        // int i = 0; // 행 번호
        // // int h = 4; // 높이(입력받지 않을 때 직접 지정)

        
        // while (i<h) { // 행 반복

        //     int j = 0; // 공백 개수 변수

        //     while (j < i) { // 공백은 0개부터 하나씩 늘어남
        //         System.out.print(" ");
        //         j++;
        //     }


        //     int k = 0; // 별 개수 변수

        //     while (k <= ((h-1)*2)-2*i) { // 별은 2개씩 줄어듦
        //         System.out.print("*");
        //         k++;
        //     }
        //     System.out.println();
        //     i++;
        // }
        
        // sc.close();

		// 별 찍기 8 : 고정 높이 마름모 ------
		// 9번과 같은 모양을 높이 7로 고정한 문제
		// 행(i)이 가운데 행(half)까지는 i, 그 뒤로는 거꾸로 줄어드는 값을 row 로 구해 공백과 별 개수를 정함
		// int h = 7;
		// int half = h / 2;
		// int i = 0;
		// while (i < h) {
		//     int row = (i <= half) ? i : h - 1 - i;
		//     int j = 0;
		//     while (j < half - row) { System.out.print(" "); j++; }
		//     int k = 0;
		//     while (k < row * 2 + 1) { System.out.print("*"); k++; }
		//     System.out.println();
		//     i++;
		// }
		//   *
		//  ***
		// *****
		//*******
		// *****
		//  ***
		//   *
		
		// 별 찍기 9 : 높이를 입력받는 마름모 ------
		// 출력 예) 높이 7
		//   *
		//  ***
		// *****
		//*******
		// *****
		//  ***
		//   *	


        // 풀이 : 높이는 홀수만 받고, 가운데 행(half)까지는 피라미드로 늘리고 그 아래는 거꾸로 줄임

        // Scanner sc = new Scanner(System.in);
        // System.out.print("높이(홀수): ");
        // int h = sc.nextInt(); // 높이

        
        // 홀수 검증 : 짝수이거나 음수면 다시 입력받음
        
        // while (h%2 == 0 || h<0) {
        //     System.out.print("홀수를 입력해주세요.: ");
        //     h = sc.nextInt(); // 높이
        // }
        
        // int half = h / 2;

        // 위쪽 절반 : 가운데 행(half)까지는 if 문, 아래쪽 절반은 else 문에서 출력함
        // int i = 0; // 행 번호

        // while (i<h) {

        //     if (i<= half) {
            
        //         // 공백 출력
        //         int j = 0;
        //         while(j< half -i) {
        //             System.out.print(" ");
        //             j++;
        //         }

        //         // 별 출력
        //         int k = 0;
        //         while (k<= i*2) {
        //             System.out.print("*");
        //             k++;                
        //         }
        //         System.out.println();
        //         i++;
                
        //     }

        //     else{
        //         // 공백 출력
        //         while (i<h) { // 높이
        //             int row = i - half;

        //             int j = 0; // 공백 개수 변수
        //             while (j < row) { // 공백은 0개부터 하나씩 늘어남
        //                 System.out.print(" ");
        //                 j++;
        //             }
                
        //             // 별 출력
        //             int k = 0; // 별 개수 변수

        //             while (k < (half-row)*2 +1 ) { // 별은 2개씩 줄어듦
        //                 System.out.print("*");
        //                 k++;
        //             }
        //             System.out.println();
        //             i++;
        //         }
        //     }
            
        // }
    

		
		// 별 찍기 10 : 모래시계 ------
		// 출력 예) 높이 7
		//*******
		// *****
		//  ***
		//   *
		//  ***
		// *****
		//*******
		


        // 풀이 : 가운데 행(half)까지는 별이 2개씩 줄고, 그 아래는 2개씩 늘어남

        // Scanner sc = new Scanner(System.in);

        // System.out.print("높이(홀수): ");
        // int h = sc.nextInt(); // 높이

        // //int h = 7;
        
        // 홀수 검증 : 짝수이거나 음수면 다시 입력받음
        
        // while (h%2 == 0 || h<0) {
        //     System.out.print("홀수를 입력해주세요.: ");
        //     h = sc.nextInt(); // 높이
        // }
        
        // int half = h / 2;

        // 위쪽 절반 : 가운데 행(half)까지는 if 문, 아래쪽 절반은 else 문에서 출력함
        // int i = 0; // 행 번호

        // while (i<h) {

        //     if (i<= half) {
            
        //         // 공백 출력
        //         int j = 0;
        //         while(j<i) {
        //             System.out.print(" ");
        //             j++;
        //         }

        //         // 별 출력
        //         int k = 0;
        //         while (k < (half-i)*2 +1) {
        //             System.out.print("*");
        //             k++;                
        //         }
        //         System.out.println();
        //         i++;
                
        //     }

        //     else{
        //         // 공백 출력
        //         while (i<h) { // 높이
        //             int row = i - half;

        //             int j = 0; // 공백 개수 변수
        //             while (j < half - row) {
        //                 System.out.print(" ");
        //                 j++;
        //             }
                
        //             // 별 출력
        //             int k = 0; // 별 개수 변수
        //             while (k<= row*2) { 
        //                 System.out.print("*");
        //                 k++;
        //             }
        //             System.out.println();
        //             i++;
        //         }
        //     }
            
        // }

        // sc.close();

	}
	
}