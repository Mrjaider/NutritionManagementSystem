package main.java.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Meal;
import main.java.service.MealService;

public class MealCSVHandler {
    private static final String MEALS_CSV_FILE = "src/resources/meals.csv";

    public static void writeMeals(List<Meal> meals) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(MEALS_CSV_FILE))) {
            for (Meal meal : meals) {
                writer.println(meal.getName() + "," + meal.getMacronutrients() + "," + meal.getCalories()
                        + "," + meal.getTimeOfDay());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readMeals(MealService mealService) {
        List<Meal> meals = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(MEALS_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String macronutrients = data[1];
                int calories = Integer.parseInt(data[2]);
                String timeOfDay = data[3];

                Meal meal = new Meal(name, macronutrients, calories, timeOfDay);
                meals.add(meal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        mealService.setMeals(meals);
    }
}
