import java.time.LocalDateTime;
import java.util.List;

public abstract class TravelFactory {

	protected abstract Company createCompany(String companyId, float price);

	protected abstract Port createPort(String portId, String city);

	protected abstract Route createRoute(Vehicle vehicle, Company company, String id, List<Port> ports, LocalDateTime departureTime, LocalDateTime arrivalTime);

	protected abstract Vehicle createVehicle(String vehicleId, String model, Company company);

}