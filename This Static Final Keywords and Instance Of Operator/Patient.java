public class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public int getPatientID() { return patientID; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAilment() { return ailment; }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient(1, "Alice", 30, "Fever");
        Patient p2 = new Patient(2, "Bob", 45, "Diabetes");
        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
        System.out.println("\nTotal Patients: " + Patient.getTotalPatients());
    }
} 