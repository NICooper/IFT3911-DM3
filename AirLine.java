public class AirLine extends Company {
    public AirLine(String companyId, float price) throws InvalidIdException {
        super(companyId, price);
    }

    public Company copy() {
        try {
            return new AirLine(this.getCompanyId(), this.getPrice());
        }
        catch (InvalidIdException e) {
            return null;
        }
    }
}