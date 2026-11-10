package Ch04Static;

// =======================================
// 싱글톤 문제
// ShopService 를 싱글톤으로 만들기
// =======================================

// 문제 ------
// ShopService 객체를 싱글톤으로 만드는 문제
// main 에서 getInstance() 로 얻은 두 객체가 같은 객체인지 확인함

class ShopService{

    // 싱글톤 : private 생성자와 getInstance() 로만 객체를 얻게 함
    private static ShopService instance;
    private ShopService() {}

    public static ShopService getInstance(){
        if(instance == null){
            instance = new ShopService();
        }
        return instance;
    }
}


public class C05ShopService {

	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();

		// == 로 주소값을 비교해 같은 객체인지 확인함
		if (obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		} else {
			System.out.println("다른 ShopService 객체 입니다.");
		}
	}
}
