package pl.javastart.task.io;

import pl.javastart.task.model.Vehicle;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class FileUtils {
    public static void saveQueueToFile(Queue<Vehicle> vehicleQueue, String fileName) {
        try (
                var writer = new ObjectOutputStream(new FileOutputStream(fileName))
        ) {
            writer.writeObject(vehicleQueue);
        } catch (IOException e) {
            System.out.println("Nie udało się zapisać pliku " + fileName);
        }
    }

    public static Queue<Vehicle> readQueueFromFile(String fileName) {
        Queue<Vehicle> vehicles = null;
        try (
                var reader = new ObjectInputStream(new FileInputStream(fileName))
        ) {
            vehicles = (LinkedList<Vehicle>) reader.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Nie udało się wczytać pliku " + fileName);
        }

        if (vehicles != null) {
            System.out.println("Wczytano kolejkę pojazdów z poprzedniej sesji.");
        }

        return vehicles;
    }

    public static void deleteQueueFile(String fileName) {
        File queue = new File(fileName);
        queue.delete();
    }

    public static boolean checkIfLastSessionQueueExists(String fileName) {
        File queue = new File(fileName);
        return queue.exists();
    }
}