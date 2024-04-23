public class TrainSeat extends Seat {
    private final ColumnSeatType columnSeatType;
    private final TrainSectionType sectionType;

    public TrainSeat(int rowNumber, String columnLetter, ColumnSeatType columnSeatType, TrainSectionType sectionType, float price) {
        super(sectionType.name() + rowNumber + columnLetter, sectionType, price);
        this.columnSeatType = columnSeatType;
        this.sectionType = sectionType;
    }

    public TrainSectionType getSectionType() {
        return sectionType;
    }

    public ColumnSeatType getColumnSeatType() {
        return columnSeatType;
    }
}