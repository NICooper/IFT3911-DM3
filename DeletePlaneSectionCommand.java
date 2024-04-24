public class DeletePlaneSectionCommand implements Command {

	private final Airplane airplane;
	private final PlaneSectionType sectionType;
	private final PlaneSection section;

	public DeletePlaneSectionCommand(Airplane airplane, PlaneSectionType planeSectionType) {
		this.sectionType = planeSectionType;
		this.airplane = airplane;
		section = (PlaneSection) airplane.getSection(sectionType);
	}

	public boolean undo() {
		try {
			airplane.addSection((PlaneSectionType) section.sectionType, section.getSectionUnitCount(), section.getRepartition());
			return true;
		} catch (DuplicateSectionException | TooManySectionUnitsException e) {
			return false;
		}
	}

	public boolean execute() {
		try {
			airplane.deleteSection(sectionType);
			return true;
		} catch (TooFewSectionsException e) {
			return false;
		}

	}

}