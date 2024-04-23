public abstract class Seat {

	Payment payment;
	Client passenger;
	private String number;
	private float price;
	private Reservation reservation;
	private SeatState currentState;

	public SeatState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(SeatState currentState) {
		this.currentState = currentState;
	}

	public boolean getIsAvailable() {
		// TODO - implement Seat.getIsAvailable
		throw new UnsupportedOperationException();
	}

	public void nextState(){
		currentState.next(this);
	}

	public void prevState(){
		currentState.prev(this);
	}

	/**
	 * 
	 * @param isAvailable
	 */
	public void setIsAvailable(boolean isAvailable) {
		// TODO - implement Seat.setIsAvailable
		throw new UnsupportedOperationException();
	}

	public float getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
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