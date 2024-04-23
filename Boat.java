import java.util.List;

public class Boat extends Vehicle {
    public Boat(String vehicleId, String model, Company company) {
        super(vehicleId, model, company);
        sections.add(new BoatSection(1, BoatSectionType.I));
        sections.add(new BoatSection(1, BoatSectionType.O));
        sections.add(new BoatSection(1, BoatSectionType.S));
        sections.add(new BoatSection(1, BoatSectionType.F));
        sections.add(new BoatSection(1, BoatSectionType.D));
    }

    @Override
    public Boat copy() {
        return new Boat(getVehicleId(), getModel(), getCompany());
    }
}