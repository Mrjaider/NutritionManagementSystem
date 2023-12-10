package main.java.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import main.java.model.Patient;

public class PatientService {
    private List<Patient> patients;

    public PatientService() {
        this.patients = new ArrayList<>();
    }

    public void registerPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void updatePatient(int patientId, Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientId() == patientId) {
                updatedPatient.setPatientId(patientId);
                patients.set(i, updatedPatient);
                break;
            }
        }
    }

    public void deletePatient(int patientId) {
        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPatientId() == patientId) {
                iterator.remove();
                break;
            }
        }
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Patient getPatientById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        throw new NoSuchElementException("Patient not found with ID: " + patientId);
    }
}