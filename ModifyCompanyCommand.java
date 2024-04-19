public class ModifyCompanyCommand implements Command {
	Application application;
	private String id;
	private float price;


	public ModifyCompanyCommand(Application application, String id, float price) {
		this.application = application;
		this.id = id;
		this.price = price;
	}

	public void undo() {
		// TODO - implement ModifyCompanyCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		int i;
		boolean found = false;
		for(i = 0; i<application.companies.size(); i++){
			if(application.companies.get(i).getCompanyId().equals(this.id)){
				application.companies.get(i).setPrice(this.price);
				found = true;
			}
		}
		if(!found){
			System.out.println("Company not found");
		}
	}

}