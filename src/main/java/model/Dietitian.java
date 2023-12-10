package main.java.model;
import java.util.Objects;

public class Dietitian {
    private int dietitianId;
    private String name;
    private String specialty;

    public Dietitian() {
    }

    public Dietitian(int dietitianId, String name, String specialty) {
        this.dietitianId = dietitianId;
        this.name = name;
        this.specialty = specialty;
    }

    public int getDietitianId() {
        return this.dietitianId;
    }

    public void setDietitianId(int dietitianId) {
        this.dietitianId = dietitianId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Dietitian dietitianId(int dietitianId) {
        setDietitianId(dietitianId);
        return this;
    }

    public Dietitian name(String name) {
        setName(name);
        return this;
    }

    public Dietitian specialty(String specialty) {
        setSpecialty(specialty);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Dietitian)) {
            return false;
        }
        Dietitian dietitian = (Dietitian) o;
        return dietitianId == dietitian.dietitianId && Objects.equals(name, dietitian.name) && Objects.equals(specialty, dietitian.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dietitianId, name, specialty);
    }

    @Override
    public String toString() {
        return "Dietitian ID: " + dietitianId +
                ", Name: " + name +
                ", Specialty: " + specialty;
    }

}
