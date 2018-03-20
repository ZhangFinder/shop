package com.netease.shop.web;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.netease.shop.meta.User;
import com.netease.shop.service.IUserService;

@Controller
@RequestMapping("/user") 
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/login",produces = "application/json; charset=utf-8")
   
	public  @ResponseBody String login(@RequestParam("userName") String userName, @RequestParam("password") String password,HttpSession httpSession, ModelMap map)
			throws IOException {
   
        System.out.println("password:"+password);;
		User u=userService.checkUsernameAndPwd(userName, password);
	
		ObjectMapper mapper = new ObjectMapper(); 
		ObjectNode root1 = mapper.createObjectNode();
		if(u!=null){
			
			httpSession.setAttribute("user", u);
			root1.put("code", 200); 
			root1.put("result", "登陆成功!"); 
		}else{
		
			root1.put("code", 300); 
			root1.put("message", "登陆 失败！"); 
		}
		
		return root1.toString();
	}
	public static void main(String[] args){
		ObjectMapper mapper = new ObjectMapper(); 
		ObjectNode root1 = mapper.createObjectNode();
		root1.put("code", 300); 
		root1.put("message", "用户名或者密码错误！"); 
		System.out.println(root1.toString());
	}
}
