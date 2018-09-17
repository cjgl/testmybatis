package cn.cjgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjgl.model.User;
import cn.cjgl.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="queryUsers.do",
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public HashMap<String, Object> queryUsers(HttpServletRequest request){
		logger.info("queryUsers");
		
		logger.info(request.getSession().getAttribute("sID"));
		
		User user = new User();
		List<User> users = this.userService.queryUsers(user);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("users", users);
		return hashMap;
	}
	
	@RequestMapping(value="addUser.do",
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public HashMap<String, Object> addUser(User user){
		logger.info("addUser");
		this.userService.addUser(user);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("success", true);
		hashMap.put("msg", "新增成功！");
		return hashMap;
	}
	
	@RequestMapping(value="delUser.do", method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public HashMap<String, Object> delUser(@RequestParam("id")int id){
		logger.info("delUser");
		
		User user = new User();
		user.setId(id);
		this.userService.delUser(user);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("success", true);
		hashMap.put("msg", "删除成功！");
		return hashMap;
	}
	
	@RequestMapping(value="modUser.do", method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public HashMap<String, Object> modUser(User user, HttpServletRequest request){
		logger.info("modUser");
		
		this.userService.modUser(user);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("success", true);
		hashMap.put("msg", "修改成功！");
		hashMap.put("date", new Date());
		return hashMap;
	}

}
