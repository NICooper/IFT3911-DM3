public class PlaneSection extends Section {

	private Vehicle vehicle;
	private float price;
	private int rows;
	private int columns;
	private PlaneSectionType sectionType;
	private Repartition repartition;

	public PlaneSection(Vehicle vehicle, float price, int rows, int columns, Repartition repartition,PlaneSectionType sectionType) {
		this.vehicle = vehicle;
		this.price = price;
		this.rows = rows;
		this.columns = columns;
		this.sectionType = sectionType;
		this.repartition = repartition;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getRows() {
		return this.rows;
	}

	/**
	 * 
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return this.columns;
	}

	/**
	 * 
	 * @param columns
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * 
	 * @param sectionType
	 */
	public void setSectionType(PlaneSectionType sectionType) {
		this.sectionType = sectionType;
	}

	public Repartition getRepartition() {
		return this.repartition;
	}

	/**
	 * 
	 * @param repartition
	 */
	public void setRepartition(Repartition repartition) {
		this.repartition = repartition;
	}

	@Override
	public float getSectionPrice() {
		switch (sectionType){
			case A :
				return (float) (0.75 * getVehicle().getCompany().getPrice());
			case P :
				return (float) (0.60 * getVehicle().getCompany().getPrice());
			case E :
				return (float) (0.50 * getVehicle().getCompany().getPrice());
			default :
				return getVehicle().getCompany().getPrice();

		}
	}
}