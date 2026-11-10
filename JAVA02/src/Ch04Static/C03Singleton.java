package Ch04Static;

// =======================================
// 싱글톤 패턴
// 객체를 하나만 만들어 공유하기
// =======================================

class Company {

    int n1;
    int n2;

    // 싱글톤 패턴 ------
    // 싱글톤 패턴 : 객체 생성을 제한해 하나의 객체만 만들고 공유하는 디자인 패턴
    // private 생성자 : 외부에서 new 로 객체를 만들 수 없게 막음
    // static instance : 만들어진 유일한 객체의 주소를 저장함
    // getInstance() : 객체가 없으면 힙에 새로 만들어 주소를 저장하고, 있으면 저장된 주소를 돌려줌
    private static Company instance;
    private Company() {}

    public static Company getInstance(){
        if(instance == null){
            instance = new Company();
        }
        return instance;
    }

    // toString 재정의
    @Override
    public String toString() {
        return "Company [n1=" + n1 + ", n2=" + n2 + "]";
    }

}


public class C03Singleton {
    public static void main(String[] args) {
        // 두 변수가 같은 객체를 가리키므로 한쪽의 변경이 다른 쪽에도 보임
        Company com1 = Company.getInstance();
        Company com2 = Company.getInstance();

        com1.n1=100;
        com2.n2=200;
        System.out.println("com1: "+com1);
        System.out.println("com2: "+com2);
    }
}
