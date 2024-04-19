public class PlaneSection extends Section {

	private int rows;
	private int columns;
	private PlaneSectionType sectionType;
	private Repartitions repartition;

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

	public Repartitions getRepartition() {
		return this.repartition;
	}

	/**
	 * 
	 * @param repartition
	 */
	public void setRepartition(Repartitions repartition) {
		this.repartition = repartition;
	}

}