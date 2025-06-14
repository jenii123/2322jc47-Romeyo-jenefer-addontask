public class Reversearray {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of elements: ");
    int n = scanner.nextInt();
    int[] array = new int[n];
System.out.println("Enter the elements:");
    for (int i = 0; i < n; i++) {
    array[i] = scanner.nextInt();
}
System.out.println("Reversed array:");
     for (int i = n - 1; i >= 0; i--) {
System.out.print(array[i] + " ");
}
}
}


