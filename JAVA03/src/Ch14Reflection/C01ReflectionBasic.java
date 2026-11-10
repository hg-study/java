package Ch14Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// =======================================
// 리플렉션 기초
// 클래스 이름으로 필드, 생성자, 메서드 목록 확인
// =======================================

public class C01ReflectionBasic {

	public static void main(String[] args) throws ClassNotFoundException {

		// Class.forName(클래스 이름) : 이름으로 Class 객체를 얻음. 여기서는 자바 기본 클래스 String 의 정보를 확인함
		Class<?> clazz = Class.forName("java.lang.String");

		// 모든 필드 확인 ------
		// getDeclaredFields() : private 을 포함해 그 클래스에 선언된 필드를 모두 돌려줌
		Field[] fields = clazz.getDeclaredFields();
		for (Field field: fields)
			System.out.println(field);

		// 모든 생성자 확인 ------
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for(Constructor con: constructors) {
			System.out.println(con);
		}

		// 모든 메서드 확인 ------
		Method [] methods = clazz.getDeclaredMethods();
		for(Method m: methods)
			System.out.println(m);
	}
}
