public abstract class Port {

	private String portId;
	private String city;
	private Company company;

	public Port(String portId, String city, Company company) {
		this.portId = portId;
		this.city = city;
		this.company = company;
	}

	public String getPortId() {
		return this.portId;
	}

	/**
	 *
	 * @param portId
	 */
	public void setPortId(String portId) {
		this.portId = portId;
	}

	public String getCity() {
		return this.city;
	}

	/**
	 *
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
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

	public abstract Port copy();

	public void restore(Port port) {
		this.portId = port.portId;
		this.city = port.city;
		this.company = port.company;
	}

}