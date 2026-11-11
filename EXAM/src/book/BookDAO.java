package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

// =======================================
// BookDAO
// Book_tbl 의 등록, 조회, 수정, 삭제(CRUD)
// =======================================

// 채점 항목 ------
// 3-3 JDBC 4단계 중 ③ SQL 준비와 실행 ④ 결과 처리와 자원 반환
// 3-4 PreparedStatement : ? 자리표시자에 값을 채워 SQL 인젝션을 막음
// DAO(Data Access Object) : DB 접근을 전담하는 클래스
public class BookDAO {

    private static final String SQL_INSERT =
            "INSERT INTO Book_tbl (Book_code, Classification_Id, author, name, publisher, isreserve) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_SELECT_ALL =
            "SELECT Book_code, Classification_Id, author, name, publisher, isreserve " +
            "FROM Book_tbl " +
            "ORDER BY Book_code";

    private static final String SQL_UPDATE =
            "UPDATE Book_tbl " +
            "   SET Classification_Id = ?, author = ?, name = ?, publisher = ?, isreserve = ? " +
            " WHERE Book_code = ?";

    private static final String SQL_DELETE =
            "DELETE FROM Book_tbl WHERE Book_code = ?";

    // 등록 : 변경된 행 수를 돌려줌
    public int insert(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, book.getBookCode());
            setClassification(pstmt, 2, book.getClassificationId());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4, book.getName());
            pstmt.setString(5, book.getPublisher());
            pstmt.setString(6, book.getIsReserve());
            return pstmt.executeUpdate();
        } finally {
            DBUtil.close(pstmt, conn);
        }
    }

    // 전체 조회 : 결과의 각 행을 Book 객체로 만들어 List 에 담음
    public List<Book> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                // getInt 는 NULL 을 0 으로 돌려주므로 wasNull() 로 NULL 이었는지 확인함
                Integer classificationId = rs.getInt("Classification_Id");
                if (rs.wasNull()) classificationId = null;
                list.add(new Book(
                        rs.getString("Book_code"),
                        classificationId,
                        rs.getString("author"),
                        rs.getString("name"),
                        rs.getString("publisher"),
                        rs.getString("isreserve")));
            }
            return list;
        } finally {
            DBUtil.close(rs, pstmt, conn);
        }
    }

    // 수정 : 도서 코드를 조건으로 나머지 컬럼을 바꿈
    public int update(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            setClassification(pstmt, 1, book.getClassificationId());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getName());
            pstmt.setString(4, book.getPublisher());
            pstmt.setString(5, book.getIsReserve());
            pstmt.setString(6, book.getBookCode());
            return pstmt.executeUpdate();
        } finally {
            DBUtil.close(pstmt, conn);
        }
    }

    // 삭제 : 도서 코드로 한 행을 지움
    public int delete(String bookCode) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, bookCode);
            return pstmt.executeUpdate();
        } finally {
            DBUtil.close(pstmt, conn);
        }
    }

    // 분류 번호 설정 : 값이 null 이면 setNull 로 NULL 을 저장하고, 아니면 setInt 로 저장함
    private void setClassification(PreparedStatement pstmt, int index, Integer classificationId) throws SQLException {
        if (classificationId == null) {
            pstmt.setNull(index, Types.INTEGER);
        } else {
            pstmt.setInt(index, classificationId);
        }
    }
}
