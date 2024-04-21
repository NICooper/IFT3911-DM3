public class AirFactory extends TravelFactory {

	private static AirFactory instance;

	private AirFactory() {
		instance = this;
	}

	public static AirFactory getInstance() {
		if(instance == null){
			return new AirFactory();
		}
		return instance;
	}

	protected Company createCompany(String companyId, float price) {
		return new AirLine(companyId, price);
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