import java.time.LocalDateTime;
import java.util.List;

public class Flight extends Route {

	public Flight(Vehicle vehicle, Company company, String id, List<Port> ports, LocalDateTime departureTime, LocalDateTime arrivalTime) throws InvalidPortsException, InvalidTimeException {
		super(vehicle, company, id, ports, departureTime, arrivalTime);
	}

	@Override
	public Route copy() {
		try {
			return new Flight(vehicle, company, id, ports, departureTime, arrivalTime);
		}
		catch (InvalidPortsException | InvalidTimeException e) {
			return null;
		}
	}

	/**
	 *
	 * @param v
	 */
	public void accept(Visitor v) {
		v.visitFlight(this);
	}

}