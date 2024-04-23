public class Boat extends Vehicle {
    public Boat(String vehicleId, String model, Company company) {
        super(vehicleId, model, company);
    }

    @Override
    public Vehicle copy() {
        return new Boat(getVehicleId(), getModel(), getCompany());
    }
}