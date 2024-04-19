import Subject.*;
import java.util.*;

public class Application implements attach, ApplicationGetters, Subject {

	Collection<Administrator> admins;
	Collection<Port> ports;
	Collection<Company> companies;
	Collection<Route> routes;
	Collection<Reservation> reservations;

}