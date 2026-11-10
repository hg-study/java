package Ch01Class;

// =======================================
// 클래스의 구성 요소
// 외부 구성 요소와 내부 구성 요소, TV 클래스 문제
// =======================================

// 클래스 외부 구성 요소 ------
// 패키지(package) : 클래스를 묶어 관리하는 물리적 폴더
// 임포트(import) : 다른 패키지의 클래스를 가져다 쓰기 위한 선언
// 외부 클래스(external class) : public 클래스 바깥에 작성한 독립된 보조 클래스

// 클래스 내부 구성 요소 ------
// 필드(field) : 객체의 속성값을 저장하는 변수(힙 영역에 저장)
// 메서드(method) : 객체의 기능을 정의한 코드 블록
// 생성자(constructor) : 객체 생성 시 필드를 초기화하는 특수 블록
// 내부 클래스(inner class) : 클래스 안에 선언한 종속 클래스
// this : 현재 실행 중인 객체 자기 자신의 주소값
// this() : 같은 클래스의 다른 생성자를 호출하는 문법

// TV 클래스 ------
// 제조사, 연도, 인치를 생성자로 받아 show() 로 출력하는 문제
class TV {
	// 속성
	String brand;
	int year;
	int inch;

	// 생성자
	public TV(String brand, int year, int inch){
		this.brand = brand;
        this.year = year;
        this.inch = inch;
	}

	public void show() {
	System.out.println(brand + "에서 만든 " + year + "년형 " + inch + "인치 TV");
	}

}


public class C09ClassStructure {

	public static void main(String[] args) {

		TV myTV = new TV("LG", 2017, 32);
		myTV.show();    // LG에서 만든 2017년형 32인치 TV 가 출력됨
	}
}

// 참고 문제 ------
// https://scksk.tistory.com/6
// https://security-nanglam.tistory.com/213
// https://iu-corner.tistory.com/entry/JAVA-%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%97%B0%EC%8A%B5-%EB%AC%B8%EC%A0%9C-%EB%AA%A8%EC%9D%8C-1
