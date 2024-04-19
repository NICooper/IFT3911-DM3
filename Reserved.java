public class Reserved implements SeatState {

	/**
	 * 
	 * @param context
	 */
	/*public void event(Seat context) {
		// TODO - implement Reserved.event
		throw new UnsupportedOperationException();
	}*/

	@Override
	public void next(Seat context) {
		context.setCurrentState(new Available());
	}

	@Override
	public void prev(Seat context) {
		context.setCurrentState(new Paid());
	}

}