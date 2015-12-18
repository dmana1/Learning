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
public class DoctorController {

	private static final Logger logger = LoggerFactory
			.getLogger(DoctorController.class);

	

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
	
	
	
	@RequestMapping(value = "/managePatient.htm", method = RequestMethod.GET)
	public String managePatient(Model model, HttpServletRequest request,
			HttpSession session) {
		User user = (User)session.getAttribute("user");
		int doctorId = user.getUserId();	
		List<Patient> patientList = null;	
		patientList = patientDao.selectPatientByPrimaryDoctor(doctorId);
		model.addAttribute("patientList",patientList);			
	
		return "managePatient";
	}

	@RequestMapping(value = "/doctorHome.htm", method = RequestMethod.GET)
	public String doctorHome(Model model, HttpServletRequest request,
			HttpSession session) {
		
		return "doctorHome";
	}


	@RequestMapping(value = "/showAddPatient.htm", method = RequestMethod.GET)
	public String showAddPatient(Model model, HttpServletRequest request,
			HttpSession session) {
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "showAddPatient";
	}

	@RequestMapping(value = "/addPatient.htm", method = RequestMethod.POST)
	public String addEnterprise(Model model, HttpServletRequest request,HttpSession session) {
		//Fetch the request parameters
		User user = (User)session.getAttribute("user");
		int doctorId = user.getUserId();
		String  firstName = (String) request.getAttribute("firstName");
		String  lastName = (String) request.getAttribute("lastName");
		String  ssn = (String) request.getAttribute("ssn");
		String  dob = (String) request.getAttribute("dob");
		String  phoneNumber = (String) request.getAttribute("phoneNumber");
		String  address = (String) request.getAttribute("address");
		String  emailId =(String) request.getAttribute("emailId");	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			date = format.parse(dob);
			System.out.println(dob);

			System.out.println(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//check if patient already exists by ssn
		Patient checkPatient = null;
		try {
			checkPatient = patientDao.selectPatientBySSN(ssn);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(checkPatient != null){
			model.addAttribute("errorMessage","Patient already exists");
			return "showAddPatient";
		}
		
		
		Patient patient = new Patient();
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setSsn(ssn);
		patient.setDob(date);
		patient.setPhoneNumber(phoneNumber);
		patient.setAddress(address);
		patient.setEmailId(emailId);
		patient.setPrimaryDoctorId(doctorId);
		
				
		try {
			patientDao.insertPatient(patient);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		List<Patient> patientList = null;	
		patientList = patientDao.selectPatientByPrimaryDoctor(doctorId);
		model.addAttribute("patientList",patientList);			
	
		return "managePatient";
		
	}	
	

	@RequestMapping(value = "/showSearchPatient.htm", method = RequestMethod.GET)
	public String showSearchPatient(Model model, HttpServletRequest request,
			HttpSession session) {
		
		return "showSearchPatient";
	}
	
	
	@RequestMapping(value = "/searchById.htm", method = RequestMethod.GET)
	public String searchById(Model model, HttpServletRequest request, HttpSession session) {
		
		String patientIdString = (String) request.getAttribute("patientId");
		int patientId = 0;
		
		Patient patient = null;
		List<Encounter> encounterList = null;
		List<Vitalsign> vitalsignList = null;
		List<Medication> medicationList = null;
		
		try {
			patientId = Integer.parseInt(patientIdString);
			patient = patientDao.selectPatientById(patientId);
			
			if(patient == null){
				model.addAttribute("errorMessage","Patient does not exist");
				return "showSearchPatient";
			}
			
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
		
		
		return "searchByIdResults";
	}
	
	List<Medicines> medList = null;

	@RequestMapping(value = "/showCreateEncounter.htm", method = RequestMethod.POST)
	public String showAddEncounter(Model model, HttpServletRequest request,
			HttpSession session) {
		medList = new ArrayList<Medicines>();

		List<Drug> drugList = null;
		List<Enterprise> pharmaciesList = null;
		
		
		try {
			drugList = drugDao.selectDrugs();
			pharmaciesList = enterpriseDao.selectEnterprisesBasedOnType(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("drugList", drugList);
		model.addAttribute("pharmaciesList", pharmaciesList);
		
		return "showCreateEncounter";
	}
	
	@RequestMapping(value = "/dosage.htm", method = RequestMethod.GET)
	public @ResponseBody List<Medicines> state(HttpServletRequest request,HttpServletResponse response) {
		String drugId = request.getParameter("drugId");
		String dosage = request.getParameter("dosage");
		Drug drug = null;
		try {
			drug = drugDao.selectDrugByDrugId(drugId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//if the medicine is already added
		for(Medicines med : medList){
			if(med.getDrugId().equals(drugId)){
				int dose = med.getDose();
				dose = dose + Integer.parseInt(dosage);
				med.setDose(dose);
				return medList;
			}
		}
		
		
		Medicines medicines = new Medicines();
		medicines.setDrugId(drugId);
		medicines.setName(drug.getName());
		medicines.setUsageDirections(drug.getUsageDirections());
		medicines.setDose(Integer.parseInt(dosage));
		
		
		
		medList.add(medicines);
		
		return medList;
		
		
       
	}
	
	
	@RequestMapping(value = "/addEncounter.htm", method = RequestMethod.POST)
	public String addEncounter(Model model, HttpServletRequest request,HttpSession session) {
		//Fetch the request parameters
		Integer patientId = (Integer)session.getAttribute("patientId");
		Patient patient = new Patient();
		patient.setPatientId(patientId);
		
		String  respiratoryRateString = request.getParameter("respiratoryRate");
		String  heartRateString = request.getParameter("heartRate");
		String  weightString = request.getParameter("weight");
		String  bloodPressureString = request.getParameter("bloodPressure");
		
		String  selectedPharmacy = request.getParameter("selectedPharmacy");
		String  problem = request.getParameter("problem");
		String  description = request.getParameter("description");	
		
		float  respiratoryRate;
		float heartRate;
		float weight;
		float bloodPressure;
		try {
			//parse the input
			respiratoryRate = Float.parseFloat(respiratoryRateString);
			heartRate = Float.parseFloat(heartRateString);
			weight = Float.parseFloat(weightString);
			bloodPressure = Float.parseFloat(bloodPressureString);
			
			//Create vitalsign object
			Vitalsign vitalsign = new Vitalsign();
			vitalsign.setRespiratoryRate(respiratoryRate);
			vitalsign.setHeartRate(heartRate);
			vitalsign.setWeight(weight);
			vitalsign.setBloodPressure(bloodPressure);
			vitalsign.setPatient(patient);
			vitalsign.setCreatedOn(new Date());
			
			//Create encounter object
			Encounter encounter = new Encounter();
			encounter.setDescription(description);
			encounter.setProblem(problem);
			encounter.setPatient(patient);
			encounter.setEncounterDate(new Date());
			
			//create workrequest object
			Workrequest  workrequest  = null;
			if(medList.size() > 0){
			 workrequest = new Workrequest();
			workrequest.setAssignedTo(Integer.parseInt(selectedPharmacy));
			workrequest.setStatus("Pending");
			workrequest.setCreatedOn(new Date());
			workrequest.setPatientId(patientId);
			}
			
			
			
			vitalsignDao.insertVitalsign(vitalsign);
			encounterDao.insertEncounter(encounter);
			int requestId = 0;
			if(medList.size() > 0){
			 requestId = workRequestDao.insertRequest(workrequest);}
			
			
			//create the medicaiton with requestId
			for(Medicines med : medList){
				Medication medication = new Medication();
				medication.setDosage(med.getDose());
				Drug drug = new Drug();
				drug.setDrugId(med.getDrugId());
				medication.setDrug(drug);
				medication.setRequestId(requestId);
				medication.setPatient(patient);
				medication.setCreatedOn(new Date());
				
				medicationDao.insertMedication(medication);
			}
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return "successAddEncounter";
		
	}
	
	@RequestMapping(value = "/quickSearchResults.htm", method = RequestMethod.GET)
	public String quickSearchResults(Model model, HttpServletRequest request, HttpSession session) {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String ssn = request.getParameter("ssn");
		String phoneNumber =  request.getParameter("phoneNumber");
	
		List<Patient> patientList = null;
		
		
		 try {
			 patientList = patientDao.selectUserByMany(firstName, lastName, ssn, phoneNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		if(patientList != null && patientList.size() == 0){
			model.addAttribute("errorMessage","Patient does not exist");
			return "showSearchPatient";
		}
		
		model.addAttribute("patientList", patientList);
				
		
		
		
		return "quickSearchResults";
	}
}
