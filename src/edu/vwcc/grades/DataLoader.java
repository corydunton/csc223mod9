package edu.vwcc.grades;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DataLoader {

	/**
	 * TODO Generate an array of 10 random grades between 50 and 100, inclusive.
	 *
	 * Instructions:
	 *
	 * Use either Math.random() or java.util.Random to generate the random grades
	 *
	 * @return An int array of size 10 containing random grades.
	 */
	public static int[] generateGrades() {
		Random rand = new Random();
		int[] grades = rand.ints(10, 50, 101).toArray();

		return grades;
	}

	/**
	 * Generates a random set of attendance records for a student.
	 * 
	 * @return HashSet of LocalDates between 5 and 15.
	 */
	public static Set<LocalDate> generateAttendanceRecords() {
		Random random = new Random();
		Set<LocalDate> records = new HashSet<>();
		int numDays = random.nextInt(11) + 5; // Randomly pick between 5 and 15 days
		for (int i = 0; i < numDays; ++i) {
			// Randomly pick a date between Jan 1 and Dec 31, 2023
			int dayOfYear = random.nextInt(365) + 1;
			LocalDate date = LocalDate.ofYearDay(2023, dayOfYear);
			records.add(date);
		}
		return records;
	}

}