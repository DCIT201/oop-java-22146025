public class Truck extends Vehicle implements Rentable {
    private double loadCapacity;

    public Truck(String vehicleId, String model, double baseRentalRate, double loadCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days + loadCapacity * 0.1; // Additional cost based on load capacity
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            // Additional rental logic
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        // Additional return logic
    }
}
