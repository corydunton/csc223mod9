package edu.vwcc.grades;

import java.util.ArrayList;
import java.util.List;

public class Gradebook {
    private List<Student> students = new ArrayList<>();


    /**
     * Add a student to the Gradebook
     */
    public void addStudent(Student student) {
        // TODO: Add the Student object to the 'students' list
    }
    
    /**
     * Get a list of all students in this Gradebook
     */
	public List<Student> getStudents() {
		return students;
	}

    /**
     * Calculates the final grade for a student
     * 
     * Use Math.ceil() to round up then cast to int
     */
    public int calculateFinalGrade(Student student) {
        // TODO: Implement the method to calculate the Final Grade for student
        return 0;
    }

    /**
     * Prints all students and their final grades
     */
    public void printGradebook() {
        // TODO: Implement a method to print all students and their final grades
    }

    /**
     * Retrieves a list of students with a final grade below 70
     */
    public List<Student> getFailingStudents() {
        // TODO: Implement the method to get a list of failing students
        return null; 
    }

    /**
     * Find the best performing student based on final grades
     */
    public Student getBestPerformingStudent() {
        // TODO: Implement the method to find the best performing student
        return null; 
    }

    /**
     * Find the worst performing student based on final grades
     */
    public Student getWorstPerformingStudent() {
        // TODO: Implement the method to find the worst performing student
        return null;
    }
    
    /**
     * Give extra credit points to Students based on Good Attendance
     *
     */
    
    // TODO

    
}

