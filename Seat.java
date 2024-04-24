public abstract class Seat {

	Payment payment;
	Client passenger;
	private String seatId;
	private float price;
	protected SectionType sectionType;
	private Reservation reservation;
	private SeatState currentState;

	public Seat(String seatId, SectionType sectionType, float price) {
		this.seatId = seatId;
		this.sectionType = sectionType;
		this.price = price;
		setCurrentState(new Available());
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public SeatState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(SeatState currentState) {
		this.currentState = currentState;
	}

	public void nextState(){
		currentState.next(this);
	}

	public void prevState(){
		currentState.prev(this);
	}

	public boolean isAvailable() {
		return reservation == null;
	}

	public String getSeatId() {
		return seatId;
	}

	public float getPrice() {
		return this.price;
	}

	public SectionType getSectionType() {
		return this.sectionType;
	}

	/**
	 * 
	 * @param passenger
	 */
	public boolean confirmPassenger(Client passenger) {
		// TODO - implement Seat.confirmPassenger
		throw new UnsupportedOperationException();
	}

}