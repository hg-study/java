package Ch02Encapsulation;

// =======================================
// 프로필 문제
// 정보 은닉, 문자열 분리, 포함 여부와 일치 여부
// =======================================

// 문제 ------
// Profile 클래스를 완성하는 문제
// 1) 생성자 : 기본 생성자, 모든 인자를 받는 생성자, "홍길동,대구,프로그래머,컴퓨터공학" 을 ,로 잘라 저장하는 생성자
// 2) 멤버 변수를 은닉하고 getter, setter 와 toString 을 만듦
// 3) boolean isContain(String findstr) : findstr 이 name, addr, job, major 중 하나라도 포함되면 true
// 4) boolean isEquals(String str) : str 을 ,로 잘라 name, addr, job, major 와 모두 일치하면 true

class Profile
{
	// 속성
	private String name;
	private String addr;
	private String job;
	private String major;

	// 생성자
	// 1) 기본 생성자
	Profile() {}

	// 2) 모든 인자를 받는 생성자
	public Profile(String name, String addr, String job, String major) {
		this.name = name;
		this.addr = addr;
		this.job = job;
		this.major = major;
	}

	// 3) 하나의 문자열을 ,로 잘라 각 멤버에 저장하는 생성자
	Profile(String arg){
		String[] params = arg.split(",");
		this.name = params[0];
		this.addr = params[1];
		this.job = params[2];
		this.major = params[3];
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Profile [name=" + name + ", addr=" + addr + ", job=" + job + ", major=" + major + "]";
	}

	// 포함 여부 : 네 멤버 중 하나라도 findstr 을 포함하면 true
	boolean isContain(String findstr){
		if (this.name.contains(findstr)) return true;
		if (this.addr.contains(findstr)) return true;
		if (this.job.contains(findstr)) return true;
		if (this.major.contains(findstr)) return true;
		return false;
	}

	// 일치 여부 : 문자열을 ,로 잘라 name, addr, job, major 가 모두 같을 때만 true
	boolean isEquals(String str) {
		String params[] = str.split(",");

		if (
			this.name.equals(params[0]) &&
			this.addr.equals(params[1]) &&
			this.job.equals(params[2]) &&
			this.major.equals(params[3])
		) return true;

		return false;
	}
}


public class C06Profile {

	public static void main(String[] args) {
		Profile hong = new Profile("홍길동,대구,프로그래머,컴퓨터공학");
		System.out.println(hong.toString());
		System.out.println("길동 포함여부 : " + hong.isContain("길동"));       // true
		System.out.println("컴퓨터 포함여부 : " + hong.isContain("컴퓨터"));   // true
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,대구,프로그래머,컴퓨터공학"));  // true
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,울산,프로그래머,컴퓨터공학"));  // false
	}
}
