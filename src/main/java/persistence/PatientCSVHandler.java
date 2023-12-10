package main.java.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Patient;
import main.java.service.PatientService;

public class PatientCSVHandler {
    private static final String PATIENTS_CSV_FILE = "src/resources/patients.csv";

    public static void writePatients(List<Patient> patients) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PATIENTS_CSV_FILE))) {
            for (Patient patient : patients) {
                writer.println(patient.getPatientId() + "," + patient.getName() + "," + patient.getAge()
                        + "," + patient.getWeight() + "," + patient.getHeight() + ","
                        + patient.getPreexistingConditions());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer pacientes desde el archivo CSV y actualizar el servicio
    public static void readPatients(PatientService patientService) {
        List<Patient> patients = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int patientId = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                double weight = Double.parseDouble(data[3]);
                double height = Double.parseDouble(data[4]);
                String preexistingConditions = data[5];

                Patient patient = new Patient(patientId, name, age, weight, height, preexistingConditions);
                patients.add(patient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Actualizar el servicio con la lista de pacientes leída desde el archivo CSV
        patientService.setPatients(patients);
    }

}
