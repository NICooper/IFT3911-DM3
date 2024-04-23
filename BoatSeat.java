public class BoatSeat extends Seat {
    private int number;
    private BoatSectionType sectionType;

    public BoatSeat(int cabinNumber, BoatSectionType sectionType, float price) {
        super(sectionType.name() + cabinNumber, sectionType, price);
        this.number = cabinNumber;
        this.sectionType = sectionType;
    }
}