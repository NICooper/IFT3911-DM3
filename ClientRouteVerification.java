import java.util.Date;

public interface ClientRouteVerification {

	/**
	 * 
	 * @param portDeparture
	 * @param portArrival
	 * @param section
	 * @param date
	 * @param type
	 */
	void verifyRoutes(Port portDeparture, Port portArrival, Section section, Date date, Type type);

}