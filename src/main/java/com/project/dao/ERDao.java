package com.project.dao;

import java.util.List;

import com.project.model.ERS;

public interface ERDao {

	// CREATE 
	public int insertEmployee(ERS e);
	
	// READ 
	public ERS selectEmployeeByFirstName(String firstName);
	public ERS selectEmployeeByLastName(String lastName);
	public ERS selectEmployeeByID(int userID);
	public ERS selectEmployeeByTicketID(int ticketID);
	public List<Integer> selectAllEmployeesByID();
	public List<ERS> selectAllEmployees();
	
	// UPDATE
	public int updateEmployeeTrue(int userID);
	public int updateEmployeeFalse(int userID);
	
	// DELETE
	public int deleteEmployee(ERS e);


	
}