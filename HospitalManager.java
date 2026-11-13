import java.util.ArrayList;
import java.util.Comparator;

public class HospitalManager {

    private ArrayList<Patient> patients;

    public HospitalManager() {
        patients = new ArrayList<>();
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public int getPatientCount() {
        return patients.size();
    }

    public ArrayList<Patient> getAllPatients() {
        return patients;
    }

    public void sortPatientsByRisk() {
        patients.sort(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return getRiskPriority(p1.getRiskLevel()) - getRiskPriority(p2.getRiskLevel());
            }
        });
    }

    private int getRiskPriority(RiskLevel risk) {
        switch (risk) {
            case HIGH: return 1;
            case MODERATE: return 2;
            case LOW: return 3;
            default: return 4;
        }
    }

    public void displayTopHighRisk(int limit) {
        System.out.println("\n=== TOP HIGH RISK PATIENTS ===");
        int count = 0;

        for (Patient p : patients) {
            // Fixed this line to use .equals()
            if (p.getRiskLevel().equals(RiskLevel.HIGH)) {
                p.displayDetails();
                count++;
                if (count >= limit) {
                    break;
                }
            }
        }

        if (count == 0) {
            System.out.println("No high-risk patients found.");
        }
    }
}