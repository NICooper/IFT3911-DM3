public class DeleteCompanyCommand {

	private Company company;
	private Application application;

	public DeleteCompanyCommand(Company company, Application application) {
		this.company = company;
		this.application = application;
	}

	public void undo() {
		// TODO - implement DeleteCompanyCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		application.deleteCompany(this.company);
	}

}