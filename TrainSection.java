public class TrainSection extends Section {

	private Vehicle vehicle;
	private TrainSectionType sectionType;
	private int rows;
	private Repartition repartition = Repartition.S;


	public TrainSection(Vehicle vehicle, TrainSectionType sectionType, int rows) {
		this.vehicle = vehicle;
		this.sectionType = sectionType;
		this.rows = rows;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public TrainSectionType getSectionType() {
		return this.sectionType;
	}


	/**
	 * @param sectionType
	 */
	public void setSectionType(TrainSectionType sectionType) {
		this.sectionType = sectionType;
	}

	public int getRows() {
		return this.rows;
	}

	/**
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	@Override
	public float getSectionPrice() {
		switch (sectionType) {
			case E:
				return (float) (0.5 * getVehicle().getCompany().getPrice());
			default:
				return (float) (0.60 * getVehicle().getCompany().getPrice());
		}
	}
}