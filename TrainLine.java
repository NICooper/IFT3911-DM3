public class TrainLine extends Company {
    public TrainLine(String companyId, Float price) {
        super(companyId, price);
    }

    public Company copy() {
        return new TrainLine(this.getCompanyId(), this.getPrice());
    }
}