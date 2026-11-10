package Ch05Inheritance;

// =======================================
// super 생성자
// 상위 클래스 생성자를 골라 호출하기
// =======================================

class C02Point2D{
    int x;
    int y;

    // 기본 생성자
    C02Point2D(){
        System.out.println("Point2D 디폴트생성자 호출!");
    }

    C02Point2D(int x) {
        this.x = x;
        System.out.println("Point2D(int x) 생성자 호출!");
    }

    C02Point2D(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Point2D(int x, int y) 생성자 호출!");
    }

    //toString() 재정의
    @Override
    public String toString() {
        return "Point2D [x=" + x + ", y=" + y + "]";
    }

}

// super() ------
// super(...) : 상위 클래스의 생성자를 호출하는 문법. 생성자의 첫 줄에 쓰며, 쓰지 않으면 super() 가 자동으로 들어감
class C02Point3D extends C02Point2D{

    int z;

    C02Point3D(){
        super();    // 상위 클래스 기본 생성자 호출(작성하지 않아도 자동으로 들어감)
        System.out.println("Point3D 디폴트생성자 호출!");
    }

    C02Point3D(int x){
        // super.x = x;     // 상위 클래스 필드에 직접 대입하는 방법
        // this.x = x;      // 물려받은 필드이므로 this 로도 가능
        super(x);           // 상위 클래스 생성자에 값을 넘기는 방법을 주로 사용함
        System.out.println("Point3D(int x) 생성자 호출!");
    }

    C02Point3D(int x, int y){
        super(x, y);
        System.out.println("Point3D(int x, int y) 생성자 호출!");
    }

    C02Point3D(int x, int y, int z){
        super(x, y);
        this.z = z;
        System.out.println("Point3D(int x, int y, int z) 생성자 호출!");
    }

	@Override
	public String toString() {
		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}
}

public class C02InheritanceSuper {
    public static void main(String[] args) {
        // 출력 순서 : 상위 생성자(x, y) -> 하위 생성자(x, y, z)
        C02Point3D ob = new C02Point3D(10,20, 30);

        System.out.println(ob);
    }
}
