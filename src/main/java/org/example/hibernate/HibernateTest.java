package org.example.hibernate;

import org.example.entities.Staff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        if (sessionFactory == null) {
            return;
        }
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.createQuery("Select s, s1 From Staff s " +
                            "Left Join Staff s1 on s.chief = s1.id " +
                            "Order By s.name", Object[].class)
                    .stream()
                    .forEach(objs -> {
                        Staff st1 = (Staff)objs[0];
                        Staff st2 = (Staff)objs[1];
                        System.out.format("%s %s; начальник: %s%n", st1.getFirstName(), st1.getName(),
                                st2 == null ? "--" : st2.getFirstName() + " " + st2.getName());
                    });
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
    }
}
