import java.util.ArrayList;
import java.util.List;

public class TrainSection extends Section {

	public TrainSection(int rows, TrainSectionType sectionType) {
		super(rows, sectionType);
	}

	public List<Seat> generateSeats(float price) {
		var columns = getRowOfSeatTypes();
		char colLetter = 'A';

		List<Seat> seats = new ArrayList<>();
		for (var column : columns) {
			for (int rowIdx = 1; rowIdx <= sectionUnitCount; rowIdx++) {
				seats.add(new TrainSeat(rowIdx, String.valueOf(colLetter), column, (TrainSectionType) sectionType, price * getPricePercentage()));
			}
			colLetter++;
		}
		return seats;
	}

	/**
	 * @param sectionType
	 */
	public void setSectionType(TrainSectionType sectionType) {
		this.sectionType = sectionType;
	}

	public float getPricePercentage() {
		return switch ((TrainSectionType)this.sectionType) {
			case E -> 0.5f;
			default -> 1.0f;
		};
	}

	private ColumnSeatType[] getRowOfSeatTypes() {
		return new ColumnSeatType[]{
					ColumnSeatType.Both,
					ColumnSeatType.Aisle, ColumnSeatType.Window
		};
	}

	@Override
	public ProtoMemento<Section> copy() {
		return new TrainSection(getSectionUnitCount(), (TrainSectionType) sectionType);
	}
}