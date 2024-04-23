public class Train extends Vehicle {
    public Train(String vehicleId, String model, Company company) {
        super(vehicleId, model, company);
    }

    @Override
    public Vehicle copy() {
        return new Train(getVehicleId(), getModel(), getCompany());
    }
}