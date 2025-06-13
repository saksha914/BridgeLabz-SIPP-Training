public class EarthVolume {
    public static void main(String[] args) {
        double radius = 6378; // in kilometers
        double pi = Math.PI;
        
        // Volume in cubic kilometers
        double volumeKm = (4.0/3.0) * pi * Math.pow(radius, 3);
        
        // Convert to cubic miles (1 km = 0.621371 miles)
        double volumeMiles = volumeKm * Math.pow(0.621371, 3);
        
        System.out.printf("The volume of earth in cubic kilometers is %.2e and cubic miles is %.2e%n", 
                         volumeKm, volumeMiles);
    }
} 