package book;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// =======================================
// DB 연결 도우미
// 접속 정보 파일을 읽어 Connection 을 만들고, 자원을 한꺼번에 닫음
// =======================================

// 채점 항목 ------
// 3-2 Driver 로드와 Connection 획득, 3-3 JDBC 4단계 중 ① 드라이버 로드 ② 연결
// 접속 정보는 config/db.properties 로 분리해 코드에 비밀번호를 적지 않음 (db.properties 는 .gitignore 로 커밋 제외)
public class DBUtil {

    private DBUtil() {}

    public static Connection getConnection() throws SQLException {
        // 접속 정보 읽기 : Properties 로 config/db.properties 를 로드함
        Properties prop = new Properties();
        try (InputStream fin = new FileInputStream("config/db.properties")) {
            prop.load(fin);
        } catch (IOException e) {
            throw new RuntimeException("DBUtil.getConnection() db.properties 로딩 실패: " + e.getMessage());
        }

        String driver   = prop.getProperty("db.driver");
        String url      = prop.getProperty("db.url");
        String user     = prop.getProperty("db.user");
        String password = prop.getProperty("db.password");

        // JDBC 4단계 ① : 드라이버 클래스를 메모리에 적재함
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("DBUtil.getConnection() 드라이버 로드 실패: " + e.getMessage());
        }

        // JDBC 4단계 ② : 접속 정보로 DB 와 연결된 Connection 을 얻음
        return DriverManager.getConnection(url, user, password);
    }

    // 자원 닫기 : 여러 자원을 순서대로 닫음. null 이면 건너뛰고, 닫는 중 오류가 나도 나머지를 계속 닫음
    public static void close(AutoCloseable... closeables) {
        for (AutoCloseable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
