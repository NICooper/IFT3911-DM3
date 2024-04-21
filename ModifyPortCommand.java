public class ModifyPortCommand {
	private final Application application;
	private final Port port;
	private Port portMemento;
	private final String newId;
	private final String newCity;
	private final Company newCompany;

	public ModifyPortCommand(Application application, Port port, String newId, String newCity, Company newCompany) {
		this.application = application;
		this.port = port;
		this.newId = newId;
		this.newCity = newCity;
		this.newCompany = newCompany;
	}

	public void undo() {
		port.restore(portMemento);
		application.modifyPort(port);
	}

	public void execute() {
		portMemento = port.copy();
		port.setPortId(newId);
		port.setCity(newCity);
		port.setCompany(newCompany);
		application.modifyPort(port);
	}
}