public class Cruise extends Route {

	/**
	 * 
	 * @param v
	 */
	public void accept(Visitor v) {
		v.visitCruise(this);
	}

}