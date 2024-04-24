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
			Port yyz = new AirPort("YYZ", "Toronto");
			ports.add(yul);
			ports.add(yvr);
			ports.add(yyz);

			Company volCan = new AirLine("VolCan", 755f);
			companies.add(volCan);

			Airplane vC1 = new Airplane("VC1", "B727", volCan);
			Airplane vC2 = new Airplane("VC2", "AB100", volCan);
			vC1.updateSectionUnitCount(PlaneSectionType.E, 50);
			vC1.addSection(PlaneSectionType.A, 20, Repartition.M);
			vC2.updateSectionUnitCount(PlaneSectionType.E, 50);
			vC2.updateRepartition(PlaneSectionType.E, Repartition.L);
			vC2.addSection(PlaneSectionType.P, 10, Repartition.S);
			vC2.addSection(PlaneSectionType.F, 10, Repartition.C);
			vehicles.add(vC1);
			vehicles.add(vC2);

			var yulToYvr = Arrays.stream(new Port[]{yul, yvr}).toList();
			var yyzToYul = Arrays.stream(new Port[]{yyz, yul}).toList();
			var yvrToYyz = Arrays.stream(new Port[]{yvr, yyz}).toList();
			routes.add(new Flight(vC1, volCan, "VC200", yulToYvr, LocalDateTime.of(2024, 5, 6, 9, 5), LocalDateTime.of(2024, 5, 6, 13, 30)));
			routes.add(new Flight(vC2, volCan, "VC123", yyzToYul, LocalDateTime.of(2024, 5, 6, 12, 0), LocalDateTime.of(2024, 5, 6, 13, 30)));
			routes.add(new Flight(vC2, volCan, "VC501", yvrToYyz, LocalDateTime.of(2024, 5, 8, 17, 30), LocalDateTime.of(2024, 5, 8, 22, 45)));



			Port mtl = new SeaPort("MTL", "Montréal");
			Port trv = new SeaPort("TRV", "Trois Rivières");
			Port qbc = new SeaPort("QBC", "Québec");
			ports.add(mtl);
			ports.add(trv);
			ports.add(qbc);

			Company ferry = new CruiseLine("Ferry", 150f);
			companies.add(ferry);

			Boat f1 = new Boat("FRY", "Nimitz", ferry);
			f1.updateSectionUnitCount(BoatSectionType.F, 400);
			f1.updateSectionUnitCount(BoatSectionType.I, 100);
			f1.updateSectionUnitCount(BoatSectionType.S, 100);
			f1.updateSectionUnitCount(BoatSectionType.D, 100);
			f1.updateSectionUnitCount(BoatSectionType.O, 150);
			vehicles.add(f1);

			var mtlToTrv = Arrays.stream(new Port[]{mtl, trv}).toList();
			var trvToQbc = Arrays.stream(new Port[]{trv, qbc}).toList();
			var qbcToMtl = Arrays.stream(new Port[]{qbc, trv, mtl}).toList();

			routes.add(new Cruise(f1, ferry, "M2T", mtlToTrv, LocalDateTime.of(2024, 5, 6, 9, 5), LocalDateTime.of(2024, 5, 6, 13, 30)));
			routes.add(new Cruise(f1, ferry, "T2Q", trvToQbc, LocalDateTime.of(2024, 5, 7, 12, 0), LocalDateTime.of(2024, 5, 7, 13, 30)));
			routes.add(new Cruise(f1, ferry, "QTM", qbcToMtl, LocalDateTime.of(2024, 5, 8, 17, 30), LocalDateTime.of(2024, 5, 8, 22, 45)));



			Port lsj = new TrainStation("LSJ", "Lac Saint Jean");
			Port otw = new TrainStation("OTW", "Ottawa");
			Port gsp = new TrainStation("GSP", "Gaspé");
			Port grn = new TrainStation("GRN", "Granby");
			ports.add(lsj);
			ports.add(otw);
			ports.add(gsp);
			ports.add(grn);

			Company trnCo = new TrainLine("TrnCo", 95f);
			companies.add(trnCo);

			Train train1 = new Train("B1", "T1000", trnCo);
			Train train2 = new Train("B2", "T1000", trnCo);
			train1.updateSectionUnitCount(TrainSectionType.E, 1000);
			train1.updateSectionUnitCount(TrainSectionType.P, 60);
			train2.updateSectionUnitCount(TrainSectionType.E, 960);
			train2.updateSectionUnitCount(TrainSectionType.P, 100);
			vehicles.add(train1);
			vehicles.add(train2);

			var lsjToOtw = Arrays.stream(new Port[]{lsj, grn, otw}).toList();
			var otwToLsj = Arrays.stream(new Port[]{otw, grn, lsj}).toList();
			var gspToOtw = Arrays.stream(new Port[]{gsp, lsj, grn, otw}).toList();
			routes.add(new RailRoad(train1, trnCo, "T10", lsjToOtw, LocalDateTime.of(2024, 5, 6, 9, 5), LocalDateTime.of(2024, 5, 6, 13, 30)));
			routes.add(new RailRoad(train1, trnCo, "T01", otwToLsj, LocalDateTime.of(2024, 5, 7, 12, 0), LocalDateTime.of(2024, 5, 7, 13, 30)));
			routes.add(new RailRoad(train2, trnCo, "T05", gspToOtw, LocalDateTime.of(2024, 5, 8, 17, 30), LocalDateTime.of(2024, 5, 8, 22, 45)));

		} catch (InvalidIdException | InvalidPortsException | InvalidTimeException | DuplicateSectionException |
				 TooManySectionUnitsException e) {
			throw new RuntimeException(e);
		}
	}

}