package com.project.driver;

import java.util.List;

import org.apache.log4j.Logger;

import com.project.dao.ERDaoImpl;
import com.project.model.ERS;

public class MainDriver {
	final static Logger loggy = Logger.getLogger(MainDriver.class);
	public static void main(String[] args) {
		ERDaoImpl ersImpl = new ERDaoImpl();
		// ersImpl.insertEmployee(employee2);
		ERS abc = new ERS();
		abc = ersImpl.selectEmployeeByTicketID(2);
		List<ERS> erss = ersImpl.selectAllEmployees();
		ERS element0 = erss.get(1);
		for (int i = 1; i < 2; i++) {
			abc = ersImpl.selectEmployeeByTicketID(i);
			System.out.println(erss);

		}
		loggy.info("this is info");
		loggy.error("message about error", new IndexOutOfBoundsException());
		loggy.fatal("fatal message");
		loggy.warn("warning message");

	}

}
