package com.java.mini.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
// 7 Fetch student score by using id
public class ScoresById {

	public void fetchStudentScoreById() {
		try {

			// Step-1- Loading Driver class

			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2- Establish the database connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");

			// Get the student ID from the user
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the student ID: ");
			int studentId = scanner.nextInt();

			// Create a prepared statement to fetch the score by ID
			String query = "SELECT score FROM registrationtable WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);

			// Execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Check if a result was found
			if (resultSet.next()) {
				int score = resultSet.getInt("score");
				System.out.println("Score for student ID " + studentId + " : " + score+"\r\n");
			} else {
				System.out.println("No score found for student ID " + studentId);
			}

			// Close the resources
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error in fetching score : " + e.getMessage());
		}
	}
}
