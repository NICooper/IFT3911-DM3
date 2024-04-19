public class CreateVehicleCommand implements Command {

	private TravelFactory travelFactory;
	private String id;
	private String model;

	public CreateVehicleCommand(String id, String model) {
		this.id = id;
		this.model = model;
	}

	public void undo() {
		// TODO - implement CreateVehicleCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		Vehicle vehicle = travelFactory.createVehicle();
		vehicle.setVehicleId(this.id);
		vehicle.setModel(this.model);
	}

}