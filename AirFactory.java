public class AirFactory extends TravelFactory {

	private static AirFactory instance;

	private AirFactory() {
		instance = this;
	}

	public AirFactory getInstance() {
		if(instance == null){
			return new AirFactory();
		}
		return instance;
	}

	protected Company createCompany() {
		return new AirLine();
	}

	protected Port createPort(String portId, String city, Company company) {
		return new AirPort(portId, city, company);
	}

	protected Route createRoute() {
		return new Flight();
	}

	protected Vehicle createVehicle() {
		return new Airplane();
	}

}