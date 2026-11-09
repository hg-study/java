package Ch03Input;

import java.util.Scanner;

// =======================================
// Scanner 연습: 이름, 나이, 주소
// 여러 자료형을 이어서 입력받아 출력
// =======================================

public class C03ScannerInfo {
    public static void main(String[] args) {

        // 실행 예 ------
        // 이름을 입력하세요? 홍길동
        // 홍길동 님의 나이를 입력하세요? 35
        // 홍길동 님의 주소를 입력하세요? 대구광역시 달서구 000
        // 홍길동 님의 나이는 35세 주소는 대구광역시 ~~ 입니다

        Scanner sc = new Scanner(System.in);

        // 이름 입력 ------
        System.out.print("이름을 입력하세요: ");
        String name = sc.next();        // next() : 공백 앞까지 한 단어를 읽는 메서드. 띄어쓰기 없는 이름에 사용함

        // 나이 입력 ------
        System.out.printf("%s 님의 나이를 입력하세요: ",name);
        int age = sc.nextInt();         // nextInt() : 정수를 읽는 메서드. 입력 뒤의 엔터(\n)는 버퍼에 남음

        sc.nextLine();                  // 남은 엔터를 읽어서 비움. 비우지 않으면 아래 nextLine()이 빈 줄을 읽고 지나감

        // 주소 입력 ------
        System.out.printf("%s 님의 주소를 입력하세요: ",name);
        String addr = sc.nextLine();    // nextLine() : 띄어쓰기를 포함한 한 줄 전체를 읽는 메서드

        System.out.printf("%s 님의 나이는 %d세, 주소는 %s 입니다.",name, age, addr);

        sc.close();

    }
}
