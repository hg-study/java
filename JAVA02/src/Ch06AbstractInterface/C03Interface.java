package Ch06AbstractInterface;

// =======================================
// 인터페이스
// 리모컨 인터페이스를 구현한 TV 와 라디오
// =======================================

// 인터페이스 ------
// 인터페이스(interface) : 클래스가 구현해야 할 메서드의 규약(계약)을 정의한 추상적인 타입
// implements : 클래스가 인터페이스를 구현할 때 쓰는 키워드. 클래스와 달리 여러 개를 동시에 구현할 수 있음(다중 상속)
// 자바 8 부터는 디폴트 메서드와 정적 메서드, 자바 9 부터는 private 메서드도 가질 수 있음

interface Remocon {

    void powerOn();     // 추상 메서드
    void powerOff();    // 추상 메서드

    int MAX_VOL = 100;	// 상수 : 인터페이스의 변수는 public static final 이 자동으로 붙음
    int MIN_VOL = 0;
    void setVolumn(int vol); // 추상 메서드

}

interface Browser {
    void SearchURL(String url);
}

class Tv implements Remocon {

	private int volumn;

    @Override
    public void powerOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void powerOff() {
        System.out.println("TV를 끕니다.");
    }

	// 볼륨 : 범위(0 ~ 100)를 벗어나면 최대값 또는 최소값으로 맞춤
	@Override
	public void setVolumn(int vol) {
		this.volumn = vol;

		if (MAX_VOL<vol) {
			this.volumn = MAX_VOL;
		}
		else if (MIN_VOL>vol) {
			this.volumn = MIN_VOL;
		}else {
			this.volumn = vol;
		}
		System.out.println("TV 현재 볼륨: " + this.volumn);
	}

}

// 상속과 구현을 함께 : Tv 를 상속하고 Browser 인터페이스를 추가로 구현함
class SmartTv extends Tv implements Browser{

	@Override
	public void SearchURL(String url) {
		System.out.println(url + "로 이동합니다.");
	}

}


class Radio implements Remocon {

	private int volumn;

    @Override
    public void powerOn() {
        System.out.println("Radio를 켭니다.");
    }

    @Override
    public void powerOff() {
        System.out.println("Radio를 끕니다.");
    }

	@Override
	public void setVolumn(int vol) {
		this.volumn = vol;

		if (MAX_VOL<vol) {
			this.volumn = MAX_VOL;
		}
		else if (MIN_VOL>vol) {
			this.volumn = MIN_VOL;
		}else {
			this.volumn = vol;
		}
		System.out.println("Radio 현재 볼륨: " + this.volumn);

	}

}

public class C03Interface {

	// 인터페이스 매개변수 : Remocon 형 변수에 Tv, Radio, SmartTv 어느 것이든 연결할 수 있음
	public static void TurnOn(Remocon remocon) {
		remocon.powerOn();
	}

	public static void TurnOff(Remocon remocon) {
		remocon.powerOff();
	}

	public static void ChangeVolumn(Remocon remocon, int vol) {
		remocon.setVolumn(vol);
	}

	public static void WebBrowser(Browser browser, String url) {
		browser.SearchURL(url);
	}

	public static void main(String[] args){

    	Tv tv = new Tv();
    	Radio radio = new Radio();
    	SmartTv smartTv = new SmartTv();

    	// 전원 켜기
    	TurnOn(tv);
    	TurnOn(radio);
    	TurnOn(smartTv);

    	// 볼륨 조절 : 200 은 최대값 100 으로 맞춰짐
    	ChangeVolumn(tv, 50);
    	ChangeVolumn(radio, 200);
    	ChangeVolumn(smartTv, 50);

    	// 브라우저 : Browser 를 구현한 SmartTv 만 가능
    	WebBrowser(smartTv, "https://naver.com");

    	// 전원 끄기
    	TurnOff(tv);
    	TurnOff(radio);
    	TurnOff(smartTv);

    }
}
