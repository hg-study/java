package Ch01CoreClass;

// =======================================
// Object 클래스의 equals
// 주소 비교를 값 비교로 재정의
// =======================================

class C02Simple{
    int n;
    C02Simple (int n){this.n = n;}

    // equals 재정의 ------
    // equals() : 두 객체가 같은지 비교하는 메서드. 기본 동작은 주소값 비교(==)이므로 필드 값을 비교하도록 재정의함
    // ob1.equals(ob2) 로 호출하면 매개변수 Object obj 에 ob2 가 업캐스팅되어 들어오므로 다운캐스팅 후 비교함
    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof C02Simple) {
    		C02Simple down = (C02Simple)obj;
    		return down.n == this.n;
    	}
    	return false;
    }

}

public class C02ObjectEquals {
    public static void main(String[] args) {
        C02Simple ob1 = new C02Simple(10);
        C02Simple ob2 = new C02Simple(20);
        C02Simple ob3 = new C02Simple(10);

        System.out.println(ob1.equals(ob2));    // false
        System.out.println(ob1.equals(ob3));    // true  : 주소는 달라도 n 이 같음
        System.out.println(ob2.equals(ob3));    // false
    }
}
