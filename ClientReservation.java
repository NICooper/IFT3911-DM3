public interface ClientReservation {


	void reserveSiege(Seat seat);

	/**
	 * 
	 * @param reservationNumber
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param passportNumber
	 */
	boolean pay(String reservationNumber, String firstName, String lastName, String email, String passportNumber);

}