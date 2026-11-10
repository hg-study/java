package Ch03Generic;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// =======================================
// 제네릭 + JDBC + 리플렉션 Repository
// 엔티티 클래스로 테이블 자동 생성
// =======================================

// 리플렉션 ------
// 리플렉션(Reflection) : 실행 중에 클래스의 이름, 필드, 메서드 정보를 읽어 오는 기능
// 이 클래스는 엔티티 클래스(Member 등)의 필드 정보를 읽어 같은 이름의 테이블을 만드는 CREATE 문을 자동으로 만들어 실행함
// <E, D> : E 는 엔티티 자료형, D 는 기본키 자료형

public class C05GenericRepository<E, D> {

	// 리플렉션용 속성
	E entity ;
	Class<?> dataType;
	Class<?> clazz;

	// JDBC 속성
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 접속 정보 속성
	String username;
	String password;
	String url;

	// 생성자 : 호출하면 엔티티 클래스 이름으로 테이블을 만듦
	public C05GenericRepository(E entity,Class<?> dataType) {
		this.entity = entity;
		this.dataType = dataType;
		System.out.println("PrimaryKey DataType : " +dataType );
		try {
		// 접속 정보 : application.properties 에서 읽어 오도록 바꿀 예정이며 현재는 직접 지정함. 비밀번호는 본인 값으로 바꿔서 사용
		username = "root";
		password = "YOUR_PASSWORD";
		url = "jdbc:mysql://localhost:3306/tmpdb";
		conn = DriverManager.getConnection(url,username,password);

		// MySQL 드라이버를 메모리에 적재함
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 엔티티의 클래스 정보와 필드 목록을 읽음
		clazz = Class.forName(String.valueOf(entity.getClass()).split(" ")[1]);
		Field[] fields =  clazz.getDeclaredFields();

		String sql ="";

		// CREATE 문 만들기 : 클래스 이름이 테이블명, 필드가 컬럼이 됨
		sql+="CREATE TABLE IF NOT EXISTS tmpdb.";
		sql+=clazz.getSimpleName()+"(";

		// 필드 자료형에 따라 컬럼 자료형과 제약조건을 정함
		for(Field field :fields) {
			if(field.getType().toString().contains("String")) {
				sql+=field.getName() + " varchar(45) not null,";
			}else if(field.getType().toString().contains("int")){
				sql+=field.getName() + " int not null,";
			}
		}
		sql = sql.substring(0,sql.lastIndexOf(","));    // 마지막 쉼표 제거
		sql+=")";

		System.out.println("Execution Sql : " + sql);

		// 테이블 생성 실행
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		int isCreatedTable =  pstmt.executeUpdate();

		System.out.println(clazz.getSimpleName() + " 테이블 생성완료");

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(entity.getClass().getSimpleName() + " 테이블 생성실패");
		}

	}

	// 구현할 기본 CRUD 기능 ------
	// INSERT()
	// UPDATE()
	// DELETE()
	// SELECTBYID(기본키 자료형)
	// SELECTALL()

}
