public class CreateCompanyCommand {

	private TravelFactory travelFactory;
	private String id;
	private Float price;

	/**
	 * 
	 * @param travelFactory
	 * @param id
	 * @param price
	 */
	public CreateCompanyCommand(TravelFactory travelFactory, String id, Float price) {
		this.travelFactory = travelFactory;
		this.id = id;
		this.price = price;
	}

	public void undo() {
		// TODO - implement CreateCompanyCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		Company company = travelFactory.createCompany();
		company.setCompanyId(this.id);
		company.setPrice(this.price);
	}

}