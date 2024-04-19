public class ModifyPortCommand {
	private Application application;
	private String id;
	private Company company;

	public ModifyPortCommand(Application application, String id, Company company) {
		this.application = application;
		this.id = id;
		this.company = company;
	}

	public void undo() {
		// TODO - implement ModifyPortCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		int i;
		boolean found = false;
		for(i = 0; i<application.ports.size(); i++){
			if(application.ports.get(i).getPortId().equals(this.id)){
				application.ports.get(i).setCompany(this.company);
				found = true;
			}
		}
		if(!found){
			System.out.println("Port not found");
		}
	}

}