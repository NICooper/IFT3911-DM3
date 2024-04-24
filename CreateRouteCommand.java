import java.time.LocalDateTime;
import java.util.List;

public class CreateRouteCommand implements Command{
	private final Application application;
	private final TravelFactory travelFactory;
	private final Vehicle vehicle;
	private final Company company;
	private final String id;
	private final List<Port> ports;
	private final LocalDateTime arrivalTime;
	private final LocalDateTime departureTime;
	private Route createdRoute;

	public CreateRouteCommand(Application application, TravelFactory travelFactory, Vehicle vehicle, Company company, String id, List<Port> ports, LocalDateTime arrivalTime, LocalDateTime departureTime) {
		this.application = application;
		this.travelFactory = travelFactory;
		this.vehicle = vehicle;
		this.company = company;
		this.id = id;
		this.ports = ports;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public boolean undo() {
		application.deleteRoute(createdRoute);
		return true;
	}

	public boolean execute() {
		createdRoute = travelFactory.createRoute(vehicle, company, id, ports, departureTime, arrivalTime);
		return application.addRoute(createdRoute);
	}

}