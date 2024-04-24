public class DeleteVehicleCommand implements Command {

	private final Application application;
	private final Vehicle vehicle;

	public DeleteVehicleCommand(Application application, Vehicle vehicle) {
		this.application = application;
		this.vehicle = vehicle;
	}

	public boolean undo() {
		return application.addVehicle(vehicle);
	}

	public boolean execute() {
		application.deleteVehicle(this.vehicle);
		return true;
	}

}