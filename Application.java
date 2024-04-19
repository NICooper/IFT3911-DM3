import java.util.*;

public class Application implements Subject, ApplicationGetters {

	ArrayList<Administrator> admins;
	ArrayList<Port> ports;
	ArrayList<Company> companies;
	ArrayList<Route> routes;
	ArrayList<Reservation> reservations;
	ArrayList<Vehicle> vehicles;
	ArrayList<Client> clients;

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
		//TODO
	}

	@Override
	public void detach(Observer observer) {
		//TODO
	}

	@Override
	public void notifyObservers() {

	}
}