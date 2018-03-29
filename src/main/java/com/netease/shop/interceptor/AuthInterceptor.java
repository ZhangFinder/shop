package com.netease.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.netease.shop.meta.User;

public class AuthInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		request.setCharacterEncoding("UTF-8");  
        String url = request.getServletPath();      
      
        if(!url.equals("")){  
            //判斷是否已登录  
        	User u = (User) request.getSession().getAttribute("user");
         
            if(u == null){  
               
                String loginUrl=request.getContextPath() +"/login.html";
                response.sendRedirect(loginUrl);  
                return false;  
            }  
        }  
        return true;  
	
	}

}
