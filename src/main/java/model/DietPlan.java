package main.java.model;
import java.util.Objects;

public class DietPlan {
    private int planId;
    private Patient patient;
    private Dietitian dietitian;
    private int dailyCalories;
    private String macronutrientDistribution;
    private String specificRecommendations;


    public DietPlan() {
    }

    public DietPlan(int planId, Patient patient, Dietitian dietitian, int dailyCalories, String macronutrientDistribution, String specificRecommendations) {
        this.planId = planId;
        this.patient = patient;
        this.dietitian = dietitian;
        this.dailyCalories = dailyCalories;
        this.macronutrientDistribution = macronutrientDistribution;
        this.specificRecommendations = specificRecommendations;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dietitian getDietitian() {
        return this.dietitian;
    }

    public void setDietitian(Dietitian dietitian) {
        this.dietitian = dietitian;
    }

    public int getDailyCalories() {
        return this.dailyCalories;
    }

    public void setDailyCalories(int dailyCalories) {
        this.dailyCalories = dailyCalories;
    }

    public String getMacronutrientDistribution() {
        return this.macronutrientDistribution;
    }

    public void setMacronutrientDistribution(String macronutrientDistribution) {
        this.macronutrientDistribution = macronutrientDistribution;
    }

    public String getSpecificRecommendations() {
        return this.specificRecommendations;
    }

    public void setSpecificRecommendations(String specificRecommendations) {
        this.specificRecommendations = specificRecommendations;
    }

    public DietPlan planId(int planId) {
        setPlanId(planId);
        return this;
    }

    public DietPlan patient(Patient patient) {
        setPatient(patient);
        return this;
    }

    public DietPlan dietitian(Dietitian dietitian) {
        setDietitian(dietitian);
        return this;
    }

    public DietPlan dailyCalories(int dailyCalories) {
        setDailyCalories(dailyCalories);
        return this;
    }

    public DietPlan macronutrientDistribution(String macronutrientDistribution) {
        setMacronutrientDistribution(macronutrientDistribution);
        return this;
    }

    public DietPlan specificRecommendations(String specificRecommendations) {
        setSpecificRecommendations(specificRecommendations);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DietPlan)) {
            return false;
        }
        DietPlan dietPlan = (DietPlan) o;
        return planId == dietPlan.planId && Objects.equals(patient, dietPlan.patient) && Objects.equals(dietitian, dietPlan.dietitian) && dailyCalories == dietPlan.dailyCalories && Objects.equals(macronutrientDistribution, dietPlan.macronutrientDistribution) && Objects.equals(specificRecommendations, dietPlan.specificRecommendations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, patient, dietitian, dailyCalories, macronutrientDistribution, specificRecommendations);
    }

    @Override
    public String toString() {
        return "Diet Plan ID: " + planId +
                ", Patient: " + patient.getName() +
                ", Dietitian: " + dietitian.getName() +
                ", Daily Calories: " + dailyCalories +
                ", Macronutrient Distribution: " + macronutrientDistribution +
                ", Specific Recommendations: " + specificRecommendations;
    }
    
}
