package com.java.mini.project;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Scanner;

public class StoreQuizResult {

	public void storeResult() {
		try {

			// Step-1- Loading Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2- Establish the database connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");

			// Get the username and new score from the user
			Scanner scanner = new Scanner(System.in);

			System.out.print("Enter the username: ");
			String searchUsername = scanner.nextLine();

			System.out.print("Enter the password: ");
			String searchPassword = scanner.nextLine();

			System.out.print("Enter the new score: ");
			int newScore = scanner.nextInt();

			// Create a prepared statement to update the score
			String updateSql = "UPDATE registrationtable SET score = ? WHERE username = ? AND password = ?";
			PreparedStatement updatePs = connection.prepareStatement(updateSql);
			updatePs.setInt(1, newScore);
			updatePs.setString(2, searchUsername);
			updatePs.setString(3, searchPassword);
			// Execute the update
			int rowsUpdated = updatePs.executeUpdate();

			if (rowsUpdated > 0) {

				System.out.println("Score updated successfully for username: " + searchUsername);
			} else {
				System.out.println("No user found with This username or password.");
			}

			// Close the resources
			updatePs.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error With Storing Data: " + e.getMessage());;
		}
	}
}


