public class CreateBoatSectionCommand implements Command{

	private Vehicle vehicle;
	private Float pricePercentage;
	private BoatSectionType sectionType;
	private int cabinNumber;

	/**
	 *
	 * @param vehicle ..
	 * @param pricePercentage ..
	 * @param sectionType ..
	 * @param cabinNumber ..
	 */
	CreateBoatSectionCommand(Vehicle vehicle, Float pricePercentage, BoatSectionType sectionType, int cabinNumber) {
		this.vehicle = vehicle;
		this.pricePercentage = pricePercentage;
		this.sectionType = sectionType;
		this.cabinNumber = cabinNumber;
	}

	@Override
	public void execute() {
		vehicle.createBoatSection(this.pricePercentage, this.sectionType, this.cabinNumber);
	}

	@Override
	public void undo() {

	}
}