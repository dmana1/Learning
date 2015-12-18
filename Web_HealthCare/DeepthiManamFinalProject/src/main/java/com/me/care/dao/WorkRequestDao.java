package com.me.care.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.me.care.model.User;
import com.me.care.model.Vitalsign;
import com.me.care.model.Workrequest;

public class WorkRequestDao extends DAO {

	
	public int insertRequest(Workrequest workrequest) throws Exception {
		Transaction tx = null;
		int requestId = 0;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(workrequest);
			requestId =  workrequest.getRequestId();
			session.close();
			return requestId;
		} catch (HibernateException e) {

			throw new Exception("Could not get user " + e.getMessage());
		}

	}
	
	
	public List<Workrequest> selectWorkRequestByEnterprise(Integer assignedTo) {

		try {
			// begin();
			Query query = getSession().createQuery(
					"from Workrequest where assignedTo = :assignedTo");
			query.setParameter("assignedTo", assignedTo);
			List<Workrequest> workRequestList = query.list();

			return workRequestList;

		} catch (HibernateException e) {

			System.out.println(" EXCEPTION" + e.getMessage());
		}
		return null;
	}
	
	public Workrequest selectWorkRequestByRequestId(Integer requestId)
			throws Exception {
		try {
			// begin();
			Query q = getSession()
					.createQuery(
							"from Workrequest where requestId = :requestId");
			q.setParameter("requestId", requestId);
			Workrequest workrequest = (Workrequest) q.uniqueResult();
			// commit();
			return workrequest;
		} catch (HibernateException e) {
			// rollback();
			throw new Exception("Could not get workrq " , e);
		}
	}
	
	public void updateWorkRequestByID(Workrequest workrequest) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.update(workrequest);
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			throw new Exception("Could not update work request " + e.getMessage());
		}

	}
	

}
