package com.me.care;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.care.dao.EncounterDao;
import com.me.care.dao.MedicationDao;
import com.me.care.dao.PatientDao;
import com.me.care.dao.VitalsignDao;
import com.me.care.model.Encounter;
import com.me.care.model.Medication;
import com.me.care.model.Patient;
import com.me.care.model.Vitalsign;


@Controller
public class PdfController {
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private EncounterDao encounterDao;
	
	@Autowired
	private VitalsignDao vitalsignDao;
	
	@Autowired
	private MedicationDao medicationDao;
	
//	@RequestMapping(value="/encounterPdf.htm",method = RequestMethod.POST)
//    public String encounterPdf(Model model,HttpServletRequest request,HttpSession session)
//   {
//		Integer patientId = (Integer)session.getAttribute("patientId");
//		
//		
//		Patient patient = null;
//		List<Encounter> encounterList = null;
//		List<Vitalsign> vitalsignList = null;
//		List<Medication> medicationList = null;
//		try {
//			
//			patient = patientDao.selectPatientById(patientId);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//			//get the encounter history of the patient
//			encounterList = encounterDao.selectEncounterByMRN(patientId);
//			vitalsignList = vitalsignDao.selectVitalSignByMRN(patientId);
//			medicationList = medicationDao.selectMedicationByMRN(patientId);
//			
//			try {
//				PDFGenerator pdfGenerator = new PDFGenerator(patient);
//			} catch (DocumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			model.addAttribute("patient", patient);
//			model.addAttribute("encounterList", encounterList);
//			model.addAttribute("vitalsignList", vitalsignList);
//			model.addAttribute("medicationList",medicationList);
//		
//		
//			return "searchByIdResults";
//		
//    	
//    }
	
	
	@RequestMapping(value="/encounterPdf.htm",method = RequestMethod.POST)
	protected ModelAndView encounterPdf(HttpServletRequest request,
		HttpServletResponse response,HttpSession session) throws Exception {
		
		Integer patientId = (Integer)session.getAttribute("patientId");
		
		
		Patient patient = null;
		List<Encounter> encounterList = null;
		List<Vitalsign> vitalsignList = null;
		List<Medication> medicationList = null;
		try {
			
			patient = patientDao.selectPatientById(patientId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			//get the encounter history of the patient
			encounterList = encounterDao.selectEncounterByMRN(patientId);
			vitalsignList = vitalsignDao.selectVitalSignByMRN(patientId);
			medicationList = medicationDao.selectMedicationByMRN(patientId);
			
			
			
		
		
		PDFGenerator p = new PDFGenerator(patient,encounterList,vitalsignList,medicationList);
		
		
		 return new ModelAndView(p,"patient",patient);
		
	}

}
