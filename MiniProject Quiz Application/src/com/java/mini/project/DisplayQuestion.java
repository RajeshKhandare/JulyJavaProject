package com.java.mini.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
// 3. Display the list of questions
public class DisplayQuestion {

	public void displayQuestions()  {


		try {
			// Step-1- Loading Driver class

			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2- Establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM questionstable");

			ResultSet resultSet = ps.executeQuery();

			int count = 0;
			int questionNumber = 1;
			while (resultSet.next()) {
				int questionID = resultSet.getInt("id");
				String questionText = resultSet.getString("QuestionText");
				String option1 = resultSet.getString("Option1");
				String option2 = resultSet.getString("Option2");
				String option3 = resultSet.getString("Option3");
				String option4 = resultSet.getString("Option4");
				int correctAnswer = resultSet.getInt("CorrectAnswer");

				System.out.println("Question " + questionNumber + ": " + questionText);
				System.out.println("Option 1: " + option1);
				System .out.println("Option 2: " + option2);
				System.out.println("Option 3: " + option3);
				System.out.println("Option 4: " + option4);
				System.out.print("Enter your answer (1-4): \r\n");
				Scanner scanner = new Scanner(System.in);
				int userAnswer = scanner.nextInt();

				if (userAnswer == correctAnswer) {
					count++;
				}

				questionNumber++;

			}

			// Display Quiz result

			System.out.println("your Score is >> "+count+"\r\n");

			//4. Storing Quiz result into database

			String username = LoginPage.username;
			// Update the user's score in the registrationtable
			String updateSql = "UPDATE registrationtable SET score = ? WHERE username = ?";
			PreparedStatement updatePs = con.prepareStatement(updateSql);
			updatePs.setInt(1, count);
			updatePs.setString(2, username);

			updatePs.executeUpdate();

			con.close();
			ps.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error displaying questions: " + e.getMessage());
		}
	}
}
