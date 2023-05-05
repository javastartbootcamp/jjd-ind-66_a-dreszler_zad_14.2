package pl.javastart.task.app;

import pl.javastart.task.controller.VehicleDiagnosticStationController;
import pl.javastart.task.io.FileUtils;
import pl.javastart.task.model.Vehicle;
import pl.javastart.task.model.VehicleDiagnosticStation;

import java.util.Queue;

public class VehicleDiagnosticStationApp {

    public static void main(String[] args) {
        String queueFileName = "vehicleQueue.obj";

        VehicleDiagnosticStation vehicleDiagnosticStation;
        boolean lastSessionQueueExists = FileUtils.checkIfLastSessionQueueExists(queueFileName);

        if (lastSessionQueueExists) {
            Queue<Vehicle> vehicleQueueFromLastSession = FileUtils.readQueueFromFile(queueFileName);
            FileUtils.deleteQueueFile(queueFileName);
            vehicleDiagnosticStation = new VehicleDiagnosticStation(vehicleQueueFromLastSession);
        } else {
            vehicleDiagnosticStation = new VehicleDiagnosticStation();
        }
        VehicleDiagnosticStationController controller = new VehicleDiagnosticStationController(vehicleDiagnosticStation);
        controller.controlLoop();
    }
}