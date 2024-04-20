public class SeaFactory extends TravelFactory {

	private static SeaFactory instance;

	private SeaFactory() {
		instance = this;
	}

	public static SeaFactory getInstance() {
		if(instance == null){
			return new SeaFactory();
		}
		return instance;
	}

	protected Company createCompany() {
		return new CruiseLine();
	}

	protected Port createPort(String portId, String city, Company company) {
		return new SeaPort(portId, city, company);
	}

	protected Route createRoute() {
		return new Cruise();
	}

	protected Vehicle createVehicle() {
		return new Boat();
	}

}