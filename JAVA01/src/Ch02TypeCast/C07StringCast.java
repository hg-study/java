package Ch02TypeCast;

// =======================================
// 문자열과 형변환
// 문자열 연결 연산과 문자열을 숫자 자료형으로 바꾸는 Wrapper 메서드
// =======================================

public class C07StringCast {
    public static void main(String[] args) {

        // 문자열 연결 ------
        // 문자열과 + 연산을 하면 다른 피연산자도 문자열로 바뀌어 단순히 이어 붙음
        System.out.println("문자열1" + "문자열2");           // 문자열 + 문자열
        System.out.println("문자열1" + ',' + "문자열2");     // 문자열 + 문자 + 문자열
        System.out.println("문자열1" + 2);                   // 문자열 + 숫자. 숫자가 문자열로 바뀌어 연결됨
        System.out.println("문자열"+','+'!');
        System.out.println(','+'!'+"문자열");                // 문자 + 문자 + 문자열. 앞의 문자끼리는 유니코드 값을 더해(44+33=77) 숫자가 된 뒤 문자열과 연결됨
        System.out.println("문자열1"+"문자열2");

        // 문자열 -> 정수 ------
        // Wrapper 클래스 : 기본 자료형을 객체로 감싼 클래스. Integer, Double, Short 등이 있고 문자열을 숫자로 바꾸는 parse 메서드를 제공함
        // int n1 = "10";   문자열은 int에 바로 넣을 수 없어 컴파일 오류

        System.out.println("10"+"20");               // 1020. 문자열 연결
        int n1 = Integer.parseInt("10");             // Integer.parseInt() : 문자열을 int로 바꾸는 메서드. 웹 폼에서 전달받은 값은 모두 문자열이라 자주 씀
        int n2 = Integer.parseInt("20");
        System.out.println(n1+n2);                   // 30. 숫자끼리의 덧셈

        // 문자열 -> 실수 ------
        double n3 = Double.parseDouble("10.5");      // Double.parseDouble() : 문자열을 double로 바꾸는 메서드
        double n4 = Double.parseDouble("20.4");
        System.out.println(n3+n4);

        short n5 = Short.parseShort("5");            // Short.parseShort() : 문자열을 short로 바꾸는 메서드
        short n6 = Short.parseShort("6");

        System.out.println(n5+n6);

        // 문자열 -> 문자 ------
        String strValue = "A";                       // 문자열(String)은 객체 자료형이라 기본 자료형 char와 다름
        // char var = (char) strValue;   String은 char로 캐스팅할 수 없음
        char var = strValue.charAt(0);               // charAt(0) : 문자열의 첫 글자를 char로 꺼내는 메서드
    }
}
