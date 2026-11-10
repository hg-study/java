package Ch05Inheritance;

// =======================================
// 상속 문제
// TV 를 상속한 ColorTV 와 확인 문제 답
// =======================================

// 문제 1 ------
// 아래 main() 과 실행 결과를 참고해 TV 를 상속받은 ColorTV 클래스를 작성하는 문제
class TV{

	String brandName;
	int year;
	int inch;

	public TV(String brandName, int year, int inch) {
		this.brandName = brandName;
		this.year = year;
		this.inch = inch;
	}

	public void show() {
		System.out.printf("%s에서 만든 %d년형 %d인치 TV 출력",this.brandName,this.year,this.inch);
	}

}
class ColorTV extends TV{

	String color;

	// 상위 클래스에 기본 생성자가 없으므로 super 로 값을 넘겨야 함
	public ColorTV(String brandName, int year,  int inch, String color) {
		super(brandName, year, inch);
		this.color = color;
	}

	public void printProperty() {
		System.out.printf("%s에서 만든 %d년형 %d인치 %s TV 출력",this.brandName,this.year,this.inch,this.color);
	}

}

public class C05ColorTV {

	public static void main(String[] args) {

		TV tv = new TV("삼성",2026,32);
		tv.show();
		System.out.println("\n---------------------");
		ColorTV myTV = new ColorTV("삼성",2026,32,"검정");
		myTV.printProperty();   // 삼성에서 만든 2026년형 32인치 검정 TV 출력

	}
}

// 확인 문제 답 : 이것이 자바다 7장 상속 ------
// https://velog.io/@kaihojun/%EC%9D%B4%EA%B2%83%EC%9D%B4-%EC%9E%90%EB%B0%94%EB%8B%A4-%EA%B0%9C%EC%A0%95%ED%8C%90-7%EC%9E%A5-%EC%83%81%EC%86%8D-%ED%99%95%EC%9D%B8-%EB%AC%B8%EC%A0%9C-%ED%92%80%EC%9D%B4
// 1) 1 : 자바는 다중 상속을 허용하지 않음
// 2) 2
// 3) 1
// 4) 4
// 5) 2
// 6) 상위 클래스 필드를 this.name = name; 으로 받는 것이 아니라 super(name); 으로 상위 생성자에 넘겨야 함
// 7) 출력 결과
//    Parent(String nation) call
//    Parent() call
//    Child(String name) call
//    Child() call
//    this(""); 는 같은 클래스의 다른 생성자를 호출하는 코드

// 확인 문제 답 : 명품 자바 상속 ------
// https://cs-ssupport.tistory.com/84
// 1) 상속은 확장이라 private 멤버도 전부 물려받음. this.a = 10 처럼 직접 접근은 안 되지만 public 메서드로 바꿀 수 있음
//    private int a;
//    public void set(int a) { this.a = a; }
// 2) private int a;
//    public void set(int a) { this.a = a; }
//    protected int b, c;
// 3) private int a;
//    public void set(int a) { this.a = a; }
//    protected int b, c;
//    public int d, e;
