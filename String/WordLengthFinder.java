import java.util.Scanner;

public class WordLengthFinder {
    
    // Method to find string length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    // Method to split text into words using charAt()
    public static String[] splitText(String text) {
        // Count number of words
        int wordCount = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        
        // Create array to store words
        String[] words = new String[wordCount];
        int wordIndex = 0;
        int startIndex = 0;
        
        // Split text into words
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words[wordIndex] = text.substring(startIndex, i);
                wordIndex++;
                startIndex = i + 1;
            }
        }
        words[wordIndex] = text.substring(startIndex);
        
        return words;
    }
    
    // Method to get word lengths
    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }
    
    // Method to display results in tabular format
    public static void displayResults(String[][] wordLengths) {
        System.out.println("\nWord Lengths");
        System.out.println("------------------------");
        System.out.printf("%-20s %-10s%n", "Word", "Length");
        System.out.println("------------------------");
        
        for (String[] row : wordLengths) {
            System.out.printf("%-20s %-10s%n", row[0], row[1]);
        }
        System.out.println("------------------------");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        // Split text into words
        String[] words = splitText(text);
        
        // Get word lengths
        String[][] wordLengths = getWordLengths(words);
        
        // Display results
        displayResults(wordLengths);
        
        scanner.close();
    }
} 