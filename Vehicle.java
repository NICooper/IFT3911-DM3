import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle implements ProtoMemento<Vehicle> {

	private String vehicleId;
	private String model;
	private Company company;

	protected List<Section> sections = new ArrayList<>();

	public Vehicle(String vehicleId, String model, Company company) {
		this.vehicleId = vehicleId;
		this.model = model;
		this.company = company;
	}

	public String getVehicleId() {
		return this.vehicleId;
	}

	/**
	 *
	 * @param vehicleId
	 */
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getModel() {
		return this.model;
	}

	/**
	 *
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	public Company getCompany() {
		return this.company;
	}

	/**
	 *
	 * @param company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void updateSectionUnitCount(SectionType sectionType, int sectionUnitCount) {
		if (sectionUnitCount < 1) {
			return;
		}
		var section = sections.stream().filter(s -> s.sectionType == sectionType).findFirst();
		section.ifPresent(value -> value.setSectionUnitCount(sectionUnitCount));
	}

	public Section getSection(SectionType sectionType) {
		var section = sections.stream().filter(s -> s.sectionType == sectionType).findFirst();
		return section.orElse(null);
	}

	public List<Seat> generateSeats(float price) {
		List<Seat> seats = new ArrayList<>();
		for (var section : sections) {
			seats.addAll(section.generateSeats(price));
		}
		return seats;
	}

	public abstract ProtoMemento<Vehicle> copy();

	public void restore(ProtoMemento<Vehicle> memento) {
		if (memento.getClass() == this.getClass()) {
			var vehicle = (Vehicle) memento;
			setVehicleId(vehicle.vehicleId);
			setModel(vehicle.model);
			setCompany(vehicle.company);
		}
	}
}