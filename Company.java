public abstract class Company {

	TravelFactory factory;
	private String companyId;
	private Float price;

	public Company(String companyId, Float price) {
		this.companyId = companyId;
		this.price = price;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	/**
	 * 
	 * @param companyId
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Float getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	public abstract Company copy();

	public void restore(Company company) {
		this.companyId = company.companyId;
		this.price = company.price;
	}
}