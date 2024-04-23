public abstract class Company {

	TravelFactory factory;
	private String companyId;
	private float price;

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

	public abstract Company copy();

	public void restore(Company company) throws InvalidIdException {
		setCompanyId(company.companyId);
		setPrice(company.price);
	}
}