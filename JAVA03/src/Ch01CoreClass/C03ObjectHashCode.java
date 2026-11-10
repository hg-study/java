package Ch01CoreClass;

import java.util.Objects;

// =======================================
// Object 클래스의 hashCode
// equals 를 재정의하면 hashCode 도 함께 재정의
// =======================================

class C03Simple{
    int n;
    C03Simple (int n){this.n = n;}

    // equals 재정의
    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof C03Simple) {
    		C03Simple down = (C03Simple)obj;
    		return down.n == this.n;
    	}
    	return false;
    }

	// hashCode 재정의 ------
	// hashCode() : 객체를 구별하는 정수값을 돌려주는 메서드. 기본 동작은 객체의 주소를 기반으로 한 값
	// equals 가 true 인 두 객체는 hashCode 도 같아야 하므로 equals 에서 비교한 필드로 값을 만듦
	// HashSet, HashMap 같은 컬렉션이 hashCode 와 equals 를 함께 사용해 같은 객체인지 판단함
	@Override
	public int hashCode() {
		return Objects.hash(this.n);
	}

}

public class C03ObjectHashCode {
    public static void main(String[] args) {
        C03Simple ob1 = new C03Simple(10);
        C03Simple ob2 = new C03Simple(20);
        C03Simple ob3 = new C03Simple(10);
        System.out.println(ob1);                    // toString 을 재정의하지 않아 클래스명@해시코드(16진수)
        System.out.printf("%x\n", ob1.hashCode());
        System.out.printf("%x\n", ob2.hashCode());
        System.out.printf("%x\n", ob3.hashCode());  // ob1 과 같은 값
    }
}
