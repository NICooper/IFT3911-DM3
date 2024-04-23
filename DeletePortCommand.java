public class DeletePortCommand implements Command {

	private final Application application;
	private final Port port;

	public DeletePortCommand(Port port, Application application) {
		this.port = port;
		this.application = application;
	}

	public boolean undo() {
		return application.addPort(port);
	}

	public boolean execute() {
		application.deletePort(this.port);
		return true;
	}

}