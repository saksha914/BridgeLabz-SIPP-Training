import java.util.Scanner;

public class VowelConsonantTypeTable {
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

    // Method to create a 2D array of character and type
    public static String[][] getCharTypes(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkCharacter(text.charAt(i));
        }
        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayTable(String[][] table) {
        System.out.println("\nCharacter Type Table");
        System.out.println("--------------------------");
        System.out.printf("%-10s %-15s%n", "Char", "Type");
        System.out.println("--------------------------");
        for (String[] row : table) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        String[][] charTypes = getCharTypes(text);
        displayTable(charTypes);
        scanner.close();
    }
} 