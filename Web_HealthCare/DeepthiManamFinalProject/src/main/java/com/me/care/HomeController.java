package com.me.care;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.care.dao.UserDao;
import com.me.care.model.Encounter;
import com.me.care.model.Medication;
import com.me.care.model.Patient;
import com.me.care.model.User;
import com.me.care.model.Vitalsign;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/*
	 * Specify this useValidate will be injected
	 */
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Autowired
	private UserDao userDao;
	
	
	
	

	/*
	 * This is to initialize webDataBinder,set its validator as we specify.
	 */
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/signin.htm", method = RequestMethod.GET)
	public String initUserLoginForm(Model model, HttpServletRequest request,
			HttpSession session) {

		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String submitForm(Model model, @Validated User user,
			BindingResult result, HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		model.addAttribute("user", user);
		String returnVal = "adminHome";
	
		HttpSession session1 = request.getSession();
		
		if (result.hasErrors()) {

			return "login";
		} else {
			try {
				User u = userDao.queryUserByNameAndPassword(user.getUserName(),
						user.getPassword());
				if (u != null) {
					// get the role of user
					int roleId = u.getRole().getRoleId();

					if (roleId == 1) {
						model.addAttribute("user", u);
						session.setAttribute("user", u);
						session1.setAttribute("user", u);
						

						return returnVal;
					} else if (roleId == 2) {
						model.addAttribute("user", u);
						session.setAttribute("user", u);
						session1.setAttribute("user", u);
						//in future retrieve employee and set in session
						
						return "doctorHome";

					}else if(roleId == 5){
						model.addAttribute("user", u);
						session.setAttribute("user", u);
						session1.setAttribute("user", u);
												
						return "patientHome";
					}
					else if(roleId == 3){
						model.addAttribute("user", u);
						session.setAttribute("user", u);
						session1.setAttribute("user", u);
												
						return "pharmacistHome";
					}

				} else {
					model.addAttribute("errorMessage", "Invalid Credentials");

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return "login";

	}
	
	
	
	
	


	@RequestMapping(value = "/careers.htm", method = RequestMethod.GET)
	public String careers() {

		return "showCareers";
	}

	@RequestMapping(value = "/blog.htm", method = RequestMethod.GET)
	public String blog() {

		return "blog";
	}

	
	@RequestMapping(value = "/gallery.htm", method = RequestMethod.GET)
	public String gallery() {

		return "gallery";
	}

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request, HttpSession session) {
		HttpSession session1 = request.getSession();
		User user = new User();
		model.addAttribute("user", user);
		session1.setAttribute("user", null);
		session.invalidate();
		return "login";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}
	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String homeLink() {

		return "home";
	}
}
