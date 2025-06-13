import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter name: ");
        String name = input.nextLine();
        
        System.out.print("Enter from city: ");
        String fromCity = input.nextLine();
        
        System.out.print("Enter via city: ");
        String viaCity = input.nextLine();
        
        System.out.print("Enter to city: ");
        String toCity = input.nextLine();
        
        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = input.nextDouble();
        
        System.out.print("Enter distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = input.nextDouble();
        
        System.out.print("Enter time taken from " + fromCity + " to " + viaCity + " in minutes: ");
        int timeFromToVia = input.nextInt();
        
        System.out.print("Enter time taken from " + viaCity + " to " + toCity + " in minutes: ");
        int timeViaToFinalCity = input.nextInt();
        
        double totalDistanceKm = (fromToVia + viaToFinalCity) * 1.6;
        int totalTime = timeFromToVia + timeViaToFinalCity;
        
        System.out.printf("The Total Distance travelled by %s from %s to %s via %s is %.2f km and the Total Time taken is %d minutes%n",
                         name, fromCity, toCity, viaCity, totalDistanceKm, totalTime);
        
        input.close();
    }
} 