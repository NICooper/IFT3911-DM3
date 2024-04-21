public class DeleteCompanyCommand {

	private final Company company;
	private final Application application;

	public DeleteCompanyCommand(Company company, Application application) {
		this.company = company;
		this.application = application;
	}

	public void undo() {
		application.addCompany(company);
	}

	public void execute() {
		application.deleteCompany(this.company);
	}

}