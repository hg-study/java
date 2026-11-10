package Ch01Class;

// =======================================
// 사과 구매 문제
// 구매자와 판매자 객체가 서로 메서드를 호출해 거래하기
// =======================================

// 문제 ------
// 고객이 사과장수에게 사과를 구매하는 상황을 두 클래스로 만드는 문제
//
// 클래스 : 고객 (Buyer)
// 속성   : 보유금액 (myMoney : int), 사과개수 (appleCnt : int)
// 기능   : 구매하기 (사과장수, 보유 금액의 일부)  ->  pay(Seller seller, int money) : void
//
// 클래스 : 사과장수 (Seller)
// 속성   : 보유금액 (myMoney : int), 사과개수 (appleCnt : int), 사과가격 (price : int)
// 기능   : 판매하기 (구매자의 돈) -> 사과개수 반환  ->  sales(int money) : int

class Buyer {

    // 속성
    private int myMoney;
    private int appleCnt;

    // 생성자
    public Buyer(int myMoney, int appleCnt) {
        super();
        this.myMoney = myMoney;
        this.appleCnt = appleCnt;
    }

    // 구매하기 ------
    // 판매자에게 구매 금액을 넘기고, 판매자가 돌려준 사과 개수를 내 사과 개수에 더함
    // 보유 금액보다 큰 금액을 요청하면 가진 돈만큼만 사용함
    public void pay(Seller seller, int money) {

        int receivedAppCnt;

        if (myMoney<money){
            receivedAppCnt = seller.sales(myMoney);
            myMoney = 0;
        }else{
            receivedAppCnt = seller.sales(money);
            myMoney-=money;     // 내 돈에서 구매 금액만큼 차감
        }
        this.appleCnt += receivedAppCnt;
    }

    @Override
    public String toString() {
        return "Buyer [myMoney=" + myMoney + ", appleCnt=" + appleCnt + "]";
    }
}

class Seller {

    // 속성
    private int myMoney;
    private int appleCnt;
    private int price;

    // 판매하기 ------
    // 받은 금액을 보유 금액에 더하고, 금액에 맞는 사과 개수를 계산해 재고에서 빼고 돌려줌
    // 재고보다 많은 개수를 요청하는지 검증하는 코드는 아직 없음
    public int sales(int money){
        this.myMoney += money;
        int calAppCnt = money/price;
        appleCnt -= calAppCnt;
        return calAppCnt;
    }

    public Seller(int myMoney, int appleCnt,int price) {
        super();
        this.myMoney = myMoney;
        this.appleCnt = appleCnt;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Seller [myMoney=" + myMoney + ", appleCnt=" + appleCnt + ", price=" + price + "]";
    }

}

public class C12AppleShop {
    public static void main(String[] args) {

        // 고객
        Buyer hong = new Buyer(100000, 0);
        Buyer nam = new Buyer(50000, 0);

        // 사과장수
        Seller seller1 = new Seller(10000, 100, 1000);

        // 고객이 사과장수에게 구매를 요청함
        hong.pay(seller1, 30000);
        nam.pay(seller1, 10000);

        System.out.println(hong);
        System.out.println(nam);
        System.out.println(seller1);

    }
}
