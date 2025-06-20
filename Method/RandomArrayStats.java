import java.util.Random;

public class RandomArrayStats {
    public static void main(String[] args) {
        int[] arr = generate4DigitRandomArray(5);
        System.out.print("Random 4-digit numbers: ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
        double[] stats = findAverageMinMax(arr);
        System.out.printf("Average: %.2f, Min: %.0f, Max: %.0f\n", stats[0], stats[1], stats[2]);
    }
    public static int[] generate4DigitRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + rand.nextInt(9000);
        }
        return arr;
    }
    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int n : numbers) {
            if (n < min) min = n;
            if (n > max) max = n;
            sum += n;
        }
        double avg = sum / (double) numbers.length;
        return new double[]{avg, min, max};
    }
} 