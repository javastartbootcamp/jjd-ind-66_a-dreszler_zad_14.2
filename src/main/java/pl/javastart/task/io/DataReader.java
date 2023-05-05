package pl.javastart.task.io;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final int INVALID_INPUT = -1;
    private static final int MAX_YEAR = LocalDate.now().getYear();
    private static final int MIN_YEAR = 1900;
    private static final int NO_CHOICE = -1;

    public static int readYearOfProduction() {
        int yearOfProduction = INVALID_INPUT;
        boolean yearValid = false;
        while (!yearValid) {
            System.out.println("Podaj rok produkcji:");
            try {
                yearOfProduction = INPUT.nextInt();
                if (yearOfProduction <= MAX_YEAR && yearOfProduction >= MIN_YEAR) {
                    yearValid = true;
                } else {
                    System.out.println("Podano zły rok. Rok musi zawierać się między " + MIN_YEAR + " a " + MAX_YEAR +
                            ". Spróbuj ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("W roku produkcji znalazło się coś innego niż liczba. Spróbuj ponownie.");
            }
            INPUT.nextLine();
        }

        return yearOfProduction;
    }

    public static int readMileage() {
        int mileage = INVALID_INPUT;
        boolean mileageValid = false;
        while (!mileageValid) {
            System.out.println("Podaj przebieg pojazdu:");
            try {
                mileage = INPUT.nextInt();
                if (mileage >= 0) {
                    mileageValid = true;
                } else {
                    System.out.println("Przebieg nie może być liczbą ujemną. Spróbuj ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("W przebiegu znalazło się coś innego niż liczba. Spróbuj ponownie.");
            }
            INPUT.nextLine();
        }

        return mileage;
    }

    public static String readString(String fieldToRead) {
        System.out.println("Podaj " + fieldToRead + ":");
        String text = INPUT.nextLine();
        return text;
    }

    public static int readOption() {
        System.out.println("Wybierz opcję:");
        int option = NO_CHOICE;
        try {
            option = INPUT.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono złą opcję");
        }
        INPUT.nextLine();
        return option;
    }
}
