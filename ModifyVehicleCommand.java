public class ModifyVehicleCommand implements Command {

	private Application application;
	private String id;
	private String model;
	private Company company;
	private Vehicle vehicle;
	private Vehicle vehicleMemento;


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