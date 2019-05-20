package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.model.ERS;

public class ERDaoImpl implements ERDao {

	private static String url = "jdbc:oracle:thin:@project1.caovgj3hwqak.us-east-1.rds.amazonaws.com:1521:project1";
	private static String username = "group4";
	private static String password = "password";

	@Override
	public int insertEmployee(ERS e) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO EXPENSE_REIMBURSEMENT VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, e.getUserID());
			ps.setString(2, e.getFirstName());
			ps.setString(3, e.getLastName());
			ps.setString(4, e.getType());
			ps.setDouble(5, e.getAmount());
			ps.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setDate(7, null);
			ps.setString(8, e.getStatus());
			ps.setString(9, e.getDescription());
			ps.setInt(10, e.getTicketID());
			ps.executeUpdate();

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return 0;
	}

	@Override
	public ERS selectEmployeeByFirstName(String name) {
		ERS employee = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Expense_Reimbursement WHERE FIRST_NAME=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee = new ERS(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public ERS selectEmployeeByLastName(String name) {
		ERS employee = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Expense_Reimbursement WHERE LAST_NAME=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee = new ERS(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public ERS selectEmployeeByID(int name) {
		ERS employee = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Expense_Reimbursement WHERE USER_ID=?");
			ps.setInt(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee = new ERS(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public ERS selectEmployeeByTicketID(int ticketID) {
		ERS employee = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Expense_Reimbursement WHERE TICKET_ID=?");
			ps.setInt(1, ticketID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee = new ERS(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<ERS> selectAllEmployees() {
		List<ERS> employees = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Expense_Reimbursement");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employees.add(new ERS(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getInt(10)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public List<Integer> selectAllEmployeesByID() {
		List<Integer> employees = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT USER_ID FROM EXPENSE_REIMBURSEMENT");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employees.add(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public int updateEmployeeTrue(int ticketID) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Expense_Reimbursement SET status = ?,Date_Resolved=? WHERE Ticket_ID=?");
			ps.setString(1, "Approve");
			ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setInt(3, ticketID);
			ps.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmployeeFalse(int ticketID) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Expense_Reimbursement SET status = ?,Date_Resolved=? WHERE Ticket_ID=?");
			ps.setString(1, "Deny");
			ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setInt(3, ticketID);
			ps.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmployee(ERS e) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Expense_Reimbursement WHERE p_name=?");
			ps.setString(1, e.getFirstName());
			ps.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return 0;
	}
}
