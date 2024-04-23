public class ModifyVehicleCommand implements Command {

	private final Application application;
	private final String id;
	private final String model;
	private final Company company;
	private final Vehicle vehicle;
	private ProtoMemento<Vehicle> vehicleMemento;

	public ModifyVehicleCommand(Application application, Vehicle vehicle, String id, String model, Company company) {
		this.application = application;
		this.id = id;
		this.model = model;
		this.company = company;
		this.vehicle = vehicle;
	}

	public boolean undo() {
		vehicle.restore(vehicleMemento);
		return application.modifyVehicle(vehicle);
	}

	public boolean execute() {
		vehicleMemento = vehicle.copy();
		vehicle.setVehicleId(id);
		vehicle.setModel(model);
		vehicle.setCompany(company);
		return application.modifyVehicle(vehicle);
	}

}