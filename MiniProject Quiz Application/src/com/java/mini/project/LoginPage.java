package com.java.mini.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
// 2. Student Login
public class LoginPage {
	//
	public static String username;

	public void loginStudent() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();


		// Check if student exists in database
		try {

			// Step-1- Loading Driver class

			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2- Establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");


			PreparedStatement ps = con.prepareStatement("SELECT * FROM registrationtable WHERE UserName = ? AND Password = ?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				// Login successful
				System.out.println("Login successful >> "+ " Welcome " +username+" \r\n");
				//
				LoginPage.username = username;
				System.out.println("Quiz Has Started\r\n");
				DisplayQuestion displayQuestion=new DisplayQuestion();
				displayQuestion.displayQuestions(); // method calling

			} else {
				System.out.println("Invalid username or password");
				// Invalid username or password
			}

			

			resultSet.close();
			ps.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error in logging " + e.getMessage());
		}

	}


}

