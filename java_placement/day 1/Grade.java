import java.util.*;
public class Grade {
    static String getGrade(int m) {
        if (m >= 90) return "A+";
        else if (m >= 80) return "A";
        else if (m >= 70) return "B";
        else if (m >= 60) return "C";
        else if (m >= 50) return "D";
        else return "F";
}
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks: ");
        int marks = sc.nextInt();
        System.out.println("Grade: " + getGrade(marks));
}
}
