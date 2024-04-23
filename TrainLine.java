public class TrainLine extends Company {
    public TrainLine(String companyId, float price) throws InvalidIdException {
        super(companyId, price);
    }

    public TrainLine copy() {
        try {
            return new TrainLine(this.getCompanyId(), this.getPrice());
        }
        catch (InvalidIdException e) {
            return null;
        }
    }
}