public class CreatePortCommand implements Command {
	private final Application application;
	private final TravelFactory travelFactory;
	private final String id;
	private final String city;
	private Port createdPort;

	/**
	 *
	 * @param application
	 * @param travelFactory
	 * @param id
	 * @param city
	 *
	 */
	public CreatePortCommand(Application application, TravelFactory travelFactory, String id, String city) {
		this.application = application;
		this.travelFactory = travelFactory;
		this.id = id;
		this.city = city;
	}

	public boolean undo() {
		application.deletePort(createdPort);
		return true;
	}

	public boolean execute() {
		createdPort = travelFactory.createPort(id, city);
		if (createdPort != null) {
			return application.addPort(createdPort);
		}
		else {
			return false;
		}
	}

}