package Ch05Inheritance;

// =======================================
// 계층 구조의 캐스팅
// instanceof 로 객체 종류를 확인하고 다운캐스팅
// =======================================

class A{
    int a;

    @Override
    public String toString() {
        return "A [a=" + a + "]";
    }
}

class B extends A{
    int b;

    @Override
    public String toString() {
        return "B [a=" + a + ", b=" + b + "]";
    }
}
class C extends A{
    int c;

    @Override
    public String toString() {
        return "C [a=" + a + ", c=" + c + "]";
    }
}
class D extends B{
    int d;

    @Override
    public String toString() {
        return "D [a=" + a + ", b=" + b + ", d=" + d + "]";
    }
}

class E extends B{
    int e;

    @Override
    public String toString() {
        return "E [a=" + a + ", b=" + b + ", e=" + e + "]";
    }
}
class F extends C{
    int f;

    @Override
    public String toString() {
        return "F [a=" + a + ", c=" + c + ", f=" + f + "]";
    }
}
class G extends C{
    int g;

    @Override
    public String toString() {
        return "G [a=" + a + ", c=" + c + ", g=" + g + "]";
    }
}

public class C07CastingHierarchy {

    // 최상위 A 형 매개변수로 모든 하위 객체를 받아 객체 종류에 따라 값을 채움
    // instanceof : 변수가 실제로 가리키는 객체가 해당 클래스(또는 그 하위)의 객체이면 true 인 연산자
    // 확인한 뒤 다운캐스팅해야 ClassCastException 없이 하위 멤버에 접근할 수 있음
    // (매개변수가 C 형이면 F 나 G 만 들어올 수 있으므로 C 아래 클래스만 확인하면 됨)
    public static void UpDownCastingTestFunc(A obj){

        obj.a = 100;

        if (obj instanceof B) {
            B down = (B)obj;
            down.b = 200;
        }
        if (obj instanceof C) {
            C down = (C)obj;
            down.c = 300;
        }
        if (obj instanceof D) {
            D down = (D)obj;
            down.d = 400;
        }
        if (obj instanceof E) {
            E down = (E)obj;
            down.e = 500;
        }
        if (obj instanceof F) {
            F down = (F)obj;
            down.f = 600;
        }
        if (obj instanceof G) {
            G down = (G)obj;
            down.g = 700;
        }

        System.out.println(obj);
    }
    public static void main(String[] args) {
        UpDownCastingTestFunc(new A());
        UpDownCastingTestFunc(new B());
        UpDownCastingTestFunc(new C());
        UpDownCastingTestFunc(new D());
        UpDownCastingTestFunc(new E());
        UpDownCastingTestFunc(new F());
        UpDownCastingTestFunc(new G());
    }
}
