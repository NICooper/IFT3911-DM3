public interface ClientReservation {

	/**
	 * 
	 * @param type
	 * @param isWindow
	 * @param seat
	 * @param isNaval
	 */
	Reservation reserveSiege(Type type, boolean isWindow, Seat seat, boolean isNaval);

	/**
	 * 
	 * @param reservationNumber
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param passportNumber
	 */
	boolean pay(String reservationNumber, String firstName, string lastName, String email, String passportNumber);

}