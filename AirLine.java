public class AirLine extends Company {
    public AirLine(String companyId, Float price) {
        super(companyId, price);
    }

    public Company copy() {
        return new AirLine(this.getCompanyId(), this.getPrice());
    }
}