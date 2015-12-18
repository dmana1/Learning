package com.me.care;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.me.care.dao.EmployeeDao;
import com.me.care.dao.MedicationDao;
import com.me.care.dao.PatientDao;
import com.me.care.dao.WorkRequestDao;
import com.me.care.model.Medication;
import com.me.care.model.Patient;
import com.me.care.model.User;
import com.me.care.model.Workrequest;

@Controller
public class PharmaController {
	
	
	@Autowired
	private WorkRequestDao workRequestDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private MedicationDao medicationDao;
	
	
	
	@RequestMapping(value = "/manageWorkRequest.htm")
	public String managePatient(Model model, HttpServletRequest request,
			HttpSession session) {
		User user = (User)session.getAttribute("user");
		int pharmacistId = user.getUserId();
		int enterpriseId = 0;
		
		try {
			enterpriseId = employeeDao.selectEnterpriseIdOfEmployee(pharmacistId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Workrequest> workRequestList = null;	
		workRequestList = workRequestDao.selectWorkRequestByEnterprise(enterpriseId);
		model.addAttribute("workRequestList",workRequestList);			
	
		return "manageWorkRequest";
	}
	
	@RequestMapping(value = "/processPrescription.htm")
	public String processPrescription(Model model, HttpServletRequest request,HttpServletResponse response,
			HttpSession session) {
		User user = (User)session.getAttribute("user");
		int pharmacistId = user.getUserId();
		
		String workRequestString = request.getParameter("processId");
		
		if(workRequestString == null){
			RequestDispatcher rd = request.getRequestDispatcher("manageWorkRequest.htm");
			request.setAttribute("errorMessage","Please select a request to process it");
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
		
		
		int workRequestId = 0;
		Workrequest  workrequest = null;
		try {
			workRequestId = Integer.parseInt(workRequestString);
			workrequest = workRequestDao.selectWorkRequestByRequestId(workRequestId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//check status
		String status = workrequest.getStatus();
		if(!status.equalsIgnoreCase("pending")){
			model.addAttribute("errorMessage","Request is already processed");
			RequestDispatcher rd = request.getRequestDispatcher("manageWorkRequest.htm");
			request.setAttribute("errorMessage","Request is already processed");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			try {
				Patient patient = patientDao.selectPatientById(workrequest.getPatientId());				
				List<Medication>medicationList = medicationDao.selectMedicationByWorkRequestId(workRequestId);
				model.addAttribute("patient", patient);
				model.addAttribute("medicationList", medicationList);
				model.addAttribute("workRequestString", workRequestString);

				return "processWorkRequest";
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return "processWorkRequest";
					
	
		
	}
	
	
	@RequestMapping(value = "/completeWorkRequest.htm")
	public void completeWorkRequest(Model model, HttpServletRequest request,HttpServletResponse response,
			HttpSession session) {
		User user = (User)session.getAttribute("user");
		int pharmacistId = user.getUserId();
		
		String workRequestString = request.getParameter("workRequestString");
		int workRequestId = 0;
		Workrequest  workrequest = null;
		try {
			workRequestId = Integer.parseInt(workRequestString);
			workrequest = workRequestDao.selectWorkRequestByRequestId(workRequestId);
			workrequest.setStatus("Completed");
			workRequestDao.updateWorkRequestByID(workrequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("manageWorkRequest.htm");
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

}
