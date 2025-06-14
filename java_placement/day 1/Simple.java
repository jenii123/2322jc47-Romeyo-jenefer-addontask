import java.util.Scanner;
public class Simple {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
System.out.print("Enter the Principal amount: ");
    double principal = scanner.nextDouble();
System.out.print("Enter the Rate of Interest (in %): ");
    double rate = scanner.nextDouble();
System.out.print("Enter the Time (in years): ");
    double time = scanner.nextDouble();
    double simpleInterest = (principal * rate * time) / 100;
System.out.println("The Simple Interest is: " + simpleInterest);
scanner.close();
}
}



