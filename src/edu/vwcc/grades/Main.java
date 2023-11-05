package edu.vwcc.grades;

import java.util.Scanner;

/**
 * Program Name: STUDENT GRADEBOOK PROGRAM Your Name: Cory Dunton Your Date:
 * 11/1/2023
 * 
 * INSTRUCTIONS: You are a new Java developer assigned the Task of completing
 * this Student Gradebook program and testing it with at least 8 or more
 * students (you choose their names)
 * 
 * First, go ahead and run Main (this class) to see the User Menu and what you
 * will be working on
 * 
 * You will need to complete all the cases and methods necessary for this
 * Menu-based program to work I've provided the skeleton and some methods for
 * you; I've tried to mark everything you need to do with TODO
 * 
 * Start by implementing the generateGrades() method in DataLoader.java which
 * must create an int array of grades
 * 
 * Tips: Read through all the Classes, their code, and view the UML Diagram if
 * it helps
 * 
 * Make sure to do the assigned reading of Sets and Maps because each Student
 * contains a grades Map and an Attendance Set
 * 
 * Where no instructions are provided, you make the rules up. For example, it is
 * up to you to decide how to award Extra Credit points for Good Attendance.
 * Post Questions in Canvas. Good Luck!
 * 
 */

public class Main {
	private static final int NUM_STUDENTS = 8;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Gradebook gradebook = new Gradebook();

		int choice;
		do {

			displayMenu();

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1: // Please add 8 or more students, you can add more by changing NUM_STUDENTS value
				for (int i = 0; i < NUM_STUDENTS; i++) {
					System.out.print("Enter the name of student " + (i + 1) + ": ");
					String name = scanner.nextLine();
					Student student = new Student(name);
					gradebook.addStudent(student);
				}
				System.out.println("Students added.");
				break;

			case 2: // Load Grades
				if (gradebook.getStudents().isEmpty()) {
					System.out.println("Error: No students available.");
					break;
				}
				for (Student student : gradebook.getStudents()) {
					student.setGrades(DataLoader.generateGrades());
				}
				System.out.println("Grades loaded successfully.");
				break;

			case 3: // Show Final Grades
				if (gradebook.getStudents().isEmpty()) {
					System.out.println("Error: No students available.");
					break;
				}
				gradebook.printGradebook();
				break;

			case 4: // Show students in danger of failing
				for (Student student : gradebook.getFailingStudents()) {
					System.out.println(student.getName());
				}
				break;

			case 5: // Show number of absences for all students
				for (Student student : gradebook.getStudents()) {
					int numAbsences = student.getNumAbsences();
					System.out.println(student.getName() + " has " + numAbsences + " absences.");
				}
				break;

			case 6: // Give extra credit for good attendance
				gradebook.giveExtraCredit();
				System.out.println("Extra credit has been awarded to all students with attendance >= 10 days.");
				break;

			case 7: // Show best and worst final grade
				System.out.println("Student with highest grade: " + gradebook.getBestPerformingStudent().getName());
				System.out.println("Student with lowest grade: " + gradebook.getWorstPerformingStudent().getName());
				break;

			case 0:
				System.out.println("Exiting the program.");
				scanner.close();
				return;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);

		scanner.close();
		System.out.println("Exiting...");
	}

	public static void displayMenu() {
		System.out.println("\nGRADEBOOK DEMO PROGRAM:");
		System.out.println("Menu Choices:");
		System.out.println("1. Add Students");
		System.out.println("2. Load Grades");
		System.out.println("3. Show Final Grades");
		System.out.println("4. Show Students in Danger of Failing");
		System.out.println("5. Show Number of Absences for all Students");
		System.out.println("6. Give Extra Credit for Good Attendance");
		System.out.println("7. Show Best and Worst Final Grade");
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
	}
}