package Ch06AbstractInterface;

import java.util.Scanner;

// =======================================
// 추상 클래스 문제
// Converter 를 상속한 단위 변환기
// =======================================

// 문제 ------
// Converter 클래스를 상속받아 원화를 달러로 바꾸는 Won2Dollar 클래스를 작성하는 문제
// 실행 예) Won2Dollar toDollar = new Won2Dollar(1477.30);  // 1달러는 1477.30원
//          원을 달러로 바꿉니다.
//          원을 입력하세요>> 24000
//          변환 결과: 16.245...달러입니다
// 추가 : 섭씨를 화씨로 바꾸는 클래스도 작성함 (화씨 = 섭씨 x 1.8 + 32)
abstract class Converter {
	abstract protected double convert(double src);  // 변환 계산(src : 입력값)
	abstract protected String getSrcString();       // 입력 단위 이름
	abstract protected String getDestString();      // 출력 단위 이름

	protected double ratio; // 비율

	// run() : 흐름은 상위 클래스가 정하고, 단위 이름과 계산은 하위 클래스가 채우는 구조
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(getSrcString() + "을 " + getDestString() + "로 바꿉니다.");
		System.out.print(getSrcString() + "을 입력하세요>> ");
		double val = scanner.nextDouble();  // 입력받은 값
		double res = convert(val);          // 변환
		System.out.println("변환 결과: " + res + getDestString() + "입니다");
		scanner.close();
	}
}

// 원화 -> 달러
class Won2Dollar extends Converter{

    public Won2Dollar(double ratio) {
        this.ratio = ratio;
    }

    @Override
    protected double convert(double src) {
        return src/ratio;
    }

    @Override
    protected String getSrcString() {
        return "원";
    }

    @Override
    protected String getDestString() {
        return "달러";
    }

}

// 섭씨 -> 화씨
class Celsius2Fahrenheit extends Converter{

    @Override
    protected double convert(double src) {
        return (src * 1.8) + 32;
    }

    @Override
    protected String getSrcString() {
        return "섭씨(℃)";
    }

    @Override
    protected String getDestString() {
        return "화씨(℉)";
    }

}
public class C02Converter {

	public static void main(String[] args) {

		// Won2Dollar toDollar = new Won2Dollar(1477.30);
		// toDollar.run();

		Celsius2Fahrenheit test = new Celsius2Fahrenheit();
		test.run();

	}

}
