package Ch02Encapsulation;

// =======================================
// this 와 this()
// 멤버 변수 구분과 다른 생성자 호출
// =======================================

// this ------
// this : 생성된 객체 자기 자신의 위치 정보(메모리 주소, 해시코드값)를 가리키는 예약어
// this.멤버변수명 : 멤버 변수와 같은 이름의 지역 변수(매개변수)를 구별할 때 사용
// this() : 오버로딩된 다른 생성자를 호출할 때 사용. 생성자 안의 첫 줄에만 쓸 수 있음

class C03Simple{

    // 속성
    int x;
    int y;

    // 기본 생성자 : this(10,10) 으로 아래의 x, y 생성자에 초기값을 넘김
    public C03Simple() {
        this(10,10);
        System.out.println("C03Simple() 호출!");
    }
    // x만 받는 생성자 : y 는 10 으로 고정
    public C03Simple(int x) {
        this(x,10);
        System.out.println("C03Simple(int x) 호출!");
    }

    // x, y 둘 다 받는 생성자 : 실제로 필드를 초기화함
    public C03Simple(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("C03Simple(int x, int y) 호출!");
    }

    @Override
    public String toString() {
        return "C03Simple [x=" + x + ", y=" + y + "]";
    }

    // 기능 : 객체 자기 자신을 반환함
    public C03Simple getThis() {
        return this;
    }

}

public class C03This {
    public static void main(String[] args) {
        // 생성자 호출 순서 : 가장 안쪽 생성자(x, y)가 먼저 끝나고 바깥 생성자가 이어서 끝남
        C03Simple ob1 = new C03Simple();
        // System.out.println("ob1: " + ob1);
        // System.out.println("ob1: " + ob1.getThis() );     // ob1 과 같은 객체가 출력됨

        System.out.println("--------------");
        C03Simple ob2 = new C03Simple(11);
        System.out.println("--------------");
        C03Simple ob3 = new C03Simple(22,33);
        System.out.println("--------------");
        System.out.println(ob1);
        System.out.println(ob2);
        System.out.println(ob3);


    }
}
