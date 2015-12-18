package com.me.care.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.me.care.model.Employee;
import com.me.care.model.Enterprise;
import com.me.care.model.Patient;
import com.me.care.model.User;

//import com.me.neu.model.User;

public class EmployeeDao extends DAO {

	/*
	 * Since its a query, it is not necessary to wrap code inside the begin
	 * transaction and commit part, unlike update, create, and delete. Since
	 * there is no object in the session yet, nothing will be committed. After
	 * Adding these, "transaction is not successfully started' Exception will be
	 * thrown.
	 */

	public List<Employee> selectEmployees() throws Exception {
		try {
			// begin();
			Query q = getSession().createQuery("from Employee ");

			List<Employee> enterpriseList = q.list();
			// commit();
			return enterpriseList;
		} catch (HibernateException e) {
			// rollback();
			throw new Exception("Could not get user " + e.getMessage());
		}
	}

	public void insertEmployee(Employee employee,User user) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(employee);
			tx.commit();
			
			user.setRole(employee.getRole());
			user.setUserId(employee.getEmployeeId());
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			
			session.close();
		} catch (HibernateException e) {

			throw new Exception("Could not get user " + e.getMessage());
		}
	}

	public int deleteEmployee(int employeeId) throws Exception {
		Transaction tx = null;
		int result = 0;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			Query query = session
					.createQuery("delete from Employee where employeeId = :employeeId");
			query.setParameter("employeeId", employeeId);
			result = query.executeUpdate();

			if (result < 0) {
				System.out.println("employeeId is not removed");
			}

			tx.commit();
			session.close();
		} catch (HibernateException e) {
			throw new Exception("Could not get user " + e.getMessage());
		}

		return result;

	}
	
	
	public int selectEnterpriseIdOfEmployee(Integer employeeId)
			throws Exception {
		try {
			// begin();
			Query query = getSession()
					.createQuery(
							"from Employee where employeeId = :employeeId ");
			query.setParameter("employeeId", employeeId);
			Employee employee = (Employee) query.uniqueResult();
			// commit();
			return employee.getEnterprise().getEnterpriseId();
		} catch (HibernateException e) {
			// rollback();
			return 1;

		}
	}
	
	
	public Employee selectEmployeeBySSN(String ssn)
			throws Exception {
		try {
			// begin();
			Query q = getSession()
					.createQuery(
							"from Employee where ssn = :ssn ");
			q.setString("ssn", ssn);
			Employee employee = (Employee) q.uniqueResult();
			// commit();
			return employee;
		} catch (HibernateException e) {
			// rollback();
			return null;

		}
	}

}
