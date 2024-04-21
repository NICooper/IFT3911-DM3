public class TrainFactory extends TravelFactory {

	private static TrainFactory instance;

	private TrainFactory() {
		instance = this;
	}

	public static TrainFactory getInstance() {
		if(instance == null) {
			return new TrainFactory();
		}
		return instance;
	}

	protected Company createCompany(String companyId, float price) {
		return new TrainLine(companyId, price);
	}

	protected Port createPort(String portId, String city, Company company) {
		return new TrainStation(portId, city, company);
	}

	protected Route createRoute() {
		return new RailRoad();
	}

	protected Vehicle createVehicle() {
		return new Train();
	}

}