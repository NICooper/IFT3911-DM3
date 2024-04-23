public class SeaPort extends Port {

    public SeaPort(String portId, String city) throws InvalidIdException {
        super(portId, city);
    }

    public SeaPort copy() {
        try {
            return new SeaPort(getPortId(), getCity());
        }
        catch (InvalidIdException e) {
            return null;
        }
    }
}