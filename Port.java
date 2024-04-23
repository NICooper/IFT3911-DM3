public abstract class Port {

	private String portId;
	private String city;

	public Port(String portId, String city) throws InvalidIdException {
		setPortId(portId);
		setCity(city);
	}

	public String getPortId() {
		return this.portId;
	}

	/**
	 *
	 * @param portId
	 */
	public void setPortId(String portId) throws InvalidIdException {
		if (portId.trim().length() != 3) {
			throw new InvalidIdException("A port's ID must be exactly 3 characters long.");
		}
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

	public abstract Port copy();

	public void restore(Port port) throws InvalidIdException {
		setPortId(port.portId);
		setCity(port.city);
	}

}