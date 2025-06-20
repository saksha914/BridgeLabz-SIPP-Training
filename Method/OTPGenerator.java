import java.util.Random;

public class OTPGenerator {
    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }
        System.out.print("Generated OTPs: ");
        for (int otp : otps) System.out.print(otp + " ");
        System.out.println();
        System.out.println("All OTPs unique: " + areUnique(otps));
    }
    public static int generateOTP() {
        Random rand = new Random();
        return 100000 + rand.nextInt(900000);
    }
    public static boolean areUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j]) return false;
        return true;
    }
} 