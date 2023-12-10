package main.java.model;

import java.util.Objects;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private double weight;
    private double height;
    private String preexistingConditions;

    public Patient(int patientId, String name, int age, double weight, double height, String preexistingConditions) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.preexistingConditions = preexistingConditions;
    }

    public Patient() {
    }

    public int getPatientId() {
        return this.patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getPreexistingConditions() {
        return this.preexistingConditions;
    }

    public void setPreexistingConditions(String preexistingConditions) {
        this.preexistingConditions = preexistingConditions;
    }

    public Patient patientId(int patientId) {
        setPatientId(patientId);
        return this;
    }

    public Patient name(String name) {
        setName(name);
        return this;
    }

    public Patient age(int age) {
        setAge(age);
        return this;
    }

    public Patient weight(double weight) {
        setWeight(weight);
        return this;
    }

    public Patient height(double height) {
        setHeight(height);
        return this;
    }

    public Patient preexistingConditions(String preexistingConditions) {
        setPreexistingConditions(preexistingConditions);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Patient)) {
            return false;
        }
        Patient patient = (Patient) o;
        return patientId == patient.patientId && Objects.equals(name, patient.name) && age == patient.age
                && weight == patient.weight && height == patient.height
                && Objects.equals(preexistingConditions, patient.preexistingConditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, name, age, weight, height, preexistingConditions);
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                ", Name: " + name + '\'' +
                ", Age: " + age + " years old" + // Agregar la unidad de medida
                ", Weight: " + weight + " kg" + // Agregar la unidad de medida
                ", Height: " + height + " cm" + // Agregar la unidad de medida
                ", Preexisting Conditions: " + preexistingConditions;
    }

}
