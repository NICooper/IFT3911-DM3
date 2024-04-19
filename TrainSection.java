public class TrainSection extends Section {

	private float pricePercentage;
	private TrainSectionType sectionType;
	private int rows;
	private int columns;


	public TrainSection(float pricePercentage, TrainSectionType sectionType, int rows, int columns) {
		this.pricePercentage = pricePercentage;
		this.sectionType = sectionType;
		this.rows = rows;
		this.columns = columns;
	}

	public TrainSectionType getSectionType() {
		return this.sectionType;
	}

	/**
	 * 
	 * @param sectionType
	 */
	public void setSectionType(TrainSectionType sectionType) {
		this.sectionType = sectionType;
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

}