import java.util.ArrayList;

public abstract class Vehicle implements ProtoMemento<Vehicle> {

	private String vehicleId;
	private String model;
	private Company company;

	private ArrayList<Section> sections;
	
	public Vehicle(String vehicleId, String model, Company company) {
		this.vehicleId = vehicleId;
		this.model = model;
		this.company = company;
	}


	public ArrayList<Section> getSections() {
		return sections;
	}

	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
	}

	public void addSection(Section section){
		sections.add(section);
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

	public void createBoatSection(float pricePercentage, BoatSectionType sectionType, int cabinCount) {
		BoatSection b_section = new BoatSection(this, sectionType, cabinCount);
		addSection(b_section);
	}

	public void createPlaneSection(float pricePercentage, int rows, int columns, Repartition repartition, PlaneSectionType sectionType){
		PlaneSection p_section = new PlaneSection(this, rows, repartition, sectionType);
		addSection(p_section);
	}

	public void createTrainSection(float pricePercentage, TrainSectionType sectionType, int rows, int columns) {
		TrainSection t_section = new TrainSection(this, sectionType, rows);
		addSection(t_section);
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