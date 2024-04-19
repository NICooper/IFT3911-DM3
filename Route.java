public abstract class Route {

	Vehicle vehicle;
	private Date departureDate;
	private Date arrivalDate;
	private Type type;
	private String id;
	private Float durationHours;
	private Company company;

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

	protected abstract void show();

}