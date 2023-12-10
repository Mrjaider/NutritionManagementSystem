package main.java.service;

import java.util.ArrayList;
import java.util.List;

import main.java.model.DietPlan;

public class DietPlanService {
    private List<DietPlan> dietPlans;

    public DietPlanService() {
        this.dietPlans = new ArrayList<>();
    }

    public void createDietPlan(DietPlan dietPlan) {
        dietPlans.add(dietPlan);
    }

    public void adjustDietPlan(int planId, DietPlan adjustedDietPlan) {
        for (int i = 0; i < dietPlans.size(); i++) {
            if (dietPlans.get(i).getPlanId() == planId) {
                dietPlans.set(i, adjustedDietPlan);
                break;
            }
        }
    }

    public void deleteDietPlan(int dietPlanId) {
        List<DietPlan> dietPlans = getAllDietPlans();
        dietPlans.removeIf(dietPlan -> dietPlan.getPlanId() == dietPlanId);
        setDietPlans(dietPlans);
    }

    public List<DietPlan> getAllDietPlans() {
        return new ArrayList<>(dietPlans);
    }
   
    public void setDietPlans(List<DietPlan> dietPlans) {
        this.dietPlans = dietPlans;
    }
    
    public DietPlan getDietPlanById(int planId) {
        // Implementar la búsqueda de un DietPlan por su ID
        // ...
        return null;
    }
}
