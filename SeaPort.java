public class SeaPort extends Port {

    public SeaPort(String portId, String city, Company company) {
        super(portId, city, company);
    }

    public AirPort copy() {
        return new AirPort(getPortId(), getCity(), getCompany());
    }
}