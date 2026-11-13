import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalManager manager = new HospitalManager();
        AIEngine engine = new AIEngine();
        
        FileHandler.loadPatients("patients.csv", manager);
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MEDISYNC HOSPITAL DASHBOARD ===");
            System.out.println("1. Run AI Triage");
            System.out.println("2. View Sorted Patients");
            System.out.println("3. Export Triage Report to File");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            
            int choice = sc.nextInt();

            if (choice == 1) {
                engine.runTriage(manager);
            } else if (choice == 2) {
                manager.sortPatientsByRisk();
                manager.displayTopHighRisk(10);
            } else if (choice == 3) {
                FileHandler.exportReport("TriageReport.txt", manager);
            } else if (choice == 4) {
                break;
            }
        }
        sc.close();
    }
}