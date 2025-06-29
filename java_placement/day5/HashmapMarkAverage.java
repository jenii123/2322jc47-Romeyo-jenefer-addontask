package day5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashmapMarkAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> studentMarks = new HashMap<>();

        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Input student names and marks
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter marks for " + name + ": ");
            int marks = scanner.nextInt();
            scanner.nextLine(); // consume newline

            studentMarks.put(name, marks);
        }

        // Compute and display
        int totalMarks = 0;
        System.out.println("\nStudent Marks:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            totalMarks += entry.getValue();
        }

        double average = (count > 0) ? (double) totalMarks / count : 0;
        System.out.printf("\nAverage Marks: %.2f\n", average);

        scanner.close();
    }
}
