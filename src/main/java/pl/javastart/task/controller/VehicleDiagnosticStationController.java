package pl.javastart.task.controller;

import pl.javastart.task.io.DataReader;
import pl.javastart.task.io.FileUtils;
import pl.javastart.task.model.Vehicle;
import pl.javastart.task.model.VehicleDiagnosticStation;

public class VehicleDiagnosticStationController {
    private static final int NO_CHOICE = -1;
    private static final int ADD_VEHICLE = 1;
    private static final int DIAGNOSE_VEHICLE = 2;
    private static final int CLOSE = 0;
    private static final String QUEUE_FILENAME = "vehicleQueue.obj";
    private VehicleDiagnosticStation vehicleDiagnosticStation;

    public VehicleDiagnosticStationController(VehicleDiagnosticStation vehicleDiagnosticStation) {
        this.vehicleDiagnosticStation = vehicleDiagnosticStation;
    }

    public void controlLoop() {
        int option = NO_CHOICE;
        while (option != CLOSE) {
            printAvailableOptions();
            option = DataReader.readOption();
            executeOption(option);
        }
    }

    private void executeOption(int option) {
        switch (option) {
            case ADD_VEHICLE -> addVehicleToQueue();
            case DIAGNOSE_VEHICLE -> diagnoseVehicle();
            case CLOSE -> {
                if (!vehicleDiagnosticStation.isQueueEmpty()) {
                    FileUtils.saveQueueToFile(vehicleDiagnosticStation.getVehicles(), QUEUE_FILENAME);
                }
            }
            default -> System.out.println("Nieznana opcja. Spróbuj ponownie.");
        }
    }

    private void printAvailableOptions() {
        System.out.println("Dostępne opcje:");
        System.out.println(" > " + ADD_VEHICLE + " - dodaj samochód do kolejki przeglądów");
        System.out.println(" > " + DIAGNOSE_VEHICLE + " - rozpocznij przegląd pierwszego samochodu z kolejki");
        System.out.println(" > " + CLOSE + " - wyjście");
    }

    private void addVehicleToQueue() {
        String type = DataReader.readString("typ pojazdu");
        String brand = DataReader.readString("markę pojazdu");
        String model = DataReader.readString("model pojazdu");
        int yearOfProduction = DataReader.readYearOfProduction();
        int mileage = DataReader.readMileage();
        String vin = DataReader.readString("numer VIN");
        vehicleDiagnosticStation.addVehicleToQueue(type, brand, model, yearOfProduction, mileage, vin);
        System.out.println("Pojazd dodany do kolejki");
    }

    private void diagnoseVehicle() {
        Vehicle vehicle = vehicleDiagnosticStation.diagnoseVehicle();
        if (vehicle != null) {
            System.out.println("Pojazd " + vehicle + " oddany do diagnozy");
        } else {
            System.out.println("Brak pojazdów w kolejce");
        }
    }
}
