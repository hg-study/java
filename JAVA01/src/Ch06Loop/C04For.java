package Ch06Loop;

import java.util.Scanner;

// =======================================
// for 반복문
// while 문제를 for로 바꾸기와 별 찍기
// =======================================

public class C04For {
    public static void main(String[] args) {
        
        // for 문 ------
        // for 문 : 초기값, 조건식, 증감연산을 한 줄에 쓰는 반복문. while 문의 탈출 변수, 조건식, 탈출 연산식을 괄호 안에 모은 형태
        // for( 초기값 ; 조건식 ; 증감연산 )

        // for (int i = 0 ; i<10 ; i++) {
        //     System.out.println((i+1) +": HELLOWORLD");
        // }


        // 문제 : C02WhileNested 의 while 문을 모두 for 문으로 바꾸는 문제


		// 2~9단 출력 ------

        // for (int dan = 2; dan<10; dan++){
	
		// 	for(int i=1; i<10; i++) {
		// 		System.out.printf("%d x %d = %d\n", dan,i,dan*i);
		// 	}
		// 	System.out.println();
		// }


		// N~9단 출력 ------

		// Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();

		// for(int dan = n;dan<10; dan++) {
			
		// 	for(int i=1;i<10;i++) {
		// 		System.out.printf("%d x %d = %d\n", dan,i,dan*i);
		// 	}
		// 	System.out.println();
		// }
		// sc.close();
		


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
		
		
		// for(int dan = n; dan<(m+1);dan++) {

		// 	for(int i=1;i<10;i++) {
		// 		System.out.printf("%d x %d = %d\n", dan,i,dan*i);
		// 	}
		// 	System.out.println();
		// }
		// sc.close();
		

        // N~M단 거꾸로 출력 ------
        // M단부터 N단까지 단을 줄여가고, 각 단은 9부터 1까지 줄여가며 출력함 (9 x 9, 9 x 8 ...)


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
		
		
		// for(int dan = m;dan>n-1;dan--) {

		// 	for(int i=9;i>0;i--) {
		// 		System.out.printf("%d x %d = %d\n", dan,i,dan*i);
				
		// 	}
		// 	System.out.println();
		// }

		// sc.close();


		// 별 찍기 1 : 고정 높이 직사각형 ------
		// 행(i) 안에서 별(j)을 반복 출력함. 높이 4, 폭 5로 고정
		// *****
		// *****
		// *****
		// *****

		
		// for(int i=0;i<4;i++) {		
		// 	for(int j=0;j<5;j++) {
		// 		System.out.print("*");
		// 	}
		// 	System.out.println();
		// }

	
		// 별 찍기 2 : 높이를 입력받는 직사각형 ------
		// 출력 예) 높이 4
		// *****
		// *****
		// *****
		// *****


		// Scanner sc = new Scanner(System.in);
		// int h = sc.nextInt();
		
		// for(int i=0;i<h;i++) {
			
		// 	for(int j=0;j<5;j++) {
		// 		System.out.print("*");
		// 	}
		// 	System.out.println();
		// }
		// sc.close();

        
		// 별 찍기 3 : 고정 높이 직각삼각형 ------
		// 행 번호(i)만큼 별(j)이 늘어남. 높이 4로 고정
		// * 
		// ** 
		// *** 
		// **** 

		// for(int i=0;i<4;i++) {
		// 	for(int j=0;j<=i;j++) {
		// 		System.out.print("*");
		// 	}
		// 	System.out.println();
		// }


		// 별 찍기 4 : 높이를 입력받는 직각삼각형 ------
		// 출력 예) 높이 4
		// * 
		// ** 
		// *** 
		// ****

		// Scanner sc = new Scanner(System.in);
		// int h = sc.nextInt();
		
		// for(int i = 0;i<h;i++) {

		// 	for(int j=0;j<=i;j++) {
		// 		System.out.print("*");
		// 	}
		// 	System.out.println();
			
		// }
		// sc.close();
		

		// 별 찍기 5 : 거꾸로 된 직각삼각형 ------
		// 행이 내려갈수록 별이 하나씩 줄어듦
		// 출력 예) 높이 4
		//****
		//***
		//**
		//*		


		// Scanner sc = new Scanner(System.in);
		// int h = sc.nextInt();
		
		// for(int i=0;i<h;i++) {
		// 	for(int j=0;j<=(h-1)-i;j++) {
		// 		System.out.print("*");
		// 	}
		// 	System.out.println();
		// }
		// sc.close();


		// 별 찍기 6 : 피라미드 ------
		// 행마다 공백을 먼저 출력하고 별을 출력함. 공백은 하나씩 줄고 별은 2개씩 늘어남
		// 출력 예) 높이 4
		//   *
		//  ***
		// *****
		//*******
      
		
        // for (int i = 0;i<4;i++) {
        //     // 공백 출력
            
        //     for(int j = 0;j<3-i; j++) {
        //         System.out.print(" ");
        //     }
        //     // 별 출력
            
        //     for (int k = 0; k<= i*2;k++) {
        //         System.out.print("*");                
        //     }
        //     System.out.println();
            
        // }


        // 높이를 입력받는 피라미드


        // Scanner sc = new Scanner(System.in);

        // System.out.print("높이: ");
        // int h = sc.nextInt();
		

        // for (int i = 0;i<h; i++) {
        //     // 공백 출력
            
        //     for(int j = 0;j< (h-1)-i; j++) {
        //         System.out.print(" ");
        //     }
        //     // 별 출력
           
        //     for ( int k = 0;k<= i*2; k++) {
        //         System.out.print("*");                 
        //     }
        //     System.out.println();
           
        // }

        // sc.close();



		// 별 찍기 7 : 거꾸로 된 피라미드 ------
		// 행마다 공백은 하나씩 늘고 별은 2개씩 줄어듦
		// 출력 예) 높이 4
		//*******
		// *****
		//  ***
		//   *

        // 풀이 : 별 개수를 (h-i)*2-1 로 계산함

        // Scanner sc = new Scanner(System.in);
        // System.out.print("높이: ");
        // int h = sc.nextInt();

        // 행(i)을 높이(h)만큼 반복함
        
        // for (int i = 0;i<h; i++) { // 행 반복

        //     for (int j = 0; j < i; j++) { // 공백은 0개부터 하나씩 늘어남
        //         System.out.print(" ");   
        //     } 

        //     for ( int k = 0; k < (h-i)*2 -1; k++) { // 별은 2개씩 줄어듦
        //         System.out.print("*");  
        //     }
        //     System.out.println();

        // }
        
        // sc.close();



		// 별 찍기 8 : 고정 높이 마름모 ------
		// 높이 7로 고정한 마름모. 행(i)이 가운데 행(half)까지는 i, 그 뒤로는 거꾸로 줄어드는 값을 row 로 구해 공백과 별 개수를 정함
		// int h = 7;
		// int half = h / 2;
		// for (int i = 0; i < h; i++) {
		//     int row = (i <= half) ? i : h - 1 - i;
		//     for (int j = 0; j < half - row; j++) System.out.print(" ");
		//     for (int k = 0; k < row * 2 + 1; k++) System.out.print("*");
		//     System.out.println();
		// }

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
         

        // for (int i = 0;i<h; ) {// 행 번호(증가는 안쪽에서 처리)

        //     if (i<= half) {
            
        //         // 공백 출력
        //         for(int j = 0; j< half -i; j++) {
        //             System.out.print(" ");
        //         }

        //         // 별 출력
                
        //         for(int k = 0; k<= i*2; k++) {
        //             System.out.print("*");         
        //         }
        //         System.out.println();
        //         i++;
                
        //     }

        //     else{
        //         for (  ;   i<h;   i++) { // 남은 행 반복
        //             int row=i-half;
        //             // 공백 출력
        //             for (int j = 0;j < row; j++) { 
        //                 System.out.print(" ");                     
        //             }
        //             // 별 출력
        //             for (int k = 0;k < (half-row)*2 +1; k++) { 
        //                 System.out.print("*");            
        //             }
        //             System.out.println();
        //         }
        //     }  
        // }
    
        // sc.close();


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

        Scanner sc = new Scanner(System.in);

        System.out.print("높이(홀수): ");
        int h = sc.nextInt(); // 높이

        // 직접 높이를 지정할 때 : int h = 7;
        
        // 홀수 검증 : 짝수이거나 음수면 다시 입력받음
        
        while (h%2 == 0 || h<0) {
            System.out.print("홀수를 입력해주세요.: ");
            h = sc.nextInt(); // 높이
        }
        
        int half = h / 2;

        // 위쪽 절반 : 가운데 행(half)까지는 if 문, 아래쪽 절반은 else 문에서 출력함
         
        for (int i = 0; i<h;  ) {// 행 번호(증가는 안쪽에서 처리)

            if (i<= half) {
            
                // 공백 출력
                
                for(int j = 0; j<i; j++) {
                    System.out.print(" ");
                    
                }

                // 별 출력
                
                for (int k = 0;  k < (half-i)*2 +1;k++) {
                    System.out.print("*");             
                }
                System.out.println();
                i++;
            }

            else{
                // 아래쪽 절반 : 가운데 행(half) 아래를 거꾸로 출력함
                while (i<h) { // 남은 행 반복
                    int row = i - half;
            
                    for (int j = 0;j < half - row;j++) {// 공백 출력
                        System.out.print(" ");
                    }
                
                // 별 출력
                        
                    for (int k = 0;k<= row*2; k++) { // 별 출력
                        System.out.print("*");
                       
                    }
                    System.out.println();
                    i++;
                }
            }
            
        }

        sc.close();











    }
}
