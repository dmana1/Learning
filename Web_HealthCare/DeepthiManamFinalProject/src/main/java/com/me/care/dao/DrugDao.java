package com.me.care.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.care.model.Drug;
import com.me.care.model.User;

public class DrugDao extends DAO {

	public List<Drug> selectDrugs() {

		try {
			// begin();
			Query query = getSession().createQuery(
					"from Drug");
			
			List<Drug> drugList = query.list();

			return drugList;

		} catch (HibernateException e) {

			System.out.println(" EXCEPTION" + e.getMessage());
		}
		return null;
	}

	public Drug selectDrugByDrugId(String drugId)
			throws Exception {
		try {
			// begin();
			Query query = getSession()
					.createQuery(
							"from Drug where drugId = :drugId");
			query.setString("drugId", drugId);
			
			Drug drug = (Drug) query.uniqueResult();
			// commit();
			return drug;
		} catch (HibernateException e) {
			// rollback();
			throw new Exception("Could not get drug " + e.getMessage());
		}
	}

}
