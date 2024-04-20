import java.sql.SQLOutput;

public class AdminView implements Visitor {

	//private State state;

	public void display() {
		// TODO - implement AdminView.display
		throw new UnsupportedOperationException();
	}

	public void input() {
		// TODO - implement AdminView.input
		throw new UnsupportedOperationException();
	}

	@Override
	public void visitFlight(Flight flight) {
		System.out.println(flight.getDeparturePort().getPortId() + "-" + flight.getArrivalPort().getPortId() +
				":" + "[" + flight.getCompany().getCompanyId() + "]" + flight.getId() + flight.getDepartureDate() +
				"-" + flight.getArrivalDate() + ")" /*TODO : Sections with prices and disponibility should be added*/);
	}

	@Override
	public void visitRailRoad(RailRoad railRoad) {
		System.out.println(railRoad.getDeparturePort().getPortId() + "-" + railRoad.getArrivalPort().getPortId() +
				":" + "[" + railRoad.getCompany().getCompanyId() + "]" + railRoad.getId() + railRoad.getDepartureDate() +
				"-" + railRoad.getArrivalDate() + ")" /*TODO : Sections with prices and disponibility should be added*/);
	}

	@Override
	public void visitCruise(Cruise cruise) {
		System.out.println(cruise.getDeparturePort().getPortId() + "-" + cruise.getArrivalPort().getPortId() +
				":" + "[" + cruise.getCompany().getCompanyId() + "]" + cruise.getId() + cruise.getDepartureDate() +
				"-" + cruise.getArrivalDate() + ")" /*TODO : Sections with prices and disponibility should be added*/);
	}
}