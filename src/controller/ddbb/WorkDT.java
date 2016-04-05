package controller.ddbb;

import connection.ConnectionPool;
import model.ddbb.entity.WorkEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class WorkDT
{

    public static WorkEntity getWorkByName (String name)
    {
        Connection connection = ConnectionPool.getConnection();
        WorkEntity workEntity = new WorkEntity();

        String query = "";

        try (Statement stmt = connection.createStatement())
        {





        } catch (Exception e)
        {

        }

        ConnectionPool.returnConnection(connection);

        return workEntity;
    }

}
