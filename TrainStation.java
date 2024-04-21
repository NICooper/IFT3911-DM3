public class TrainStation extends Port {

    public TrainStation(String portId, String city, Company company) {
        super(portId, city, company);
    }

    public AirPort copy() {
        return new AirPort(getPortId(), getCity(), getCompany());
    }
}