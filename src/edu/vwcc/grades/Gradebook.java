package edu.vwcc.grades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gradebook {
	private List<Student> students = new ArrayList<>();

	/**
	 * Add a student to the Gradebook
	 */
	public void addStudent(Student student) {
		students.add(student);
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
		int total = 0;
		for (Integer grade : student.getGrades().values()) {
			total += grade;
		}
		return (int) Math.ceil(total / 10);
	}

	/**
	 * Prints all students and their final grades
	 */
	public void printGradebook() {
		for (Student student : students) {
			System.out.println(student.getName() + ": " + calculateFinalGrade(student));
		}
	}

	/**
	 * Retrieves a list of students with a final grade below 70
	 */
	public List<Student> getFailingStudents() {
		return students.stream().filter(stu -> calculateFinalGrade(stu) < 70).toList();
	}

	/**
	 * Find the best performing student based on final grades
	 */
	public Student getBestPerformingStudent() {
		return students.stream().max(new StudentComparator()).get();
	}

	/**
	 * Find the worst performing student based on final grades
	 */
	public Student getWorstPerformingStudent() {
		return students.stream().min(new StudentComparator()).get();

	}

	/**
	 * Give extra credit points to Students based on Good Attendance
	 *
	 */
	public void giveExtraCredit() {
		int goodAttendance = 10;
		int extraCredit = 10;

		for (Student student : this.students) {
			if (student.getAttendance().size() < goodAttendance)
				continue;

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

	private final class StudentComparator implements Comparator<Student> {
		@Override
		public int compare(Student s1, Student s2) {
			if (calculateFinalGrade(s1) < calculateFinalGrade(s2)) {
				return -1;
			} else if (calculateFinalGrade(s1) > calculateFinalGrade(s2)) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}