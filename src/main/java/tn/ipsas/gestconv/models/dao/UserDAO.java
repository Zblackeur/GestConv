package tn.ipsas.gestconv.models.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tn.ipsas.gestconv.models.beans.User;
import tn.ipsas.gestconv.utils.HibernateUtil;

public class UserDAO {

    public static void  saveUser(User user) {
        HibernateUtil.create(user);
    }
    public static User getUser(String username) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an convention object
            user  = session.get(User.class, username);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }
}
