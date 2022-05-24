package Service;

import Mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryExecutorService {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/proiect-pao";

    //  Database credentials
    static final String USER = "amg";
    static final String PASS = "amg";

    public static List<Object> executeReadQuery(String sql, RowMapper<?> rowMapper) {

            Connection conn = null;
            Statement stmt = null;
            List<Object> result = new ArrayList<>();
            try {
                Class.forName(JDBC_DRIVER);

                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    result.add(rowMapper.mapRow(rs));
                }
                rs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException se2) {
                }
                try {
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            // System.out.println("Goodbye!");

            return result;
    }

     // for INSERT, UPDATE, DELETE sql queries

    public static Integer executeUpdateQuery(String sql) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return null;
    }
}
