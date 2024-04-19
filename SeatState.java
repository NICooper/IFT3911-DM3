public interface SeatState {

	/**
	 * 
	 * @param context
	 */
	//abstract void event(Seat context);

	abstract void next(Seat context);

	abstract void prev(Seat context);

}