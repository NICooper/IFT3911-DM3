public class SeaFactory extends TravelFactory {

	private SeaFactory instance;

	protected Company createCompany() {
		// TODO - implement SeaFactory.createCompany
		throw new UnsupportedOperationException();
	}

	public SeaFactory getInstance() {
		if(instance == null){
			return new SeaFactory();
		}
		return this.instance;
	}

	private SeaFactory() {
		this.instance = this;
	}

	protected Port createPort() {
		// TODO - implement SeaFactory.createPort
		throw new UnsupportedOperationException();
	}

	protected Route createRoute() {
		// TODO - implement SeaFactory.createRoute
		throw new UnsupportedOperationException();
	}

	protected Vehicle createVehicle() {
		// TODO - implement SeaFactory.createVehicle
		throw new UnsupportedOperationException();
	}

}