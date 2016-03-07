package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String MySQLDriver = "com.mysql.jdbc.Driver";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{

        Class.forName(MySQLDriver);
        return DriverManager.getConnection("jdbc:mysql://localhost/sce","tester","tester123");
    }
    
}
