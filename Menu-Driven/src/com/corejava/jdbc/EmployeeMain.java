package com.corejava.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

		//EmployeeProject.insertRecord();
		//EmployeeProject.updateRecord();
		//EmployeeProject.deleteRecord();
		//EmployeeProject.fetchAllRecord();
		while(true) {
			System.out.println("***************Welcome To Infosys***************");
			System.out.println("                       1:List Of Employees");
			System.out.println("                       2:Add New Employees");
			System.out.println("                       3:Update Employee");
			System.out.println("                       4:Delete Employee");
			System.out.println("                       5:Exit");
			
			System.out.println("Enter Your Choice: ");
			
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			
			if(ch==1) {
				
				EmployeeProject.fetchAllRecord();
				
			}else if(ch==2) {
				
				EmployeeProject.insertRecord();
				
			}else if(ch==3) {
				
				EmployeeProject.updateRecord();
				
			}else if(ch==4) {
				
				EmployeeProject.deleteRecord();
				
            }else if(ch==5) {
				
            	System.out.println("Its Our Employess Data...Thanx For Searching...");
            	break;
            	
			}
			
		}

	}

}
