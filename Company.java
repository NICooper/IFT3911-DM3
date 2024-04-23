public abstract class Company implements ProtoMemento<Company> {

	TravelFactory factory;
	private String companyId;
	private float price;
	protected Type type;

	public Company(String companyId, float price) throws InvalidIdException {
		setCompanyId(companyId);
		setPrice(price);
	}

	public String getCompanyId() {
		return this.companyId;
	}

	/**
	 *
	 * @param companyId
	 */
	public void setCompanyId(String companyId) throws InvalidIdException {
		if (companyId.length() == 6) {
			this.companyId = companyId;
		} else {
			throw new InvalidIdException("Company IDs must be 6 characters long.");
		}
	}

	public float getPrice() {
		return this.price;
	}

	/**
	 *
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public abstract ProtoMemento<Company> copy();

	public void restore(ProtoMemento<Company> memento) {
		if (memento.getClass() == this.getClass()) {
			var company = (Company) memento;
			try {
				setCompanyId(company.companyId);
				setPrice(company.price);
			}
			catch (InvalidIdException e) {
				// This is very unlikely to happen since we are copying valid values.
				throw new RuntimeException(e);
			}
		}
	}
}