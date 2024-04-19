public class DeletePortCommand implements Command {

	private Application application;
	private Port port;

	public DeletePortCommand(Port port, Application application) {
		this.port = port;
		this.application = application;
	}

	public void undo() {
		// TODO - implement DeletePortCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		application.deletePort(this.port);
	}

}