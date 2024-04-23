public class CruiseLine extends Company {
    public CruiseLine(String companyId, float price) throws InvalidIdException {
        super(companyId, price);
    }

    public Company copy() {
        try {
            return new CruiseLine(this.getCompanyId(), this.getPrice());
        } catch (InvalidIdException e) {
            return null;
        }
    }
}