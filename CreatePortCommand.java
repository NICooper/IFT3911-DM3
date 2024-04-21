public class CreatePortCommand {
	private final Application application;
	private final TravelFactory travelFactory;
	private final String id;
	private final String city;
	private final Company company;
	private Port createdPort;

	/**
	 *
	 * @param application
	 * @param travelFactory
	 * @param id
	 * @param city
	 * @param company
	 *
	 */
	public CreatePortCommand(Application application, TravelFactory travelFactory, String id, String city, Company company) {
		this.application = application;
		this.travelFactory = travelFactory;
		this.id = id;
		this.city = city;
		this.company = company;
	}

	public void undo() {
		application.deletePort(createdPort);
	}

	public void execute() {
		createdPort = travelFactory.createPort(id, city, company);
		application.addPort(createdPort);
	}

}