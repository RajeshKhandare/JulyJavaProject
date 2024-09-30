package com.java.mini.project;

import java.sql.SQLException;
import java.util.Scanner;
//Main Method to Display The List of Operation
public class MainMethod {

	static{
		// Welcome message
		System.out.println("Welcome to Quiz based application\r\n");
	}
	public static void main(String[] args) throws SQLException {	

		// Displaying the operation options
		//		for(int i = 1;i<=8;i++) {

		System.out.println("User Operation\r\n");
		System.out.println("1. Student Registration");
		System.out.println("2. Student Login");
		System.out.println("3. Display the list of questions");
		System.out.println("4. Store Quiz result into database");
		System.out.println("5. Display Quiz result\r\n");
		System.out.println("Admin Operation\r\n");
		System.out.println("6. Display all students score as per ascending order");
		System.out.println("7. Fetch student score by using id");
		System.out.println("8. Add question with 4 options into database\r\n");


		// Creating a Scanner object to read user input
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter your choice: \r\n");

			int choice = scanner.nextInt();

			// Switch statement to handle the user's choice
			switch (choice) {
			case 1:
				// Creating an instance of the Registration class
				Registration registration=new Registration();
				registration. getUserInputData(); // method   calling
				break;

			case 2:
				// Creating an instance of the LoginPage class
				LoginPage loginPage=new LoginPage();
				loginPage.loginStudent(); // method calling		                
				break;

			case 3:
				// Creating an instance of the DisplayQuestion class
				DisplayQuestion displayQuestion=new DisplayQuestion();
				displayQuestion.displayQuestions(); // method calling
				break;

			case 4:
				// Creating an instance of the storeQuizResult class
				StoreQuizResult storeQuizResult=new StoreQuizResult();
				storeQuizResult.storeResult();
				break;

			case 5:
				// Creating an instance of the DisplayQuestion class
				DisplayResult displayResult=new DisplayResult();
				displayResult.displayScore();
				break;

			case 6:
				// Creating an instance of the DisplayStudentScores class
				DisplayStudentScores displayStudentScores=new DisplayStudentScores();
				displayStudentScores.getStudentScore();
				break;

			case 7:
				// Creating an instance of the ScoresById class
				ScoresById  scoresById=new ScoresById();
				scoresById.fetchStudentScoreById();

				break;

			case 8:
				// Creating an instance of the QuestionTable class
				QuestionTable  questionTable=new QuestionTable();
				questionTable.setQuestionsInDatabase();;
				break;	

			default:

				// Displaying an error message for invalid choice
				System.out.println("Invalid choice. \r\n");
				break;
			}
		}
	}
}
//}



