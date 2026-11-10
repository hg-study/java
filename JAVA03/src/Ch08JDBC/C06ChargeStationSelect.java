package Ch08JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// =======================================
// 공공데이터 조회 (충전소)
// 한국가스안전공사 전국 도시가스충전소 현황을 DTO 로 읽기
// =======================================

public class C06ChargeStationSelect {

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
			
			pstmt = conn.prepareStatement("select * from tbl_charge");
			
			
			// SQL 실행 ------ : executeUpdate 는 변경된 행 수를, executeQuery 는 조회 결과(ResultSet)를 돌려줌
			rs = pstmt.executeQuery();
			
			// 조회한 행을 DTO 객체에 담아 List 에 모은 뒤 출력함. 공공데이터 CSV 는 MySQL 에 tbl_charge 테이블로 미리 가져와 둠
			List<C06ChargeStationDto> list = new ArrayList();
			C06ChargeStationDto dto = null;
			
			while(rs.next()) {
				dto = new C06ChargeStationDto();
				dto.set순번(rs.getInt("순번"));
				dto.set행정구역(rs.getString("행정구역"));
				dto.set지사(rs.getString("지사"));
				dto.set시설명(rs.getString("시설명"));
				dto.set우편번호(rs.getInt("우편번호"));
				dto.set주소(rs.getString("주소"));
				
				list.add(dto);
			}

			list.forEach(System.out::println);
			
		} catch(Exception e) {
			e.printStackTrace();
			
		// finally : 성공과 실패에 상관없이 자원을 반납함. 연 순서의 역순으로 닫음
		}finally {
			
			try {conn.close();
			
			} catch(Exception e2) {
				e2.printStackTrace();
			} finally {
				try {rs.close();}catch(Exception e2) {e2.printStackTrace();}
				try {pstmt.close();}catch(Exception e2) {e2.printStackTrace();}
				try {conn.close();}catch(Exception e2) {e2.printStackTrace();}
			}
		}
		
		
		
		
		

	}

}
