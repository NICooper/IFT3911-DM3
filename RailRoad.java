public class RailRoad extends Route implements IVisitable {

	/**
	 * 
	 * @param v
	 */
	public void accept(Visitor v) {
		v.visitRailRoad(this);
	}

	protected void show() {
		// TODO - implement RailRoad.show
		throw new UnsupportedOperationException();
	}

}