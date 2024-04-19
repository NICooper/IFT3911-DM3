public class PlaneSection extends Section {

	private float price;
	private int rows;
	private int columns;
	private PlaneSectionType sectionType;
	private Repartition repartition;

	public PlaneSection(float price, int rows, int columns, Repartition repartition,PlaneSectionType sectionType) {
		this.price = price;
		this.rows = rows;
		this.columns = columns;
		this.sectionType = sectionType;
		this.repartition = repartition;
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

}