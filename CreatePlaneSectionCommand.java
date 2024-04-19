public class CreatePlaneSectionCommand {

	private Vehicle vehicle;
	private Float pricePercentage;
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
	public PlaneSection createPlaneSection(Vehicle vehicle, Float pricePercentage, int rows, int columns, Repartition repartition, PlaneSectionType sectionType) {
		// TODO - implement CreatePlaneSectionCommand.createPlaneSection
		throw new UnsupportedOperationException();
	}

	public void undo() {
		// TODO - implement CreatePlaneSectionCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		// TODO - implement CreatePlaneSectionCommand.execute
		throw new UnsupportedOperationException();
	}

}