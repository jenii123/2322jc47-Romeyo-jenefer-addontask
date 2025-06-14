package day3;

import java.util.ArrayList;
import java.util.Scanner;

public class Simplelibrary {
    static ArrayList<String> books = new ArrayList<>();

  
    public static void addBook(String title) {
        books.add(title);
        System.out.println("Book added: " + title);
    }


    public static void issueBook(String title) {
        if (books.contains(title)) {
            books.remove(title);
            System.out.println("Book issued: " + title);
        } else {
            System.out.println("Book not available.");
        }
    }

   
    public static void showBooks() {
        System.out.println("\nAvailable Books:");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (String book : books) {
                System.out.println("- " + book);
            }
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Show Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            if (choice == 1) {
                System.out.print("Enter book title to add: ");
                String title = scanner.nextLine();
                addBook(title);
            } else if (choice == 2) {
                System.out.print("Enter book title to issue: ");
                String title = scanner.nextLine();
                issueBook(title);
            } else if (choice == 3) {
                showBooks();
            } else if (choice == 4) {
                System.out.println("Exiting Library.");
            } else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        scanner.close();
    }
}



