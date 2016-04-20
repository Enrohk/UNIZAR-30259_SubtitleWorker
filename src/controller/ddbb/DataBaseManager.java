package controller.ddbb;

import exceptions.DBException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class DataBaseManager {

    private static SessionFactory sf = new Configuration()
            .configure()
            .buildSessionFactory();

    public static List getListByQuery(String query) throws DBException {
        Session session = null;
        Transaction transaction = null;
        List list = Collections.emptyList();
        try {
            session = sf.openSession();
            transaction = session.beginTransaction();
            list = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null)
                session.close();
            return list;
        }
    }

    public static void saveOrDeleteSingleObject(Object object, boolean save) throws DBException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sf.openSession();
            transaction = session.beginTransaction();
            if (save)
                session.save(object);
            else
                session.delete(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null)
                session.close();
        }

    }

}
