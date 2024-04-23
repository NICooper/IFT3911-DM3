import java.time.LocalDateTime;
import java.util.List;

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
		try {
			return new AirLine(companyId, price);
		}
		catch (InvalidIdException e) {
			return null;
		}
	}

	protected Port createPort(String portId, String city) {
		try {
			return new AirPort(portId, city);
		}
		catch (InvalidIdException e) {
			return null;
		}
	}

	protected Route createRoute(Vehicle vehicle, Company company, String id, List<Port> ports, LocalDateTime departureTime, LocalDateTime arrivalTime) {
		try {
			return new Flight(vehicle, company, id, ports, departureTime, arrivalTime);
		}
		catch (InvalidPortsException | InvalidTimeException e) {
			return null;
		}
	}

	protected Vehicle createVehicle(String vehicleId, String model, Company company) {
		return new Airplane(vehicleId, model, company);
	}

}