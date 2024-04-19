import java.sql.Time;
import java.util.Date;

public class CreateRouteCommand {

	private TravelFactory travelFactory;
	private String id;
	private Time arrivingTime;
	private Time departureTime;
	private Date arrivingDate;
	private Date departureDate;

	public CreateRouteCommand(TravelFactory travelFactory, String id, Time arrivingTime, Time departureTime, Date arrivingDate, Date departureDate) {
		this.travelFactory = travelFactory;
		this.id = id;
		this.arrivingTime = arrivingTime;
		this.departureTime = departureTime;
		this.arrivingDate = arrivingDate;
		this.departureDate = departureDate;
	}

	public void undo() {
		// TODO - implement CreateRouteCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		Route route = travelFactory.createRoute();
		route.setId(this.id);
		route.setDepartureDate(this.departureDate);
		route.setArrivalDate(this.arrivingDate);
		// TODO - complete maybe
	}

}