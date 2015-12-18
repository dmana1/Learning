package com.me.care;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.me.care.model.Encounter;
import com.me.care.model.Medication;
import com.me.care.model.Patient;
import com.me.care.model.Vitalsign;


public class PDFGenerator extends AbstractPdfView{
	
//	public PDFGenerator(Patient patient) throws DocumentException{
//		Document document = new Document();
//		try {
//			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Deepthi\\Desktop\\bck up\\Encounter.pdf"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		document.open();
//
//		
//
//                Chunk chunk1 = new Chunk(patient.getEmailId().toString());
//           
//                Chunk chunk2 = new Chunk(patient.getEmailId().toString());
//
//               
//
//
//
//		Phrase phrase1 = new Phrase( "p1:"  );
//                phrase1.add(chunk1);
//
//                Phrase phrase21 = new Phrase("p2");
//                phrase21.add(chunk2);
//
//              
//                 
//
//		Paragraph paragraph = new Paragraph(); 
//		paragraph.add(phrase1);
//                
//               
//                Paragraph paragraph22 = new Paragraph();
//                paragraph22.add(phrase21);
//
//		document.add(paragraph);
//                document.add(paragraph22);
//                document.add(paragraph22);
//                document.add(paragraph22);
//                document.add(paragraph22);
//              
//                document.add(paragraph22);
//                document.add(paragraph22);
//                document.add(paragraph22);
//              
//                document.add(paragraph22);
//                document.add(paragraph22);
//                document.add(paragraph22);
//             	document.close();
//		
//	}
	
	Patient patient ;
	List<Encounter> encounterList ;
	List<Vitalsign> vitalsignList ;
	List<Medication> medicationList ;
	
	public PDFGenerator(Patient patient ,List<Encounter> encounterList,List<Vitalsign> vitalsignList,List<Medication> medicationList) {
	  this.patient = patient;
	  this.encounterList = encounterList;
	  this.vitalsignList = vitalsignList;
	  this.medicationList = medicationList;
	}

@Override
protected void buildPdfDocument(Map<String, Object> model, Document document,
		PdfWriter arg2, HttpServletRequest request, HttpServletResponse response)
		throws Exception {
    document.addTitle("Encounter Details PDF");
    Paragraph p1 = new Paragraph("Patient MRN : "+ this.patient.getPatientId());
    document.add(p1);
    Paragraph p2 = new Paragraph("Name : "+ this.patient.getFirstName() + " " + this.patient.getLastName());
    document.add(p2);
    Paragraph p3 = new Paragraph("SSN : "+ this.patient.getSsn());
    document.add(p3);
    Paragraph p4 = new Paragraph("Date Of Birth : "+ this.patient.getDob());
    document.add(p4);
    Paragraph p5 = new Paragraph("Email ID : "+ this.patient.getEmailId());
    document.add(p5);
 
	Table table1 = new Table(4);
	table1.addCell("Encounter ID");
	table1.addCell("Date");
	table1.addCell("Problem");
	table1.addCell("Description");

		for (Encounter encounter : this.encounterList) {
			table1.addCell(encounter.getEncounterId().toString());
			table1.addCell(encounter.getEncounterDate().toString());
			table1.addCell(encounter.getProblem());
			table1.addCell(encounter.getDescription());

			
		}

	document.add(table1);
	  p2 = new Paragraph("");
	 document.add(p2);
	Table table2 = new Table(4);
	table2.addCell("Medication ID");
	table2.addCell("Date");
	table2.addCell("Drug");
	table2.addCell("Dosage");

		for (Medication medication : this.medicationList) {
			table2.addCell(medication.getMedicationId().toString());
			table2.addCell(medication.getCreatedOn().toString());
			table2.addCell(medication.getDrug().getDrugId());
			table2.addCell(medication.getDosage().toString());

			
		}

	document.add(table2);
	
	Table table4 = new Table(6);
	table4.addCell("VitalSign ID");
	table4.addCell("Date");
	table4.addCell("Blood Pressure");
	table4.addCell("HeartRate");
	table4.addCell("weight");
	table4.addCell("RespiratoryRate");

		for (Vitalsign vitalsign : this.vitalsignList) {
			table4.addCell(vitalsign.getVitalSignId().toString());
			table4.addCell(vitalsign.getCreatedOn().toString());
			table4.addCell(vitalsign.getBloodPressure().toString());
			table4.addCell(vitalsign.getHeartRate().toString());
			table4.addCell(vitalsign.getWeight().toString());
			table4.addCell(vitalsign.getRespiratoryRate().toString());


			
		}

	document.add(table4);
	
}

}
