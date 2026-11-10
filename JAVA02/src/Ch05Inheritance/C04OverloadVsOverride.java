package Ch05Inheritance;

// =======================================
// 오버로딩과 오버라이딩 구분
// 상속 관계에서 같은 이름 메서드의 종류
// =======================================

class C04Super{

    int sum(int x, int y) {
        return x + y;
    }
    int sum(int x, int y, int z) {
        return x + y + z;
    }

}


class C04Sub extends C04Super{

    // 오버라이딩 : 상위 클래스와 헤더가 같고 본문만 다름
    int sum(int x, int y) {
        return x + y + 1;
    }

    // 오버라이딩
    int sum(int x, int y, int z) {
        return x+x+y+y+z+z;
    }

    // 오버로딩 : 매개변수 개수가 달라 새로 추가한 메서드
    int sum(int x, int y, int z, int h) {
        return x + y + z + h;
    }

    // 오버로딩 : 매개변수 자료형이 달라 새로 추가한 메서드
    int sum(int x, double y) {
        return (int)(x+y);
    }

    // 오버로딩 : 매개변수 개수와 자료형이 모두 달라 새로 추가한 메서드
    // 반환형(double)은 구분 기준이 아니며 헤더의 매개변수만 상위 클래스와 다르면 오버로딩임
    double sum(int x, double y, double z) {
        return x + y + z;
    }
}


public class C04OverloadVsOverride {
    public static void main(String[] args) {
        C04Sub sub = new C04Sub();
        System.out.println(sub.sum(1, 2));              // 4  : 오버라이딩한 메서드
        System.out.println(sub.sum(1, 2, 3));           // 12 : 오버라이딩한 메서드
        System.out.println(sub.sum(1, 2, 3, 4));        // 10 : 오버로딩한 메서드
        System.out.println(sub.sum(1, 2.5));            // 3  : 오버로딩한 메서드
        System.out.println(sub.sum(1, 2.5, 3.5));       // 7.0: 오버로딩한 메서드
    }
}
