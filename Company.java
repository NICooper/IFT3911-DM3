public abstract class Company {

	TravelFactory factory;
	private String companyId;
	private Float price;

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

}