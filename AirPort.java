public class AirPort extends Port {

    public AirPort(String portId, String city, Company company) {
        super(portId, city, company);
    }

    public AirPort copy() {
        return new AirPort(getPortId(), getCity(), getCompany());
    }
}