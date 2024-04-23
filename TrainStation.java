public class TrainStation extends Port {

    public TrainStation(String portId, String city) throws InvalidIdException {
        super(portId, city);
        type = Type.land;
    }

    public TrainStation copy() {
        try {
            return new TrainStation(getPortId(), getCity());
        }
        catch (InvalidIdException e) {
            return null;
        }
    }
}