public abstract class TravelFactory {

	protected abstract Company createCompany(String companyId, float price);

	protected abstract Port createPort(String portId, String city, Company company);

	protected abstract Route createRoute();

	protected abstract Vehicle createVehicle();

}