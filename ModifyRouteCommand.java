import java.time.LocalDateTime;
import java.util.List;

public class ModifyRouteCommand implements Command {

	private final Application application;
	private final Vehicle vehicle;
	private final Company company;
	private final String id;
	private final List<Port> ports;
	private final LocalDateTime arrivalTime;
	private final LocalDateTime departureTime;
	private final Route route;
	private ProtoMemento<Route> routeMemento;

	public ModifyRouteCommand(Application application, Route route, Vehicle vehicle, Company company, String id, List<Port> ports, LocalDateTime arrivalTime, LocalDateTime departureTime) {
		this.application = application;
		this.route = route;
		this.vehicle = vehicle;
		this.company = company;
		this.id = id;
		this.ports = ports;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public boolean undo() {
		route.restore(routeMemento);
		return application.modifyRoute(route);
	}

	public boolean execute() {
		routeMemento = route.copy();
		try {
			route.setVehicle(vehicle);
			route.setCompany(company);
			route.setId(id);
			route.setPorts(ports);
			route.setDepartureAndArrivalTime(departureTime, arrivalTime);
		} catch (InvalidPortsException | InvalidTimeException e) {
			return false;
		}
		return application.modifyRoute(route);
	}


}