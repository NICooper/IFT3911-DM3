public class TrainFactory extends TravelFactory {

	private TrainFactory instance;

	public TrainFactory getInstance() {
		if(instance == null) {
			return new TrainFactory();
		}
		return this.instance;
	}

	private TrainFactory() {
		this.instance = this;
	}

	protected Company createCompany() {
		return new TrainLine();
	}

	protected Port createPort() {
		return new TrainStation();
	}

	protected Route createRoute() {
		return new RailRoad();
	}

	protected Vehicle createVehicle() {
		return new Train();
	}

}