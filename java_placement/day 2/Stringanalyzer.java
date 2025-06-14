import java.util.Scanner;
public class Stringanalyzer {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter a string:");
   String input = scanner.nextLine();

String[] words = input.split("\\s+");
    int wordCount = words.length;
    int charCount = input.replace(" ", "").length();

String reversed = new StringBuilder(input).reverse().toString();
String longestWord = "";
     for (String word : words) {
     if (word.length() > longestWord.length()) {
     longestWord = word;
}
}
System.out.println("Word Count: " + wordCount);
System.out.println("Character Count (excluding spaces): " + charCount);
System.out.println("Reversed String: " + reversed);
System.out.println("Longest Word: " + longestWord);
scanner.close();
}
}

