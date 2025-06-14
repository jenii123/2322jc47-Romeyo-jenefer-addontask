import java.util.Scanner;
public class SplitSentence {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
System.out.println("Enter a sentence:");
    String sentence = scanner.nextLine();
    String[] words = sentence.split(" ");
System.out.println("Words in the sentence:");
    for (String word : words) {
System.out.println(word);
}
scanner.close();
}
}