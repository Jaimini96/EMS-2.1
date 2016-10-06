package com.flp.ems.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.flp.ems.domain.Employee;

public interface IemployeeDao {

	public void addEmployee(Employee e) throws FileNotFoundException, IOException, SQLException, ParseException;
		
	
	public void modifyEmployee(Employee e);
		

	public void removeEmployee(int e);
		
	

	public ArrayList<Employee> searchEmployee(String s);
		
	

	public ArrayList<Employee> getAllEmployee();


	ArrayList<Employee> searchEmployee(int id);
}
