import java.util.*;

public class Application implements Subject, ApplicationGetters {

	ArrayList<Observer> observers = new ArrayList<>();
	ArrayList<Administrator> admins;
	ArrayList<Port> ports;
	ArrayList<Company> companies;
	ArrayList<Route> routes;
	ArrayList<Reservation> reservations;
	ArrayList<Vehicle> vehicles;
	ArrayList<Client> clients;
	ArrayList<Object>[] news = new ArrayList[7];


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