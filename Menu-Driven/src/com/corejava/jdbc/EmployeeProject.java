package com.corejava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeProject {
	
public static void createConnection() throws ClassNotFoundException, SQLException {
		
		//register driver class
				Class.forName("com.mysql.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost:3306/employee1";
				String password ="root";
				String username = "root";
				
				//establish connection between java application and database
				Connection con = DriverManager.getConnection(url, password, username);
				
				System.out.println(con);

	}

public static void insertRecord() throws ClassNotFoundException, SQLException {
	
	//register driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/employee1";
			String password ="root";
			String username = "root";
			String query = "insert into employee1(e_name,e_surname,e_age,e_designation,e_salary,e_joining) values (?,?,?,?,?,?)";
			
			//establish connection between java application and database
			Connection con = DriverManager.getConnection(url, password, username);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Employee Name: ");
			String e_name = sc.nextLine();
			
			System.out.println("Enter Employee Surname: ");
			String e_surname = sc.nextLine();
			
			System.out.println("Enter Employee Designation: ");
			String e_designation = sc.nextLine();
			
			System.out.println("Enter Employee Age: ");
			int e_age = sc.nextInt();
			
			System.out.println("Enter Employee Salary: ");
			double e_salary = sc.nextDouble();
			
			System.out.println("Enter Employee Joining: ");
			int e_joining = sc.nextInt();
			
			//create statement object
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1,e_name);
			stm.setString(2,e_surname);
			stm.setInt(3, e_age);
			stm.setString(4, e_designation);
			stm.setDouble(5, e_salary);
			stm.setInt(6, e_joining);
			int num =stm.executeUpdate();
			
			System.out.println("Student data added to database successfully...");
			
			System.out.println(num+ "rows affected...");
			
			con.close();
			stm.close();

}

public static void updateRecord() throws ClassNotFoundException, SQLException{
	        
	//register driver class
    Class.forName("com.mysql.jdbc.Driver");
	
	String url = "jdbc:mysql://localhost:3306/employee1";
	String password ="root";
	String username = "root";
	String query = "update employee1 set e_designation =? where e_name=?";
	
	//establish connection between java application and database
	Connection con = DriverManager.getConnection(url, password, username);
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter Employee Updated e_designation: ");
	String e_designation=sc.nextLine();
	
	System.out.println("Enter Employee e_name: ");
	String e_name=sc.nextLine();
	
	PreparedStatement stm = con.prepareStatement(query);
	stm.setString(1, e_designation );
	stm.setString(2, e_name);
	
	int num=stm.executeUpdate();
	System.out.println("Student data successfully add.....");
	System.out.println(num+ " rows affected");
	
	con.close();
	stm.close();


}

public static void deleteRecord() throws ClassNotFoundException, SQLException {
	 
	//register driver class
    Class.forName("com.mysql.jdbc.Driver");
	
	String url = "jdbc:mysql://localhost:3306/employee1";
	String password ="root";
	String username = "root";
	String query = "delete from employee1 where e_name=?";
	
	//establish connection between java application and database
	Connection con = DriverManager.getConnection(url, password, username);
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter Employee e_name: ");
	String e_name=sc.nextLine();
	
	PreparedStatement stm = con.prepareStatement(query);
	stm.setString(1, e_name);
	
	int num=stm.executeUpdate();
	System.out.println("Student data deleted successfully .....");
	System.out.println(num+ " rows affected");
	
	con.close();
	stm.close();



}
public static void fetchAllRecord()throws ClassNotFoundException, SQLException {
	
	//register driver class
	Class.forName("com.mysql.jdbc.Driver");
	
	String url = "jdbc:mysql://localhost:3306/employee1";
	String password ="root";
	String username = "root";
	String query = "select * from employee1";
	
	//establish connection between java application and database
	Connection con = DriverManager.getConnection(url, password, username);
	
	//create statement object
	Statement stm = con.createStatement();
	ResultSet res = stm.executeQuery(query);
	
	while(res.next()) {
		System.out.println("Employee Name Is: "+res.getString("e_name"));
		System.out.println("Employee Surname Is: "+res.getString("e_surname"));
		System.out.println("Employee Desigantion Is: "+res.getString("e_designation"));
		System.out.println("Employee Age Is: "+res.getInt("e_age"));
		System.out.println("Employee Salary Is: "+res.getDouble("e_Salary"));
		System.out.println("Employee Joining Date Is: "+res.getInt("e_joining"));
		System.out.println("******************************************");
	}
	
	con.close();
	stm.close();

}



}
