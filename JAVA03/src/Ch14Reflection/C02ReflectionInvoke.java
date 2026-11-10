package Ch14Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

// =======================================
// 리플렉션으로 객체 만들기와 호출
// 생성자, 메서드, 필드를 이름으로 찾아 사용
// =======================================

class Simple{
	private String name;
	private int age;
	String addr;
	
	// 디폴트 생성자
	Simple(){}
	
	// 모든 인자 생성자
	public Simple(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	// getter and setter
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}

	// toString 재정의
	@Override
	public String toString() {
		return "Simple [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}	
}

public class C02ReflectionInvoke {
	
	// 클래스 정보만 받아 기본 생성자로 객체를 만들어 돌려주는 메서드. 어떤 클래스든 넘길 수 있어 프레임워크가 객체를 만들 때 쓰는 방식
	public static Object getObject(Class<?> clazz) throws Exception{
		
		// 디폴트 생성자
		Constructor con = clazz.getDeclaredConstructor(null);
		Object obj = con.newInstance(null);
		
		
		
		return obj;
	}
	

	public static void main(String[] args) throws Exception {
		
		// 생성자 호출
		Simple ob1 = new Simple();
		System.out.println("ob1: "+ob1);
		
		// 생성자 호출(with reflect)
		// 생성자 호출 ------
		// getConstructors() : public 생성자 목록, newInstance(값...) : 생성자를 호출해 객체를 만듦
		Class<?> clazz = Class.forName("Ch14Reflection.Simple");
		Constructor[] cons = clazz.getConstructors();
		for(Constructor con : cons)
			System.out.println("con: "+con);
		System.out.println("cons's length: " + cons.length);
		
		Constructor con = cons[0];
		Object ob2 = con.newInstance("홍길동",30,"대구");	
		System.out.println("ob2: "+ob2);
		
		// 메서드 호출(with reflect)
		System.out.println("----------");		
		// 메서드 호출 ------
		// getDeclaredMethod(이름, 매개변수 타입...) : 메서드를 찾음. invoke(객체, 값...) : 그 객체에서 메서드를 실행함
		Method setName = clazz.getDeclaredMethod("setName",String.class);
		Method getName = clazz.getDeclaredMethod("getName",null);
		
		setName.invoke(ob1, "남길동");
		System.out.println("setName ob1: " + ob1);
		System.out.println("getName ob1: " + getName.invoke(ob1, null));
		
		setName.invoke(ob2, "티모");
		System.out.println("setName ob2: " + ob2);
		System.out.println("getName ob2: " + getName.invoke(ob2, null));	
		System.out.println("----------");		
		
		// 필드 호출(with reflect)
		// 필드 접근 ------
		// getDeclaredField(이름) : 필드를 찾음. set(객체, 값) : 그 객체의 필드 값을 바꿈. private 필드는 setAccessible(true) 를 먼저 호출해야 접근할 수 있음
		Field addr = clazz.getDeclaredField("addr");
		addr.set(ob1, "창원");
		addr.set(ob2, "울산");
		System.out.println("ob1: " + ob1);		
		System.out.println("ob2: " + ob2);		
		
		System.out.println("----------");		
		System.out.println(getObject(Class.forName("Ch14Reflection.Simple")));
		System.out.println(getObject(Class.forName("Ch11ThreadChat.ServerMain")));
		
	}

}
