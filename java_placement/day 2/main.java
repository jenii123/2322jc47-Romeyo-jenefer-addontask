class Main {
    public static void main(String[] args) {
        String str = "morning";
        String vowels = "";
        String consonants = "";
for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        vowels += ch;
} else {
        consonants += ch;
}
}
System.out.println("Vowels: " + vowels);
System.out.println("Consonants: " + consonants);
}
} 