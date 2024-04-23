public class CreateCompanyCommand {
	private final Application application;
	private final TravelFactory travelFactory;
	private final String id;
	private final float price;
	private Company createdCompany;

	/**
	 * 
	 * @param travelFactory
	 * @param id
	 * @param price
	 */
	public CreateCompanyCommand(Application application, TravelFactory travelFactory, String id, float price) {
		this.application = application;
		this.travelFactory = travelFactory;
		this.id = id;
		this.price = price;
	}

	public void undo() {
		application.deleteCompany(createdCompany);
	}

	public void execute() {
		createdCompany = travelFactory.createCompany(this.id, this.price);
		application.addCompany(createdCompany);
	}

}