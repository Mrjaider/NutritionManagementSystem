package main.java.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import main.java.model.DietPlan;
import main.java.model.Dietitian;
import main.java.model.Patient;
import main.java.service.DietPlanService;
import main.java.service.DietitianService;
import main.java.service.PatientService;

public class DietPlanCSVHandler {
    private static final String DIET_PLANS_CSV_FILE = "src/resources/dietplans.csv";

    public static void writeDietPlans(List<DietPlan> dietPlans) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DIET_PLANS_CSV_FILE))) {
            for (DietPlan dietPlan : dietPlans) {
                writer.println(dietPlan.getPlanId() + "," + dietPlan.getPatient().getPatientId()
                        + "," + dietPlan.getDietitian().getDietitianId() + "," + dietPlan.getDailyCalories()
                        + "," + dietPlan.getMacronutrientDistribution() + "," + dietPlan.getSpecificRecommendations());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readDietPlans(DietPlanService dietPlanService,
            PatientService patientService,
            DietitianService dietitianService) {
        List<DietPlan> dietPlans = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DIET_PLANS_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int planId = Integer.parseInt(data[0]);
                int patientId = Integer.parseInt(data[1]);
                int dietitianId = Integer.parseInt(data[2]);
                int dailyCalories = Integer.parseInt(data[3]);
                String macronutrientDistribution = data[4];
                String specificRecommendations = data[5];

                Patient patient = patientService.getPatientById(patientId);
                Dietitian dietitian = dietitianService.getDietitianById(dietitianId);

                DietPlan dietPlan = new DietPlan(planId, patient, dietitian, dailyCalories, macronutrientDistribution,
                        specificRecommendations);
                dietPlans.add(dietPlan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        dietPlanService.setDietPlans(dietPlans);
    }
}
