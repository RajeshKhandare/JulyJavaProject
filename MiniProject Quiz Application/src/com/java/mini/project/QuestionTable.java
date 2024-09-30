package com.java.mini.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//8. Add question with 4 options into database
public class QuestionTable {

	public void setQuestionsInDatabase() {

		try {
			// Step-1- Loading Driver class

			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2- Establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");

			PreparedStatement statement = con.prepareStatement("INSERT INTO QuestionsTable (QuestionText, Option1, Option2, Option3, Option4, CorrectAnswer) VALUES (?, ?, ?, ?, ?, ?)");

			// Question 1
			statement.setString(1, "What is the default access modifier in Java?");
			statement.setString(2, "Public");
			statement.setString(3, "Private");
			statement.setString(4, "Protected");
			statement.setString(5, "Default");
			statement.setInt(6, 4);
			statement.executeUpdate();

			// Question 2
			statement.setString(1, "What is the purpose of the 'finally' block in a try-catch statement?");
			statement.setString(2, "To handle exceptions");
			statement.setString(3, "To execute code regardless of exceptions");
			statement.setString(4, "To skip exceptions");
			statement.setString(5, "To throw exceptions");
			statement.setInt(6, 2);
			statement.executeUpdate();

			// Question 3
			statement.setString(1, "What is the difference between '==' and '.equals()' in Java?");
			statement.setString(2, "Both are used for string comparison");
			statement.setString(3, "'==' is used for primitive comparison, '.equals()' is used for object comparison");
			statement.setString(4, "'==' is used for object comparison, '.equals()' is used for primitive comparison");
			statement.setString(5, "Both are used for primitive comparison");
			statement.setInt(6, 2);
			statement.executeUpdate();

			// Question 4
			statement.setString(1, "What is the purpose of the 'abstract' keyword in Java?");
			statement.setString(2, "To declare a variable");
			statement.setString(3, "To declare a method");
			statement.setString(4, "To declare an abstract class or method");
			statement.setString(5, "To declare a concrete class or method");
			statement.setInt(6, 3);
			statement.executeUpdate();

			// Question 5
			statement.setString(1, "What is the purpose of the 'interface' keyword in Java?");
			statement.setString(2, "To declare a class");
			statement.setString(3, "To declare a method");
			statement.setString(4, "To declare an interface");
			statement.setString(5, "To declare a variable");
			statement.setInt(6, 3);
			statement.executeUpdate();

			// Question 6
			statement.setString(1, "What is the purpose of the 'super' keyword in Java?");
			statement.setString(2, "To access the parent class");
			statement.setString(3, "To access the child class");
			statement.setString(4, "To access the current class");
			statement.setString(5, "To access the grandparent class");
			statement.setInt(6, 1);
			statement.executeUpdate();

			// Question 7
			statement.setString(1, "What is the purpose of the 'this' keyword in Java?");
			statement.setString(2, "To access the parent class");
			statement.setString(3, "To access the child class");
			statement.setString(4, "To access the current class");
			statement.setString(5, "To access the grandparent class");
			statement.setInt(6, 3);
			statement.executeUpdate();

			// Question 8
			statement.setString(1, "What is the purpose of the 'static' keyword in Java?");
			statement.setString(2, "To declare a variable");
			statement.setString(3, "To declare a method");
			statement.setString(4, "To declare a static variable or method");
			statement.setString(5, "To declare a non-static variable or method");
			statement.setInt(6, 3);
			statement.executeUpdate();

			// Question 9
			statement.setString(1, "What is the purpose of the 'final' keyword in Java?");
			statement.setString(2, "To declare a variable");
			statement.setString(3, "To declare a method");
			statement.setString(4, "To declare a final variable, method, or class");
			statement.setString(5, "To declare a non-final variable, method, or class");
			statement.setInt(6, 3);
			statement .executeUpdate();

			// Question 10
			statement.setString(1, "What is the purpose of the 'throws' keyword in Java?");
			statement.setString(2, "To handle exceptions");
			statement.setString(3, "To declare exceptions");
			statement.setString(4, "To throw exceptions");
			statement.setString(5, "To skip exceptions");
			statement.setInt(6, 2);
			int a=  statement.executeUpdate();
			System.out.println("Questions are Incerted Successefully \r\n");
			statement.close();   
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error setting questions in database: " + e.getMessage());
		}

	}

	public static void main(String[] args) {
		QuestionTable questionTable=new QuestionTable();
		questionTable.setQuestionsInDatabase(); // methid calling
	}
}
