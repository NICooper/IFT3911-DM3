import java.sql.Time;
import java.util.Date;

public class ModifyRouteCommand implements Command {

	private Application application;
	private String id;
	private Vehicle vehicle;
	private Date departureDate;
	private Date arrivalDate;
	private Type type;
	private float durationHours;
	private Company company;
	private Port departurePort;
	private Port arrivalPort;
	private Time departureTime;
	private Time arrivalTime;

	public ModifyRouteCommand(Application application, String id, Vehicle vehicle, Date departureDate, Date arrivalDate, Type type, float durationHours, Company company, Port departurePort, Port arrivalPort, Time departureTime, Time arrivalTime) {
		this.application = application;
		this.id = id;
		this.vehicle = vehicle;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.type = type;
		this.durationHours = durationHours;
		this.company = company;
		this.departurePort = departurePort;
		this.arrivalPort = arrivalPort;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public void undo() {
		// TODO - implement ModifyRouteCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		int i;
		boolean found = false;
		for(i = 0; i<application.routes.size(); i++){
			if(application.routes.get(i).getId().equals(this.id)){
				application.routes.get(i).setArrivalDate(this.arrivalDate);
				application.routes.get(i).setDepartureDate(this.departureDate);
				application.routes.get(i).setArrivalPort(this.arrivalPort);
				application.routes.get(i).setDeparturePort(this.departurePort);
				application.routes.get(i).setVehicle(this.vehicle);
				application.routes.get(i).setArrivalTime(this.arrivalTime);
				application.routes.get(i).setDepartureTime(this.departureTime);
				application.routes.get(i).setCompany(this.company);
				found = true;
			}
		}
		if(!found){
			System.out.println("Route not found");
		}
	}


}