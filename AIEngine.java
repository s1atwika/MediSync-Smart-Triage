import java.util.ArrayList;

public class AIEngine {
    public MedicalAnalyzer getAnalyzerForPatient(Patient p) {
        if (p.getBloodPressure() > 135 || p.getSugarLevel() < 100) {
            return new CardioAnalyzer();
        } else {
            return new DiabetesAnalyzer();
        }
    }

    public void runTriage(HospitalManager manager) {
        System.out.println("Running AI Triage on " + manager.getPatientCount() + " patients...");
        for (Patient p : manager.getAllPatients()) {
            if (p.getRiskLevel().equals(RiskLevel.PENDING)) { // Fixed .equals
                MedicalAnalyzer activeAI = getAnalyzerForPatient(p);
                RiskLevel calculatedRisk = activeAI.analyzeRisk(p.getBloodPressure(), p.getSugarLevel(), p.getBmi());
                Department department = activeAI.assignDepartment();
                
                p.setRiskLevel(calculatedRisk);
                p.setAssignedDepartment(department);
            }
        }
        System.out.println("Triage Complete.");
    }
}