package com.me.care.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.me.care.model.User;

//import com.me.neu.model.User;

public class UserDao extends DAO {

	/*
	 * Since its a query, it is not necessary to wrap code inside the begin
	 * transaction and commit part, unlike update, create, and delete. Since
	 * there is no object in the session yet, nothing will be committed. After
	 * Adding these, "transaction is not successfully started' Exception will be
	 * thrown.
	 */
	
	
	public User queryUserByNameAndPassword(String name, String password)
			throws Exception {
		try {
			// begin();
			Query q = getSession()
					.createQuery(
							"from User where userName = :username and password = :password");
			q.setString("username", name);
			q.setString("password", password);
			User user = (User) q.uniqueResult();
			// commit();
			return user;
		} catch (HibernateException e) {
			// rollback();
			throw new Exception("Could not get user " + name, e);
		}
	}
	
	public User queryUserByUserName(String name)
			throws Exception {
		try {
			// begin();
			Query q = getSession()
					.createQuery(
							"from User where userName = :username");
			q.setString("username", name);
			User user = (User) q.uniqueResult();
			// commit();
			return user;
		} catch (HibernateException e) {
			// rollback();
			throw new Exception("Could not get user " + name, e);
		}
	}
	
	public User SelectUserByUserId(Integer userId)
			throws Exception {
		try {
			// begin();
			Query q = getSession()
					.createQuery(
							"from User where userId = :userId");
			q.setParameter("userId", userId);
			User user = (User) q.uniqueResult();
			// commit();
			return user;
		} catch (HibernateException e) {
			// rollback();
			throw new Exception("Could not get user "+  e);
		}
	}
	
	
	
	public void insertUser(User user) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			session.close();
		} catch (HibernateException e) {

			throw new Exception("Could not get user " + e.getMessage());
		}

	}
	
	public int deleteUserBasedOnId(Integer userId) throws Exception {
		Transaction tx = null;
		int result = 0;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			Query query = session
					.createQuery("delete from User where userId = :userId");
			query.setParameter("userId", userId);
			 result = query.executeUpdate();

			if (result < 0) {
				System.out.println("User is not removed");
			}

			tx.commit();
			session.close();
		} catch (HibernateException e) {
			throw new Exception("Could not get user " + e.getMessage());
		}
		
		return result;

	}


}
