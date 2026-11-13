public class DiabetesAnalyzer implements MedicalAnalyzer {

    @Override
    public RiskLevel analyzeRisk(double bp, double sugar, double bmi) {
        if (!Double.isFinite(sugar) || !Double.isFinite(bmi) || sugar < 0 || bmi <= 0) {
            throw new IllegalArgumentException("Sugar and BMI must be valid values.");
        }

        if (sugar > 140 || bmi > 30) {
            return RiskLevel.HIGH;
        }

        if (sugar > 100 || bmi > 25) {
            return RiskLevel.MODERATE;
        }

        return RiskLevel.LOW;
    }

    @Override
    public Department assignDepartment() {
        return Department.ENDOCRINOLOGY;
    }
}