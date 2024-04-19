public class SeaFactory extends TravelFactory {

	private SeaFactory instance;

	public SeaFactory getInstance() {
		if(instance == null){
			return new SeaFactory();
		}
		return this.instance;
	}

	private SeaFactory() {
		this.instance = this;
	}

	protected Company createCompany() {
		return new CruiseLine();
	}

	protected Port createPort() {
		return new SeaPort();
	}

	protected Route createRoute() {
		return new Cruise();
	}

	protected Vehicle createVehicle() {
		return new Boat();
	}

}