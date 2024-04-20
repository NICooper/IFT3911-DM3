import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public abstract class Route {

	Vehicle vehicle;
	private Date departureDate;
	private Date arrivalDate;
	private Type type;
	private String id;
	private float durationHours;
	private Company company;
	private Port departurePort;
	private Port arrivalPort;
	private ArrayList<Port> intermidaryPorts;
	private Time departureTime;
	private Time arrivalTime;

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Port getDeparturePort() {
		return departurePort;
	}

	public void setDeparturePort(Port departurePort) {
		this.departurePort = departurePort;
	}

	public Port getArrivalPort() {
		return arrivalPort;
	}

	public void setArrivalPort(Port arrivalPort) {
		this.arrivalPort = arrivalPort;
	}

	public Date getDepartureDate() {
		return this.departureDate;
	}

	/**
	 * 
	 * @param departureDate
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return this.arrivalDate;
	}

	/**
	 * 
	 * @param arrivalDate
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Type getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
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

	public Float getDurationHours() {
		return this.durationHours;
	}

	/**
	 * 
	 * @param durationHours
	 */
	public void setDurationHours(Float durationHours) {
		this.durationHours = durationHours;
	}

}