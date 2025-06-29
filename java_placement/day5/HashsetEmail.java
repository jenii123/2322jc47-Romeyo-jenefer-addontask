package day5;

import java.util.HashSet;
import java.util.Scanner;

public class HashsetEmail{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> emailSet = new HashSet<>();

        System.out.print("Enter number of email addresses: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < count; i++) {
            System.out.print("Enter email address " + (i + 1) + ": ");
            String email = scanner.nextLine();

            // Add email to the set (duplicates will be ignored)
            if (emailSet.add(email)) {
                System.out.println("Email added.");
            } else {
                System.out.println("Thank You");
            }
        }

        // Display unique email addresses
        System.out.println("\nUnique Email Addresses:");
        for (String email : emailSet) {
            System.out.println(email);
        }

        scanner.close();
    }
}
