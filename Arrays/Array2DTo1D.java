import java.util.Scanner;

public class Array2DTo1D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get dimensions
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();

        // Create 2D array
        int[][] matrix = new int[rows][columns];
        int[] array = new int[rows * columns];
        int index = 0;

        // Input values for 2D array
        System.out.println("\nEnter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("Enter element at position [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
                array[index++] = matrix[i][j];
            }
        }

        // Display 2D array
        System.out.println("\n2D Array (Matrix):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Display 1D array
        System.out.println("\n1D Array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
} 