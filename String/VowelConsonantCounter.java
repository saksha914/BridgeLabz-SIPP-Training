import java.util.Scanner;

public class VowelConsonantCounter {
    // Method to check if character is vowel or consonant
    public static String checkCharacter(char c) {
        // Convert to lowercase
        if (c >= 'A' && c <= 'Z') {
            c = (char)(c + 32);
        }
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to count vowels and consonants
    public static int[] countVowelsAndConsonants(String text) {
        int[] counts = new int[2]; // [vowels, consonants]
        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacter(text.charAt(i));
            if (type.equals("Vowel")) {
                counts[0]++;
            } else if (type.equals("Consonant")) {
                counts[1]++;
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        int[] counts = countVowelsAndConsonants(text);
        System.out.println("\nResults:");
        System.out.println("Text: " + text);
        System.out.println("Number of vowels: " + counts[0]);
        System.out.println("Number of consonants: " + counts[1]);
        scanner.close();
    }
} 