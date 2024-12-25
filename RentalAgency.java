import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> fleet;

    public RentalAgency() {
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public List<Vehicle> getFleet() {
        return fleet;
    }

    public Vehicle findAvailableVehicle(String model) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getModel().equals(model) && vehicle.isAvailableForRental()) {
                return vehicle;
            }
        }
        return null;
    }

    public void processRental(Customer customer, String model, int days) {
        Vehicle vehicle = findAvailableVehicle(model);
        if (vehicle != null) {
            vehicle.rent(customer, days);
            customer.addRental(vehicle);
            double rentalCost = vehicle.calculateRentalCost(days);
            System.out.println("Rented " + model + " to " + customer.getName() + " for " + days + " days. Total cost: $" + rentalCost);
        } else {
            System.out.println("No available " + model + " for rental.");
        }
    }

    public void generateReport() {
        System.out.println("Rental Agency Report:");
        for (Vehicle vehicle : fleet) {
            System.out.println("Vehicle ID: " + vehicle.getVehicleId() + ", Model: " + vehicle.getModel() + ", Available: " + vehicle.isAvailable());
        }
    }
}
