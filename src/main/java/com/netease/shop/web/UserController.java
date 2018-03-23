package com.netease.shop.web;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.netease.shop.meta.User;
import com.netease.shop.service.IUserService;

/**
 * 用户相关Controller,包括登陆和注销
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	/**
	 * 用户登陆
	 * 
	 * @param userName，password
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", produces = "application/json; charset=utf-8")
	public @ResponseBody String login(@RequestParam("userName") String userName,
			@RequestParam("password") String password, HttpSession httpSession, ModelMap map) throws IOException {

		User u = userService.checkUsernameAndPwd(userName, password);

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode result = mapper.createObjectNode();
		if (u != null) {

			httpSession.setAttribute("user", u);
			result.put("code", 200);
			result.put("result", true);
			result.put("message", "登陆 成功！");
		} else {

			result.put("code", 300);
			result.put("result", false);
			result.put("message", "登陆 失败！");
		}

		return result.toString();
	}

	/**
	 * 用户注销
	 * 
	 * @param
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws IOException {

		session.invalidate();
		System.out.println("logout");

		return "redirect:/product/index";
	}

}
