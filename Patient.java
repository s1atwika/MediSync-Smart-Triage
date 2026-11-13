public class Patient extends Person {

    private int patientId;
    private double bloodPressure, sugarLevel, bmi;
    private RiskLevel riskLevel;
    private Department assignedDepartment;

    public Patient(int patientId, String name, int age, double bp, double sugar, double bmi)
            throws InvalidVitalException {

        super(name, age);

        if (bp <= 0 || sugar < 0 || bmi <= 0) {
            throw new InvalidVitalException("Invalid vitals for " + name);
        }

        this.patientId = patientId;
        this.bloodPressure = bp;
        this.sugarLevel = sugar;
        this.bmi = bmi;

        this.riskLevel = RiskLevel.PENDING;
        this.assignedDepartment = Department.PENDING;
    }

    // Getters
    public int getPatientId() { return patientId; }
    public double getBloodPressure() { return bloodPressure; }
    public double getSugarLevel() { return sugarLevel; }
    public double getBmi() { return bmi; }
    public RiskLevel getRiskLevel() { return riskLevel; }
    public Department getAssignedDepartment() { return assignedDepartment; }

    // Setters
    public void setRiskLevel(RiskLevel riskLevel) { this.riskLevel = riskLevel; }
    public void setAssignedDepartment(Department assignedDepartment) { this.assignedDepartment = assignedDepartment; }

    // Display Details (Using StringBuilder)
    @Override
    public void displayDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(patientId)
          .append(" | Age: ").append(age) 
          .append(" | BP: ").append(bloodPressure)
          .append(" | Risk: ").append(riskLevel)
          .append(" | Dept: ").append(assignedDepartment);
        System.out.println(sb.toString());
    }

    // NEW: Demonstrating String, StringBuilder, StringBuffer
    public String generateMedicalSummary() {
        StringBuffer summaryBuffer = new StringBuffer();
        summaryBuffer.append("Patient ").append(name).append(" requires review. ");
        
        StringBuilder notes = new StringBuilder();
        notes.append("Vitals: BP=").append(bloodPressure).append(", Sugar=").append(sugarLevel);
        
        summaryBuffer.append(notes);
        return summaryBuffer.toString();
    }
}