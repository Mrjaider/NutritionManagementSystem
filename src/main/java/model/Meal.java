package main.java.model;

import java.util.Objects;

public class Meal {
    private String name;
    private String macronutrients;
    private int calories;
    private String timeOfDay;

    public Meal() {
    }

    public Meal(String name, String macronutrients, int calories, String timeOfDay) {
        this.name = name;
        this.macronutrients = macronutrients;
        this.calories = calories;
        this.timeOfDay = timeOfDay;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacronutrients() {
        return this.macronutrients;
    }

    public void setMacronutrients(String macronutrients) {
        this.macronutrients = macronutrients;
    }

    public int getCalories() {
        return this.calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getTimeOfDay() {
        return this.timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public Meal name(String name) {
        setName(name);
        return this;
    }

    public Meal macronutrients(String macronutrients) {
        setMacronutrients(macronutrients);
        return this;
    }

    public Meal calories(int calories) {
        setCalories(calories);
        return this;
    }

    public Meal timeOfDay(String timeOfDay) {
        setTimeOfDay(timeOfDay);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Meal)) {
            return false;
        }
        Meal meal = (Meal) o;
        return Objects.equals(name, meal.name) && Objects.equals(macronutrients, meal.macronutrients)
                && calories == meal.calories && Objects.equals(timeOfDay, meal.timeOfDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, macronutrients, calories, timeOfDay);
    }

    @Override
    public String toString() {
        return "Meal Name: " + name +
                ", Macronutrients: " + macronutrients +
                ", Calories: " + calories +
                ", Time of Day: " + timeOfDay;
    }
}
