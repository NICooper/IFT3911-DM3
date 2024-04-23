import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public abstract class Route implements IVisitable, ProtoMemento<Route> {

	protected Vehicle vehicle;
	protected LocalDateTime departureTime;
	protected LocalDateTime arrivalTime;
	protected String id;
	protected Duration duration;
	protected Company company;
	protected List<Port> ports;

	public Route(Vehicle vehicle, Company company, String id, List<Port> ports, LocalDateTime departureTime, LocalDateTime arrivalTime) throws InvalidPortsException, InvalidTimeException {
		setVehicle(vehicle);
		setCompany(company);
		setId(id);
		setDepartureAndArrivalTime(departureTime, arrivalTime);
		setPorts(ports);
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Port getDeparturePort() {
		return ports.get(0);
	}

	public Port getArrivalPort() {
		return ports.get(ports.size() - 1);
	}

	public List<Port> getIntermediaryPorts() {
		return ports.subList(1, ports.size() - 1);
	}

	public void setPorts(List<Port> ports) throws InvalidPortsException {
		if (ports.size() < 2) {
			throw new InvalidPortsException("At least two ports are required.");
		} else {
			this.ports = ports;
		}
	}

	public LocalDateTime getDepartureTime() {
		return this.departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return this.arrivalTime;
	}

	/**
	 *
	 * @param departureTime
	 */
	public void setDepartureAndArrivalTime(LocalDateTime departureTime, LocalDateTime arrivalTime) throws InvalidTimeException {
		if (departureTime != null && arrivalTime != null) {
			this.departureTime = departureTime;
			this.arrivalTime = arrivalTime;
			updateDurationHours();
		}
		else {
			throw new InvalidTimeException("");
		}
	}

	public Duration getDuration() {
		return this.duration;
	}

	private void updateDurationHours() {
		if (departureTime != null && arrivalTime != null) {
			duration = Duration.between(departureTime, arrivalTime);
		}
	}

	public Company getCompany() {
		return this.company;
	}

	/**
	 *
	 * @param company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	public String getId() {
		return this.id;
	}

	/**
	 *
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public abstract ProtoMemento<Route> copy();

	public void restore(ProtoMemento<Route> memento) {
		if (memento.getClass() == this.getClass()) {
			var route = (Route) memento;
			try {
				setVehicle(route.vehicle);
				setCompany(route.company);
				setId(route.id);
				setDepartureAndArrivalTime(departureTime, arrivalTime);
				setPorts(route.ports);
			} catch (InvalidTimeException | InvalidPortsException e) {
				// This is very unlikely to happen since we are copying valid values.
				throw new RuntimeException(e);
			}

		}
	}

	/**
	 *
	 * @param v
	 */
	public abstract void accept(Visitor v);

}