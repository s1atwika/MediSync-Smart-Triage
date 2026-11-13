public class CardioAnalyzer implements MedicalAnalyzer {

    @Override
    public RiskLevel analyzeRisk(double bp, double sugar, double bmi) {
        if (bp > 140) {
            return RiskLevel.HIGH;
        } else if (bp > 120) {
            return RiskLevel.MODERATE;
        } else {
            return RiskLevel.LOW;
        }
    }

    @Override
    public Department assignDepartment() {
        return Department.CARDIOLOGY;
    }
}