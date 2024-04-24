public class CreatePlaneSectionCommand implements Command{

	private final Airplane airplane;
	private final int rows;
	private final Repartition repartition;
	private final PlaneSectionType sectionType;

	/**
	 * 
	 * @param airplane
	 * @param rows
	 * @param repartition
	 * @param sectionType
	 */
	public CreatePlaneSectionCommand(Airplane airplane, int rows, Repartition repartition, PlaneSectionType sectionType) {
		this.airplane = airplane;
		this.rows = rows;
		this.repartition = repartition;
		this.sectionType = sectionType;
	}

	public boolean undo() {
		try {
			airplane.deleteSection(this.sectionType);
			return true;
		} catch (TooFewSectionsException e) {
			return false;
		}
	}

	public boolean execute() {
		try {
			airplane.addSection(this.sectionType, this.rows, this.repartition);
			return true;
		} catch (DuplicateSectionException | TooManySectionUnitsException e) {
			return false;
		}
	}

}