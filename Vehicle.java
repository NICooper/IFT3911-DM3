public abstract class Vehicle {

	private String vehicleId;
	private String model;
	private Company company;

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

}