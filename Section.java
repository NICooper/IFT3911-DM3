import java.util.List;

public abstract class Section {
	protected int sectionUnitCount;
	protected SectionType sectionType;

	public Section(int sectionUnitCount, SectionType sectionType) {
		this.sectionUnitCount = sectionUnitCount;
		this.sectionType = sectionType;
	}

	public void setSectionUnitCount(int sectionUnitCount) {
		this.sectionUnitCount = sectionUnitCount;
	}

	public int getSectionUnitCount() {
		return sectionUnitCount;
	}

	public abstract List<Seat> generateSeats(float price);

	public abstract float getPricePercentage();

}