public class ModifyVehicleCommand implements Command {

	private Application application;
	private String id;
	private String model;
	private Company company;


	public ModifyVehicleCommand(Application application, String id, String model, Company company) {
		this.application = application;
		this.id = id;
		this.model = model;
		this.company = company;
	}

	public void undo() {
		// TODO - implement ModifyVehicleCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		int i;
		boolean found = false;
		for(i = 0; i<application.vehicles.size(); i++){
			if(application.vehicles.get(i).getVehicleId().equals(this.id)){
				application.vehicles.get(i).setCompany(this.company);
				application.vehicles.get(i).setModel(this.model);
				found = true;
			}
		}
		if(!found){
			System.out.println("Vehicle not found");
		}
	}

}