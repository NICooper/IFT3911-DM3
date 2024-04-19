public class CreateVehicleCommand implements Command {

	private TravelFactory travelFactory;
	private String id;
	private String model;

	/**
	 * 
	 * @param travelFactory
	 * @param id
	 * @param model
	 */
	public Vehicle createVehicle(TravelFactory travelFactory, String id, String model) {
		// TODO - implement CreateVehicleCommand.createVehicle
		throw new UnsupportedOperationException();
	}

	public void undo() {
		// TODO - implement CreateVehicleCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		// TODO - implement CreateVehicleCommand.execute
		throw new UnsupportedOperationException();
	}

}