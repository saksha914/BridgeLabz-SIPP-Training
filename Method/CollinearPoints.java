import java.util.Scanner;

public class CollinearPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x1 y1: ");
        int x1 = scanner.nextInt(), y1 = scanner.nextInt();
        System.out.print("Enter x2 y2: ");
        int x2 = scanner.nextInt(), y2 = scanner.nextInt();
        System.out.print("Enter x3 y3: ");
        int x3 = scanner.nextInt(), y3 = scanner.nextInt();
        System.out.println("Collinear (slope method): " + areCollinearSlope(x1, y1, x2, y2, x3, y3));
        System.out.println("Collinear (area method): " + areCollinearArea(x1, y1, x2, y2, x3, y3));
        scanner.close();
    }
    public static boolean areCollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }
    public static boolean areCollinearArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)) == 0;
    }
} 