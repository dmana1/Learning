package com.me.care;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.me.care.dao.ResumeUploadDao;
import com.me.care.model.ResumeUpload;
import com.me.care.model.User;
import com.me.care.upload.FileUpload;
@Controller
public class FileUploadController {
	
	@Autowired
	private ResumeUploadDao resumeUploadDao;
 
	@RequestMapping(value = "/uploadFile.htm", method = RequestMethod.POST)
	public  String uploadFile(@ModelAttribute("fileUpload") FileUpload fileUpload,
			Model map) {
		String saveToDirectory = "C:\\Users\\Deepthi\\Documents\\Tools\\Proj\\";
		MultipartFile multipartFile = fileUpload.getFile();
		 String fileName = multipartFile.getOriginalFilename();
		 if(!fileName.isEmpty()){
			 try {
				multipartFile.transferTo(new File(saveToDirectory + fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 String name = fileUpload.getName();
		 String path = saveToDirectory + fileName;
		 ResumeUpload resumeUpload = new ResumeUpload();
		 resumeUpload.setName(name);
		 resumeUpload.setPath(path);
		 try {
			resumeUploadDao.insertResumeUpload(resumeUpload);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		 return "uploadSuccess";
		
	}
	

}
