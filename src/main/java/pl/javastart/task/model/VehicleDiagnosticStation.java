package pl.javastart.task.model;

import java.util.LinkedList;
import java.util.Queue;

public class VehicleDiagnosticStation {
    private Queue<Vehicle> vehicles;

    public VehicleDiagnosticStation(Queue<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleDiagnosticStation() {
        this.vehicles = new LinkedList<>();
    }

    public void addVehicleToQueue(String type, String brand, String model, int yearOfProduction, int mileage, String vin) {
        Vehicle vehicle = new Vehicle(type, brand, model, yearOfProduction, mileage, vin);
        vehicles.offer(vehicle);
    }

    public Vehicle diagnoseVehicle() {
        Vehicle vehicle = null;
        if (!vehicles.isEmpty()) {
            vehicle = vehicles.poll();
        }

        return vehicle;
    }

    public boolean isQueueEmpty() {
        return vehicles.isEmpty();
    }

    public Queue<Vehicle> getVehicles() {
        return vehicles;
    }
}
