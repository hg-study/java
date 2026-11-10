package Ch02Encapsulation;

// =======================================
// 문자열 비교
// 상수 풀과 힙, == 와 equals
// =======================================

public class C04StringCompare {
    public static void main(String[] args) {
        // 문자열 생성 방식 ------
        // 리터럴("java") : 문자열 상수 풀에 저장함. 같은 값이면 하나를 공유함
        // new String("java") : 호출할 때마다 힙에 새 객체를 만듦
        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");

        // 주소값 확인
        System.out.printf("%X\n", System.identityHashCode((str1)));
        System.out.printf("%X\n", System.identityHashCode((str2)));
        System.out.printf("%X\n", System.identityHashCode((str3)));
        System.out.printf("%X\n", System.identityHashCode((str4)));
        System.out.println("--------------------------");

        // 주소값 비교 ------
        // == : 참조형에서는 두 변수의 주소값이 같은지 비교함
        System.out.println("str1 == str2 ? " + (str1 == str2));   // true  : 상수 풀의 같은 주소를 가리킴
        System.out.println("str3 == str4 ? " + (str3 == str4));   // false : 힙에 각각 만든 별도의 객체
        System.out.println("str1 == str3 ? " + (str1 == str3));   // false : 상수 풀과 힙으로 주소가 다름
        System.out.println("str2 == str4 ? " + (str2 == str4));   // false
        System.out.println("--------------------------");

        // 값 비교 ------
        // equals() : 주소와 상관없이 문자열 내용이 같은지 비교함. 문자열 비교에는 equals 를 사용
        System.out.println("str1 equals str2 ? " + str1.equals(str2));
        System.out.println("str3 equals str4 ? " + str3.equals(str4));
        System.out.println("str1 equals str3 ? " + str1.equals(str3));
        System.out.println("str2 equals str4 ? " + str2.equals(str4));
    }
}
