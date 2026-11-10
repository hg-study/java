package Ch08JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

// =======================================
// 트랜잭션
// setAutoCommit, commit, rollback, Savepoint
// =======================================

public class C08Transaction {

	public static void main(String[] args) {
		
		// DB 접속 정보 ------ : 비밀번호는 본인 환경에 맞게 바꿔서 사용하며 MySQL 에 opendatadb 를 미리 만들어 둠
		String id = "root";
		String pw = "YOUR_PASSWORD";
		String url = "jdbc:mysql://localhost:3306/opendatadb";
		
		// JDBC 참조변수 ------
		Connection conn = null; 			// DBMS의 특정 DB와 연결되는 객체
		PreparedStatement pstmt = null; 	// SQL Query 전송용 객체
		ResultSet rs = null; 				// Select 결과물 담을 객체

		Savepoint sp1 = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED...");	
			
			// 트랜잭션 시작 ------
			// 트랜잭션 : 여러 SQL 을 하나의 작업 단위로 묶어 모두 성공해야 반영(commit)하고, 실패하면 되돌리는(rollback) 기능
			// setAutoCommit(false) : SQL 마다 자동 반영하지 않고 commit() 을 호출할 때 한꺼번에 반영함
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement("insert into tbl_a values(1,'a')");
			pstmt.executeUpdate();
			
			// Savepoint : 되돌릴 지점을 표시함. rollback(sp1) 은 이 지점 이후의 작업만 취소함
			sp1 = conn.setSavepoint("sp1");
			
			pstmt = conn.prepareStatement("insert into tbl_a values(2,'b')");
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into tbl_a values(3,'c')");
			pstmt.executeUpdate();
			
			// 기본키 3 이 중복되어 여기서 예외가 발생하면 catch 에서 롤백함
			pstmt = conn.prepareStatement("insert into tbl_a values(3,'d')");
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into tbl_a values(5,'e')");
			pstmt.executeUpdate();
			
			conn.commit();

		} catch(Exception e) {
			e.printStackTrace();
			
			try {
				
				if(sp1!=null){conn.rollback(sp1);
				}else {conn.rollback();}
				
				conn.commit();
				
			}catch(Exception rollback) {rollback.printStackTrace();}

		// finally : 성공과 실패에 상관없이 자원을 반납함
		}finally {			
			try {pstmt.close();}catch(Exception e2) {e2.printStackTrace();}
			try {conn.close();}catch(Exception e2) {e2.printStackTrace();}
		}
	}
			
	

}
