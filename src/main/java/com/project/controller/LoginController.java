package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project.dao.ERDaoImpl;
import com.project.dao.EmployeeDaoImpl;
import com.project.model.ERS;
import com.project.model.Employee;

public class LoginController {

	public static int userNumber;

	public static String Login(HttpServletRequest request) {

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		// Employee Information
		EmployeeDaoImpl pdImpl = new EmployeeDaoImpl();
		Employee p = new Employee();
		p = pdImpl.selectEmployeeByUserName(name);

		userNumber = p.getUserID();
		String admin = "admin";
		// ER System
		ERDaoImpl ersImpl = new ERDaoImpl();

		 List<ERS> erss = ersImpl.selectAllEmployees();
		ERS ers = new ERS();

		if (name.equals(p.getUserName()) & password.equals(p.getPassword())) {
			if (name.equals(admin)) {
					request.getSession().setAttribute("Listt", erss);
					return "/html/AdminHome.html";
			} else {
				return "/html/EmployeeHome.html";
			}
		}
		return "/html/Login.html";
	}
}