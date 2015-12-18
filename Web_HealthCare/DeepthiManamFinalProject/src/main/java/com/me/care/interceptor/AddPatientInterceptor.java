package com.me.care.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AddPatientInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)

	throws Exception {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String ssn = request.getParameter("ssn");
		String dob = request.getParameter("dob");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String emailId = request.getParameter("emailId");

		String name = request.getParameter("name");

		if (firstName != null) {

			firstName = firstName.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
			firstName = firstName.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
			firstName = firstName.replaceAll("'", "");
			firstName = firstName.replaceAll("eval\\((.*)\\)", "");
			firstName = firstName.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
					"\"\"");
			firstName = firstName.replaceAll("script", "");
			request.setAttribute("firstName", firstName);
		}

		if (lastName != null) {

			lastName = lastName.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
			lastName = lastName.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
			lastName = lastName.replaceAll("'", "");
			lastName = lastName.replaceAll("eval\\((.*)\\)", "");
			lastName = lastName.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
					"\"\"");
			lastName = lastName.replaceAll("script", "");
			request.setAttribute("lastName", lastName);
		}

		
		if (ssn != null) {

			ssn = ssn.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
			ssn = ssn.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
			ssn = ssn.replaceAll("'", "");
			ssn = ssn.replaceAll("eval\\((.*)\\)", "");
			ssn = ssn.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
					"\"\"");
			ssn = ssn.replaceAll("script", "");
			request.setAttribute("ssn", ssn);
		}
		if (dob != null) {

			dob = dob.replaceAll("script", "");
			request.setAttribute("dob", dob);
		}
		if (phoneNumber != null) {

			phoneNumber = phoneNumber.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
			phoneNumber = phoneNumber.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
			phoneNumber = phoneNumber.replaceAll("'", "");
			phoneNumber = phoneNumber.replaceAll("eval\\((.*)\\)", "");
			phoneNumber = phoneNumber.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
					"\"\"");
			phoneNumber = phoneNumber.replaceAll("script", "");
			request.setAttribute("phoneNumber", phoneNumber);
		}
		if (address != null) {

			address = address.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
			address = address.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
			address = address.replaceAll("'", "");
			address = address.replaceAll("eval\\((.*)\\)", "");
			address = address.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
					"\"\"");
			address = address.replaceAll("script", "");
			request.setAttribute("address", address);
		}
		if (emailId != null) {

			emailId = emailId.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
			emailId = emailId.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
			emailId = emailId.replaceAll("'", "");
			emailId = emailId.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
					"\"\"");
			emailId = emailId.replaceAll("script", "");
			request.setAttribute("emailId", emailId);
		}

		return true;

	}

}
