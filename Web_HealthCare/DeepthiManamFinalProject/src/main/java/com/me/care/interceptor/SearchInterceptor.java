package com.me.care.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SearchInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)

	throws Exception {

		String patientId = request.getParameter("patientId");

		if (patientId != null) {

			patientId = patientId.replaceAll("<", "& lt;").replaceAll(">",
					"& gt;");
			patientId = patientId.replaceAll("\\(", "& #40;").replaceAll("\\)",
					"& #41;");
			patientId = patientId.replaceAll("'", "");
			patientId = patientId.replaceAll("eval\\((.*)\\)", "");
			patientId = patientId.replaceAll(
					"[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
			patientId = patientId.replaceAll("script", "");
			request.setAttribute("patientId", patientId);
		}

		String firstName = request.getParameter("patientId");

		if (firstName != null) {

			firstName = firstName.replaceAll("<", "& lt;").replaceAll(">",
					"& gt;");
			firstName = firstName.replaceAll("\\(", "& #40;").replaceAll("\\)",
					"& #41;");
			firstName = firstName.replaceAll("'", "");
			firstName = firstName.replaceAll("eval\\((.*)\\)", "");
			firstName = firstName.replaceAll(
					"[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
			firstName = firstName.replaceAll("script", "");
			request.setAttribute("firstName", firstName);
		}

		String lastName = request.getParameter("lastName");

		if (lastName != null) {

			lastName = lastName.replaceAll("<", "& lt;").replaceAll(">",
					"& gt;");
			lastName = lastName.replaceAll("\\(", "& #40;").replaceAll("\\)",
					"& #41;");
			lastName = lastName.replaceAll("'", "");
			lastName = lastName.replaceAll("eval\\((.*)\\)", "");
			lastName = lastName.replaceAll(
					"[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
			lastName = lastName.replaceAll("script", "");
			request.setAttribute("lastName", lastName);
		}

		String ssn = request.getParameter("ssn");

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

		String phoneNumber = request.getParameter("phoneNumber");

		if (phoneNumber != null) {

			phoneNumber = phoneNumber.replaceAll("<", "& lt;").replaceAll(">",
					"& gt;");
			phoneNumber = phoneNumber.replaceAll("\\(", "& #40;").replaceAll(
					"\\)", "& #41;");
			phoneNumber = phoneNumber.replaceAll("'", "");
			phoneNumber = phoneNumber.replaceAll("eval\\((.*)\\)", "");
			phoneNumber = phoneNumber.replaceAll(
					"[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
			phoneNumber = phoneNumber.replaceAll("script", "");
			request.setAttribute("phoneNumber", phoneNumber);
		}

		return true;

	}

}
