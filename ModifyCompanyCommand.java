public class ModifyCompanyCommand implements Command {
	Application application;
	private final String newId;
	private final float newPrice;
	private final Company company;
	private Company companyMemento;

	public ModifyCompanyCommand(Application application, Company company, String newId, float newPrice) {
		this.application = application;
		this.company = company;
		this.newId = newId;
		this.newPrice = newPrice;
	}

	public boolean undo() {
		try {
			company.restore(companyMemento);
		} catch (InvalidIdException e) {
			return false;
		}
		return application.modifyCompany(company);
	}

	public boolean execute() {
		companyMemento = company.copy();
		try {
			company.setCompanyId(newId);
		}
		catch (InvalidIdException e) {
			return false;
		}
		company.setPrice(newPrice);
		return application.modifyCompany(company);
	}

}