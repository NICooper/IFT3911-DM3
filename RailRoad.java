import java.time.LocalDateTime;
import java.util.List;

public class RailRoad extends Route implements IVisitable {

	public RailRoad(Vehicle vehicle, Company company, String id, List<Port> ports, LocalDateTime departureTime, LocalDateTime arrivalTime) throws InvalidPortsException, InvalidTimeException {
		super(vehicle, company, id, ports, departureTime, arrivalTime);
	}

	@Override
	public Route copy() {
		try {
			return new RailRoad(vehicle, company, id, ports, departureTime, arrivalTime);
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
		v.visitRailRoad(this);
	}
}