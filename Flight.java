public class Flight extends Route implements IVisitable {

	/**
	 * 
	 * @param v
	 */
	public void accept(Visitor v) {
		v.visitFlight(this);
	}

	protected void show() {
		// TODO - implement Flight.show
		throw new UnsupportedOperationException();
	}

}