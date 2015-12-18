package com.me.care.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.me.care.model.Message;

public class MessageDao extends DAO {

	public List<Message> selectMessagesByUserName(String name) {

		try {
			// begin();
			Query q = getSession().createQuery(
					"from Message where toUser = :name");
			q.setString("name", name);
			List<Message> messages = q.list();

			return messages;

		} catch (HibernateException e) {

			System.out.println(" EXCEPTION" + e.getMessage());
		}
		return null;
	}

	public void insertMessages(Message message) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(message);
			tx.commit();
			session.close();
		} catch (HibernateException e) {

			throw new Exception("Could not get user " + e.getMessage());
		}

	}

	public int deleteMessageBasedOnId(Integer messageId) throws Exception {
		Transaction tx = null;
		int result = 0;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			Query query = session
					.createQuery("delete from Message where messageId = :messageId");
			query.setParameter("messageId", messageId);
			 result = query.executeUpdate();

			if (result < 0) {
				System.out.println("Message is not removed");
			}

			tx.commit();
			session.close();
		} catch (HibernateException e) {
			throw new Exception("Could not get user " + e.getMessage());
		}
		
		return result;

	}

}
