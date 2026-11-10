package Ch08JDBC;

// =======================================
// DTO (충전소)
// 도시가스충전소 테이블 한 행을 담는 클래스
// =======================================

// DTO(Data Transfer Object) : 테이블 한 행의 데이터를 담아 옮기는 클래스. 필드 이름은 테이블 컬럼명(한글)과 같게 둠
public class C06ChargeStationDto {

	private int 순번;
	private String 행정구역;
	private String 지사;
	private String 시설명;
	private int 우편번호;
	private String 주소;
	
	// 기본 생성자
	C06ChargeStationDto(){}
	// 모든 인자 생성자
	public C06ChargeStationDto(int 순번, String 행정구역, String 지사, String 시설명, int 우편번호, String 주소) {
		super();
		this.순번 = 순번;
		this.행정구역 = 행정구역;
		this.지사 = 지사;
		this.시설명 = 시설명;
		this.우편번호 = 우편번호;
		this.주소 = 주소;
	}	
	// getter and setter
		
	public int get순번() {
		return 순번;
	}
	public void set순번(int 순번) {
		this.순번 = 순번;
	}
	public String get행정구역() {
		return 행정구역;
	}
	public void set행정구역(String 행정구역) {
		this.행정구역 = 행정구역;
	}
	public String get지사() {
		return 지사;
	}
	public void set지사(String 지사) {
		this.지사 = 지사;
	}
	public String get시설명() {
		return 시설명;
	}
	public void set시설명(String 시설명) {
		this.시설명 = 시설명;
	}
	public int get우편번호() {
		return 우편번호;
	}
	public void set우편번호(int 우편번호) {
		this.우편번호 = 우편번호;
	}
	public String get주소() {
		return 주소;
	}
	public void set주소(String 주소) {
		this.주소 = 주소;
	}
		

	// toString 재정의
	@Override
	public String toString() {
		return "C06CargeDto [순번=" + 순번 + ", 행정구역=" + 행정구역 + ", 지사=" + 지사 + ", 시설명=" + 시설명 + ", 우편번호=" + 우편번호 + ", 주소="
				+ 주소 + "]";
	}

	public static void main(String[] args) {
		
	}
	
}
