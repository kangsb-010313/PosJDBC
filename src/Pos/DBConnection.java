package Pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 데이터베이스 연결을 담당하는 클래스
public class DBConnection {
    private static final String driever = "com.mysql.cj.jdbc.Driver";
    static final String db_url = "jdbc:mysql://localhost:3306/pos_db";
    static final String user = "pos";
    static final String pass = "pos";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(driever); // 드라이버 클래스 명시적 로딩
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(db_url, user, pass);
    }
}
