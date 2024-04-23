public class AirPort extends Port {

    public AirPort(String portId, String city) throws InvalidIdException {
        super(portId, city);
    }

    public AirPort copy() {
        try {
            return new AirPort(getPortId(), getCity());
        }
        catch (InvalidIdException e) {
            return null;
        }
    }
}