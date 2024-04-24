public class DeleteCompanyCommand implements Command{

	private final Company company;
	private final Application application;

	public DeleteCompanyCommand(Company company, Application application) {
		this.company = company;
		this.application = application;
	}

	public boolean undo() {
		return application.addCompany(company);
	}

	public boolean execute() {
		application.deleteCompany(this.company);
		return true;
	}

}