public class ModifyPortCommand {
	private final Application application;
	private final Port port;
	private ProtoMemento<Port> portMemento;
	private final String newId;
	private final String newCity;

	public ModifyPortCommand(Application application, Port port, String newId, String newCity) {
		this.application = application;
		this.port = port;
		this.newId = newId;
		this.newCity = newCity;
	}

	public boolean undo() {
		port.restore(portMemento);
		return application.modifyPort(port);
	}

	public boolean execute() {
		portMemento = port.copy();
		try {
			port.setPortId(newId);
		} catch (InvalidIdException e) {
			return false;
		}
		port.setCity(newCity);
		return application.modifyPort(port);
	}
}