package Ch01Class;

// =======================================
// 메서드와 toString
// 기능을 가진 클래스와 객체 정보 출력
// =======================================

class C03Person {

    // 속성
    public String name;     // null(기본값)
    public int age;         // 0
    public float height;    // 0.0F
    public double weight;   // 0.0

    // 기능 ------
    // 메서드 : 객체가 수행하는 동작을 정의한 코드 블록. this 는 메서드를 호출한 객체 자신을 가리킴
    void talk() {System.out.printf("%s 님이 말합니다.%n", this.name);}
    void walk() {System.out.printf("%s 님이 걷습니다.%n", this.name);}
    String showInfo() {
        return "name  : " + this.name  +
               "\nage   : " + this.age   +
               "\nheight: " + this.height+
               "\nweight: " + this.weight;
    }

    // toString 재정의 ------
    // toString() : 객체의 정보를 문자열로 돌려주는 메서드. 재정의하지 않으면 주소값이 출력됨
    // 이클립스에서는 오른쪽 마우스 - 소스작업 - Generate toString 으로 자동 생성함
    @Override
    public String toString() {
        return "C03Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
    }
    
}

public class C03PersonMain {
    public static void main(String[] args) {
        C03Person hong = new C03Person();

        // 속성 저장
        hong.name   = "홍길동";
        hong.age    = 15;
        hong.height = 177.5f;
        hong.weight = 70.5;

        // 기능 사용
        hong.talk();
        hong.walk();
        System.out.println(hong.showInfo());

        // toString 으로 객체 속성 정보 확인
        System.out.println(hong.toString());
    }    

}
