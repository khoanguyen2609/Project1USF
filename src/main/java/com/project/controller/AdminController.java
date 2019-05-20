package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.ERDaoImpl;

public class AdminController {
	public static String Approve(HttpServletRequest request, HttpServletResponse response) {
		int ticket_id = Integer.parseInt(request.getParameter("value"));
		ERDaoImpl ersImpl = new ERDaoImpl();
		ersImpl.updateEmployeeTrue(ticket_id);
		return "/html/AdminHome.html";
	}
	public static String Deny(HttpServletRequest request, HttpServletResponse response) {
		int ticket_id = Integer.parseInt(request.getParameter("value"));
		ERDaoImpl ersImpl = new ERDaoImpl();
		ersImpl.updateEmployeeFalse(ticket_id);
		return "/html/AdminHome.html";
	}
	
}


