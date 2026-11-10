package Ch01Class;

// =======================================
// 커피 주문 문제
// 손님과 카페사장 객체의 거래
// =======================================

// 문제 ------
// 손님이 카페사장에게 커피를 주문하는 상황을 두 클래스로 만드는 문제
//
// 클래스 : 손님 (Customer)
// 속성   : 보유금액 (myMoney : int), 커피잔수 (coffeeCnt : int)
// 기능   : 주문하기 (카페사장, 보유금액의 일부)  ->  order(CafeOwner owner, int money) : void
//
// 클래스 : 카페사장 (CafeOwner)
// 속성   : 보유금액 (myMoney : int), 커피재고 (coffeeCnt : int), 커피가격 (price : int)
// 기능   : 제조하기 (손님의 돈) -> 커피잔수 반환  ->  make(int money) : int

class Customer{
	private int myMoney;
	private int coffeeCnt;

	public Customer(int myMoney, int coffeeCnt){
		this.myMoney = myMoney;
		this.coffeeCnt = coffeeCnt;
	}

	@Override
	public String toString(){
		return "Customer [myMoney=" + myMoney + ", coffeeCnt=" + coffeeCnt + "]";
	}

	// 주문하기 ------
	// 카페사장에게 금액을 넘기고, 돌려받은 커피 잔수를 내 잔수에 더함
	public void order(CafeOwner owner, int money){
		int orderCnt = owner.make(money);
		myMoney -= money;
		coffeeCnt += orderCnt;
	}

}

class CafeOwner{
	private int myMoney;
	private int coffeeCnt;
	private int price;

	public CafeOwner(int myMoney, int coffeeCnt, int price){
		this.myMoney = myMoney;
		this.coffeeCnt = coffeeCnt;
		this.price = price;
	}

	@Override
	public String toString() {
		return "CafeOwner [myMoney=" + myMoney + ", coffeeCnt=" + coffeeCnt + ", price=" + price + "]";
	}

	// 제조하기 ------
	// 받은 금액을 보유 금액에 더하고, 금액에 맞는 잔수를 계산해 재고에서 빼고 돌려줌
	public int make(int money){
		this.myMoney += money;
		int makeCnt = money/price;
		this.coffeeCnt -= makeCnt;
		return makeCnt;
	}

}

public class C14CafeOrder {

	public static void main(String[] args) {

		Customer hong = new Customer(20000, 0);
		CafeOwner owner = new CafeOwner(500000, 100, 4500);

		// 손님이 주문을 요청함
		hong.order(owner, 9000);

		System.out.println(hong);
		System.out.println(owner);
	}

}
