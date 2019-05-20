package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	static{

	       try {

	           Class.forName("oracle.jdbc.driver.OracleDriver");

	       } catch (ClassNotFoundException e) {

	           e.printStackTrace();

	       }

	   }

	private static String url = "jdbc:oracle:thin:@project1.caovgj3hwqak.us-east-1.rds.amazonaws.com:1521:project1";
	private static String username = "group4";
	private static String password = "password";
	@Override
	public int insertEmployee(Employee p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEES VALUES(?,?,?,?,?)");
			ps.setInt(1, p.getUserID());
			ps.setString(2, p.getUserName());
			ps.setString(3, p.getPassword());
			ps.setString(4, p.getFirstName());
			ps.setString(5, p.getLastName());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Employee selectEmployeeByUserName(String name) {
		Employee employee = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employees WHERE user_name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	@Override
	public Employee selectEmployeeByUserID(int userID) {
		Employee employee = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employees WHERE user_ID=?");
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
}