package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		try {
			FileInputStream fIn = new FileInputStream("dbDetails.properties");
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Employee E= e;
		String updateQuery = props.getProperty("jdbc.query.update");

		try(PreparedStatement updateStatement = dbConnection.prepareStatement(updateQuery)){
			//insertStatement.setInt(1, E.getEmpId1());
			updateStatement.setString(1, E.getName());
			//insertStatement.setString(2, employee.getKinId());
			updateStatement.setString(2, E.getEmailId());
			updateStatement.setLong(3, E.getPhoneNumber());
			updateStatement.setString(4, E.getAddress());
			try {
				updateStatement.setDate(5, Util.getSQLDateFromDate(E.getDateOfBirth()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				updateStatement.setDate(6, Util.getSQLDateFromDate(E.getDateOfJoining()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			updateStatement.setInt(7, E.getDepartment());
			updateStatement.setInt(8, E.getProject());
			updateStatement.setInt(9, E.getRole());
			updateStatement.setInt(10, E.getEmpId1());

			
			int rows = updateStatement.executeUpdate();
			System.out.println(rows + " row(s) updated.");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			//e2.printStackTrace();
			System.out.println("No such employee exists");

		}
	}

	@Override
	public void removeEmployee(int e) {

		try {
			FileInputStream fIn = new FileInputStream("dbDetails.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int emp_id =e;
		String deleteQuery = props.getProperty("jdbc.query.delete");

		try(PreparedStatement deleteStatement = dbConnection.prepareStatement(deleteQuery)){
			//insertStatement.setInt(1, E.getEmpId1());
			deleteStatement.setInt(1, e);
			int rows = deleteStatement.executeUpdate();
			System.out.println(rows + " row(s) updated.");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("No such employee exists");
		}
		
	}

	@Override
	public ArrayList<Employee> searchEmployee(int id) {
		//Employee e = new Employee();
		ArrayList<Employee> list = new ArrayList<>();
		

		
		
		
		try {
			FileInputStream fIn = new FileInputStream("dbDetails.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int emp_id =id;
		
		//String searchQuery = props.getProperty("jdbc.query.select1");
		String searchQuery = "select * from Employee where employeeId="+emp_id;
		try(Statement searchStatement = dbConnection.createStatement()){
			//insertStatement.setInt(1, E.getEmpId1());
			
			//searchStatement.setInt(1, emp_id);
			//int rows = searchStatement.executeUpdate();
			ResultSet result;
			
			result = searchStatement.executeQuery(searchQuery);
			result.beforeFirst();
			while(result.next()){
				Employee em = new Employee();
				em.setEmployeeId( result.getInt(1));
				em.setName(result.getString(2));
				em.setPhoneNumber(result.getLong(4));
				em.setEmailId(result.getString(3));
				em.setDateOfBirth(result.getString(6));
				em.setDateOfJoining(result.getString(7));
				em.setDepartment(result.getInt(8));
				em.setProject(result.getInt(9));
				em.setRole(result.getInt(10));
				em.setAddress(result.getString(5));

				list.add(em);
				//System.out.println(message+" yolo");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("No such employee exists");
		}
		return list;
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		//Employee em = new Employee();
		ArrayList<Employee> list = new ArrayList<>();
		
		try(Statement selectStatement = dbConnection.createStatement()){
			String selectQuery = props.getProperty("jdbc.query.select");
			
			ResultSet result;
			result = selectStatement.executeQuery(selectQuery);
			result.beforeFirst();
			while(result.next()){
				Employee em = new Employee();
				em.setEmployeeId( result.getInt(1));
				em.setName(result.getString(2));
				em.setPhoneNumber(result.getLong(4));
				em.setEmailId(result.getString(3));
				em.setDateOfBirth(result.getString(6));
				em.setDateOfJoining(result.getString(7));
				em.setDepartment(result.getInt(8));
				em.setProject(result.getInt(9));
				em.setRole(result.getInt(10));
				em.setAddress(result.getString(5));

				list.add(em);
				//System.out.println(message+" yolo");
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No Employee in the record");
		}
		return list;
	}

	@Override
	public ArrayList<Employee> searchEmployee(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
