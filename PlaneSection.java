import java.util.ArrayList;
import java.util.List;

public class PlaneSection extends Section {
	private Repartition repartition;

	public PlaneSection(int rows, PlaneSectionType sectionType, Repartition repartition) {
		super(rows, sectionType);
		this.repartition = repartition;
	}

	public PlaneSection(int rows, PlaneSectionType sectionType) {
		this(rows, sectionType, Repartition.S);
	}

	public Repartition getRepartition() {
		return this.repartition;
	}

	/**
	 * 
	 * @param repartition
	 */
	public void setRepartition(Repartition repartition) {
		this.repartition = repartition;
	}

	@Override
	public List<Seat> generateSeats(float price) {
		var columns = getRowOfSeatTypes();
		char colLetter = 'A';

		List<Seat> seats = new ArrayList<>();
		for (var column : columns) {
			for (int rowIdx = 1; rowIdx <= sectionUnitCount; rowIdx++) {
				seats.add(new PlaneSeat(rowIdx, String.valueOf(colLetter), column, (PlaneSectionType) sectionType, price * getPricePercentage()));
			}
			colLetter++;
		}
		return seats;
	}

	public float getPricePercentage() {
		return switch ((PlaneSectionType)this.sectionType) {
			case A -> 0.75f;
			case P -> 0.6f;
			case E -> 0.5f;
			default -> 1.0f;
		};
	}

	private ColumnSeatType[] getRowOfSeatTypes() {
		return switch (this.repartition) {
			case L -> new ColumnSeatType[]{
					ColumnSeatType.Window, ColumnSeatType.Neither, ColumnSeatType.Aisle,
					ColumnSeatType.Aisle, ColumnSeatType.Neither, ColumnSeatType.Neither, ColumnSeatType.Aisle,
					ColumnSeatType.Aisle, ColumnSeatType.Neither, ColumnSeatType.Window
			};
			case M -> new ColumnSeatType[]{
					ColumnSeatType.Window, ColumnSeatType.Neither, ColumnSeatType.Aisle,
					ColumnSeatType.Aisle, ColumnSeatType.Neither, ColumnSeatType.Window
			};
			case C -> new ColumnSeatType[]{
					ColumnSeatType.Window, ColumnSeatType.Aisle,
					ColumnSeatType.Aisle, ColumnSeatType.Window
			};
			default -> new ColumnSeatType[]{
					ColumnSeatType.Both,
					ColumnSeatType.Aisle, ColumnSeatType.Window
			};
		};
	}

	@Override
	public ProtoMemento<Section> copy() {
		return new PlaneSection(getSectionUnitCount(), (PlaneSectionType) sectionType, repartition);
	}

	@Override
	public void restore(ProtoMemento<Section> memento) {
		super.restore(memento);
		setRepartition(((PlaneSection)memento).getRepartition());
	}
}