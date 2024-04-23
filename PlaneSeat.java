public class PlaneSeat extends Seat {
    private final ColumnSeatType columnSeatType;
    private final PlaneSectionType sectionType;

    public PlaneSeat(int rowNumber, String columnLetter, ColumnSeatType columnSeatType, PlaneSectionType sectionType, float price) {
        super(sectionType.name() + rowNumber + columnLetter, sectionType, price);
        this.columnSeatType = columnSeatType;
        this.sectionType = sectionType;
    }

    public PlaneSectionType getSectionType() {
        return sectionType;
    }

    public ColumnSeatType getColumnSeatType() {
        return columnSeatType;
    }
}