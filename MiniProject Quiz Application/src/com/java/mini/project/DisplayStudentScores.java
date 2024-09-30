package com.java.mini.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 6. Display all students score as per ascending order

public class DisplayStudentScores {
	public void getStudentScore() {
		try {
			// Replace with your database connection details

			System.out.println("ID - Username - Score");
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2- Establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");


			// Create a prepared statement to retrieve scores in ascending order
			String query = "SELECT * FROM registrationtable ORDER BY score ASC";
			PreparedStatement ps = con.prepareStatement(query);

			// Execute the query
			ResultSet resultSet = ps.executeQuery();

			// Display the results

			System.out.println("-----------------------------");
			while (resultSet.next()) {
				String username = resultSet.getString("username");
				int score = resultSet.getInt("score");
				int ID=resultSet.getInt("id");
				System.out.println(ID+"  "+username+"  "+ score+"\r\n");
			}

			// Close the resources
			resultSet.close();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error Displaying Score: " + e.getMessage());

		}
	}
}

