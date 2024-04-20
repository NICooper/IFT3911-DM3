public abstract class TravelFactory {

	protected abstract Company createCompany();

	protected abstract Port createPort(String portId, String city, Company company);

	protected abstract Route createRoute();

	protected abstract Vehicle createVehicle();

}