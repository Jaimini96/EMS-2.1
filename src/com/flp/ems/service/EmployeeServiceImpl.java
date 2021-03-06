package com.flp.ems.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flp.ems.dao.EmployeeDaoImplForDB;
import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService {

	String name;
	String email_id;
	String phone;
	String dob;
	String doj;
	String address;
	String dept;
	String proj;
	String role;
	String emp_id;
	int emp_id1;
	HashMap<String, String> newEmp ;
	EmployeeDaoImplForList empDaoList = new EmployeeDaoImplForList();
	EmployeeDaoImplForDB empDaoDb = new EmployeeDaoImplForDB();
	public void addEmployee(HashMap newEmp){
		
		this.newEmp=newEmp;
		this.name=(String) newEmp.get("name");
		this.email_id=(String) newEmp.get("email_id");
		this.phone=(String) newEmp.get("phone");
		this.dob=(String) newEmp.get("dob");
		this.doj=(String) newEmp.get("doj");
		this.address=(String) newEmp.get("address");
		this.dept=(String) newEmp.get("dept");
		this.proj=(String) newEmp.get("proj");
		this.role=(String) newEmp.get("role");

		Employee newE = new Employee( name,  email_id,  phone,dob,doj, address,  dept, proj,  role);
		//empDaoList.addEmployee(newE);
		try {
			empDaoDb.addEmployee(newE);
		} catch (IOException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void modifyEmployee(HashMap newEmp){
		this.newEmp=newEmp;
		this.name=(String) newEmp.get("name");
		this.email_id=(String) newEmp.get("email_id");
		this.phone=(String) newEmp.get("phone");
		this.dob=(String) newEmp.get("dob");
		this.doj=(String) newEmp.get("doj");
		this.address=(String) newEmp.get("address");
		this.dept=(String) newEmp.get("dept");
		this.proj=(String) newEmp.get("proj");
		this.role=(String) newEmp.get("role");
		this.emp_id1=Integer.parseInt((String) newEmp.get("emp_id"));

		Employee newE = new Employee(emp_id1, name,  email_id,  phone,dob,doj, address,  dept, proj,  role);
		empDaoDb.modifyEmployee(newE);

	}

	public void removeEmployee(int emp_id){
		this.emp_id1=emp_id;
		empDaoDb.removeEmployee(emp_id1);
		
	}

	public void searchEmployee(){
		
	}

	public void getAllEmployee(){
		ArrayList<Employee> list;
		list = empDaoDb.getAllEmployee();
		for(Employee i:list){
			i.getDetails();
		}
		
	}

	/*public void searchEmployee(String name) {
		
		this.name=name;
		ArrayList<Employee> list =  empDaoList.searchEmployee(name);
		for(Employee i:list){
			i.getDetails();
		}
		
	}*/

	public void searchEmployee(int emp_id) {
		
		int r = emp_id;
		ArrayList<Employee> e = empDaoDb.searchEmployee(r);
		for(Employee i:e){
			i.getDetails();
		}
		
	}

}
