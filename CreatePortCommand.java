public class CreatePortCommand {

	private TravelFactory travelFactory;
	private String id;
	private String city;
	private Company company;

	/**
	 *
	 * @param travelFactory
	 * @param id
	 * @param city
	 */
	public CreatePortCommand(TravelFactory travelFactory, String id, String city, Company company) {
		this.travelFactory = travelFactory;
		this.id = id;
		this.city = city;
		this.company = company;
	}

	public void undo() {
		// TODO - implement CreatePortCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		Port port = travelFactory.createPort(id, city, company);
	}

}