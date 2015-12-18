package com.me.care;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.me.care.dao.MessageDao;
import com.me.care.dao.PatientDao;
import com.me.care.dao.UserDao;
import com.me.care.model.Message;
import com.me.care.model.Patient;
import com.me.care.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MessageController {

	private static final Logger logger = LoggerFactory
			.getLogger(MessageController.class);

	

	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/showMessages.htm")
	public String showMessages(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String userName = user.getUserName();
		List<Message> messagesList;
		try {
			messagesList = messageDao.selectMessagesByUserName(userName);

			model.addAttribute("messages", messagesList);
			model.addAttribute("size", messagesList.size());
			return "showMessages";

		} catch (Exception e) {
			System.out.println("EXCEPTION" + e.getMessage());
		}

		return "showMessages";
	}
	@RequestMapping(value = "/patientMessages.htm")
	public String patientMessages(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String userName = user.getUserName();
		List<Message> messagesList;
		try {
			messagesList = messageDao.selectMessagesByUserName(userName);

			model.addAttribute("messages", messagesList);
			model.addAttribute("size", messagesList.size());
			return "patientMessages";

		} catch (Exception e) {
			System.out.println("EXCEPTION" + e.getMessage());
		}

		return "patientMessages";
	}
	
	
	@RequestMapping(value = "/reply.htm")
	public String reply(Model model, HttpServletRequest request,
			HttpSession session) {
		String toUser = (String) request.getParameter("fromUser");
		model.addAttribute("toUser", toUser);

		return "reply";
	}
	
	@RequestMapping(value = "/messageDoctor.htm")
	public String replyOfPatient(Model model, HttpServletRequest request,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		String userName = user.getUserName();
		
		Patient patient = null;
		String toUser = null;
		int patientId = user.getUserId();
		try {
			//get the userid of patient
			patient = patientDao.selectPatientById(patientId);

			int primaryDoctorId = patient.getPrimaryDoctorId();

			// get the userName of doctor
			User doctorUser = userDao.SelectUserByUserId(primaryDoctorId);
			 toUser = doctorUser.getUserName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("toUser", toUser);
		model.addAttribute("fromUser", user.getUserName());
		return "replyOfPatient";
	}
	
	@RequestMapping(value = "/send.htm")
	public String sendMessage(Model model, HttpServletRequest request,
			HttpSession session) {

		User user = (User) session.getAttribute("user");
		String userName = user.getUserName();

		String receiver = request.getParameter("receiver");

		String textMessage = request.getParameter("comment");

		Message message = new Message();
		message.setFromUser(userName);
		message.setToUser(receiver);
		message.setSentDate(new Date());
		
		message.setMessage(textMessage);
		try {
			messageDao.insertMessages(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("EXCEPTIOn" + e.getMessage());
		}
		return "successMessage";
	}
	@RequestMapping(value = "/sendDoctor.htm")
	public String sendMessageOfPatient(Model model, HttpServletRequest request,
			HttpSession session) {

		User user = (User) session.getAttribute("user");
		String userName = user.getUserName();

		String receiver = request.getParameter("receiver");

		String textMessage = request.getParameter("comment");

		Message message = new Message();
		message.setFromUser(userName);
		message.setToUser(receiver);
		message.setSentDate(new Date());
		
		message.setMessage(textMessage);
		try {
			messageDao.insertMessages(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("EXCEPTIOn" + e.getMessage());
		}
		return "successMessageOfPatient";
	}

	@RequestMapping(value = "/deleteMessage.htm")
	public String deleteMessages(Model model, HttpServletRequest request,
			HttpSession session,HttpServletResponse response) {

		String[] deletedMessageIds = request
				.getParameterValues("deleteMessage");
		
		//check if none of the messages are selected 
		if(deletedMessageIds == null){
			RequestDispatcher rd = request.getRequestDispatcher("showMessages.htm");
			request.setAttribute("errorMessage","Please select a message to delete");
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
		
		
		
		int count = 0;
		int noOfRowDeleted = 0;

		for (String messageId : deletedMessageIds) {
			try {
				noOfRowDeleted = messageDao.deleteMessageBasedOnId(Integer
						.parseInt(messageId));
				count = count + noOfRowDeleted;
			} catch (NumberFormatException e) {

			} catch (Exception e) {

			}

		}

		if (count == deletedMessageIds.length) {
			List<Message> messagesList;
			User user = (User) session.getAttribute("user");
			String userName = user.getUserName();
			try {
				messagesList = messageDao.selectMessagesByUserName(userName);

				model.addAttribute("messages", messagesList);
				model.addAttribute("size", messagesList.size());
				return "showMessages";

			} catch (Exception e) {
				System.out.println("EXCEPTION" + e.getMessage());
			}

		}

		return "error";
	}
	
	@RequestMapping(value = "/deleteMessageOfPatient.htm")
	public String deleteMessageOfPatient(Model model, HttpServletRequest request,
			HttpSession session,HttpServletResponse response) {

		String[] deletedMessageIds = request
				.getParameterValues("deleteMessage");
		
		//check if none of the messages are selected 
				if(deletedMessageIds == null){
					RequestDispatcher rd = request.getRequestDispatcher("patientMessages.htm");
					request.setAttribute("errorMessage","Please select a message to delete");
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
		
		
		
		
		int count = 0;
		int noOfRowDeleted = 0;

		for (String messageId : deletedMessageIds) {
			try {
				noOfRowDeleted = messageDao.deleteMessageBasedOnId(Integer
						.parseInt(messageId));
				count = count + noOfRowDeleted;
			} catch (NumberFormatException e) {

			} catch (Exception e) {

			}

		}

		if (count == deletedMessageIds.length) {
			List<Message> messagesList;
			User user = (User) session.getAttribute("user");
			String userName = user.getUserName();
			try {
				messagesList = messageDao.selectMessagesByUserName(userName);

				model.addAttribute("messages", messagesList);
				model.addAttribute("size", messagesList.size());
				return "patientMessages";

			} catch (Exception e) {
				System.out.println("EXCEPTION" + e.getMessage());
			}

		}

		return "error";
	}
	
	
	
}
