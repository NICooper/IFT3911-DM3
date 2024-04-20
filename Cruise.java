public class Cruise extends Route {

	/**
	 * 
	 * @param v
	 */
	public void accept(Visitor v) {
		v.visitCruise(this);
	}

	protected void show() {
		// TODO - implement Cruise.show
		throw new UnsupportedOperationException();
	}

}