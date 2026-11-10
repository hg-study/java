package Ch08JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// =======================================
// JDBC 연결
// MySQL 드라이버를 적재하고 DB 에 연결
// =======================================

// JDBC : 자바에서 DBMS 에 접속해 SQL 을 실행하는 표준 API
// Connection : DB 와의 연결, PreparedStatement : SQL 전송, ResultSet : SELECT 결과
public class C01DbConnect {

	public static void main(String[] args) {
		// DB 접속 정보 ------ : 비밀번호는 본인 환경에 맞게 바꿔서 사용하며 MySQL 에 opendatadb 를 미리 만들어 둠
		
		String id = "root";
		String pw = "YOUR_PASSWORD";
		String url = "jdbc:mysql://localhost:3306/opendatadb";
		
		// JDBC 참조변수 ------
		Connection conn = null; 			// DBMS의 특정 DB와 연결되는 객체
		PreparedStatement pstmt = null; 	// SQL Query 전송용 객체
		ResultSet rs = null; 				// Select 결과물 담을 객체
		
		try {
			// Class.forName : MySQL 드라이버 클래스를 메모리에 적재함 (mysql-connector-j jar 필요)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			// getConnection(url, 아이디, 비밀번호) : DB 와 연결된 Connection 을 얻음
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED...");	
			
		} catch(Exception e) {
			e.printStackTrace();
			
		// finally : 성공과 실패에 상관없이 자원을 반납함. 연 순서의 역순으로 닫음
		}finally {
			
			try {conn.close();
			
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
