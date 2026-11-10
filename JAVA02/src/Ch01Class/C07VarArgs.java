package Ch01Class;

// =======================================
// 가변 인자
// 개수가 정해지지 않은 매개변수 받기
// =======================================

class C07Simple{
    // 가변 인자 ------
    // 가변 인자 : 자료형 뒤에 ... 을 붙여 인자를 몇 개든 받는 매개변수. 메서드 안에서는 배열로 다룸
    int sum(int ...arg){
        System.out.println(arg);    // 배열의 주소값이 출력됨
        int s = 0;

        for(int item: arg){
            System.out.println(item);
            s+=item;
        }
        return s;
    }
}

public class C07VarArgs {
    public static void main(String[] args) {
        C07Simple obj = new C07Simple();
        int result = obj.sum(10,20,30);
        System.out.println("누적 합: " + result);
    }
}
