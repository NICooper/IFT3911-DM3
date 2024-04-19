public class Available implements SeatState {

	/**
	 *
	 * @param context
	 */
	/*public void event(Seat context) {
		// TODO - implement Available.event
		throw new UnsupportedOperationException();
	}*/

	@Override
	public void next(Seat context) {
		context.setCurrentState(new Reserved());
	}

	@Override
	public void prev(Seat context) {
		System.out.println("The seat is available");
	}

}