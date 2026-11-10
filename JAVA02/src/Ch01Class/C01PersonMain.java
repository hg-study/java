package Ch01Class;

// =======================================
// 객체 생성과 속성 사용
// 클래스를 다른 파일에서 불러 객체 만들기
// =======================================

public class C01PersonMain {
    public static void main(String[] args) {

        // 객체 생성 ------
        // 클래스명 참조변수 = new 클래스명(); 형태로 객체를 만듦
        C01Person hong = new C01Person();

        // 기본값 출력 : 값을 넣기 전이라 null, 0, 0.0 이 출력됨
        System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);

        // 속성 저장 ------
        // 참조변수.속성 으로 객체 안의 값을 바꿈
        hong.name   = "홍길동";
        hong.age    = 15;
        hong.height = 177.5f;
        hong.weight = 70.5;
        System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);
        
    }    
}
