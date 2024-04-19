public class AirFactory extends TravelFactory {

	private AirFactory instance;

	public AirFactory getInstance() {
		if(instance == null){
			return new AirFactory();
		}
		return this.instance;
	}

	private void AirCreator() {
		this.instance = this;
	}

	protected Company createCompany() {
		return new AirLine();
	}

	protected Port createPort() {
		return new AirPort();
	}

	protected Route createRoute() {
		return new Flight();
	}

	protected Vehicle createVehicle() {
		return new Airplane();
	}

}