public class CruiseLine extends Company {
    public CruiseLine(String companyId, float price) throws InvalidIdException {
        super(companyId, price);
        type = Type.naval;
    }

    public CruiseLine copy() {
        try {
            return new CruiseLine(this.getCompanyId(), this.getPrice());
        } catch (InvalidIdException e) {
            return null;
        }
    }
}