public class AverageMarks {
    public static void main(String[] args) {
        int mathsMarks = 94;
        int physicsMarks = 95;
        int chemistryMarks = 96;
        
        double averageMarks = (mathsMarks + physicsMarks + chemistryMarks) / 3.0;
        
        System.out.printf("Sam's average mark in PCM is %.2f%%%n", averageMarks);
    }
} 