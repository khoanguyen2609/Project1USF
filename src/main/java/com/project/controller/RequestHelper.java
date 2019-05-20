package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		
		case "/Project1USF/html/Login.do":
			return LoginController.Login(request);
		case "/Project1USF/html/EmployeeHome.do":
			return Requests.ERSystem(request);	
		case "/Project1USF/html/AdminHome.do":
			return HomeController.PetJSON(request, response);	
		case "/Project1USF/html/AdminApprove.do":
			return AdminController.Approve(request, response);
		case "/Project1USF/html/AdminDeny.do":
			return AdminController.Deny(request, response);
		default:
			return "/Project1USF/html/Login.html";
		}
		
	}

}