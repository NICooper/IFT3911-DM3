import java.sql.Time;
import java.util.Date;

public class CreateRouteCommand {

	private TravelFactory travelFactory;
	private String id;
	private Time arrivingTime;
	private Time departureTime;
	private Date arrivingDate;
	private Date departureDate;

	/**
	 * 
	 * @param travelFactory
	 * @param id
	 * @param arrivingTime
	 * @param departureTime
	 * @param arrivingDate
	 * @param departureDate
	 */
	public Route createsRoute(TravelFactory travelFactory, String id, Time arrivingTime, Time departureTime, Date arrivingDate, Date departureDate) {
		// TODO - implement CreateRouteCommand.createsRoute
		throw new UnsupportedOperationException();
	}

	public void undo() {
		// TODO - implement CreateRouteCommand.undo
		throw new UnsupportedOperationException();
	}

	public void execute() {
		// TODO - implement CreateRouteCommand.execute
		throw new UnsupportedOperationException();
	}

}