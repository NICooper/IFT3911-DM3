import java.time.LocalDateTime;
import java.util.List;

public class SeaFactory extends TravelFactory {

	private static SeaFactory instance;

	private SeaFactory() {
		instance = this;
	}

	public static SeaFactory getInstance() {
		if(instance == null){
			return new SeaFactory();
		}
		return instance;
	}

	protected Company createCompany(String companyId, float price) {
		try {
			return new CruiseLine(companyId, price);
		} catch (InvalidIdException e) {
			return null;
		}
	}

	protected Port createPort(String portId, String city) {
		try {
			return new SeaPort(portId, city);
		} catch (InvalidIdException e) {
			return null;
		}
	}

	protected Route createRoute(Vehicle vehicle, Company company, String id, List<Port> ports, LocalDateTime departureTime, LocalDateTime arrivalTime) {
		try {
			return new Cruise(vehicle, company, id, ports, departureTime, arrivalTime);
		}
		catch (InvalidPortsException | InvalidTimeException e) {
			return null;
		}
	}

	protected Vehicle createVehicle(String vehicleId, String model, Company company) {
		return new Boat(vehicleId, model, company);
	}

}