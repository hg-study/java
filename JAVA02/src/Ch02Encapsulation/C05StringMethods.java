package Ch02Encapsulation;

// =======================================
// 문자열 메모리와 메서드
// String 이어붙이기, StringBuilder, 문자열 메서드
// =======================================

public class C05StringMethods {
    public static void main(String[] args) {

        // 문자열 저장 장소 ------
        // 리터럴은 상수 풀, new 와 연산 결과(+, concat)는 힙에 저장됨. 같은 연산이라도 매번 새 주소를 가짐

//         String str1 = "Java Powerful";                 // 상수 풀
//         String str2 = new String("java Programming");  // 힙
//         String str3 = str1 + str2;                     // 힙
//         String str4 = str1 + str2;                     // 힙
//         String str5 = str1.concat(str2);               // 힙
//         String str6 = str1.concat(str2);               // 힙

//         // 저장 주소값 확인 (전부 다름)
//         System.out.printf("%x\n", System.identityHashCode(str1));
//         System.out.printf("%x\n", System.identityHashCode(str2));
//         System.out.printf("%x\n", System.identityHashCode(str3));
//         System.out.printf("%x\n", System.identityHashCode(str4));
//         System.out.printf("%x\n", System.identityHashCode(str5));
//         System.out.printf("%x\n", System.identityHashCode(str6));

//         // + 로 덧붙이면 더할 때마다 새 주소에 저장되어 메모리 공간이 낭비됨
//         String str7 = "HELLO WORLD";
//         System.out.printf("%x\n", System.identityHashCode(str7));
//         str7+=1;
//         System.out.printf("%x\n", System.identityHashCode(str7));
//         str7+=2;
//         System.out.printf("%x\n", System.identityHashCode(str7));
//         str7+=3;
//         System.out.printf("%x\n", System.identityHashCode(str7));
//         System.out.println("--------------");

//         // StringBuilder : 같은 주소에서 문자열을 덧붙이는 클래스. StringBuffer 보다 속도가 빠름
//         // StringBuffer : 여러 스레드에서 안전하게 쓰는 클래스(안정적)
//         StringBuilder builder = new StringBuilder("hello world");
//         System.out.printf("%x\n",System.identityHashCode(builder));
//         builder.append("1");
//         System.out.printf("%x\n",System.identityHashCode(builder));
//         builder.append("2");
//         System.out.printf("%x\n",System.identityHashCode(builder));
//         builder.append("3");
//         System.out.printf("%x\n",System.identityHashCode(builder));
//         builder.append("4");

        // 반복문에서 덧붙이기 ------
        // String 의 += 로 덧붙이면 반복마다 새 객체가 만들어지므로 StringBuilder 를 사용함. 주소가 바뀌지 않음
        int i=0;
//		String str  = "";
		StringBuilder str = new StringBuilder("");
		while(i<10) {
//			str +=i;
			str.append(i);
			System.out.print("str : " + str + " ");
			System.out.printf("위치 : %x\n",System.identityHashCode(str));
			i++;
		}

        // 문자열 메서드 ------
        String str1 = "Java Powerful";

        System.out.println("문자열 길이: "+ str1.length());             // length() : 문자 개수
        System.out.println("한문자 찾기: "+ str1.charAt(2));            // charAt(i) : i번째 문자

        System.out.println("인덱스 찾기: "+ str1.indexOf('a'));         // indexOf : 앞에서부터 처음 위치
        System.out.println("인덱스 찾기: "+ str1.lastIndexOf('a'));     // lastIndexOf : 뒤에서부터 처음 위치

        System.out.println("문자열 포함 여부: "+str1.contains("va"));   // contains : 포함하면 true
        System.out.println("문자열 포함 여부: "+str1.contains("abs"));

        System.out.println("문자열 자르기: " + (str1.substring(2,6)));  // substring(시작, 끝) : 끝 인덱스는 제외


        // split ------
        // split(",") : 기준 문자로 잘라 문자열 배열로 돌려줌
        String str6 = "등산,탁구,축구,골프,독서,영화감상";
		String [] result = str6.split(",");

		for(String hobby : result)
			System.out.println(hobby);

    }
}
