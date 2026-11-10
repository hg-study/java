package Ch01Class;

// =======================================
// 영화표 예매 문제
// 관객과 매표원 객체의 거래
// =======================================

// 문제 ------
// 관객이 매표원에게 영화표를 예매하는 상황을 두 클래스로 만드는 문제
//
// 클래스 : 관객 (Audience)
// 속성   : 보유금액 (myMoney : int), 티켓개수 (ticketCnt : int)
// 기능   : 예매하기 (매표원, 보유금액의 일부)  ->  reserve(TicketSeller seller, int money) : void
//
// 클래스 : 매표원 (TicketSeller)
// 속성   : 보유금액 (myMoney : int), 티켓재고 (ticketCnt : int), 티켓가격 (price : int)
// 기능   : 발권하기 (관객의 돈) -> 티켓개수 반환  ->  issue(int money) : int

class Audience{
	private int myMoney;
	private int ticketCnt;

	public Audience(int myMoney, int ticketCnt){
		this.myMoney = myMoney;
		this.ticketCnt = ticketCnt;
	}

	@Override
	public String toString(){
		return "Audience [myMoney=" + myMoney + ", ticketCnt=" + ticketCnt + "]";
	}

	// 예매하기 ------
	// 매표원에게 금액을 넘기고, 돌려받은 티켓 개수를 내 티켓 개수에 더함
	public void reserve(TicketSeller seller, int money){
		int issued = seller.issue(money);
		myMoney -= money;
		ticketCnt += issued;
	}

}

class TicketSeller{
	private int myMoney;
	private int ticketCnt;
	private int price;

	public TicketSeller(int myMoney, int ticketCnt, int price){
		this.myMoney = myMoney;
		this.ticketCnt = ticketCnt;
		this.price = price;
	}

	@Override
	public String toString() {
		return "TicketSeller [myMoney=" + myMoney + ", ticketCnt=" + ticketCnt + ", price=" + price + "]";
	}

	// 발권하기 ------
	// 받은 금액을 보유 금액에 더하고, 금액에 맞는 티켓 개수를 계산해 재고에서 빼고 돌려줌
	public int issue(int money){
		this.myMoney += money;
		int issuedCnt = money/price;
		this.ticketCnt -= issuedCnt;
		return issuedCnt;
	}

}

public class C15TicketReserve {

	public static void main(String[] args) {

		Audience hong = new Audience(30000, 0);
		TicketSeller seller = new TicketSeller(1000000, 200, 12000);

		// 관객이 예매를 요청함
		hong.reserve(seller, 24000);

		System.out.println(hong);
		System.out.println(seller);
	}

}
