import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {
    public static void loadPatients(String filePath, HospitalManager manager) {
        System.out.println("Loading data from " + filePath + "...");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                int age = Integer.parseInt(data[1].trim());
                double bmi = Double.parseDouble(data[3].trim());
                double bp = Double.parseDouble(data[4].trim());
                double sugar = Double.parseDouble(data[7].trim());
                
                try {
                    manager.addPatient(new Patient(id, "P_" + id, age, bp, sugar, bmi));
                } catch (InvalidVitalException e) { }
            }
            System.out.println("Successfully loaded " + manager.getPatientCount() + " patients.");
        } catch (Exception e) {
            System.out.println("Error reading dataset: " + e.getMessage());
        }
    }

    public static void exportReport(String filePath, HospitalManager manager) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("=== HOSPITAL TRIAGE REPORT ===");
            writer.println("Total Patients Processed: " + manager.getPatientCount());
            writer.println("=================================================");
            for (Patient p : manager.getAllPatients()) {
                if (p.getRiskLevel().equals(RiskLevel.HIGH)) {
                    writer.printf("ID: %-4d | BP: %-5.1f | Sugar: %-5.1f | Dept: %s%n", 
                        p.getPatientId(), p.getBloodPressure(), p.getSugarLevel(), p.getAssignedDepartment());
                }
            }
            System.out.println("Report successfully exported to " + filePath);
        } catch (IOException e) {
            System.out.println("Error exporting report.");
        }
    }
}