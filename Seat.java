public abstract class Seat {

	Payment payment;
	Client passenger;
	private String number;
	private Float price;
	private Reservation reservation;

	public boolean getIsAvailable() {
		// TODO - implement Seat.getIsAvailable
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isAvailable
	 */
	public void setIsAvailable(boolean isAvailable) {
		// TODO - implement Seat.setIsAvailable
		throw new UnsupportedOperationException();
	}

	public Float getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(Float price) {
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