package Ch02Encapsulation;

// =======================================
// 정보 은닉
// 접근 한정자와 getter, setter
// =======================================

// 접근 한정자 ------
// 접근 한정자 : 클래스와 멤버의 접근 범위를 제한하는 예약어
// public : 모든 클래스에서 접근 가능
// protected : 같은 패키지이거나 상속 관계인 클래스에서 접근 가능
// default(기본) : 아무것도 쓰지 않은 상태. 같은 패키지의 클래스에서 접근 가능
// private : 해당 클래스 안에서만 접근 가능

class C01Person{
    // 속성 : 직접 접근하지 못하도록 private 로 숨김
    private String name;
    private int age;
    private String addr;

    // 생성자(모든 인자를 받는) ------
    // 이클립스 자동 생성 : 소스작업 - Generate Constructors using Fields...
    public C01Person(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    // getter, setter ------
    // 정보 은닉 : 필드를 private 로 숨기고 getter(값 읽기)와 setter(값 쓰기) 메서드로만 접근하게 하는 방법
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString 재정의 ------
    // 이클립스 자동 생성 : 소스작업 - Generate toString()...
    @Override
    public String toString() {
        return "C01Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
    }
}

public class C01InfoHiding {
    public static void main(String[] args) {
        C01Person ob = new C01Person("홍길동",55,"대구");

        // ob.name= "남길동";    // private 이라 직접 접근할 수 없음
        ob.setName("남길동");    // setter 를 만들어 호출해야 바꿀 수 있음

        System.out.println(ob);

    }
}
