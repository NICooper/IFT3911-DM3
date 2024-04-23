public class CreateBoatSectionCommand implements Command {

	private Vehicle vehicle;
	private float pricePercentage;
	private BoatSectionType sectionType;
	private int cabinNumber;

	/**
	 *
	 * @param vehicle ..
	 * @param pricePercentage ..
	 * @param sectionType ..
	 * @param cabinNumber ..
	 */
	CreateBoatSectionCommand(Vehicle vehicle, float pricePercentage, BoatSectionType sectionType, int cabinNumber) {
		this.vehicle = vehicle;
		this.pricePercentage = pricePercentage;
		this.sectionType = sectionType;
		this.cabinNumber = cabinNumber;
	}

	@Override
	public boolean undo() {
	 	return true;
	}

	@Override
	public boolean execute() {
//		vehicle.createBoatSection(this.pricePercentage, this.sectionType, this.cabinNumber);
		return true;
	}
}