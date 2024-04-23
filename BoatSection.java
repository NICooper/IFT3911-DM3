public class BoatSection extends Section {

	private Vehicle vehicle;
	private BoatSectionType sectionType;


	public BoatSection(Vehicle vehicle, BoatSectionType sectionType, int placeCount) {
		this.vehicle = vehicle;
		this.sectionType = sectionType;
		this.placeCount = placeCount;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public BoatSectionType getSectionType() {
		return this.sectionType;
	}

	public void setPlaceCount(int placeCount) {
		this.placeCount = placeCount;
	}

	/**
	 * 
	 * @param sectionType
	 */
	public void setSectionType(BoatSectionType sectionType) {
		this.sectionType = sectionType;
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