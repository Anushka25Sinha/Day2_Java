package com.example.studentUtil;
import java.util.ArrayList;
import java.util.List;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentGrades){
        double[] GPAarray = new double[studentIdList.length];

        for(int i=0; i<studentIdList.length; i++)
        {
           char[] grades = studentGrades[i];
           double totalPoints =0;

           for(char grade:grades)
           {
               totalPoints+=getGradePoint(grade);
           }

           GPAarray[i]=totalPoints/grades.length;
        }
        return GPAarray;
    }

    private static int getGradePoint(char grade)
    {
        switch(grade){
            case 'A' : return 4;
            case 'B' : return 3;
            case 'C' : return 2;
            default: throw new IllegalArgumentException("Invalid grade: "+ grade);
        }
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        double[] gpaArray = calculateGPA(studentIdList, studentsGrades);
        List<Integer> filteredStudents = new ArrayList<>();

        for (int i = 0; i < gpaArray.length; i++) {
            if (gpaArray[i] >= lower && gpaArray[i] <= higher) {
                filteredStudents.add(studentIdList[i]);
            }
        }

        return filteredStudents.stream().mapToInt(i -> i).toArray();
    }
}
