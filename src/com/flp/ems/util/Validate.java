package com.flp.ems.util;
import java.util.Scanner;

public class Validate {

	public boolean validateName(String s) 
	{
	   Scanner userInput = new Scanner(System.in);
	   String words;
	   //System.out.println("Enter your words: ");
	   words = s;

	if (words.matches(".*[^a-zA-Z ]")) 
	{ 
	    System.out.println("Error, no number input or special character input please: ");
	    return false;
	}

	else 
	    {
	        System.out.println("good name");
	        return true;
	    }
	

	}
	
	public boolean validatePhone(String s) 
	{
	   Scanner userInput = new Scanner(System.in);
	   String words;
	   //System.out.println("Enter your words: ");
	   words = s;
	  // words.replaceAll("\\D", "").length();

	if (words.matches(".*[^0-9 ]") ) 
	{ 
	    System.out.println("Error, Please enter valid number: ");
	    return false;
	}

	else if(words.length()==10)
	    {
	        System.out.println("good number");
	        return true;
	    }
	else{
		 System.out.println("Error, Please enter valid number: ");
		    return false;
	}

	}

	
	/*public boolean validateMail(String s) 
	{
	   Scanner userInput = new Scanner(System.in);
	   String words;
	   //System.out.println("Enter your words: ");
	   words = s;
	  // words.replaceAll("\\D", "").length();

	if (words.matches(regex) ) 
	{ 
	    System.out.println("Error, Please enter valid Email id: ");
	    return false;
	}

	else 
	    {
	        System.out.println("good mail");
	        return true;
	    }


	}*/
}
