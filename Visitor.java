public interface Visitor {

	/**
	 * 
	 * @param flight
	 */
	void visitFlight(Flight flight);

	/**
	 * 
	 * @param railRoad
	 */
	void visitRailRoad(RailRoad railRoad);

	/**
	 * 
	 * @param cruise
	 */
	void visitCruise(Cruise cruise);

}