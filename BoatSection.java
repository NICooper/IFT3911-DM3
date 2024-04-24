import java.util.ArrayList;
import java.util.List;

public class BoatSection extends Section {

	public BoatSection(int cabinCount, BoatSectionType sectionType) {
		super(cabinCount, sectionType);
	}

	public BoatSectionType getSectionType() {
		return (BoatSectionType) this.sectionType;
	}

	/**
	 * 
	 * @param sectionType
	 */
	public void setSectionType(BoatSectionType sectionType) {
		this.sectionType = sectionType;
	}

	@Override
	public List<Seat> generateSeats(float price) {
		List<Seat> seats = new ArrayList<>();
		for (int i = 1; i <= sectionUnitCount; i++) {
			seats.add(new BoatSeat(i, (BoatSectionType) sectionType, price * getPricePercentage()));
		}
		return seats;
	}

	public float getPricePercentage() {
		return switch ((BoatSectionType)this.sectionType) {
			case F, S -> 0.9f;
			case O -> 0.75f;
			case I -> 0.5f;
			default -> 1.0f;
		};
	}

	@Override
	public ProtoMemento<Section> copy() {
		return new BoatSection(getSectionUnitCount(), (BoatSectionType) sectionType);
	}
}