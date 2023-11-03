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
    	List<Student> failingStudents = new ArrayList<>();
    	
    	for (Student student : this.students) {
    		boolean isFailing = false;
    		for (Integer grade : student.getGrades().values()) {
    			if (grade < 70) {
    				isFailing = true;
    				break;
    			}
    		}
    		
    		if (isFailing) {
    			failingStudents.add(student);
    		}
    	}
    	
        return failingStudents; 
    }

    /**
     * Find the best performing student based on final grades
     */
    public Student getBestPerformingStudent() {
    	Student bestPerformingStudent = this.students.get(0);
    	
    	for (Student student : this.students) {
    		int bestPerformingStudentGrades = bestPerformingStudent.getGrades().values().stream()
    				.mapToInt(Integer::intValue)
    				.sum();
    		int currentStudentGrades = student.getGrades().values().stream()
    				.mapToInt(Integer::intValue)
    				.sum();
    		if (currentStudentGrades > bestPerformingStudentGrades) {
    			bestPerformingStudent = student;
    		}
    	}
    	
        return bestPerformingStudent; 
    }

    /**
     * Find the worst performing student based on final grades
     */
    public Student getWorstPerformingStudent() {
    	Student worstPerformingStudent = this.students.get(0);
    	
    	for (Student student : this.students) {
    		int worstPerformingStudentGrades = worstPerformingStudent.getGrades().values().stream()
    				.mapToInt(Integer::intValue)
    				.sum();
    		int currentStudentGrades = student.getGrades().values().stream()
    				.mapToInt(Integer::intValue)
    				.sum();
    		if (currentStudentGrades < worstPerformingStudentGrades) {
    			worstPerformingStudent = student;
    		}
    	}
    	
        return worstPerformingStudent; 
    
    }
    
    /**
     * Give extra credit points to Students based on Good Attendance
     *
     */
    public void giveExtraCredit() {
    	int goodAttendance = 10;
    	int extraCredit = 10;
    	
    	for (Student student : this.students) {
    		if (student.getAttendance().size() < goodAttendance) continue;
    		
    		for (String clazz : student.getGrades().keySet()) {
    			Integer grade = student.getGrades().get(clazz);
    			grade = grade + extraCredit;
    			if (grade > 100) {
    				grade = 100;
    			}
    			student.getGrades().put(clazz, grade);
    		}    		
    	}    	
    }    
}