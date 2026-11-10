package Ch01Class;

// =======================================
// 외부 클래스
// 한 파일에 클래스를 함께 선언하는 방법
// =======================================

// 외부 클래스 ------
// 외부 클래스 : public 클래스와 같은 파일의 바깥에 선언한 보조 클래스. 파일 이름과 같은 클래스만 public 으로 쓸 수 있음
class C02Person {

    // 속성
    public String name;     // null(기본값)
    public int age;         // 0
    public float height;    // 0.0F
    public double weight;   // 0.0

}


public class C02PersonMain {
    public static void main(String[] args) {
        C02Person hong = new C02Person();
        System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);

        hong.name   = "홍길동";
        hong.age    = 15;
        hong.height = 177.5f;
        hong.weight = 70.5;
        System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);
        
    }    

}
