package homeworks.hw1.scooter;

import java.util.ArrayList;
import java.util.List;

public class RentalCompany extends Scooter {
    List<Scooter> scooters = new ArrayList<>();

    // Method to get a list of available scooters
    public List<Scooter> availableScooters() {
        List<Scooter> result = new ArrayList<>();
        for (Scooter scooter : scooters) {
            if (scooter.isAvailable()) {
                result.add(scooter);
            }
        }
        return result;
    }

    // Method to add a scooter to the rental company
    public void addScooter(Scooter scooter) {
        scooter.setId(id++);
        scooters.add(scooter);
    }

    // Method to remove a scooter from the rental company by its ID
    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed;
    }

    // Method to rent a scooter by its ID
    public void rentScooter(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id && scooter.isAvailable()) {
                scooter.rent();
                System.out.println("Scooter '" + scooter.getModel() + "' with ID " + id + " has been rented.");
                break;
            } else {
                System.out.println("Scooter '" + scooter.getModel() + "' with ID " + id + " is not available.");
            }
        }
    }

    // Method for returning a rented scooter
    public void returnScooter(int id, double x, double y) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id && !scooter.isAvailable()) {
                scooter.setAvailable(true);
                scooter.setX(x);
                scooter.setY(y);
                System.out.println("Scooter '" + scooter.getModel() + "' with ID " + id + " has been returned at coordinates x:'" + x + "' and y:'" + y + "'.");
                break;
            }
        }
    }

    // Method to display information about all scooters in the company
    public void displayAllScooters() {
        for (Scooter scooter : scooters) {
            System.out.println(scooter.toString());
        }
    }
}