package main.java.service;

import java.util.ArrayList;
import java.util.List;

import main.java.model.Meal;

public class MealService {
      private List<Meal> meals;

    public MealService() {
        this.meals = new ArrayList<>();
    }

    public void createMeal(Meal meal) {
        meals.add(meal);
    }

    public void updateMeal(String mealName, Meal updatedMeal) {
        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).getName().equals(mealName)) {
                meals.set(i, updatedMeal);
                break;
            }
        }
    }

    public void deleteMeal(String mealName) {
        List<Meal> meals = getAllMeals();
        meals.removeIf(meal -> meal.getName().equalsIgnoreCase(mealName));
        setMeals(meals);
    }
    public List<Meal> getAllMeals() {
        return new ArrayList<>(meals);
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
    
    public Meal getMealByName(String name) {
        for (Meal meal : meals) {
            if (meal.getName().equals(name)) {
                return meal;
            }
        }
        return null; // Retornar null si no se encuentra la Meal con el nombre dado
    }


}
