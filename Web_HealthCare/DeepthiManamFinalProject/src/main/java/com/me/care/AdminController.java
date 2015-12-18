package com.me.care;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.care.dao.EmployeeDao;
import com.me.care.dao.EnterpriseDao;
import com.me.care.dao.ResumeUploadDao;
import com.me.care.dao.UserDao;
import com.me.care.model.Employee;
import com.me.care.model.Ent;
import com.me.care.model.Enterprise;
import com.me.care.model.Enterprisetype;
import com.me.care.model.ResumeUpload;
import com.me.care.model.Role;
import com.me.care.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/*
	 * Specify this useValidate will be injected
	 */


	@Autowired
	private EnterpriseDao enterpriseDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private ResumeUploadDao resumeUploadDao;
	
	@Autowired
	private UserDao userDao;
	
	

	
	@RequestMapping(value = "/viewEnterprise.htm", method = RequestMethod.GET)
	public String viewEnterprise(Model model) {
		List<Enterprise> enterprisesList = null;
		try {
			enterprisesList =	enterpriseDao.selectEnterprises();
			model.addAttribute("enterprisesList", enterprisesList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "viewEnterprise";
	}	
	
	@RequestMapping(value = "/addEnterprise.htm", method = RequestMethod.GET)
	public String addEnterprise(Model model, HttpServletRequest request) {
		String enterpriseName = request.getParameter("enterpriseName");
		int enterpriseType = Integer.parseInt(request.getParameter("enterpriseType"));
		Enterprise enterprise = new Enterprise();
		enterprise.setName(enterpriseName);
		Enterprisetype enterprise_type = new Enterprisetype();
		enterprise_type.setEnterpriseTypeId(enterpriseType);
		enterprise.setEnterprisetype(enterprise_type);
		//check whether enterprise already exists		
		Enterprise ent = null;
		try {
			ent =enterpriseDao.selectEnterpriseByName(enterpriseName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(ent != null){
			model.addAttribute("errorMessage","Enterprise already exists");
			return "showAddEnterprise";
		}
		
		//if enterprise does not exist , insert into db
		try {
			enterpriseDao.insertEnterprise(enterprise);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//After adding showing the view enterprise page
		List<Enterprise> enterprisesList = null;
		try {
			enterprisesList =	enterpriseDao.selectEnterprises();
			model.addAttribute("enterprisesList", enterprisesList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "viewEnterprise";
	}	
	
	@RequestMapping(value = "/showAddEnterprise.htm", method = RequestMethod.GET)
	public String showAddEnterprise() {
		
		
		return "showAddEnterprise";
	}

	@RequestMapping(value = "/deleteEnterprise.htm", method = RequestMethod.GET)
	public String deleteEnterprise(Model model, HttpServletRequest request, HttpServletResponse response) {
		String[] deletedEnterpriseIDs = request.getParameterValues("deleteEnterprise");
		
		//check if no enterprise is selected
		if(deletedEnterpriseIDs == null){
			RequestDispatcher rd = request.getRequestDispatcher("viewEnterprise.htm");
			request.setAttribute("errorMessage","Please select an enterprise to delete");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(String deleteEnterpriseId :deletedEnterpriseIDs ){
		try {
			enterpriseDao.deleteEnterprise(Integer.parseInt(deleteEnterpriseId));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//After deleting showing the view enterprise page
				List<Enterprise> enterprisesList = null;
				try {
					enterprisesList =	enterpriseDao.selectEnterprises();
					model.addAttribute("enterprisesList", enterprisesList);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return "viewEnterprise";
	}
	
	
	@RequestMapping(value = "/manageEmployee.htm", method = RequestMethod.GET)
	public String manageEmployee(Model model) {
		List<Employee> employeeList = null;
		try {
			employeeList =	employeeDao.selectEmployees();
			model.addAttribute("employeeList", employeeList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "manageEmployee";
	}	
	
	@RequestMapping(value = "/deleteEmployee.htm", method = RequestMethod.GET)
	public String deleteEmployee(Model model, HttpServletRequest request, HttpServletResponse response) {
		String[] deletedEmployeeIDs = request.getParameterValues("deleteEmployee");
		
		//check if no enterprise is selected
				if(deletedEmployeeIDs == null){
					RequestDispatcher rd = request.getRequestDispatcher("manageEmployee.htm");
					request.setAttribute("errorMessage","Please select an employee to delete");
					try {
						rd.forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
		for(String deleteEmployeeId :deletedEmployeeIDs ){
		try {
			employeeDao.deleteEmployee(Integer.parseInt(deleteEmployeeId));
			userDao.deleteUserBasedOnId(Integer.parseInt(deleteEmployeeId));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//After deleting showing the view enterprise page
		List<Employee> employeeList = null;
		try {
			employeeList =	employeeDao.selectEmployees();
			model.addAttribute("employeeList", employeeList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return "manageEmployee";
	}
	
	@RequestMapping(value = "/showAddEmployee.htm", method = RequestMethod.GET)
	public String showAddEmployee() {
		
		
		return "showAddEmployee";
	}
	
	@RequestMapping(value = "/addEmployee.htm", method = RequestMethod.GET)
	public String addEmployee(Model model, HttpServletRequest request) {
		String enterpriseIdString = request.getParameter("enterprise");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String ssn = request.getParameter("ssn");
		String phoneNumber = request.getParameter("phoneNumber");
		String emailId = request.getParameter("emailId");
		String designation = request.getParameter("designation");
		String dob = request.getParameter("dob");
		String roleIdString = request.getParameter("role");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int roleId = 0;
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		Date date = null;
		
		int enterpriseId = 0;
		try {
			enterpriseId = Integer.parseInt(enterpriseIdString);
			 date = format.parse(dob);
			roleId = Integer.parseInt(roleIdString);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//check whether employee already exists using ssn
		Employee checkEmployee = null;
		try {
			checkEmployee = employeeDao.selectEmployeeBySSN(ssn);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(checkEmployee != null){
			model.addAttribute("errorMessage","Employee already exists");
			return "showAddEmployee";
		}
		
		//check whether username already exists
		User checkUser = null;
		try {
			checkUser = userDao.queryUserByUserName(username);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(checkUser != null){
			model.addAttribute("errorMessage","UserName already exists");
			return "showAddEmployee";
		}
		
		
		

		//Form the employee object
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSsn(ssn);
		employee.setEmailId(emailId);
		employee.setPhoneNumber(phoneNumber);
		employee.setDesignation(designation);
		employee.setDob(date);
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseId(enterpriseId);
		employee.setEnterprise(enterprise);
		Role role = new Role();
		role.setRoleId(roleId);
		employee.setRole(role);
		
		//form the user object
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		
		
		
		try {
			employeeDao.insertEmployee(employee, user);
			userDao.insertUser(user);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//After adding showing the view employee page
		List<Employee> employeeList = null;
		try {
			employeeList =	employeeDao.selectEmployees();
			model.addAttribute("employeeList", employeeList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "manageEmployee";
	}	
	
	
	@RequestMapping(value = "/enterprise.htm", method = RequestMethod.GET)
	public @ResponseBody  List<Ent> enterprise(HttpServletRequest request, HttpServletResponse response) {
		String enterpriseTypeId = request.getParameter("enterpriseType");
		
		
		List<Enterprise> enterpriseList= null;
		try {
			enterpriseList = enterpriseDao.selectEnterprisesBasedOnType(Integer.parseInt(enterpriseTypeId));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Ent> entList = new ArrayList<Ent>();
		for(Enterprise ent : enterpriseList){
			entList.add(new Ent(ent.getEnterpriseId(), ent.getName()));
		}
		

		
		
		return entList;
		
		
       
	}
	
	@RequestMapping(value = "/state.htm", method = RequestMethod.GET)
	public @ResponseBody List<Enterprise> state(HttpServletResponse response) {
		
		List<Enterprise> enterList = new ArrayList<Enterprise>();
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseId(1);
		enterprise.setName("sssss");
		enterList.add(enterprise);
		
		return enterList;
		
		
       
	}
	
	
	@RequestMapping(value = "/viewResume.htm", method = RequestMethod.GET)

	public String showResume(Model model, HttpServletRequest request) {


	List<ResumeUpload> resumeList=null;

	try {

	resumeList = resumeUploadDao.selectResumes();

	model.addAttribute("resumeList", resumeList);

	} catch (Exception e) {

	// TODO Auto-generated catch block

	e.printStackTrace();

	}


	return "manageResumes";

	}
	
	
	@RequestMapping(value = "/downloadResume.htm", method = RequestMethod.GET)

	public @ResponseBody void doDownload(HttpServletRequest request,

	HttpServletResponse response,@RequestParam("fullPath")String fullPath,@RequestParam("name")String name) {


	try

	{		ServletContext servletContext =  request.getSession().getServletContext();

	        File downloadFile = new File(fullPath);

	        FileInputStream inputStream = new FileInputStream(downloadFile);

	        

	        // get MIME type of the file

	        String mimeType = servletContext.getMimeType(fullPath);

	     
	        
	     

	 

	        // set content attributes for the response

	        response.setContentType(mimeType);

	        response.setContentLength((int) downloadFile.length());

	 

	        // set headers for the response

	        String headerKey = "Content-Disposition";

	        String headerValue = String.format("attachment; filename=\"%s\"",

	              name);

	        response.setHeader(headerKey, headerValue);

	 

	        // get output stream of the response

	        OutputStream outStream = response.getOutputStream();

	 

	        byte[] buffer = new byte[4096];

	        int bytesRead = -1;

	 

	        // write bytes read from the input stream into the output stream

	        while ((bytesRead = inputStream.read(buffer)) != -1) {

	            outStream.write(buffer, 0, bytesRead);

	        }

	 

	        inputStream.close();

	        outStream.close();

	}catch(Exception e)

	{

	 

	}

	 

	    }
}
