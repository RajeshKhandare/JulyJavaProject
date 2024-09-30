package com.java.mini.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
// 1. Student Registration
public class Registration {

	private void getRegistrationInfo(String FirstName, String LastName, String EmailId, String MobileNumber, String UserName,
			String Password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			// Step-1- Loading Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step-2- Establish connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");

			// Step-3-
			ps = con.prepareStatement("insert into registrationtable(FirstName,LastName,EmailId,MobileNumber,UserName,Password)values(?,?,?,?,?,?)");

			ps.setString(1, FirstName);
			ps.setString(2, LastName);
			ps.setString(3, EmailId);
			ps.setString(4, MobileNumber);
			ps.setString(5, UserName);
			ps.setString(6, Password);


			// Step- 4. Submit SQL statement to database
			int a = ps.executeUpdate();
			// Step-5- Process result (internally)

			// Step-6-
			System.out.println("Registration Is Completed");
			System.out.println("Please login To take the Quiz");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Step-6- Release or close resource
			con.close();
			ps.close();
		}

	}

	public void getUserInputData() throws SQLException {

		System.out.println("Enter the First Name");
		Scanner scanner = new Scanner(System.in);
		String fname = scanner.nextLine();
		System.out.println("Enter the Last Name");
		String lname = scanner.nextLine();
		System.out.println("Enter the Email Id");
		String emailid = scanner.nextLine();
		System.out.println("Enter the Mobile Number");
		String mobilenumber = scanner.nextLine();
		System.out.println("Set The Username");
		String username = scanner.nextLine();
		System.out.println("Set the Password");
		String password = scanner.nextLine();
		Registration registration=new Registration();
		registration.getRegistrationInfo(fname, lname, emailid, mobilenumber, username, password);

	}
	//	public static void main(String[] args) throws SQLException {
	//		
	//	
	//	Registration registration=new Registration();
	//	registration. getUserInputData(); // method calling
	//	}
}
