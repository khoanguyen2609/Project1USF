package com.project.dao;

import com.project.model.Employee;

public interface EmployeeDao {

	public int insertEmployee(Employee p);
	public Employee selectEmployeeByUserName(String name);
	public Employee selectEmployeeByUserID(int userID);
}
