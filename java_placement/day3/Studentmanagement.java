package day3;

import java.util.Scanner;



public class studentmanagement {

    

    

    static class Student {

        String name;

        int rollNumber;

        int[] assignmentMarks;

        int totalMarks;

        double average;



        public Student(String name, int rollNumber, int numAssignments) {

            this.name = name;

            this.rollNumber = rollNumber;

            this.assignmentMarks = new int[numAssignments];

        }



        public void calculateResult() {

            totalMarks = 0;

            for (int mark : assignmentMarks) {

                totalMarks += mark;

            }

            average = (double) totalMarks / assignmentMarks.length;

        }



        public void displayResult() {

            System.out.println("\n--- Student Result ---");

            System.out.println("Name: " + name);

            System.out.println("Roll Number: " + rollNumber);

            for (int i = 0; i < assignmentMarks.length; i++) {

                System.out.println("Assignment " + (i + 1) + " Marks: " + assignmentMarks[i]);

            }

            System.out.println("Total Marks: " + totalMarks);

            System.out.println("Average Marks: " + average);

        }

    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



       

        System.out.print("Enter student name: ");

        String name = scanner.nextLine();



        System.out.print("Enter roll number: ");

        int rollNumber = scanner.nextInt();



        System.out.print("Enter number of assignments: ");

        int numAssignments = scanner.nextInt();



        Student student = new Student(name, rollNumber, numAssignments);



     

        for (int i = 0; i < numAssignments; i++) {

            System.out.print("Enter marks for assignment " + (i + 1) + ": ");

            student.assignmentMarks[i] = scanner.nextInt();

        }



        

        student.calculateResult();

        student.displayResult();



        scanner.close();

    }

}