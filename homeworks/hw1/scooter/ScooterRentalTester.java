package homeworks.hw1.scooter;

public class ScooterRentalTester {

    public static void main(String[] args) {
        RentalCompany company = new RentalCompany();

        // Create and add some scooters to the rental company
        Scooter scooter1 = new Scooter();
        scooter1.setModel("Sparrow X10");
        scooter1.setBatteryLevel(80);
        scooter1.setX(41.78671861495965); // Home coordinates
        scooter1.setY(44.82081508423444);
        scooter1.setAvailable(true); // Available initially
        company.addScooter(scooter1); // Add scooter after defining the properties

        Scooter scooter2 = new Scooter();
        scooter2.setModel("Zingo Z5");
        scooter2.setBatteryLevel(65);
        scooter2.setX(41.78671861495965); // Home coordinates
        scooter2.setY(44.82081508423444);
        scooter2.setAvailable(true); // Available initially
        company.addScooter(scooter2); // Add after defining all the properties

        company.displayAllScooters(); // Displays all scooters and info about them

        // Rent the scooter and go from home to the University
        company.rentScooter(scooter1.getId());
        scooter1.setX(41.7121106); // University coordinates
        scooter1.setY(44.7489232);

        // Leave the scooter at the University
        company.returnScooter(scooter1.getId(), 41.7121106, 44.7489232);

        // Wait for 1 hour
        // To test the program, feel free to lower the value inside the parentheses of Thread.sleep
        try {
            Thread.sleep(3600000); // Sleep for 1 hour (1 hour = 3600000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Rent the scooter again after 1 hour
        company.rentScooter(scooter1.getId());
        scooter1.setX(41.78671861495965); // Home coordinates
        scooter1.setY(44.82081508423444);

        // Leave the scooter near home
        company.returnScooter(scooter1.getId(), 41.78671861495965, 44.82081508423444);

        // Display all scooters
        company.displayAllScooters(); // Display the second time to demonstrate change in coordinates
    }
}