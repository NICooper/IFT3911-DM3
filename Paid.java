public class Paid implements SeatState {

	/**
	 *
	 * @param context
	 */
    public void event(Seat context) {
		// TODO - implement Paid.event
		throw new UnsupportedOperationException();
	}
	@Override
	public void next(Seat context) {
		System.out.println("The seat is already paid");;
	}

	@Override
	public void prev(Seat context) {
		context.setCurrentState(new Reserved());
	}

}