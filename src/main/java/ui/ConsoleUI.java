package main.java.ui;

import java.util.List;
import java.util.Scanner;

import main.java.model.DietPlan;
import main.java.model.Dietitian;
import main.java.model.Meal;
import main.java.model.Patient;
import main.java.persistence.DietPlanCSVHandler;
import main.java.persistence.DietitianCSVHandler;
import main.java.persistence.MealCSVHandler;
import main.java.persistence.PatientCSVHandler;
import main.java.service.DietPlanService;
import main.java.service.DietitianService;
import main.java.service.MealService;
import main.java.service.PatientService;

public class ConsoleUI {
    private static final PatientService patientService = new PatientService();
    private static final DietitianService dietitianService = new DietitianService();
    private static final DietPlanService dietPlanService = new DietPlanService();
    private static final MealService mealService = new MealService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Leer datos desde archivos CSV al inicio
        PatientCSVHandler.readPatients(patientService);
        DietitianCSVHandler.readDietitians(dietitianService);
        DietPlanCSVHandler.readDietPlans(dietPlanService, patientService, dietitianService);

        MealCSVHandler.readMeals(mealService);

        // Mostrar menú y realizar operaciones
        displayMenu();
        saveData();
    }

    static void displayMenu() {
        int choice;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Register Dietitian");
            System.out.println("3. Create Diet Plan");
            System.out.println("4. Create Meal");
            System.out.println("5. Display Patients");
            System.out.println("6. Display Dietitians");
            System.out.println("7. Display Diet Plans");
            System.out.println("8. Display Meals");
            System.out.println("9. Delete Patient");
            System.out.println("10. Delete Dietitian");
            System.out.println("11. Delete Diet Plan");
            System.out.println("12. Delete Meal");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    registerPatient();
                    saveData();
                    break;
                case 2:
                    registerDietitian();
                    saveData();
                    break;
                case 3:
                    createDietPlan();
                    saveData();
                    break;
                case 4:
                    createMeal();
                    saveData();
                    break;
                case 5:
                    displayPatients();
                    break;
                case 6:
                    displayDietitians();
                    break;
                case 7:
                    displayDietPlans();
                    break;
                case 8:
                    displayMeals();
                    break;
                case 9:
                    deletePatient();
                    saveData();
                    break;
                case 10:
                    deleteDietitian();
                    saveData();
                    break;
                case 11:
                    deleteDietPlan();
                    saveData();
                    break;
                case 12:
                    deleteMeal();
                    saveData();
                    break;
                case 13:

                    saveData();

                    System.out.println("Exiting...");
                    System.out.println("See you soon!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 13);
    }

    private static void registerPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter patient weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter patient height: ");
        double height = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter preexisting conditions: ");
        String preexistingConditions = scanner.nextLine();

        Patient newPatient = new Patient(patientService.getAllPatients().size() + 1, name, age, weight, height,
                preexistingConditions);
        patientService.registerPatient(newPatient);
        System.out.println("Patient registered successfully.");
    }

    private static void registerDietitian() {
        System.out.print("Enter dietitian name: ");
        String name = scanner.nextLine();
        System.out.print("Enter dietitian specialty: ");
        String specialty = scanner.nextLine();

        Dietitian newDietitian = new Dietitian(dietitianService.getAllDietitians().size() + 1, name, specialty);
        dietitianService.registerDietitian(newDietitian);
        System.out.println("Dietitian registered successfully.");
    }

    private static void createDietPlan() {
        // Display available patients
        List<Patient> patients = patientService.getAllPatients();
        System.out.println("Available Patients:");
        for (Patient patient : patients) {
            System.out.println(patient.getPatientId() + ". " + patient.getName());
        }

        // Select a patient
        System.out.print("Select a patient (Enter patient ID): ");
        int selectedPatientId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        Patient selectedPatient = null;
        for (Patient patient : patients) {
            if (patient.getPatientId() == selectedPatientId) {
                selectedPatient = patient;
                break;
            }
        }

        // Display available dietitians
        List<Dietitian> dietitians = dietitianService.getAllDietitians();
        System.out.println("Available Dietitians:");
        for (Dietitian dietitian : dietitians) {
            System.out.println(dietitian.getDietitianId() + ". " + dietitian.getName());
        }

        // Select a dietitian
        System.out.print("Select a dietitian (Enter dietitian ID): ");
        int selectedDietitianId = scanner.nextInt();
        scanner.nextLine();
        Dietitian selectedDietitian = null;
        for (Dietitian dietitian : dietitians) {
            if (dietitian.getDietitianId() == selectedDietitianId) {
                selectedDietitian = dietitian;
                break;
            }
        }

        // Get diet plan details
        System.out.print("Enter daily calories: ");
        int dailyCalories = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter macronutrient distribution: ");
        String macronutrientDistribution = scanner.nextLine();
        System.out.print("Enter specific recommendations: ");
        String specificRecommendations = scanner.nextLine();

        // Create and register the diet plan
        DietPlan newDietPlan = new DietPlan(
                dietPlanService.getAllDietPlans().size() + 1,
                selectedPatient,
                selectedDietitian,
                dailyCalories,
                macronutrientDistribution,
                specificRecommendations);
        dietPlanService.createDietPlan(newDietPlan);
        System.out.println("Diet Plan created successfully.");
    }

    private static void createMeal() {
        System.out.print("Enter meal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter macronutrients: ");
        String macronutrients = scanner.nextLine();
        System.out.print("Enter calories: ");
        int calories = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter time of day: ");
        String timeOfDay = scanner.nextLine();

        Meal newMeal = new Meal(name, macronutrients, calories, timeOfDay);
        mealService.createMeal(newMeal);
        System.out.println("Meal created successfully.");
    }

    private static void displayPatients() {
        List<Patient> patients = patientService.getAllPatients();
        System.out.println("=== Patients ===");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void displayDietitians() {
        List<Dietitian> dietitians = dietitianService.getAllDietitians();
        System.out.println("=== Dietitians ===");
        for (Dietitian dietitian : dietitians) {
            System.out.println(dietitian);
        }
    }

    private static void displayDietPlans() {
        List<DietPlan> dietPlans = dietPlanService.getAllDietPlans();
        System.out.println("=== Diet Plans ===");
        for (DietPlan dietPlan : dietPlans) {
            System.out.println(dietPlan);
        }
    }

    private static void displayMeals() {
        List<Meal> meals = mealService.getAllMeals();
        System.out.println("=== Meals ===");
        for (Meal meal : meals) {
            System.out.println(meal);
        }
    }

    public static void saveData() {
        PatientCSVHandler.writePatients(patientService.getAllPatients());
        DietitianCSVHandler.writeDietitians(dietitianService.getAllDietitians());
        DietPlanCSVHandler.writeDietPlans(dietPlanService.getAllDietPlans());
        MealCSVHandler.writeMeals(mealService.getAllMeals());
        System.out.println("Data saved successfully.");
    }

    private static void deletePatient() {
        System.out.print("Enter patient ID to delete: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        patientService.deletePatient(patientId);
        System.out.println("Patient deleted successfully.");
    }

    private static void deleteDietitian() {
        System.out.print("Enter dietitian ID to delete: ");
        int dietitianId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        dietitianService.deleteDietitian(dietitianId);
        System.out.println("Dietitian deleted successfully.");
    }

    private static void deleteDietPlan() {
        System.out.print("Enter diet plan ID to delete: ");
        int dietPlanId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        dietPlanService.deleteDietPlan(dietPlanId);
        System.out.println("Diet Plan deleted successfully.");
    }

    private static void deleteMeal() {
        System.out.print("Enter meal name to delete: ");
        String mealName = scanner.nextLine();
        mealService.deleteMeal(mealName);
        System.out.println("Meal deleted successfully.");
    }

}
