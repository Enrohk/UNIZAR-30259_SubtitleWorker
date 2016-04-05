package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{

    private static List<Connection> connectionPool = new ArrayList<Connection>();
    private static final int maxPoolSize = 1;

    static
    {
        while (connectionsAvailable())
        {
            // Adding new connection instance until the pool is full
            try
            {
                connectionPool.add(ConnectionDriver.getConnection());
            } catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    private static synchronized boolean connectionsAvailable ()
    {
        //Check if the pool size
        if (connectionPool.size() < maxPoolSize)
        {
            return true;
        }
        return false;
    }

    public static synchronized Connection getConnection ()
    {

        Connection connection = null;

        //Check if there is a connection available.
        if (connectionPool.size() > 0)
        {
            connection = connectionPool.remove(0);

        }
        //Giving away the connection from the connection pool
        return connection;
    }

    public static synchronized void returnConnection (Connection connection)
    {
        //Adding  connection from the client back to the connection pool
        connectionPool.add(connection);
    }

    public static synchronized void closeConnections () throws SQLException
    {
        for (Connection c : connectionPool)
        {
            c.close();
        }
    }

}
