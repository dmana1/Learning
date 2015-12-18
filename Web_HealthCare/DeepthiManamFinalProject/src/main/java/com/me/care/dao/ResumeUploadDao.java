package com.me.care.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.me.care.model.Message;
import com.me.care.model.ResumeUpload;

public class ResumeUploadDao extends DAO {


	public void insertResumeUpload(ResumeUpload resumeUpload) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(resumeUpload);
			tx.commit();
			session.close();
		} catch (HibernateException e) {

			throw new Exception("Could not get user " + e.getMessage());
		}

	}
	
	public List<ResumeUpload> selectResumes() {

		try {
			// begin();
			Query q = getSession().createQuery(
					"from ResumeUpload ");
			
			List<ResumeUpload> resumeList = q.list();

			return resumeList;

		} catch (HibernateException e) {

			System.out.println(" EXCEPTION" + e.getMessage());
		}
		return null;
	}

}
