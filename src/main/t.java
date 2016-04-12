package main;

import model.ddbb.entity.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class t {

    public static void main (String[] args)
    {

        SessionFactory sf = new Configuration()
                                .configure()
                                .buildSessionFactory();

        Session s = sf.openSession();

        Transaction t = s.beginTransaction();
        List r = s.createQuery("from Language").list();
        t.commit();
        s.close();
        for(Language l : (List<Language>) r)
        {
            System.out.println(l.getName());
        }

    }
}
