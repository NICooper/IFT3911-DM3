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

	public void addPort(Port port) {
		ports.add(port);
		notifyObservers();
	}

	public void addCompany(Company company) {
		companies.add(company);
		notifyObservers();
	}

	public void addRoute(Route route) {
		routes.add(route);
		notifyObservers();
	}

	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
		notifyObservers();
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
		notifyObservers();
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public void modifyPort(Port port) {
		// Would save the modified data to a database
		notifyObservers();
	}

	public void modifyCompany(Company company) {
		// Would save the modified data to a database
		notifyObservers();
	}

	public void modifyRoute(Route route) {
		// Would save the modified data to a database
		notifyObservers();
	}

	public void modifyReservation(Reservation reservation) {
		// Would save the modified data to a database
		notifyObservers();
	}

	public void modifyVehicle(Vehicle vehicle) {
		// Would save the modified data to a database
		notifyObservers();
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
	public void notifyObservers(Class stateClass, List<Object> state) {
		updateNews();
		for(Observer observer : observers){
			observer.update(this.news);
		}
	}

}