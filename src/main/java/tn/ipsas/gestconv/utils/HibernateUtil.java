package tn.ipsas.gestconv.utils;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;


public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

				SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	public static Object create(Object o){
			Transaction transaction = null;
			Object result = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the participant object
				result = session.save(o);
				// commit transaction
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			return result;
		}
	public static void update(Object o) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the convention object
			session.update(o);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public static void delete(Object o) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete o object
				session.delete(o);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public static Object get(Class klass, int id) {

		Transaction transaction = null;
		Object o = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an convention object
			o  = session.get(klass.getName(), id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return o;
	}
	public static List getAll(Class klass) {
		Transaction transaction = null;
		List listOfConvention = null;
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an convention object
			listOfConvention = session.createQuery("from "+ klass.getSimpleName()).getResultList();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfConvention;
	}
}
