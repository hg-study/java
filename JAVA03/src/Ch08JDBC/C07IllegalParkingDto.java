package Ch08JDBC;

// =======================================
// DTO (불법 주정차)
// 불법주정차 위반 정보 테이블 한 행을 담는 클래스
// =======================================

// DTO : 테이블 한 행의 데이터를 담는 클래스. 필드 이름은 테이블 컬럼명(한글)과 같게 둠
public class C07IllegalParkingDto {

	private String 위반구분;
	private String 위반일시;
	private String 위반장소;
	private String 과태료부과일자;
	private String 데이터기준일자;
	
	// 기본 생성자
	C07IllegalParkingDto(){}
	// 모든 인자 생성자
	public C07IllegalParkingDto(String 위반구분, String 위반일시, String 위반장소, String 과태료부과일자, String 데이터기준일자) {
		super();
		this.위반구분 = 위반구분;
		this.위반일시 = 위반일시;
		this.위반장소 = 위반장소;
		this.과태료부과일자 = 과태료부과일자;
		this.데이터기준일자 = 데이터기준일자;
	}
	
	// getter and setter
		

	public String get위반구분() {
		return 위반구분;
	}
	public void set위반구분(String 위반구분) {
		this.위반구분 = 위반구분;
	}
	public String get위반일시() {
		return 위반일시;
	}
	public void set위반일시(String 위반일시) {
		this.위반일시 = 위반일시;
	}
	public String get위반장소() {
		return 위반장소;
	}
	public void set위반장소(String 위반장소) {
		this.위반장소 = 위반장소;
	}
	public String get과태료부과일자() {
		return 과태료부과일자;
	}
	public void set과태료부과일자(String 과태료부과일자) {
		this.과태료부과일자 = 과태료부과일자;
	}
	public String get데이터기준일자() {
		return 데이터기준일자;
	}
	public void set데이터기준일자(String 데이터기준일자) {
		this.데이터기준일자 = 데이터기준일자;
	}
	
	// toString 재정의

	@Override
	public String toString() {
		return "C07IllegalParkingDto [위반구분=" + 위반구분 + ", 위반일시=" + 위반일시 + ", 위반장소=" + 위반장소 + ", 과태료부과일자=" + 과태료부과일자
				+ ", 데이터기준일자=" + 데이터기준일자 + "]";
	}

	public static void main(String[] args) {
		
	}

	
}
