package day5;

import java.util.*;


public class StudentCourseEnrollmentSystem {

    private ArrayList<String> studentList;
    private HashMap<String, ArrayList<String>> studentCourses;

    public StudentCourseEnrollmentSystem() {
        studentList = new ArrayList<>();
        studentCourses = new HashMap<>();
    }

    public void addStudentAndEnroll(String studentName, String courseName) {
        if (!studentList.contains(studentName)) {
            studentList.add(studentName);
            studentCourses.put(studentName, new ArrayList<>());
            System.out.println("Student added: " + studentName);
        } else {
            System.out.println("Student already exists. Adding course...");
        }

        ArrayList<String> courses = studentCourses.get(studentName);
        if (!courses.contains(courseName)) {
            courses.add(courseName);
            System.out.println( studentName + " enrolled in " + courseName);
        } else {
            System.out.println("Student already enrolled in this course.");
        }
    }

    public void removeStudent(String studentName) {
        if (studentList.contains(studentName)) {
            studentList.remove(studentName);
            studentCourses.remove(studentName);
            System.out.println(" Student removed: " + studentName);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayStudentsAndCourses() {
        System.out.println("\n=== Students and Their Courses ===");
        if (studentList.isEmpty()) {
            System.out.println("No students enrolled yet.");
        } else {
            for (String student : studentList) {
                System.out.println("Student: " + student);
                ArrayList<String> courses = studentCourses.get(student);
                if (courses.isEmpty()) {
                    System.out.println("  No courses enrolled.");
                } else {
                    for (String course : courses) {
                        System.out.println("  Course: " + course);
                    }
                }
            }
        }
        System.out.println("==================================\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentCourseEnrollmentSystem system = new StudentCourseEnrollmentSystem();

        while (true) {
            System.out.println("===== Student Course Enrollment System =====");
            System.out.println("1. Add Student and Enroll in Course");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students and Courses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    system.addStudentAndEnroll(studentName, courseName);
                    break;
                case 2:
                    System.out.print("Enter student name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    system.removeStudent(nameToRemove);
                    break;
                case 3:
                    system.displayStudentsAndCourses();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
