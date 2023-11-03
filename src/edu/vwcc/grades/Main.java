package edu.vwcc.grades;

import java.util.Scanner;

/**
 * Program Name: STUDENT GRADEBOOK PROGRAM
 * Your Name: Cory Dunton
 * Your Date: 11/1/2023
 * 
 * INSTRUCTIONS:
 * You are a new Java developer assigned the Task of completing this Student Gradebook program 
 * and testing it with at least 8 or more students (you choose their names)
 * 
 * First, go ahead and run Main (this class) to see the User Menu and what you will be working on
 * 
 * You will need to complete all the cases and methods necessary for this Menu-based program to work
 * I've provided the skeleton and some methods for you; I've tried to mark everything you need to do with TODO
 * 
 * Start by implementing the generateGrades() method in DataLoader.java which must create an int array of grades
 * 
 * Tips: Read through all the Classes, their code, and view the UML Diagram if it helps
 * 
 * Make sure to do the assigned reading of Sets and Maps because each Student contains a grades Map and an Attendance Set
 * 
 * Where no instructions are provided, you make the rules up. For example, it is up to you to decide how
 * to award Extra Credit points for Good Attendance. Post Questions in Canvas. Good Luck!
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
                case 1:
                    // Please add 8 or more students, you can add more by changing NUM_STUDENTS value
                    for (int i = 0; i < NUM_STUDENTS; i++) {
                        System.out.print("Enter the name of student " + (i + 1) + ": ");
                        String name = scanner.nextLine();
                        Student student = new Student(name);
                    }
                    break;

                case 2:
                    // Load Grades
                    if (gradebook.getStudents().isEmpty()) {
                        System.out.println("Error: No students available.");
                        break;
                    }
                    
                    for (Student student : gradebook.getStudents()) {
                    	int[] grades = DataLoader.generateGrades();
                    	student.setGrades(grades);
                    }
                    
                    break;

                case 3:
                    // Show Final Grades
                    if (gradebook.getStudents().isEmpty()) {
                        System.out.println("Error: No students available.");
                        break;
                    }
                    // TODO
                    for (Student student : gradebook.getStudents()) {
                    	for (Integer grade : student.getGrades().values()) {
                    		System.out.println(grade);
                    	}
                    }
                    break;

                case 4:
                	// Continue based on menu choices...
                    // TODO
                    break;

                case 5:
                    // TODO
                    break;

                case 6:
                    // TODO
                    break;

                case 7:
                    // TODO
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

