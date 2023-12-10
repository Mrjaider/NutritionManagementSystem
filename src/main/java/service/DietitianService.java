package main.java.service;

import java.util.ArrayList;
import java.util.List;
import main.java.model.Dietitian; // Add the missing import statement for the Dietitian class

public class DietitianService {
    private List<Dietitian> dietitians;

    public DietitianService() {
        this.dietitians = new ArrayList<>();
    }

    public void registerDietitian(Dietitian dietitian) {
        dietitians.add(dietitian);
    }

    public void updateDietitian(int dietitianId, Dietitian updatedDietitian) {
        for (int i = 0; i < dietitians.size(); i++) {
            if (dietitians.get(i).getDietitianId() == dietitianId) {
                dietitians.set(i, updatedDietitian);
                break;
            }
        }
    }

    public void deleteDietitian(int dietitianId) {
        List<Dietitian> dietitians = getAllDietitians();
        dietitians.removeIf(dietitian -> dietitian.getDietitianId() == dietitianId);
        setDietitians(dietitians);
    }

    public List<Dietitian> getAllDietitians() {
        return new ArrayList<>(dietitians);
    }

    public void setDietitians(List<Dietitian> dietitians) {
        this.dietitians = dietitians;
    }

    public Dietitian getDietitianById(int dietitianId) {
        for (Dietitian dietitian : dietitians) {
            if (dietitian.getDietitianId() == dietitianId) {
                return dietitian;
            }
        }
        return null; // Retornar null si no se encuentra el dietista con el ID dado
    }
}