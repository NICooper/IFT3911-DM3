import java.time.LocalDateTime;
import java.util.List;

public class RailRoad extends Route {

	public RailRoad(Vehicle vehicle, Company company, String id, List<Port> ports, LocalDateTime departureTime, LocalDateTime arrivalTime) throws InvalidPortsException, InvalidTimeException {
		super(vehicle, company, id, ports, departureTime, arrivalTime);
	}

	public Seat getAvailableSeat(TrainSectionType sectionType, ColumnSeatType prefSeatType) {
		var availableSeats = seats.stream().filter(s -> s.getSectionType() == sectionType).toList();
		var preferredSeat = availableSeats.stream().filter(s -> ((PlaneSeat)s).getColumnSeatType() == prefSeatType).findFirst();
		if (preferredSeat.isPresent()) {
			return preferredSeat.get();
		}
		var bothSeat = availableSeats.stream().filter(s -> ((PlaneSeat)s).getColumnSeatType() == ColumnSeatType.Both).findFirst();
		return bothSeat.orElseGet(() -> availableSeats.stream().findFirst().orElse(null));
	}

	@Override
	public RailRoad copy() {
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