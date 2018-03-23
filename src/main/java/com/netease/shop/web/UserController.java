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
	@RequestMapping(value="/logout")
	   
	public String logout(HttpSession session)
			throws IOException {
   
		session.invalidate();
		System.out.println("logout");
		
		return "redirect:/product/index";
	}
	public static void main(String[] args){
		String str="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521560120170&di=b74b841f2c6a654275e0c6a860d12138&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0159cf5848d440a801219c77259a61.jpg%401280w_1l_2o_100sh.jpg";
	    System.out.println(str.length());
	}
}
