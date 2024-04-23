import java.util.*;

public class Application implements Subject, ApplicationGetters {

	private ArrayList<Observer> observers = new ArrayList<>();
	private ArrayList<Administrator> admins = new ArrayList<>();
	private ArrayList<Port> ports = new ArrayList<>();
	private ArrayList<Company> companies = new ArrayList<>();
	private ArrayList<Route> routes = new ArrayList<>();
	private ArrayList<Reservation> reservations = new ArrayList<>();
	private ArrayList<Vehicle> vehicles = new ArrayList<>();
	private ArrayList<Client> clients = new ArrayList<>();
	private ArrayList<Object>[] news = new ArrayList[7];



	public ArrayList<Object>[] getNews() {
		return news;
	}

	public void setNews(ArrayList<Object>[] news) {
		this.news = news;
	}

	public void updateNews() {
		//news = new ArrayList[7];
		this.news[0].add(admins);
		this.news[1].add(ports);
		this.news[2].add(companies);
		this.news[3].add(routes);
		this.news[4].add(reservations);
		this.news[5].add(vehicles);
		this.news[6].add(clients);
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
		}
		else {
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
		}
		else {
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
		}
		else {
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
		}
		else {
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

	@Override
	public ArrayList<Port> getPorts() {
		return ports;
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
		updateNews();
		for(Observer observer : observers){
			observer.update(this.news);
		}
	}

}