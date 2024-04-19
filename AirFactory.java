public class AirFactory extends TravelFactory {

	private AirFactory instance;

	protected Company createCompany() {
		// TODO - implement AirFactory.createCompany
		throw new UnsupportedOperationException();
	}

	public AirFactory getInstance() {
		if(instance == null){
			return new AirFactory();
		}
		return this.instance;
	}

	private void AirCreator() {
		this.instance = this;
	}

	protected Port createPort() {
		// TODO - implement AirFactory.createPort
		throw new UnsupportedOperationException();
	}

	protected Route createRoute() {
		// TODO - implement AirFactory.createRoute
		throw new UnsupportedOperationException();
	}

	protected Vehicle createVehicle() {
		// TODO - implement AirFactory.createVehicle
		throw new UnsupportedOperationException();
	}

}