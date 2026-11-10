package Ch03Generic;

// =======================================
// Repository 사용
// 엔티티 클래스와 Repository 클래스를 만들어 테이블 생성
// =======================================

// 엔티티 ------
// 엔티티(Entity) : 테이블 한 줄에 해당하는 데이터를 담는 클래스. 클래스 이름이 테이블명, 필드가 컬럼명이 됨
class Member{
	private String username;
	private String password;
	private String role;
}
class Board{
	private int no;
	private String writer;
	private String contents;
	private String LocalDateTime;

}

class Product{
	private int prodNo;
	String productName;
	String brandName;
	int amount;
}

// Repository ------
// Repository : 엔티티별 DB CRUD 를 맡는 객체. 제네릭 Repository 를 상속하면 객체를 만들 때 테이블이 자동 생성됨
class MemberRepository extends C05GenericRepository<Member,String>{
	public MemberRepository(Member entity, Class<?> dataType) {
		super(entity, dataType);
	}
}
class BoardRepository extends C05GenericRepository<Board,String>{
	public BoardRepository(Board entity, Class<?> dataType) {
		super(entity, dataType);
	}
}

class ProductRepository extends C05GenericRepository<Product,Integer>{
	public ProductRepository(Product entity, Class<?> dataType) {
		super(entity, dataType);
	}
}

public class C05RepositoryMain {
	// Repository 객체를 만들면 Member, Board, Product 테이블이 생성됨
	public static MemberRepository memberRepository = new MemberRepository(new Member(),String.class);
	public static BoardRepository boardRepository= new BoardRepository(new Board(),Long.class);
	public static ProductRepository productRepository= new ProductRepository(new Product(),int.class);

	public static void main(String[] args) throws Exception {
		System.out.println("TEST");
	}
}
