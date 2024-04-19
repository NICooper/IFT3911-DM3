public class DeleteRouteCommand {

	private Application application;
	private Route route;


	public DeleteRouteCommand(Application application, Route route) {
		this.application = application;
		this.route = route;
	}

	public void undo() {
		// TODO - implement DeleteRouteCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		application.deleteRoute(this.route);
	}

}