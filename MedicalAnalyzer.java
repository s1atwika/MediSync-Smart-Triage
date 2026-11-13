public interface MedicalAnalyzer {
    RiskLevel analyzeRisk(double bp, double sugar, double bmi);
    Department assignDepartment();
}