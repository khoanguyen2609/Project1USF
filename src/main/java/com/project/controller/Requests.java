package com.project.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.project.dao.ERDaoImpl;
import com.project.dao.EmployeeDaoImpl;
import com.project.model.ERS;
import com.project.model.Employee;

public class Requests extends LoginController {

	public static String ERSystem(HttpServletRequest request) {
		EmployeeDaoImpl pdImpl = new EmployeeDaoImpl();
		Employee p = new Employee();
		p = pdImpl.selectEmployeeByUserID(userNumber);

		String type = request.getParameter("type");
		Double amount = Double.parseDouble(request.getParameter("amount"));
		String description = request.getParameter("description");
		java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
		ERS emp = new ERS();
		Random rand = new Random();
		int ticket = rand.nextInt(1000);
		
		emp.setUserID(p.getUserID());
		emp.setFirstName(p.getFirstName());
		emp.setLastName(p.getLastName());
		emp.setType(type);
		emp.setAmount(amount);
		emp.setDateSubmitted(sqlDate);
		emp.setDateResolved(null);
		emp.setStatus("Pending");
		emp.setDescription(description);
		emp.setTicketID(ticket);
		ERDaoImpl ax = new ERDaoImpl();
		ax.insertEmployee(emp);
		return "/html/Logout.html";
	}

}