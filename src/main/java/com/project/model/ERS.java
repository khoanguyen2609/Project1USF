package com.project.model;

import java.sql.Timestamp;
import java.util.Date;

public class ERS {
	
	String firstName, lastName, type, status, description;
	int userID, ticketID;
	double amount;
	Date dateSubmitted, dateResolved;
	
	java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
	public ERS() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public int getUserID() {
		return userID;
	}




	public void setUserID(int userID) {
		this.userID = userID;
	}




	public int getTicketID() {
		return ticketID;
	}




	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public Date getDateSubmitted() {
		return dateSubmitted;
	}




	public void setDateSubmitted(Timestamp dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}




	public Date getDateResolved() {
		return dateResolved;
	}




	public void setDateResolved(Timestamp dateResolved) {
		this.dateResolved = dateSubmitted;
	}




	public ERS(int userID, String firstName, String lastName, String type, double amount, Date dateSubmitted, Date dateResolved, String status, String description, int ticketID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.status = status;
		this.description = description;
		this.userID = userID;
		this.ticketID = ticketID;
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.dateResolved = dateResolved;
	}

	@Override
	public String toString() {
		return "ERS [firstName=" + firstName + ", lastName=" + lastName + ", type=" + type + ", status=" + status
				+ ", description=" + description + ", userID=" + userID + ", ticketID=" + ticketID + ", amount="
				+ amount + ", dateSubmitted=" + dateSubmitted + ", dateResolved=" + dateResolved + "]";
	}

}
