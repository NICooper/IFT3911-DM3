import java.util.List;

public class Boat extends Vehicle {
    public Boat(String vehicleId, String model, Company company) {
        super(vehicleId, model, company);
        sections.add(new BoatSection(10, BoatSectionType.I));
        sections.add(new BoatSection(15, BoatSectionType.O));
        sections.add(new BoatSection(20, BoatSectionType.S));
        sections.add(new BoatSection(30, BoatSectionType.F));
        sections.add(new BoatSection(40, BoatSectionType.D));
    }

    @Override
    public Boat copy() {
        return new Boat(getVehicleId(), getModel(), getCompany());
    }
}