import java.time.LocalDateTime;
import java.util.List;

public class Cruise extends Route {

	public Cruise(Vehicle vehicle, Company company, String id, List<Port> ports, LocalDateTime departureTime, LocalDateTime arrivalTime) throws InvalidPortsException, InvalidTimeException {
		super(vehicle, company, id, ports, departureTime, arrivalTime);
	}

	@Override
	public Cruise copy() {
		try {
			return new Cruise(vehicle, company, id, ports, departureTime, arrivalTime);
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
		v.visitCruise(this);
	}

}