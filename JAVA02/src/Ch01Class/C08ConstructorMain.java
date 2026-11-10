package Ch01Class;

// =======================================
// 생성자
// 기본 생성자, 매개변수 생성자, toString
// =======================================

// 생성자 ------
// 생성자 : 객체를 만들 때 한 번만 호출되어 필요한 공간을 만들고 초기값을 넣는 메서드
// 예) Scanner sc = new Scanner(System.in); 에서 Scanner(System.in) 부분
// 규칙 : 이름은 클래스 이름과 같고, 반환 자료형을 쓰지 않음. 만든 객체 안에서는 다시 호출할 수 없음
// 기본 생성자 : 클래스에 생성자를 쓰지 않으면 컴파일러가 자동으로 넣어 주는 생성자. 생성자를 하나라도 쓰면 넣어 주지 않음
class C08Simple{

    // 속성
    int n1;
    double n2;
    boolean n3;
    String n4;

    // 기본 생성자 ------
    C08Simple(){
        System.out.println("C08Simple()");
        this.n1 = 11;
        this.n2 = 22.22;
        this.n3 = true;
        this.n4 = "HELLO WORLD";
    }

    // 매개변수 생성자(직접 작성한 코드) ------
    // C08Simple(int n1, double n2, boolean n3, String n4){
    //     System.out.println("C08Simple(int n1, double n2, boolean n3, String n4)");
    //     this.n1 = n1;
    //     this.n2 = n2;
    //     this.n3 = n3;
    //     this.n4 = n4;
    // }

    // 매개변수 생성자(자동 생성) ------
    // 오른쪽 마우스 - 소스작업 - Generate Constructors using Fields... 로 자동 생성함
    public C08Simple(int n1, double n2, boolean n3, String n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    // toString 재정의
    @Override
    public String toString() {
        return "C08Simple [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
    }

}

public class C08ConstructorMain {
    public static void main(String[] args) {
        C08Simple ob1 = new C08Simple();                        // 기본 생성자 호출
        System.out.println(ob1);
        System.out.println("-----------------------");
        C08Simple ob2 = new C08Simple(10, 20.2, true, "TEST");  // 매개변수 생성자 호출
        System.out.println(ob2);

    }
}
