import java.util.Date;
import java.util.Random;

public class Reservation implements SeatConfirmation, Validation {

	private String reservationNumber;
	private Boolean isPaid;
	private Seat seat;
	private Date creationDate;

	public Reservation(Seat seat) {
		this.seat = seat;
		Random rand = new Random();
		reservationNumber = Integer.toString(rand.nextInt());
	}

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

	@Override
	public boolean confirmSeat(String firstName, String lastName, String email, String passportNumber) {
		return false;
	}

	@Override
	public boolean isValid() {
		return false;
	}
	
	public String getReservationNumber() {
		return reservationNumber;
	}
}
