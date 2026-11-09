package Ch06Loop;

// =======================================
// break와 continue
// 반복문 탈출과 건너뛰기, 라벨을 이용한 중첩 반복 탈출
// =======================================

public class C03BreakContinue {
    public static void main(String[] args) {

        // break ------
        // break : 가장 가까운 반복문(또는 switch 문)을 즉시 빠져나가는 키워드
        // -1을 입력하기 전까지의 정수를 누적해 합을 출력하는 문제

        //     Scanner sc = new Scanner(System.in);
        //     int n;
        //     int sum = 0;

        //     while(true) {

        //         n = sc.nextInt();
        //         if(n==-1)
        //             break;

        //         sum+=n;
        //     }
        //     System.out.println("SUM: " + sum);

        //     sc.close();

        // break 를 쓰지 않는 풀이 : 입력받는 식을 조건식 안에 넣어, 입력값이 -1이면 반복이 끝남

        //     Scanner sc = new Scanner(System.in);
        //     int n;
        //     int sum = 0;

        //     while ( (n = sc.nextInt()) != -1 )
        //         sum += n;

        //     System.out.println("SUM: " + sum);

        //     sc.close();


        // 모든 반복문 탈출 : flag ------
        // 중첩 반복문에서 break 는 안쪽 반복문만 빠져나옴
        // 바깥 반복문까지 끝내려면 탈출 신호용 변수(flag)를 true로 바꾼 뒤 바깥에서 한 번 더 break 함
        // 7 x 7 까지만 출력함 (dan == 7 && i == 7)

		// int dan = 2;
        // boolean isExit = false;

		// while(dan<10) {

		// 	int i=1;
		// 	while(i<10) {
		// 		System.out.printf("%d x %d = %d\n", dan,i,dan*i);

        //         if (dan == 7 && i == 7){
        //             isExit = true;
        //             break;
        //         }

		// 		i++;
		// 	}

        //     if(isExit)
        //         break;

		// 	System.out.println();
		// 	dan++;
		// }

        // 모든 반복문 탈출 : 라벨 ------
        // 라벨 : 반복문 앞에 붙이는 이름(Exit:). break Exit; 를 쓰면 이름이 붙은 바깥 반복문까지 한 번에 빠져나감
        // 7 x 7 까지만 출력함 (dan == 7 && i == 7)

		// int dan = 2;

        // Exit:
		// while(dan<10) {

		// 	int i=1;

		// 	while(i<10) {
		// 		System.out.printf("%d x %d = %d\n", dan,i,dan*i);

        //         if (dan == 7 && i == 7){
        //             break Exit;
        //         }

		// 		i++;
		// 	}

		// 	System.out.println();
		// 	dan++;
		// }


        // continue ------
        // continue : 반복문의 남은 문장을 건너뛰고 다음 반복으로 넘어가는 키워드
        // 1부터 10까지의 수 중에 3의 배수를 제외한 합을 출력하는 문제
        // while 에서는 continue 앞에서 i++ 를 해야 같은 값에서 멈추지 않고 계속 반복됨

        int i = 1;
        int sum = 0;
        while (i<=10) {
            if (i%3==0){
                i++;
                continue;
            }

            System.out.println("i: " +i);
            sum += i;
            i++;
        }

        System.out.println("SUM: " + sum);

    }

}
