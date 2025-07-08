// Hospital Patient Management System
// Demonstrates: Abstract Classes, Interfaces, Encapsulation, Polymorphism

// Interface for MedicalRecord functionality
interface MedicalRecord {
    void addRecord(String diagnosis, String treatment);
    void viewRecords();
}

// Abstract class Patient with encapsulation
abstract class Patient {
    // Private fields - Encapsulation
    private String patientId;
    private String name;
    private int age;
    private String gender;
    private String contactNumber;
    private boolean isAdmitted;
    
    // Constructor
    public Patient(String patientId, String name, int age, String gender, String contactNumber) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.isAdmitted = false;
    }
    
    // Getter methods - Encapsulation
    public String getPatientId() {
        return patientId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getContactNumber() {
        return contactNumber;
    }
    
    public boolean isAdmitted() {
        return isAdmitted;
    }
    
    // Setter methods with validation - Encapsulation
    public void setPatientId(String patientId) {
        if (patientId != null && !patientId.trim().isEmpty()) {
            this.patientId = patientId;
        } else {
            System.out.println("Patient ID cannot be empty");
        }
    }
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Patient name cannot be empty");
        }
    }
    
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }
    
    public void setGender(String gender) {
        if (gender != null && !gender.trim().isEmpty()) {
            this.gender = gender;
        } else {
            System.out.println("Gender cannot be empty");
        }
    }
    
    public void setContactNumber(String contactNumber) {
        if (contactNumber != null && !contactNumber.trim().isEmpty()) {
            this.contactNumber = contactNumber;
        } else {
            System.out.println("Contact number cannot be empty");
        }
    }
    
    public void setAdmitted(boolean admitted) {
        this.isAdmitted = admitted;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateBill();
    
    // Concrete method - shared implementation
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Contact: " + contactNumber);
        System.out.println("Admitted: " + (isAdmitted ? "Yes" : "No"));
        System.out.println("Bill Amount: $" + calculateBill());
    }
}

// InPatient class extending Patient
class InPatient extends Patient implements MedicalRecord {
    private int roomNumber;
    private int daysAdmitted;
    private String[] diagnoses;
    private String[] treatments;
    private int recordCount;
    private static final double DAILY_RATE = 200.0;
    private static final double ROOM_CHARGE = 150.0;
    
    public InPatient(String patientId, String name, int age, String gender, String contactNumber, int roomNumber) {
        super(patientId, name, age, gender, contactNumber);
        this.roomNumber = roomNumber;
        this.daysAdmitted = 0;
        this.diagnoses = new String[10];
        this.treatments = new String[10];
        this.recordCount = 0;
    }
    
    // Getter and setter methods
    public int getRoomNumber() {
        return roomNumber;
    }
    
    public void setRoomNumber(int roomNumber) {
        if (roomNumber > 0 && roomNumber <= 1000) {
            this.roomNumber = roomNumber;
        } else {
            System.out.println("Invalid room number");
        }
    }
    
    public int getDaysAdmitted() {
        return daysAdmitted;
    }
    
    public void setDaysAdmitted(int daysAdmitted) {
        if (daysAdmitted >= 0) {
            this.daysAdmitted = daysAdmitted;
        } else {
            System.out.println("Days admitted cannot be negative");
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateBill() {
        return (DAILY_RATE * daysAdmitted) + ROOM_CHARGE;
    }
    
    // Implementation of MedicalRecord interface methods
    @Override
    public void addRecord(String diagnosis, String treatment) {
        if (recordCount < diagnoses.length) {
            diagnoses[recordCount] = diagnosis;
            treatments[recordCount] = treatment;
            recordCount++;
            System.out.println("Medical record added for " + getName());
        } else {
            System.out.println("Medical record limit reached");
        }
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        if (recordCount == 0) {
            System.out.println("No medical records found");
        } else {
            for (int i = 0; i < recordCount; i++) {
                System.out.println("Record " + (i + 1) + ":");
                System.out.println("  Diagnosis: " + diagnoses[i]);
                System.out.println("  Treatment: " + treatments[i]);
            }
        }
    }
    
    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Days Admitted: " + daysAdmitted);
        System.out.println("------------------------");
    }
}

// OutPatient class extending Patient
class OutPatient extends Patient implements MedicalRecord {
    private int visitCount;
    private String[] diagnoses;
    private String[] treatments;
    private int recordCount;
    private static final double CONSULTATION_FEE = 50.0;
    private static final double MEDICINE_CHARGE = 30.0;
    
    public OutPatient(String patientId, String name, int age, String gender, String contactNumber) {
        super(patientId, name, age, gender, contactNumber);
        this.visitCount = 0;
        this.diagnoses = new String[10];
        this.treatments = new String[10];
        this.recordCount = 0;
    }
    
    // Getter and setter methods
    public int getVisitCount() {
        return visitCount;
    }
    
    public void setVisitCount(int visitCount) {
        if (visitCount >= 0) {
            this.visitCount = visitCount;
        } else {
            System.out.println("Visit count cannot be negative");
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateBill() {
        return (CONSULTATION_FEE + MEDICINE_CHARGE) * visitCount;
    }
    
    // Implementation of MedicalRecord interface methods
    @Override
    public void addRecord(String diagnosis, String treatment) {
        if (recordCount < diagnoses.length) {
            diagnoses[recordCount] = diagnosis;
            treatments[recordCount] = treatment;
            recordCount++;
            visitCount++;
            System.out.println("Medical record added for " + getName());
        } else {
            System.out.println("Medical record limit reached");
        }
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        if (recordCount == 0) {
            System.out.println("No medical records found");
        } else {
            for (int i = 0; i < recordCount; i++) {
                System.out.println("Visit " + (i + 1) + ":");
                System.out.println("  Diagnosis: " + diagnoses[i]);
                System.out.println("  Treatment: " + treatments[i]);
            }
        }
    }
    
    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Visit Count: " + visitCount);
        System.out.println("------------------------");
    }
}

// Main class to demonstrate the system
public class HospitalPatientManagement {
    public static void main(String[] args) {
        System.out.println("=== Hospital Patient Management System ===\n");
        
        // Creating patients
        InPatient inPatient = new InPatient("IP001", "John Doe", 45, "Male", "123-456-7890", 101);
        OutPatient outPatient = new OutPatient("OP001", "Jane Smith", 32, "Female", "098-765-4321");
        
        // Setting admission status and days
        inPatient.setAdmitted(true);
        inPatient.setDaysAdmitted(5);
        outPatient.setVisitCount(3);
        
        // Adding medical records
        inPatient.addRecord("Pneumonia", "Antibiotics and rest");
        inPatient.addRecord("Fever", "Paracetamol");
        outPatient.addRecord("Headache", "Pain relievers");
        outPatient.addRecord("Cough", "Cough syrup");
        outPatient.addRecord("Fever", "Antipyretics");
        
        // Demonstrating polymorphism - using Patient reference
        Patient[] patients = {inPatient, outPatient};
        
        System.out.println("Patient Details:");
        for (Patient patient : patients) {
            patient.getPatientDetails(); // Polymorphic method call
        }
        
        // Demonstrating interface usage
        System.out.println("Medical Records:");
        MedicalRecord[] medicalRecords = {inPatient, outPatient};
        for (MedicalRecord record : medicalRecords) {
            record.viewRecords();
            System.out.println();
        }
        
        // Demonstrating billing with polymorphism
        System.out.println("Billing Summary:");
        for (Patient patient : patients) {
            System.out.println(patient.getName() + " - Bill: $" + patient.calculateBill());
        }
        
        // Demonstrating encapsulation
        System.out.println("\n=== Testing Encapsulation ===");
        inPatient.setName(""); // Should show validation message
        outPatient.setAge(200); // Should show validation message
        inPatient.setRoomNumber(-1); // Should show validation message
        
        inPatient.setName("John Updated");
        outPatient.setAge(35);
        inPatient.setRoomNumber(102);
        
        System.out.println("Updated patient details:");
        inPatient.getPatientDetails();
        outPatient.getPatientDetails();
    }
} 