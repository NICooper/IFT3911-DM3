public class CreateTrainSectionCommand {

	private Vehicle vehicle;
	private float pricePercentage;
	private TrainSectionType sectionType;
	private int rows;
	private int columns;


	public CreateTrainSectionCommand(Vehicle vehicle, float pricePercentage, TrainSectionType sectionType, int rows, int columns) {
		this.vehicle = vehicle;
		this.pricePercentage = pricePercentage;
		this.sectionType = sectionType;
		this.rows = rows;
		this.columns = columns;
	}

	public boolean undo() {
		// TODO - implement CreateTrainSectionCommand.undo
		throw new UnsupportedOperationException();
	}

	public boolean execute() {
		vehicle.createTrainSection(this.pricePercentage, this.sectionType, this.rows, this.columns);
		return true;
	}

}