package controller.ddbb;

import connection.ConnectionPool;
import exceptions.DBException;
import model.ddbb.entity.SubtitleEntity;

import java.sql.Connection;

public class SubtitleDT
{

    public static void addSubtitle (SubtitleEntity subtitle) throws DBException
    {

        Connection connection = ConnectionPool.getConnection();



        ConnectionPool.returnConnection(connection);

    }





}
