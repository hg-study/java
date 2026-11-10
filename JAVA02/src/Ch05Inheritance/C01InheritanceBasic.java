package Ch05Inheritance;

// =======================================
// 상속 기초
// extends 와 기본 생성자 호출 순서
// =======================================

class C01Point2D{
    int x;
    int y;

    // 기본 생성자
    C01Point2D(){
        System.out.println("Point2D 디폴트생성자 호출!");
    }

    //toString() 재정의
    @Override
    public String toString() {
        return "Point2D [x=" + x + ", y=" + y + "]";
    }

}

// 상속 ------
// extends : 상위 클래스를 지정해 속성(x, y)과 기능을 물려받음. 하위 클래스는 z 를 추가함
class C01Point3D extends C01Point2D{

    int z;

    // 하위 클래스 객체를 만들면 상위 클래스의 기본 생성자가 먼저 호출됨
    C01Point3D(){
        System.out.println("Point3D 디폴트생성자 호출!");
    }

	@Override
	public String toString() {
		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}
}

public class C01InheritanceBasic {
    public static void main(String[] args) {

        C01Point3D ob = new C01Point3D();
        ob.x=10;    // 물려받은 속성
        ob.y=20;
        ob.z=30;    // 추가한 속성

        System.out.println(ob);

    }
}
