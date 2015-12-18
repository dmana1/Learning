package com.me.care;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ServicesController {
	
	@RequestMapping(value = "/services.htm")
	public ModelAndView services(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		ServiceFreeMarkerView sfmv = new ServiceFreeMarkerView();
//		sfmv.setUrl("/WEB-INF/templates/index.ftl");
//		HashMap<String,Object> model = new HashMap<String,Object>();
//		sfmv.doRender(model, request, response);
		
		ModelAndView mv = new ModelAndView("services");
		return mv;
	}

}
