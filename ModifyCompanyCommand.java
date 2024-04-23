public class ModifyCompanyCommand implements Command {
	Application application;
	private final String newId;
	private final float newPrice;
	private final Company company;
	private ProtoMemento<Company> companyMemento;

	public ModifyCompanyCommand(Application application, Company company, String newId, float newPrice) {
		this.application = application;
		this.company = company;
		this.newId = newId;
		this.newPrice = newPrice;
	}

	public boolean undo() {
		company.restore(companyMemento);
		return application.modifyCompany(company);
	}

	public boolean execute() {
		companyMemento = company.copy();
		try {
			company.setCompanyId(newId);
			company.setPrice(newPrice);
		}
		catch (InvalidIdException e) {
			return false;
		}
		return application.modifyCompany(company);
	}

}