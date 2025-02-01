package com.example.studentUtil;
import java.util.Arrays;

public class StudentUtilTest {
    public static void main(String[] args) {
        int[] studentIdList = {1001, 1002};
        char[][] studentsGrades = {{'A', 'A', 'A', 'B'}, {'A', 'B', 'B'}};

        // Test calculateGPA
        double[] gpas = StudentUtil.calculateGPA(studentIdList, studentsGrades);
        System.out.println("GPA Array: " + Arrays.toString(gpas));

        // Test getStudentsByGPA
        int[] studentsInRange = StudentUtil.getStudentsByGPA(3.2, 3.5, studentIdList, studentsGrades);
        System.out.println("Students with GPA in range: " + Arrays.toString(studentsInRange));
    }
}