package com.flp.ems.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.flp.ems.util.Util;

public class Employee {
	public static int emp_id;
	String name;
	String email_id;
	String phone;
	String dob;
	String doj;
	String address;
	String dept;
	String proj;
	String role;
	int emp_id1;
	HashMap<String, String> newEmp;
	public Employee(){};
	public Employee(String name, String email_id, String phone,String dob,String doj,String address, String dept,String proj, String role){
		this.name=name;
		this.email_id=email_id;
		this.phone=phone;
		this.dob=dob;
		this.doj=doj;
		this.address=address;
		this.dept=dept;
		this.proj=proj;
		this.role=role;
		emp_id++;
		this.emp_id1=emp_id;
		
		System.out.println("YOLO123"+ emp_id);
		
	}
	public Employee(int emp_id,String name, String email_id, String phone,String dob,String doj,String address, String dept,String proj, String role){
		this.name=name;
		this.email_id=email_id;
		this.phone=phone;
		this.dob=dob;
		this.doj=doj;
		this.address=address;
		this.dept=dept;
		this.proj=proj;
		this.role=role;
		//Hello world
		//this.emp_id+=1;
		int temp = emp_id;
		this.emp_id1 = emp_id;
		//emp_id=temp;
		System.out.println("YOLO123"+ emp_id);
	}
	public int getEmpId1(){
		return emp_id1;}
	public String getName(){
		return name;}
	public void getDetails(){
		if(name != null){
		System.out.println("Employee ID: "+emp_id1+" \t"+"Name: " +name+ "\t"+"Email ID: "+email_id+"\t"+"Phone number: "+phone+"\t"+"Date of birth: " +dob+"\t"+"Date of Joining: " +doj+"\t"+"Address: "+address+"\t"+"Department ID: "+dept+"\t"+"Project ID: "+proj+"\t"+"Role ID: "+role+"\t");
		}
		else{
			System.out.println("Employee not found, Please enter valid Employee ID");
			}
		}
	
	public void searchEmpByName(){
		
			System.out.println("Employee ID: "+emp_id1+" \t"+"Name: " +name+ "\t"+"Email ID: "+email_id+"\t"+"Phone number: "+phone+"\t"+"Date of birth: " +dob+"\t"+"Date of Joining: " +doj+"\t"+"Address: "+address+"\t"+"Department ID: "+dept+"\t"+"Project ID: "+proj+"\t"+"Role ID: "+role+"\t");
			
		}
	

	public void setEmployeeId(int employeeId) {
		this.emp_id1 = employeeId;
	}

	public int getEmployeeId() {
		return emp_id1;
	}


	public void setName(String name) {
		this.name = name;
	}

	/*public String getKinId() {
		return kinId;
	}
*/
	/*public void setKinId(String kinId) {
		this.kinId = kinId;
	}*/

	public String getEmailId() {
		return email_id;
	}

	public void setEmailId(String emailId) {
		this.email_id = emailId;
	}

	public long getPhoneNumber() {
		return  Long.parseLong(phone, 10) ;
	}

	public void setPhoneNumber(long l) {
		this.phone =Long.toString(l);
	}

	public Date getDateOfBirth() throws ParseException {
		return Util.getDateFromString(dob);
	}

	/*public void setDateOfBirth(Date dateOfBirth) {
		 String DATE_FORMAT_NOW = "yyyy-MM-dd";
		 Date date = dateOfBirth;
		 SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		 String stringDate = sdf.format(date );
		this.dob = stringDate;
	}
*/
	public void setDateOfBirth(String dateOfBirth) {
		this.dob = dateOfBirth;
	}
	public Date getDateOfJoining() throws ParseException {
		return Util.getDateFromString(doj);
	}

	/*public void setDateOfJoining(Date dateOfJoining) {
		 String DATE_FORMAT_NOW = "yyyy-MM-dd";
		 Date date = dateOfJoining;
		 SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		 String stringDate = sdf.format(date );
		this.doj = stringDate;
	}*/
	
	public void setDateOfJoining(String dateOfJoining) {
		this.doj = dateOfJoining;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDepartment() {
		return  Integer.parseInt(dept) ;
	}

	public void setDepartment(int department) {
		this.dept = Integer.toString(department);
	}

	public int getProject() {
		return  Integer.parseInt(proj) ;
	}
	public void setProject(int project) {
		this.proj = Integer.toString(project);
	}

	public int getRole() {
		return  Integer.parseInt(role) ;
	}

	public void setRole(int role) {
		this.role = Integer.toString(role);
	}
}
