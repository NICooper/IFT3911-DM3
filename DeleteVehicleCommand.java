public class DeleteVehicleCommand {

	private Application application;
	private Vehicle vehicle;

	public DeleteVehicleCommand(Application application, Vehicle vehicle) {
		this.application = application;
		this.vehicle = vehicle;
	}

	public void undo() {
		// TODO - implement DeleteVehicleCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		application.deleteVehicle(this.vehicle);
	}

}