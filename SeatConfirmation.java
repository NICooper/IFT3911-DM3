public interface SeatConfirmation {

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param passportNumber
	 */
	boolean confirmSeat(String firstName, String lastName, String email, String passportNumber);

}