import java.util.ArrayList;

public abstract class Vehicle {

	private String vehicleId;
	private String model;
	private Company company;

	private ArrayList<Section> sections;


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

	public void createBoatSection(Float pricePercentage, BoatSectionType sectionType, int cabinNumber) {
		BoatSection b_section = new BoatSection(this, pricePercentage, sectionType, cabinNumber);
		addSection(b_section);
	}

	public void createPlaneSection(Float pricePercentage, int rows, int columns, Repartition repartition, PlaneSectionType sectionType){
		PlaneSection p_section = new PlaneSection(this, pricePercentage, rows, columns, repartition, sectionType);
		addSection(p_section);
	}

	public void createTrainSection(Float pricePercentage, TrainSectionType sectionType, int rows, int columns) {
		TrainSection t_section = new TrainSection(this, pricePercentage, sectionType, rows, columns);
		addSection(t_section);
	}
}