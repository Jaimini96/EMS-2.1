package com.flp.ems.view;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;


public class UserInteraction {

	int digit;
	static String emp_id;
	static String kin_id;
	String name;
	String email_id;
	String phone;
	String dob;
	String doj;
	String address;
	String dept;
	String proj;
	String role;
	EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

	public UserInteraction(String name, String email_id, String phone,String dob, String doj,String address, String dept,String proj, String role) {
		this.name=name;
		this.email_id=email_id;
		this.phone=phone;
		this.dob=dob;
		this.doj=doj;
		this.address=address;
		this.dept=dept;
		this.proj=proj;
		this.role=role;
		addEmployee(name, email_id, phone,dob,doj, address, dept, proj, role);
		}
	
	public UserInteraction(String emp_id,String name, String email_id, String phone,String dob, String doj,String address, String dept,String proj, String role) {
		this.name=name;
		this.email_id=email_id;
		this.phone=phone;
		this.dob=dob;
		this.doj=doj;
		this.address=address;
		this.dept=dept;
		this.proj=proj;
		this.role=role;
		this.emp_id=emp_id;
		
		modifyEmployee(emp_id,name, email_id, phone,dob,doj, address, dept, proj, role);
		}
	public UserInteraction (int emp_id){
		this.digit=emp_id;
		removeEmployee(digit);
		
	}

	public UserInteraction() {

	employeeServiceImpl.getAllEmployee();
	}

	public UserInteraction(int emp_id, String name) {

		emp_id = emp_id;
		name = name;
/*	if(emp_id==0){
		employeeServiceImpl.searchEmployee(name);
		
	}
	else {*/
		employeeServiceImpl.searchEmployee(emp_id);
	//}
	
	}

	public void addEmployee(String name, String email_id, String phone,String dob,String doj,String address, String dept,String proj, String role){
		
		HashMap<String, String> newEmp =new  HashMap<String, String>();
		newEmp.put("name",name );
		newEmp.put("email_id",email_id );
		newEmp.put("phone",phone );
		newEmp.put("dob",dob );
		newEmp.put("doj",doj );
		newEmp.put("address",address );
		newEmp.put("dept",dept );
		newEmp.put("proj",proj );
		newEmp.put("role",role );
		System.out.println(newEmp.get("name"));
		employeeServiceImpl.addEmployee(newEmp);

		
		
	}
	
	public void modifyEmployee(String emp_id,String name, String email_id, String phone,String dob,String doj,String address, String dept,String proj, String role){
		
		HashMap<String, String> editEmp =new  HashMap<String, String>();
		editEmp.put("name",name );
		editEmp.put("email_id",email_id );
		editEmp.put("phone",phone );
		editEmp.put("dob",dob );
		editEmp.put("doj",doj );
		editEmp.put("address",address );
		editEmp.put("dept",dept );
		editEmp.put("proj",proj );
		editEmp.put("role",role );
		editEmp.put("emp_id",emp_id );

		employeeServiceImpl.modifyEmployee(editEmp);
	}

	public void removeEmployee(int emp_id){
		int r =emp_id;
		employeeServiceImpl.removeEmployee(r);
	}

	public void searchEmployee(int emp_id){
		
	}
	
/*public void searchEmployee(String name){
		
	}*/

	public void getAllEmployee(){
		employeeServiceImpl.getAllEmployee();
	}

}
