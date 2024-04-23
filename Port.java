public abstract class Port implements ProtoMemento<Port> {

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

	public abstract ProtoMemento<Port> copy();

	public void restore(ProtoMemento<Port> memento) {
		if (memento.getClass() == this.getClass()) {
			var port = (Port) memento;
			try {
				setPortId(port.portId);
				setCity(port.city);
			} catch (InvalidIdException e) {
				// This is very unlikely to happen since we are copying valid values.
				throw new RuntimeException(e);
			}

			}
		}

}