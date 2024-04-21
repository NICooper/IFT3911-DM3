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

	public void undo() {
		company.restore(companyMemento);
		application.modifyCompany(company);
	}

	public void execute() {
		companyMemento = company.copy();
		company.setCompanyId(newId);
		company.setPrice(newPrice);
		application.modifyCompany(company);
	}

}