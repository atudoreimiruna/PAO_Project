package Service;

import Entity.CardEntity;

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

    public static List<CardEntity> executeReadQuery() {

            Connection conn = null;
            Statement stmt = null;
            List<CardEntity> result = new ArrayList<>();
            try {
                // STEP 1: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                // STEP 2: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                // STEP 3: Execute a query
                System.out.println("Connected database successfully...");
                stmt = conn.createStatement();
                String sql = "SELECT * from Card";
                ResultSet rs = stmt.executeQuery(sql);

                // STEP 4: Extract data from result set
                while (rs.next()) {
                    // Retrieve by column name
                    int id = rs.getInt("id");
                    String nume = rs.getString("nume");

                    // Display values
                    CardEntity cardEntity = new CardEntity(id, nume);
                    result.add(cardEntity);

                }
                // STEP 5: Clean-up environment
                rs.close();
            } catch (SQLException se) {
                // Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                // Handle errors for Class.forName
                e.printStackTrace();
            } finally {
                // finally block used to close resources
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException se2) {
                } // nothing we can do
                try {
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                } // end finally try
            } // end try
            System.out.println("Goodbye!");

            return result;
    }
}
