public class Train extends Vehicle {
    public Train(String vehicleId, String model, Company company) {
        super(vehicleId, model, company);
        sections.add(new TrainSection(1, TrainSectionType.P));
        sections.add(new TrainSection(1, TrainSectionType.E));
    }

    @Override
    public Train copy() {
        return new Train(getVehicleId(), getModel(), getCompany());
    }
}