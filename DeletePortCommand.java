public class DeletePortCommand implements Command {

	private final Application application;
	private final Port port;

	public DeletePortCommand(Port port, Application application) {
		this.port = port;
		this.application = application;
	}

	public void undo() {
		application.addPort(port);
	}

	public void execute() {
		application.deletePort(this.port);
	}

}