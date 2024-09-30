package com.java.mini.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//5. Display Quiz result
public class DisplayResult {

	public void displayScore() {

		try {
			// Step-1- Loading Driver class

			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2- Establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");
			Scanner scanner = new Scanner(System.in);

			System.out.print("Enter the username: ");
			String searchUsername = scanner.nextLine();
			System.out.print("Enter password: ");
			String password = scanner.nextLine();

			String selectSql = "SELECT score FROM registrationtable WHERE username = ? AND password = ?";
			PreparedStatement selectPs = con.prepareStatement(selectSql);
			selectPs.setString(1, searchUsername);
			selectPs.setString(2, password);

			ResultSet resultSet = selectPs.executeQuery();

			if (resultSet.next()) {
				int score = resultSet.getInt("score");
				System.out.println("Score for " + searchUsername + ": " + score+"\r\n");
			} else {
				System.out.println("No score found for username: " + searchUsername);
			}
			con.close();
			selectPs.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error Displaying Result: " + e.getMessage());
		}

	}


}
