public class Reservation implements SeatConfirmation, Validation {

	private String reservationNumber;
	private Boolean isPaid;
	private Seat seat;
	private Date creationDate;

	public Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * 
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Seat getSeat() {
		return this.seat;
	}

}