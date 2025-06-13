import java.util.Scanner;

public class CylinderVolume {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the radius of the cylinder: ");
        double radius = input.nextDouble();
        
        System.out.print("Enter the height of the cylinder: ");
        double height = input.nextDouble();
        
        double volume = Math.PI * Math.pow(radius, 2) * height;
        
        System.out.printf("The volume of the cylinder with radius %.2f and height %.2f is %.2f%n",
                         radius, height, volume);
        
        input.close();
    }
} 