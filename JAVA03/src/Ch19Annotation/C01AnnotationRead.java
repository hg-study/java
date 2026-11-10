package Ch19Annotation;

// =======================================
// 어노테이션 값 읽기
// 리플렉션으로 클래스에 붙은 어노테이션의 값을 읽어 필드에 저장
// =======================================

@C01CustomAnnotation(value="홍길동", number=10000, isOpen=true)

class Simple{
	String value;
	int number;
	boolean isOpen;
	
	Simple(){
		// getAnnotation(어노테이션.class) : 클래스에 붙은 어노테이션 객체를 얻음. 속성값은 메서드처럼 호출해 읽음
		C01CustomAnnotation ref = this.getClass().getAnnotation(C01CustomAnnotation.class);
		System.out.println("VALUE : " + ref.value());
		System.out.println("NUMBER: " + ref.number());
		System.out.println("ISOPEN: " + ref.isOpen());
		
		this.value = ref.value();
		this.number = ref.number();
		this.isOpen = ref.isOpen();
	}
}

public class C01AnnotationRead {

	public static void main(String[] args) {
		Simple ob = new Simple();
	}
	
}
