import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalAgency agency = new RentalAgency();

        Car car = new Car("C001", "Toyota", 50, true);
        Motorcycle motorcycle = new Motorcycle("M001", "Yamaha", 30, true);
        Truck truck = new Truck("T001", "Ford", 100, 500);

        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);

        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerId, customerName);

        boolean continueRenting = true;
        while (continueRenting) {
            System.out.println("Available vehicles:");
            for (Vehicle vehicle : agency.getFleet()) {
                System.out.println(vehicle.getModel() + " (ID: " + vehicle.getVehicleId() + ")");
            }

            System.out.print("Enter vehicle model to rent (or 'exit' to quit): ");
            String model = scanner.nextLine();
            if (model.equalsIgnoreCase("exit")) {
                continueRenting = false;
                break;
            }

            System.out.print("Enter rental days: ");
            int days = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            agency.processRental(customer, model, days);
        }

        System.out.println("Generating report...");
        agency.generateReport();

        System.out.println("Rental history for customer " + customer.getName() + ":");
        for (Vehicle vehicle : customer.getRentalHistory()) {
            System.out.println("Rented vehicle: " + vehicle.getModel());
        }

        scanner.close();
    }
}
