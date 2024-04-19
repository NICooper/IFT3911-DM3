import java.util.Date;

public class Client implements ClientRouteVerification, Observer, ClientReservation {

	private String firstName;
	private String lastName;
	private String email;
	private String passportNumber;
	private Reservation reservation;
	private Seat seat;
	private ClientView clientView;

	public void seatEvent() {
		// TODO - implement Client.seatEvent
		throw new UnsupportedOperationException();
	}

	@Override
	public Reservation reserveSiege(Type type, boolean isWindow, Seat seat, boolean isNaval) {
		return null;
	}

	@Override
	public boolean pay(String reservationNumber, String firstName, String lastName, String email, String passportNumber) {
		return false;
	}

	@Override
	public void verifyRoutes(Port portDeparture, Port portArrival, Section section, Date date, Type type) {

	}

	@Override
	public void update() {

	}
}