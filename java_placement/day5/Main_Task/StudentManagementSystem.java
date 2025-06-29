package Main_task;

import java.util.*;

public class StudentManagementSystem {

    private ArrayList<String> studentNames;
    private HashMap<String, ArrayList<String>> studentData; // studentID → list of courses

    public StudentManagementSystem () {
        studentNames = new ArrayList<>();
        studentData = new HashMap<>();
    }

    // Add student and courses
    public void addStudent(String studentID, String studentName, List<String> courses) {
        if (studentData.containsKey(studentID)) {
            System.out.println(" Student ID already exists.");
            return;
        }

        studentNames.add(studentName);
        studentData.put(studentID, new ArrayList<>(courses));

        System.out.println(" Student " + studentName + " added with ID: " + studentID);
    }

    // Search student and courses by ID
    public void searchStudent(String studentID) {
        if (studentData.containsKey(studentID)) {
            System.out.println("Student ID: " + studentID);
            System.out.println("Courses:");
            for (String course : studentData.get(studentID)) {
                System.out.println(" - " + course);
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete student by ID
    public void deleteStudent(String studentID) {
        if (studentData.containsKey(studentID)) {
            studentData.remove(studentID);
            System.out.println("Student with ID " + studentID + " removed.");
        } else {
            System.out.println(" Student not found.");
        }
    }

    // Display all student IDs and their courses
    public void displayAll() {
        if (studentData.isEmpty()) {
            System.out.println(" No student records found.");
            return;
        }

        System.out.println(" All Students and Courses:");
        for (String studentID : studentData.keySet()) {
            System.out.println(studentID);
            ArrayList<String> courses = studentData.get(studentID);
            for (String course : courses) {
                System.out.println("   - " + course);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem  app = new StudentManagementSystem ();

        while (true) {
            System.out.println("\n=== Mini Student Management App ===");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Delete Student by ID");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter courses separated by commas: ");
                    String courseInput = scanner.nextLine();
                    List<String> courses = Arrays.asList(courseInput.split(","));
                    app.addStudent(id.trim(), name.trim(), courses);
                    break;

                case "2":
                    System.out.print("Enter Student ID to search: ");
                    String searchId = scanner.nextLine();
                    app.searchStudent(searchId.trim());
                    break;

                case "3":
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    app.deleteStudent(deleteId.trim());
                    break;

                case "4":
                    app.displayAll();
                    break;

                case "5":
                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
