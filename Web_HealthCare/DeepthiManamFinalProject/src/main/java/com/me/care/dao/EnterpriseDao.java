package com.me.care.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.me.care.model.Enterprise;
import com.me.care.model.User;

//import com.me.neu.model.User;

public class EnterpriseDao extends DAO {

	/*
	 * Since its a query, it is not necessary to wrap code inside the begin
	 * transaction and commit part, unlike update, create, and delete. Since
	 * there is no object in the session yet, nothing will be committed. After
	 * Adding these, "transaction is not successfully started' Exception will be
	 * thrown.
	 */

	public List<Enterprise> selectEnterprises() throws Exception {
		try {
			// begin();
			Query q = getSession().createQuery("from Enterprise");

			List<Enterprise> enterpriseList = q.list();
			// commit();
			return enterpriseList;
		} catch (HibernateException e) {
			// rollback();
			throw new Exception("Could not get user " + e.getMessage());
		}
	}
	
	public List<Enterprise> selectEnterprisesBasedOnType(int enterpriseTypeId) throws Exception {
		List<Enterprise> actualList = new ArrayList<Enterprise>();
		try {
			// begin();
			Query query = getSession().createQuery("from Enterprise");
			List<Enterprise> enterpriseList = query.list();
			
			for(Enterprise enterprise: enterpriseList){
				if(enterprise.getEnterprisetype().getEnterpriseTypeId() == enterpriseTypeId){
					actualList.add(enterprise);
				}
			}
			// commit();
			return actualList;
		} catch (HibernateException e) {
			// rollback();
			throw new Exception("Could not get user " + e.getMessage());
		}
	}

	
	public int selectEnterpriseIdByName(String name)
			throws Exception {
		try {
			// begin();
			Query q = getSession()
					.createQuery(
							"from Enterprise where name = :name ");
			q.setString("name", name);
			Enterprise enterprise = (Enterprise) q.uniqueResult();
			// commit();
			return enterprise.getEnterpriseId();
		} catch (HibernateException e) {
			// rollback();
			return 1;

		}
	}
	
	public Enterprise selectEnterpriseByName(String name)
			throws Exception {
		try {
			// begin();
			Query q = getSession()
					.createQuery(
							"from Enterprise where name = :name ");
			q.setString("name", name);
			Enterprise enterprise = (Enterprise) q.uniqueResult();
			// commit();
			return enterprise;
		} catch (HibernateException e) {
			// rollback();
			return null;

		}
	}

	
	
	public void insertEnterprise(Enterprise enterprise) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(enterprise);
			tx.commit();
			session.close();
		} catch (HibernateException e) {

			throw new Exception("Could not get user " + e.getMessage());
		}
	}

	public int deleteEnterprise(int enterpriseId) throws Exception {
		Transaction tx = null;
		int result = 0;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			Query query = session
					.createQuery("delete from Enterprise where enterpriseId = :enterpriseId");
			query.setParameter("enterpriseId", enterpriseId);
			result = query.executeUpdate();

			if (result < 0) {
				System.out.println("enterpriseId is not removed");
			}

			tx.commit();
			session.close();
		} catch (HibernateException e) {
			throw new Exception("Could not get user " + e.getMessage());
		}

		return result;

	}
	
	
	
	
}
