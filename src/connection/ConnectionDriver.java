package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDriver
{

    private final static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private final static String DRIVER_URL = "jdbc:mysql://localhost/Users";
    private final static String USER = "root";
    private final static String PASSWORD = "1234";

    static
    {
        try
        {
            Class.forName(DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace(System.err);
        }
    }

    public final static Connection getConnection () throws SQLException
    {
        return DriverManager.getConnection(DRIVER_URL, USER, PASSWORD);
    }

}
