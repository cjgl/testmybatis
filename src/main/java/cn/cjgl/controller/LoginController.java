package cn.cjgl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value="login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		logger.info("login");
        
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="login1.do")
	public String login1(HttpServletRequest request, HttpServletResponse response){
		logger.info("login1");
        
		return "login";
	}
}
