package Ch05Inheritance;

// =======================================
// 상속 문제
// 사람을 상속한 아르바이트와 정규직
// =======================================

// 문제 ------
// 공통 속성(이름, 나이, 주소, 금액)을 People 에 두고 Parttimer 와 Regular 가 상속하게 만드는 문제
// 이름은 private 라 하위 클래스에서 직접 쓸 수 없으므로 생성자의 super 로만 값을 넘김
class C09People {

    private String name;
    int age;
    String addr;
    int money;

    C09People(){}

    C09People(String name, int age, String addr, int money) {
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.money = money;
    }

    @Override
    public String toString() {
        return "People [name=" + name + ", age=" + age + ", addr=" + addr + ", money=" + money + "]";
    }

}

class C09Parttimer extends C09People {

    C09Parttimer(String name, int age, String addr, int money) {
        super(name, age, addr, money);
    }

    // age 는 접근 한정자가 없는(default) 필드라 같은 패키지의 하위 클래스에서 바로 바꿀 수 있음
    public void setAge(int newAge) {
        age = newAge;
    }

}

class C09Regular extends C09People {

    C09Regular(String name, int age, String addr, int money) {
        super(name, age, addr, money);
    }
}

public class C09EmployeePractice {

	public static void main(String[] args) {
		C09Parttimer emp1 = new C09Parttimer("홍길동", 25, "대구", 20000);
		emp1.setAge(100);

		C09Regular emp2 = new C09Regular("서길동", 45, "울산", 50000000);
		System.out.println(emp1);
		System.out.println(emp2);
	}
}
