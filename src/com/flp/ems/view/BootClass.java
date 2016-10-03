package com.flp.ems.view;
import java.util.Scanner;

import com.flp.ems.util.Validate;
public class BootClass {

	static int digit = 0;
	public static void main(String[] args) {
	
		while(true){
		menuSelection();
		}
	}
	
	public static void menuSelection(){
		
		Scanner sc=new Scanner(System.in);
		Validate val1 = new Validate();

		System.out.println("Please select the operation:  (Enter the digit)  \n 1. Add a new Employee \n 2. Remove an Employee"
				+ "\n 3. Modify an Employee \n 4. Search an Employee \n 5. Get all Employees   ");
		
		digit=sc.nextInt();
		//sc.close();
		if(digit==1){System.out.println("Adding a new employee");
			Scanner sc1=new Scanner(System.in); 
			System.out.println("Enter Name");  
			String name=sc1.next(); 
			while(val1.validateName(name)==false){
				 name=sc1.next();
			};
			System.out.println("Enter Email ID");  
			String email_id=sc.next();
			while(val1.validatePhone(email_id)==false){
				 email_id=sc1.next();
			};
			System.out.println("Enter Phone no");  
			String phone=sc.next();  
			while(val1.validatePhone(phone)==false){
				 phone=sc1.next();
			};
			System.out.println("Enter Date of Birth");  
			String dob=sc.next();
			System.out.println("Enter Date of Joining ");  
			String doj=sc.next();
			System.out.println("Enter address");  
			String address=sc.next();  
			System.out.println("Enter dept no");  
			String dept=sc.next(); 
			System.out.println("Enter Project no");  
			String proj=sc.next(); 
			System.out.println("Enter Role id");  
			String role=sc.next();  
			
			UserInteraction ui = new UserInteraction(name,email_id,phone,dob,doj,address,dept,proj,role);
			
		}
		else
		if(digit==2){System.out.println("Removing an employee");
		Scanner sc1=new Scanner(System.in); 
		System.out.println("Enter Employee id");  
		int emp_id=sc.nextInt();
		
		UserInteraction ui = new UserInteraction(emp_id);

		
		}
		else
		if(digit==3){System.out.println("Modifying an employee");
		Scanner sc1=new Scanner(System.in); 

		System.out.println("Enter Employee id");  
		String emp_id=sc.next();
		
		System.out.println("Enter Name");  
		String name=sc1.next();  
		System.out.println("Enter Email ID");  
		String email_id=sc.next();  
		System.out.println("Enter Phone no");  
		String phone=sc.next();  
		System.out.println("Enter Date of Birth");  
		String dob=sc.next();
		System.out.println("Enter Date of Joining ");  
		String doj=sc.next();
		System.out.println("Enter address");  
		String address=sc.next();  
		System.out.println("Enter dept no");  
		String dept=sc.next(); 
		System.out.println("Enter Project no");  
		String proj=sc.next(); 
		System.out.println("Enter Role id");  
		String role=sc.next();  
		
		UserInteraction ui = new UserInteraction(emp_id,name,email_id,phone,dob,doj,address,dept,proj,role);

		}
		else
		if(digit==4){System.out.println("Searching employee");
		Scanner sc1=new Scanner(System.in); 
		String name="";
		System.out.println("Enter Employee id else print 0");  
		int emp_id=sc.nextInt();
		if(emp_id==0 ){ 
			System.out.println("Enter Employee name");  
			name=sc.next();
		}
		
		UserInteraction ui = new UserInteraction(emp_id,name);
		
		
		}
		
		
		else
		if(digit==5){System.out.println("Get all employee");
		Scanner sc1=new Scanner(System.in); 
		UserInteraction ui = new UserInteraction();

		}
		
		else {System.out.println("Invalid Selection");
			digit =0;
		}

		//if(digit!=0) {UserInteraction ui = new UserInteraction(digit);}
	}
}
