import java.time.LocalDateTime;
import java.util.List;

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
		try {
			return new TrainLine(companyId, price);
		}
		catch (InvalidIdException e) {
			return null;
		}
	}

	protected Port createPort(String portId, String city) {
		try {
			return new TrainStation(portId, city);
		}
		catch (InvalidIdException e) {
			return null;
		}
	}

	protected Route createRoute(Vehicle vehicle, Company company, String id, List<Port> ports, LocalDateTime departureTime, LocalDateTime arrivalTime) {
		try {
			return new RailRoad(vehicle, company, id, ports, departureTime, arrivalTime);
		}
		catch (InvalidPortsException | InvalidTimeException e) {
			return null;
		}
	}

	protected Vehicle createVehicle(String vehicleId, String model, Company company) {
			return new Train(vehicleId, model, company);
		}

}