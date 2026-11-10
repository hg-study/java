package Ch19Annotation;

// =======================================
// 어노테이션 주입 사용
// 필드에 값을 직접 넣지 않아도 어노테이션 값이 자동으로 채워짐
// =======================================

@C02CustomAnnotation(value="홍길동",number=10000,isOpen=true)
// 클래스에 값을 붙이고(@C02CustomAnnotation) 부모 클래스(C02AnnotationInjected)를 상속하면 생성자에서 필드가 자동으로 채워짐
class Simple2 extends C02AnnotationInjected
{
	@C02BindFrom("value")
	String value;
	
	@C02BindFrom("number")
	int number;
	
	@C02BindFrom("isOpen")
	boolean isOpen;
	
	Simple2(){
		System.out.println("Simple2 디폴트 생성자 호출!..");
	}

	@Override
	public String toString() {
		return "Simple2 [value=" + value + ", number=" + number + ", isOpen=" + isOpen + "]";
	}
	
	
}

public class C02AnnotationInject {

	public static void main(String[] args) {
		Simple2 ob = new Simple2();
		System.out.println(ob);

	}

}
