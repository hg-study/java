package Ch05Inheritance;

// =======================================
// 업캐스팅 연습 4
// 인터페이스 구현 클래스의 업캐스팅
// =======================================

// 인터페이스 ------
// 인터페이스(interface) : 구현할 메서드의 이름만 정해 두고 구현은 implements 한 클래스에 맡기는 설계도. 자세한 내용은 Ch06 에서 다룸
interface Playable {
    void play();
}

class Instrument implements Playable {
    public void play() {
        System.out.println("악기를 연주합니다");
    }
}

class Piano extends Instrument {
    public void play() {
        System.out.println("피아노를 연주합니다");
    }

    void tune() {
        System.out.println("피아노를 조율합니다");
    }
}

public class C14UpcastInterface {
    public static void main(String[] args) {
        System.out.println("=== 연습문제 4: 인터페이스 구현 ===");

        // 문제 ------
        // 1. Piano 인스턴스를 생성함
        // 2. 생성한 인스턴스를 Playable 인터페이스 타입으로 업캐스팅함
        // 3. 업캐스팅된 참조로 play() 를 호출함
        // 4. Instrument 클래스 타입으로 업캐스팅하고 play() 를 호출함
        // 5. 각 단계에서 tune() 호출을 시도함
        // 실행 결과 : 피아노를 연주합니다 / 피아노를 연주합니다

        Piano piano = new Piano();

        Playable p1 = piano;        // 인터페이스 타입으로 업캐스팅
        p1.play();                  // 재정의된 Piano 의 play 가 실행됨
        // p1.tune();               // Playable 에는 tune 이 없어 접근 불가

        Instrument p2 = piano;      // 상위 클래스 타입으로 업캐스팅
        p2.play();
        // p2.tune();               // Instrument 에도 tune 이 없어 접근 불가
        ((Piano) p2).tune();        // 다운캐스팅하면 호출 가능

    }
}
