public class CreateVehicleCommand implements Command {
	private final Application application;
	private final TravelFactory travelFactory;
	private final String id;
	private final String model;
	private final Company company;
	private Vehicle createdVehicle;

	public CreateVehicleCommand(Application application, TravelFactory travelFactory, String id, String model, Company company) {
		this.application = application;
		this.travelFactory = travelFactory;
		this.id = id;
		this.model = model;
		this.company = company;
	}

	public boolean undo() {
		application.deleteVehicle(createdVehicle);
		return true;
	}

	public boolean execute() {
		createdVehicle = travelFactory.createVehicle(id, model, company);
		return application.addVehicle(createdVehicle);
	}

}