package com.flp.ems.service;

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
	EmployeeDaoImplForDB empDaoDb;
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
		empDaoDb.addEmployee(newE);
		
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
		empDaoList.modifyEmployee(newE);

	}

	public void removeEmployee(int emp_id){
		this.emp_id1=emp_id;
		empDaoList.removeEmployee(emp_id1);
		
	}

	public void searchEmployee(){
		
	}

	public void getAllEmployee(){
		ArrayList<Employee> list;
		list = empDaoList.getAllEmployee();
		for(Employee i:list){
			i.getDetails();
		}
		
	}

	public void searchEmployee(String name) {
		
		this.name=name;
		ArrayList<Employee> list =  empDaoList.searchEmployee(name);
		for(Employee i:list){
			i.getDetails();
		}
		
	}

	public void searchEmployee(int emp_id) {
		
		int r = emp_id;
		Employee e = empDaoList.searchEmployee(r);
		e.getDetails();
	}

}
