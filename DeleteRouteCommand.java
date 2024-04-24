public class DeleteRouteCommand implements Command{
	private final Application application;
	private final Route route;

	public DeleteRouteCommand(Application application, Route route) {
		this.application = application;
		this.route = route;
	}

	public boolean undo() {
		return application.addRoute(route);
	}

	public boolean execute() {
		application.deleteRoute(this.route);
		return true;
	}

}