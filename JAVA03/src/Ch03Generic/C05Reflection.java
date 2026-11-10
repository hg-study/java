package Ch03Generic;

import java.lang.reflect.Field;

// =======================================
// 리플렉션 확인
// 클래스의 필드 이름과 자료형 읽기
// =======================================

// 리플렉션 ------
// Class.forName(클래스 이름) : 클래스 이름으로 Class 객체를 얻음
// getDeclaredFields() : 클래스에 선언된 모든 필드를 Field 배열로 돌려줌 (private 포함)
class RefTarget{
	private String a;
	private int b;
}
public class C05Reflection {

	public static void main(String[] args) throws ClassNotFoundException {
		// RefTarget.class 를 문자열로 바꾸면 "class Ch03Generic.RefTarget" 이라 공백 뒤 부분이 클래스 이름이 됨
		Class<?> clazz = Class.forName(String.valueOf(RefTarget.class).split(" ")[1]);
		System.out.println(clazz.getSimpleName());
		Field[] fields =  clazz.getDeclaredFields();

		for(Field field :fields) {
			System.out.println(field.getType().toString());     // 필드 자료형
			System.out.println(field.getName());                // 필드 이름
		}
	}
}
