public class BoatSection extends Section {

	private BoatSectionType sectionType;
	private int cabinNumbers;

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

}