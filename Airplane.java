public class Airplane extends Vehicle {
    public Airplane(String vehicleId, String model, Company company) {
        super(vehicleId, model, company);
    }

    @Override
    public Vehicle copy() {
        return new Airplane(getVehicleId(), getModel(), getCompany());
    }
}