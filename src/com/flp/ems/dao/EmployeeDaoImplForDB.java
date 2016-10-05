package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;

import com.flp.ems.domain.Employee;
import com.flp.ems.util.DBProps;
import com.flp.ems.util.Util;

public class EmployeeDaoImplForDB implements IemployeeDao{


	Properties props = new Properties();
	Connection dbConnection;

	//props.load(fIn);
	//Properties props = new Properties();
	//String url = props.getProperty("jdbc.url");
	
	public EmployeeDaoImplForDB() {
		FileInputStream fIn;
		try {
			fIn = new FileInputStream("dbDetails.properties");
			props.load(fIn);

		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url = props.getProperty("jdbc.url");

		try {
			dbConnection = DriverManager.getConnection(url);		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//props.load(fIn);

	@Override
	public void addEmployee(Employee e) throws IOException, SQLException, ParseException {
		FileInputStream fIn = new FileInputStream("dbDetails.properties");
		Employee E= e;
		String insertQuery = props.getProperty("jdbc.query.insert");

		try(PreparedStatement insertStatement = dbConnection.prepareStatement(insertQuery)){
			//insertStatement.setInt(1, E.getEmpId1());
			insertStatement.setString(1, E.getName());
			//insertStatement.setString(2, employee.getKinId());
			insertStatement.setString(2, E.getEmailId());
			insertStatement.setLong(3, E.getPhoneNumber());
			insertStatement.setString(4, E.getAddress());
			try {
				insertStatement.setDate(5, Util.getSQLDateFromDate(E.getDateOfBirth()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				insertStatement.setDate(6, Util.getSQLDateFromDate(E.getDateOfJoining()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			insertStatement.setInt(7, E.getDepartment());
			insertStatement.setInt(8, E.getProject());
			insertStatement.setInt(9, E.getRole());
			
			int rows = insertStatement.executeUpdate();
			System.out.println(rows + " row(s) updated.");
		}

	}

	@Override
	public void modifyEmployee(Employee e) {
		// TODO Auto-generated method stub
		FileInputStream fIn = new FileInputStream("dbDetails.properties");
		Employee E= e;
		String insertQuery = props.getProperty("jdbc.query.insert");

		try(PreparedStatement insertStatement = dbConnection.prepareStatement(insertQuery)){
			//insertStatement.setInt(1, E.getEmpId1());
			insertStatement.setString(1, E.getName());
			//insertStatement.setString(2, employee.getKinId());
			insertStatement.setString(2, E.getEmailId());
			insertStatement.setLong(3, E.getPhoneNumber());
			insertStatement.setString(4, E.getAddress());
			try {
				insertStatement.setDate(5, Util.getSQLDateFromDate(E.getDateOfBirth()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				insertStatement.setDate(6, Util.getSQLDateFromDate(E.getDateOfJoining()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			insertStatement.setInt(7, E.getDepartment());
			insertStatement.setInt(8, E.getProject());
			insertStatement.setInt(9, E.getRole());
			
			int rows = insertStatement.executeUpdate();
			System.out.println(rows + " row(s) updated.");
		
	}

	@Override
	public void removeEmployee(int e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Employee> searchEmployee(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
