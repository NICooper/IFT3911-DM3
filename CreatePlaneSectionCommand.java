public class CreatePlaneSectionCommand {

	private Vehicle vehicle;
	private float pricePercentage;
	private int rows;
	private int columns;
	private Repartition repartition;
	private PlaneSectionType sectionType;

	/**
	 * 
	 * @param vehicle
	 * @param pricePercentage
	 * @param rows
	 * @param columns
	 * @param repartition
	 * @param sectionType
	 */
	public CreatePlaneSectionCommand(Vehicle vehicle, float pricePercentage, int rows, int columns, Repartition repartition, PlaneSectionType sectionType) {
		this.vehicle = vehicle;
		this.pricePercentage = pricePercentage;
		this.rows = rows;
		this.columns = columns;
		this.repartition = repartition;
		this.sectionType = sectionType;
	}

	public void undo() {
		// TODO - implement CreatePlaneSectionCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		vehicle.createPlaneSection(this.pricePercentage, this.rows, this.columns, this.repartition, this.sectionType);
	}

}