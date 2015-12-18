package com.me.care;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.care.dao.DrugDao;
import com.me.care.dao.EncounterDao;
import com.me.care.dao.EnterpriseDao;
import com.me.care.dao.MedicationDao;
import com.me.care.dao.PatientDao;
import com.me.care.dao.VitalsignDao;
import com.me.care.dao.WorkRequestDao;
import com.me.care.model.Drug;
import com.me.care.model.Encounter;
import com.me.care.model.Enterprise;
import com.me.care.model.Medication;
import com.me.care.model.Medicines;
import com.me.care.model.Patient;
import com.me.care.model.User;
import com.me.care.model.Vitalsign;
import com.me.care.model.Workrequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PatientController {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientController.class);

	

	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private EncounterDao encounterDao;
	
	@Autowired
	private VitalsignDao vitalsignDao;
	
	@Autowired
	private MedicationDao medicationDao;
	
	@Autowired
	private DrugDao drugDao;
	
	@Autowired
	private EnterpriseDao enterpriseDao;
	
	@Autowired
	private WorkRequestDao workRequestDao;
	
	

	
	@RequestMapping(value = "/viewEncounterDetails.htm", method = RequestMethod.GET)
	public String searchById(Model model, HttpServletRequest request, HttpSession session) {
		
		User user =	(User)session.getAttribute("user");
		int patientId = user.getUserId();
		
		Patient patient = null;
		List<Encounter> encounterList = null;
		List<Vitalsign> vitalsignList = null;
		List<Medication> medicationList = null;
		
		try {
			patient = patientDao.selectPatientById(patientId);
			//get the encounter history of the patient
			encounterList = encounterDao.selectEncounterByMRN(patientId);
			vitalsignList = vitalsignDao.selectVitalSignByMRN(patientId);
			medicationList = medicationDao.selectMedicationByMRN(patientId);
			
			 
			 
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		model.addAttribute("patient", patient);
		model.addAttribute("encounterList", encounterList);
		model.addAttribute("vitalsignList", vitalsignList);
		model.addAttribute("medicationList",medicationList);
		session.setAttribute("patientId", patient.getPatientId());
		
		
		return "viewEncounterDetails";
	}
	
	@RequestMapping(value = "/patientHome.htm", method = RequestMethod.GET)
	public String doctorHome(Model model, HttpServletRequest request,
			HttpSession session) {
		
		return "patientHome";
	}
	
	
}
