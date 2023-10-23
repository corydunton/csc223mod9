package edu.vwcc.grades;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private final Map<String, Integer> grades; 
    private final Set<LocalDate> attendance;
    public static final int NUM_IN_PERSON_CLASSES = 15;
    

    public Student(String name) { // constructor to initialize fields
        this.name = name;
        
        this.grades = new HashMap<>();
        grades.put("Homework1", null);
        grades.put("Quiz1", null);
        grades.put("Homework2", null);
        grades.put("Quiz2", null);
        grades.put("MidtermExam", null);
        grades.put("Homework3", null);
        grades.put("Quiz3", null);
        grades.put("Homework4", null);
        grades.put("Quiz4", null);
        grades.put("FinalExam", null);

        this.attendance = DataLoader.generateAttendanceRecords();
    }


    // HELPER METHODS

    /**
     * Returns the grade of a student with the given key.
     */
    public Integer getStudentGrade(String key) {
        if (grades.containsKey(key)) {
            return grades.get(key);
        } else {
            throw new IllegalArgumentException("Invalid key: " + key);
        }
    }

    /**
     * Sets the grade of a student with the given key to the int value
     */
    public void setStudentGrade(String key, Integer value) {
        if (grades.containsKey(key)) {
            grades.put(key, value);
        } else {
            throw new IllegalArgumentException("Invalid key: " + key);
        }
    }
    
    
    // TODO Implement the following Helper method:
    /**
     * Sets all grades of a student at once with the given key
     */
    public void setGrades(int[] intArr) {
		// TODO 
	}
    

    /**
     * Marks a student as present on a given date.
     */
    public void markStudentPresent(LocalDate date) {
        attendance.add(date);
    }
    
    // TODO Create your own helper method to count number of Absences for a Student given just their String name

    
    
    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public Set<LocalDate> getAttendance() {
        return attendance;
    }



}
