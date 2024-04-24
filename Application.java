import java.time.LocalDateTime;
import java.util.*;

public class Application implements Subject, ApplicationGetters {

	private final ArrayList<Observer> observers = new ArrayList<>();
	private final ArrayList<Administrator> admins = new ArrayList<>();
	private final ArrayList<Port> ports = new ArrayList<>();
	private final ArrayList<Company> companies = new ArrayList<>();
	private final ArrayList<Route> routes = new ArrayList<>();
	private final ArrayList<Reservation> reservations = new ArrayList<>();
	private final ArrayList<Vehicle> vehicles = new ArrayList<>();
	private final ArrayList<Client> clients = new ArrayList<>();

	public Application() {
		loadDatabase();
	}

	public void addAdmin(Administrator admin) {
		admins.add(admin);
	}

	public boolean addPort(Port port) {
		if (ports.stream().noneMatch(p ->
				p.getClass() == port.getClass() &&
						p.getPortId().equals(port.getPortId()))
		) {
			ports.add(port);
			notifyObservers();
			return true;
		} else {
			return false;
		}
	}

	public boolean addCompany(Company company) {
		if (companies.stream().noneMatch(c ->
				c.getClass() == company.getClass() &&
						c.getCompanyId().equals(company.getCompanyId()))
		) {
			companies.add(company);
			notifyObservers();
			return true;
		} else {
			return false;
		}
	}

	public boolean addRoute(Route route) {
		routes.add(route);
		notifyObservers();
		return true;
	}

	public boolean addReservation(Reservation reservation) {
		reservations.add(reservation);
		notifyObservers();
		return true;
	}

	public boolean addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
		notifyObservers();
		return true;
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public boolean modifyPort(Port port) {
		if (ports.stream().noneMatch(p ->
				p != port &&
						p.getPortId().equalsIgnoreCase(port.getPortId()))
		) {
			notifyObservers();
			return true;
		} else {
			return false;
		}
	}

	public boolean modifyCompany(Company company) {
		if (companies.stream().noneMatch(c ->
				c != company &&
						c.getCompanyId().equalsIgnoreCase(company.getCompanyId()))
		) {
			notifyObservers();
			return true;
		} else {
			return false;
		}
	}

	public boolean modifyRoute(Route route) {
		// Would save the modified data to a database
		notifyObservers();
		return true;
	}

	public boolean modifyReservation(Reservation reservation) {
		// Would save the modified data to a database
		notifyObservers();
		return true;
	}

	public boolean modifyVehicle(Vehicle vehicle) {
		// Would save the modified data to a database
		notifyObservers();
		return true;
	}

	public void deletePort(Port port){
		ports.remove(port);
		notifyObservers();
	}

	public void deleteCompany(Company company){
		companies.remove(company);
		notifyObservers();
	}

	public void deleteRoute(Route route){
		routes.remove(route);
		notifyObservers();
	}

	public void deleteVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
		notifyObservers();
	}

	public Port getPort(String portId, Type type) {
		var match = ports.stream().filter(p -> p.getType() == type && p.getPortId().equals(portId)).findFirst();
		return match.orElse(null);
	}

	@Override
	public ArrayList<Port> getPorts() {
		return ports;
	}

	public Company getCompany(String companyId, Type type) {
		var match = companies.stream().filter(c -> c.getType() == type && c.getCompanyId().equals(companyId)).findFirst();
		return match.orElse(null);
	}

	@Override
	public ArrayList<Company> getCompanies() {
		return companies;
	}

	@Override
	public ArrayList<Route> getRoutes() {
		return routes;
	}

	@Override
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	@Override
	public ArrayList<Administrator> getAdmins() {
		return admins;
	}

	@Override
	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	@Override
	public ArrayList<Client> getClients() {
		return clients;
	}

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer : observers){
			observer.update(this);
		}
	}

	private void loadDatabase() {
		try {
			Port yul = new AirPort("YUL", "Montréal");
			Port yvr = new AirPort("YVR", "Vancouver");
			ports.add(yul);
			ports.add(yvr);

			Company volCan = new AirLine("VolCan", 755f);
			Airplane vC1 = new Airplane("VC1", "B727", volCan);
			vC1.updateSectionUnitCount(PlaneSectionType.E, 50);
			vC1.addSection(PlaneSectionType.A, 20, Repartition.M);
			companies.add(volCan);
			vehicles.add(vC1);

			var yulToYvr = Arrays.stream(new Port[]{yul, yvr}).toList();
			Route vcYulYvr = new Flight(vC1, volCan, "VC200", yulToYvr, LocalDateTime.of(2024, 5, 6, 9, 5), LocalDateTime.of(2024, 5, 6, 13, 30));
			routes.add(vcYulYvr);

		} catch (InvalidIdException | InvalidPortsException | InvalidTimeException | DuplicateSectionException |
				 TooManySectionUnitsException e) {
			throw new RuntimeException(e);
		}
	}

}