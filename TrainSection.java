public class TrainSection extends Section {

	private Vehicle vehicle;
	private float pricePercentage;
	private TrainSectionType sectionType;
	private int rows;
	private int columns;


	public TrainSection(Vehicle vehicle, float pricePercentage, TrainSectionType sectionType, int rows, int columns) {
		this.vehicle = vehicle;
		this.pricePercentage = pricePercentage;
		this.sectionType = sectionType;
		this.rows = rows;
		this.columns = columns;
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

	public int getColumns() {
		return this.columns;
	}

	/**
	 * @param columns
	 */
	public void setColumns(int columns) {
		this.columns = columns;
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