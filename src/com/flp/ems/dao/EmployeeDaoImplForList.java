package com.flp.ems.dao;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IemployeeDao {
	
	
	static ArrayList<Employee> empList = new ArrayList<>();
	
	public void addEmployee(Employee newE){
		Employee E= newE;
		empList.add(E);
		
	}
	
	public void modifyEmployee(Employee newE){
		Employee E= newE;
		int count = 0;
		for(Employee index:empList){
			if(index.getEmpId1()==E.getEmpId1()){
				int emp_id = E.getEmpId1();
				count++;
				System.out.println(index.getEmpId1()+ "id before changing" +index.getName());
				empList.remove(index);
				empList.add(E);
				System.out.println(E.getEmpId1());

			} 
		}
		if(count==0){System.out.println("No such record exists");}

		//testghg
		
	}

	public void removeEmployee(int emp_id1){
		Employee e = null;
		int count = 0;
		for(Employee index:empList){
			if(index.getEmpId1()==emp_id1){
				int emp_id = emp_id1;
				e = index;
				count++;
				System.out.println(index.getEmpId1());
				
			}
			
		}
		if(count==0){System.out.println("No such record exists");}

		empList.remove(e);
	}

	

	public  ArrayList<Employee> getAllEmployee(){
		return empList;
	}

	public ArrayList<Employee> searchEmployee(String name) {
		Employee e = new Employee();
		ArrayList<Employee> list = new ArrayList<>();
		for(Employee index:empList){
			if(index.getName().equals(name)){
				e = index;
				list.add(e);
			}
		}
		if(list.size()==0){System.out.println("Employee not found, Please enter valid Employee name");}

		return list;
		
	}

	public Employee searchEmployee(int r) {
		Employee e = new Employee();
		int count = 0;
		for(Employee index:empList){
			if(index.getEmpId1()==r){
				e = index;
				count++;
				
			}
		}
		if(count==0){System.out.println("Employee not found, Please enter valid Employee name");}

		return e;
	}

}
