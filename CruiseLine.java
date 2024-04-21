public class CruiseLine extends Company {
    public CruiseLine(String companyId, Float price) {
        super(companyId, price);
    }

    public Company copy() {
        return new CruiseLine(this.getCompanyId(), this.getPrice());
    }
}