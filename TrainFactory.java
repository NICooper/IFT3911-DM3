public class TrainFactory extends TravelFactory {

	private TrainFactory instance;

	protected Company createCompany() {
		// TODO - implement TrainFactory.createCompany
		throw new UnsupportedOperationException();
	}

	public TrainFactory getInstance() {
		if(instance == null) {
			return new TrainFactory();
		}
		return this.instance;
	}

	private TrainFactory() {
		this.instance = this;
	}

	protected Port createPort() {
		// TODO - implement TrainFactory.createPort
		throw new UnsupportedOperationException();
	}

	protected Route createRoute() {
		// TODO - implement TrainFactory.createRoute
		throw new UnsupportedOperationException();
	}

	protected Vehicle createVehicle() {
		// TODO - implement TrainFactory.createVehicle
		throw new UnsupportedOperationException();
	}

}