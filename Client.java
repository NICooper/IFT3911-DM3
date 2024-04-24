import java.util.ArrayList;
import java.util.Date;

public class Client implements ClientRouteVerification, Observer<ApplicationGetters>, ClientReservation {

    private String firstName;
    private String lastName;
    private String email;
    private String passportNumber;
    private Reservation reservation;
    private Seat seat;
    private ClientView clientView;

    /*public Client(String firstName, String lastName, String email, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passportNumber = passportNumber;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public ClientView getClientView() {
        return clientView;
    }

    public void setClientView(ClientView clientView) {
        this.clientView = clientView;
    }

    @Override
    public Reservation reserveSiege(Type type, boolean isWindow, Seat seat, boolean isNaval) {
        /*
        // Implémentation de la réservation d'un siège ou d'une cabine
        if (seat.isAvailable()) {
            Reservation reservation = new Reservation();
            reservation.setSeat(seat);
            reservation.setClient(this);
            this.reservation = reservation;
            seat.setReserved(true);
            return reservation;
        } else {
            System.out.println("Ce siège est déjà réservé. Veuillez en choisir un autre.");
            return null;
        }
        */
        return null;
    }

    @Override
    public boolean pay(String reservationNumber, String firstName, String lastName, String email, String passportNumber) {
        // implementation du paiement d'une réservation
        /*
        if (this.reservation != null && this.reservation.getReservationNumber().equals(reservationNumber) &&
                this.firstName.equals(firstName) && this.lastName.equals(lastName) &&
                this.email.equals(email) && this.passportNumber.equals(passportNumber)) {
            PaymentAuthorization paymentAuthorization = new PaymentAuthorization();
            return paymentAuthorization.authorizePayment(reservation.getSeat().getPrice());
        } else {
            System.out.println("Les informations fournies ne correspondent pas à la réservation.");
            return false;
        }
         */
        return true;
    }

    @Override
    public void verifyRoutes(Port portDeparture, Port portArrival, Section section, Date date, Type type) {
        // todo : vérifier les itinéraires
        System.out.println("Vérification des itinéraires en cours...");
        // ..
    }

    @Override
    public void update(ApplicationGetters object) {
        // todo  mise à jour des nouvelles
        System.out.println("Nouvelles mises à jour !");
    }

    public void seatEvent() {
        // pas trop compris ça.. 
		throw new UnsupportedOperationException();
    }
}
