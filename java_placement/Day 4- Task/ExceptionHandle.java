package TasksDay4;

import java.util.Scanner;

public class ExceptionHandle {
public static void main(String args[])
{
	Scanner in = new Scanner(System.in);
	System.out.println("Enter num1:");
	int n1=in.nextInt();
	System.out.println("Enter num2:");
	int n2=in.nextInt();
	try {
		int result=n1/n2;
		System.out.println("Result:"+result);
	} catch (ArithmeticException e) {
		System.out.println("\nERROR:Cannot divide by zero");
	}
}
}
