package es.api.atw.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import es.api.atw.configuration.HibernateConfiguration;
import es.api.atw.model.User;
import es.api.atw.repository.UserRepository;

@Repository
public class UserPostgres implements UserRepository {

	private final SessionFactory sessionFactory = HibernateConfiguration.init();

	@Override
	public boolean createUser(User user) {
		boolean resultado = false;
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			resultado = true;
		} catch (final HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			return false;
		} finally {
			session.close();
		}
		return resultado;
	}

	@Override
	public boolean editUser(User user) {
		boolean resultado = false;
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			resultado = true;
		} catch (final HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			resultado = true;
		} finally {
			session.close();
		}
		return resultado;
	}

	@Override
	public User getUserById(int id) {
		User resultUser = null;
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			resultUser = (User) session.get(User.class, id);
			tx.commit();
		} catch (final HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return resultUser;
	}

	@Override
	public boolean deleteUserById(int id) {
		boolean resultado = false;
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			final User deleteUser = new User();
			deleteUser.setId(id);

			session.delete(deleteUser);
			tx.commit();
			resultado = true;
		} catch (final HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				return false;
			}
		} finally {
			session.close();
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		List<User> users = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			users = session.createQuery("FROM User").list();

			tx.commit();
		} catch (final HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return users;
	}

}
