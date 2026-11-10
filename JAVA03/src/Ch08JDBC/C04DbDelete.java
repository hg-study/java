package Ch08JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// =======================================
// DELETE
// PreparedStatement 로 행 삭제 (실행할 때 인자 1개 필요: 번호)
// =======================================

public class C04DbDelete {

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
			
			// 삭제할 행의 번호를 ? 에 채워 실행함
			pstmt = conn.prepareStatement("delete from tbl_a where no=?");
			pstmt.setInt(1, Integer.parseInt(args[0]));

			
			// SQL 실행 ------ : executeUpdate 는 변경된 행 수를, executeQuery 는 조회 결과(ResultSet)를 돌려줌
			int result = pstmt.executeUpdate();
			System.out.println("result: "  + result);
			// 변경된 행 수가 0 보다 크면 성공으로 판단
			if(result>0) {
				System.out.println("DELETE 성공");
			}
			else {
				System.out.println("DELETE 실패");
			}
			
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
		
	
