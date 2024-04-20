public class BoatSection extends Section {

	private Vehicle vehicle;
	private BoatSectionType sectionType;
	private int cabinNumbers;
	private Float pricePercentage;


	public BoatSection(Vehicle vehicle, Float pricePercentage, BoatSectionType sectionType, int cabinNumber) {
		this.vehicle = vehicle;
		this.pricePercentage = pricePercentage;
		this.sectionType = sectionType;
		this.cabinNumbers = cabinNumber;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public Float getPricePercentage() {
		return pricePercentage;
	}

	public void setPricePercentage(Float pricePercentage) {
		this.pricePercentage = pricePercentage;
	}

	public BoatSectionType getSectionType() {
		return this.sectionType;
	}

	/**
	 * 
	 * @param sectionType
	 */
	public void setSectionType(BoatSectionType sectionType) {
		this.sectionType = sectionType;
	}

	public int getCabinNumbers() {
		return this.cabinNumbers;
	}

	/**
	 * 
	 * @param cabinNumbers
	 */
	public void setCabinNumbers(int cabinNumbers) {
		this.cabinNumbers = cabinNumbers;
	}

	@Override
	public float getSectionPrice() {
		switch(this.sectionType){
			case F :
			case S :
				return (float) (0.9 * getVehicle().getCompany().getPrice());
			case O :
				return (float) (0.75 * getVehicle().getCompany().getPrice());
			case I :
				return (float) (0.5 * getVehicle().getCompany().getPrice());
			default:
				return getVehicle().getCompany().getPrice();
		}
	}
}