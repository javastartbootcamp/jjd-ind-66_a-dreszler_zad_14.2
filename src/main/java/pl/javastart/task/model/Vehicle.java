package pl.javastart.task.model;

import java.io.Serializable;

public class Vehicle implements Serializable {
    private String type;
    private String brand;
    private String model;
    private int yearOfProduction;
    private int mileage;
    private String vin;

    public Vehicle(String type, String brand, String model, int yearOfProduction, int mileage, String vin) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.mileage = mileage;
        this.vin = vin;
    }

    @Override
    public String toString() {
        return type + " " + brand + " " + model + " " + yearOfProduction + " Przebieg: " + mileage + " VIN: " + vin;
    }
}
