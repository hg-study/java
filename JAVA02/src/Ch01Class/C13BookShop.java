package Ch01Class;

// =======================================
// 책 구매 문제
// 학생과 서점주인 객체의 거래
// =======================================

// 문제 ------
// 학생이 서점주인에게 책을 구매하는 상황을 두 클래스로 만드는 문제
//
// 클래스 : 학생 (Student)
// 속성   : 보유금액 (myMoney : int), 책개수 (bookCnt : int)
// 기능   : 구매하기 (서점주인, 보유금액의 일부)  ->  buy(BookSeller seller, int money) : void
//
// 클래스 : 서점주인 (BookSeller)
// 속성   : 보유금액 (myMoney : int), 책개수 (bookCnt : int), 책가격 (price : int)
// 기능   : 판매하기 (구매자의 돈) -> 책개수 반환  ->  sell(int money) : int

class Student{
	private int myMoney;
	private int bookCnt;

	public Student(int myMoney, int bookCnt){
        super();
		this.myMoney = myMoney;
		this.bookCnt = bookCnt;
	}

	@Override
	public String toString(){
		return "Student [myMoney=" + myMoney + ", bookCnt=" + bookCnt + "]";
	}

	// 구매하기 ------
	// 서점주인에게 금액을 넘기고, 돌려받은 책 개수를 내 책 개수에 더함
	public void buy(BookSeller seller, int money){
		int buybookCnt = seller.sell(money);
		myMoney -= money;           // 구매 금액만큼 내 돈 차감
		bookCnt += buybookCnt;
	}

}

class BookSeller{
	private int myMoney;
	private int bookCnt;
	private int price;

	public BookSeller(int myMoney, int bookCnt, int price){
        super();
		this.myMoney = myMoney;
		this.bookCnt = bookCnt;
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookSeller [myMoney=" + myMoney + ", bookCnt=" + bookCnt + ", price=" + price + "]";
	}

	// 판매하기 ------
	// 받은 금액을 보유 금액에 더하고, 금액에 맞는 책 권수를 계산해 재고에서 빼고 돌려줌
	public int sell(int money){
		this.myMoney += money;
		int buyBookCnt = money/price;
		this.bookCnt -= buyBookCnt;
		return buyBookCnt;
	}

}

public class C13BookShop {

	public static void main(String[] args) {

		Student hong = new Student(50000,0);
		BookSeller seller = new BookSeller(2000000, 50, 10000);

		// 학생이 구매를 요청함
		hong.buy(seller, 30000);

		System.out.println(hong);
		System.out.println(seller);
	}

}
