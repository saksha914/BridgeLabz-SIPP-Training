import java.util.Scanner;

public class TextSplitter {
    
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
    
    // Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        // Split using user-defined method
        String[] words1 = splitText(text);
        
        // Split using split()
        String[] words2 = text.split(" ");
        
        // Compare the results
        boolean areEqual = compareArrays(words1, words2);
        
        System.out.println("\nResults:");
        System.out.println("Original text: " + text);
        System.out.println("\nWords using user-defined method:");
        for (String word : words1) {
            System.out.println(word);
        }
        System.out.println("\nWords using split() method:");
        for (String word : words2) {
            System.out.println(word);
        }
        System.out.println("\nAre the results equal? " + areEqual);
        
        scanner.close();
    }
} 