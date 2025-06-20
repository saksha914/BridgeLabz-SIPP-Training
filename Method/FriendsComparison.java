import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of friend " + (i+1) + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height (in cm) of friend " + (i+1) + ": ");
            heights[i] = scanner.nextInt();
        }
        int youngest = findYoungest(ages);
        int tallest = findTallest(heights);
        System.out.println("Youngest friend's age: " + youngest);
        System.out.println("Tallest friend's height: " + tallest);
        scanner.close();
    }
    public static int findYoungest(int[] ages) {
        int min = ages[0];
        for (int age : ages) {
            if (age < min) min = age;
        }
        return min;
    }
    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int h : heights) {
            if (h > max) max = h;
        }
        return max;
    }
} 