package main.java.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Dietitian;
import main.java.service.DietitianService;

public class DietitianCSVHandler {
    private static final String DIETITIANS_CSV_FILE = "src/resources/dietitians.csv";

    public static void writeDietitians(List<Dietitian> dietitians) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DIETITIANS_CSV_FILE))) {
            for (Dietitian dietitian : dietitians) {
                writer.println(
                        dietitian.getDietitianId() + "," + dietitian.getName() + "," + dietitian.getSpecialty());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readDietitians(DietitianService dietitianService) {
        List<Dietitian> dietitians = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DIETITIANS_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int dietitianId = Integer.parseInt(data[0]);
                String name = data[1];
                String specialty = data[2];

                Dietitian dietitian = new Dietitian(dietitianId, name, specialty);
                dietitians.add(dietitian);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Actualizar el servicio con la lista de dietitians leída desde el archivo CSV
        dietitianService.setDietitians(dietitians);
    }
}
