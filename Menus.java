import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Menus {
    private Administrator admin;
    private Client client;
    private Scanner scanner;
    private Application application;


    public Menus() {
        // initialistion des instances
        admin = new Administrator();
        client = new Client();
        application = new Application();
        scanner = new Scanner(System.in);
    }

    public void afficherMenuPrincipal() {
        System.out.println("Bienvenue dans le système de gestion de réservation de voyages.\n");
        System.out.println("1. Volet administratif\n");
        System.out.println("2. Volet client\n");
        System.out.println("0. Quitter\n");
        System.out.print("Choisissez une option : ");
        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> afficherMenuTypeVoyageAdmin();
            //case 2 -> afficherMenuClient();
            case 0 -> {
                System.out.println("Au revoir !");
                System.exit(0);
            }
            default -> System.out.println("Option invalide !");
        }
    }
    public void afficherMenuTypeVoyageAdmin() {
        System.out.println("Sélectionnez le type de voyage :\n");
        System.out.println("1. Voyage aérien\n");
        System.out.println("2. Voyage naval\n");
        System.out.println("3. Voyage ferroviaire\n");
        System.out.print("Choisissez une option : ");
        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> afficherMenuAdmin(AirFactory.getInstance());
            case 2 -> afficherMenuAdmin(SeaFactory.getInstance());
            case 3 -> afficherMenuAdmin(TrainFactory.getInstance());
            default -> System.out.println("Option invalide !");
        }
    }

    public void afficherMenuAdmin(TravelFactory travelFactory) {
        System.out.println("Menu Administratif :\n");
        System.out.println("1. Gérer les compagnies\n");
        System.out.println("2. Gérer les ports\n");
        System.out.println("3. Gérer les routes\n");
        System.out.println("4. Gérer les véhicules\n");
        System.out.println("5. Gérer les séctions\n");
        System.out.println("6. Revenir");

        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> gererCompagnies(travelFactory);
            case 2 -> gererPorts(travelFactory);
            case 3 -> gererRoutes(travelFactory);
            case 4 -> gererEntitesDeVoyage(travelFactory);
            //case 5 -> ;
            case 6 -> afficherMenuTypeVoyageAdmin();
            default -> System.out.println("Option invalide !");
        }
    }

    private void gererRoutes(TravelFactory travelFactory) {
        System.out.println("Menu de gestion des routes :\n");
        System.out.println("1. Ajouter une route\n");
        System.out.println("2. Supprimer une route\n");
        System.out.println("3. Modifier une route\n");
        System.out.println("4. Revenir");

        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> ajouterRoute(travelFactory);
            case 2 -> supprimerRoute(travelFactory);
            case 3 -> modifierRoute(travelFactory);
            case 4 -> afficherMenuAdmin(travelFactory);
            default -> System.out.println("Option invalide !");
        }
    }

    private void modifierRoute(TravelFactory travelFactory) {
    }

    private void supprimerRoute(TravelFactory travelFactory) {
    }

    private void ajouterRoute(TravelFactory travelFactory) {
        String routeId;
        String VehicleId;
        Vehicle vehicle;
        String CompanyId;
        Company company;
        ArrayList<Port> ports;
        LocalDateTime arrivalTime;
        LocalDateTime departureTime;


    }

    private void gererPorts(TravelFactory travelFactory) {
        System.out.println("Menu de gestion des ports :\n");
        System.out.println("1. Ajouter un port\n");
        System.out.println("2. Supprimer un port\n");
        System.out.println("3. Modifier un port\n");
        System.out.println("4. Revenir");

        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> ajouterPort(travelFactory);
            case 2 -> supprimerPort(travelFactory);
            case 3 -> modifierPort(travelFactory);
            case 4 -> afficherMenuAdmin(travelFactory);
            default -> System.out.println("Option invalide !");
        }
    }

    private void modifierPort(TravelFactory travelFactory) {
        String portId;
        String city;
        Port port;

        System.out.println("C'est quoi l'Id du port que vous voulez modifier");
        portId = scanner.nextLine();

        port = findPort(portId, application.getPorts());

        if(port != null){
            System.out.println("Choisissez la cite que vous voulez ?");
            city = scanner.nextLine();

            admin.setCommand(new ModifyPortCommand(application, port, portId, city));
            admin.exec();
        }
        else{
            System.out.println("Id du port n'est pas valide, veuillez choisir un autre port ou en creer une");
            gererPorts(travelFactory);
        }
    }

    private void supprimerPort(TravelFactory travelFactory) {
        String portId;
        Port port;

        System.out.println("C'est quoi l'id du port que vous voulez supprimer?");
        portId = scanner.nextLine();

        port = findPort(portId, application.getPorts());

        if (port!=null) {
            admin.setCommand(new DeletePortCommand(port, application));
            admin.exec();
        }
        else{
            System.out.println("Id du port n'est pas valide, veuillez choisir un autre port ou en creer une");
            gererPorts(travelFactory);
        }
    }

    private void ajouterPort(TravelFactory travelFactory) {
        String portId;
        String city;

        System.out.println("Choisissez un id pour votre port?");
        portId = scanner.nextLine();

        System.out.println("Dans quel city il se situe?");
        city = scanner.nextLine();

        Port port = findPort(portId, application.getPorts());

        if(port == null){
            admin.setCommand(new CreatePortCommand(application, travelFactory, portId, city));
            admin.exec();
        }
        else{
            System.out.println("Il existe deja un port avec cet Id, choisissez une autre svp");
            ajouterPort(travelFactory);
        }
    }

    private Port findPort(String portId, ArrayList<Port> ports) {
        for (int i = 0; i<ports.size(); i++){
            if (portId.equals(ports.get(i).getPortId())){
                return ports.get(i);
            }
        }
        return null;
    }

    private void gererCompagnies(TravelFactory travelFactory) {
        System.out.println("Menu de gestion des compagnies :\n");
        System.out.println("1. Ajouter une compagnie\n");
        System.out.println("2. Supprimer une compagnie\n");
        System.out.println("3. Modifier une compagnie\n");
        System.out.println("4. Revenir");

        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> ajouterCompagnie(travelFactory);
            case 2 -> supprimerCompagnie(travelFactory);
            case 3 -> modifierCompagnie(travelFactory);
            case 4 -> afficherMenuAdmin(travelFactory);
            default -> System.out.println("Option invalide !");
        }

    }

    private void modifierCompagnie(TravelFactory travelFactory) {
        String companyId;
        float price;
        Company company;

        System.out.println("C'est quoi l'Id de la compagnie que vous voulez modifier");
        companyId = scanner.nextLine();

        company = findCompany(companyId, application.getCompanies());

        if(company != null){
            System.out.println("Choisissez le prix que vous voulez ?");
            price = scanner.nextFloat();

            admin.setCommand(new ModifyCompanyCommand(application, company, companyId, price));
            admin.exec();
        }
        else{
            System.out.println("Id de la compagnie n'est pas valide, veuillez choisir une autre compagnie ou en creer une");
            gererCompagnies(travelFactory);
        }
    }

    private void supprimerCompagnie(TravelFactory travelFactory) {
        String companyId;
        Company company;

        System.out.println("C'est quoi l'id de la vehicule que vous voulez supprimer?");
        companyId = scanner.nextLine();

        company = findCompany(companyId, application.getCompanies());

        if (company!=null) {
            admin.setCommand(new DeleteCompanyCommand(company, application));
            admin.exec();
        }
        else{
            System.out.println("Id de la compagnie n'est pas valide, veuillez choisir une autre vehicle ou en creer une");
            gererCompagnies(travelFactory);
        }
    }

    private void ajouterCompagnie(TravelFactory travelFactory) {
        String companyId;
        float price;

        System.out.println("Choisissez un id pour votre compagnie");
        companyId = scanner.nextLine();

        System.out.println("Quel est le prix?");
        price = scanner.nextFloat();

        Company company = findCompany(companyId, application.getCompanies());
        
        if (company == null) {
            admin.setCommand(new CreateCompanyCommand(application, travelFactory, companyId, price));
            admin.exec();
        }
        else{
            System.out.println("Il existe deja une compagnie avec cet Id, choisissez une autre svp");
            ajouterCompagnie(travelFactory);
        }
    }

    private void gererEntitesDeVoyage(TravelFactory travelFactory) {
        System.out.println("Menu de gestion des entités de voyages :\n");
        System.out.println("1. Ajouter une véhicule\n");
        System.out.println("2. Supprimer une véhicule\n");
        System.out.println("3. Modifier une véhicule\n");
        System.out.println("4. Revenir");


        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> ajouterVehicule(travelFactory);
            case 2 -> supprimerVehicule(travelFactory);
            case 3 -> modifierVehicule(travelFactory);
            case 4 -> afficherMenuAdmin(travelFactory);
            default -> System.out.println("Option invalide !");
        }
    }

    private void modifierVehicule(TravelFactory travelFactory) {
        String vehicleId;
        Vehicle vehicle;
        String model;
        String companyId;
        Company company;

        System.out.println("C'est quoi la vehicule que vous voulez modifier?");
        vehicleId = scanner.nextLine();

        vehicle = findVehicle(vehicleId, application.getVehicles());

        if (vehicle!=null) {

            System.out.println("C'est quoi le modele de la vehicule apres modification?");
            model = scanner.nextLine();

            System.out.println("C'est quoi l'id de la compagnie de la vehicule apres modification?");
            companyId = scanner.nextLine();

            company = findCompany(companyId, application.getCompanies());

            if (company!=null) {
                admin.setCommand(new ModifyVehicleCommand(application, vehicle, vehicleId, model, company));
                admin.exec();
            }
            else{
                System.out.println("Id de la compagnie n'est pas valide, veuillez choisir une autre compagnie ou en creer une");
                gererEntitesDeVoyage(travelFactory);
            }
        }
        else{
            System.out.println("Id de la vehicle n'est pas valide, veuillez choisir une autre vehicle ou en creer une");
            gererEntitesDeVoyage(travelFactory);
        }
    }

    private void supprimerVehicule(TravelFactory travelFactory) {
        String vehicleId;
        Vehicle vehicle;

        System.out.println("C'est quoi la vehicule que vous voulez supprimer?");
        vehicleId = scanner.nextLine();

        vehicle = findVehicle(vehicleId, application.getVehicles());

        if (vehicle!=null) {
            admin.setCommand(new DeleteVehicleCommand(application, vehicle));
            admin.exec();
        }
        else{
            System.out.println("Id de la vehicle n'est pas valide, veuillez choisir une autre vehicle ou en creer une");
            gererEntitesDeVoyage(travelFactory);
        }
    }

    private Vehicle findVehicle(String vehicleId, ArrayList<Vehicle> vehicles) {
        for (int i = 0; i<vehicles.size(); i++){
            if (vehicleId.equals(vehicles.get(i).getVehicleId())){
                return vehicles.get(i);
            }
        }
        return null;
    }

    private void ajouterVehicule(TravelFactory travelFactory) {
        String id;
        String model;
        String company_id;
        Company company;

        System.out.println("Choisissez l'Id de la vehicule a ajouter");
        id = scanner.nextLine();

        System.out.println("Choisissez le modele de la vehicule a ajouter");
        model = scanner.nextLine();

        System.out.println("C'est quoi l'id de la compagnie a laquelle vous desirez ajouter la vehicule");
        company_id = scanner.nextLine();

        company = findCompany(company_id, application.getCompanies());

        if (company!=null) {
            admin.setCommand(new CreateVehicleCommand(application, travelFactory, id, model, company));
            admin.exec();
        }
        else{
            System.out.println("Id de la compagnie n'est pas valide, veuillez choisir une autre compagnie ou en creer une");
            gererEntitesDeVoyage(travelFactory);
        }
    }

    private Company findCompany(String companyId, ArrayList<Company> companies) {
        for (int i = 0; i<companies.size(); i++){
            if (companyId.equals(companies.get(i).getCompanyId())){
                return companies.get(i);
            }
        }
        return null;
    }


    /*public void afficherMenuClient () {
            System.out.println("Menu Client :");
            System.out.println("1. Rechercher des vols, itinéraires ou trajets");
            System.out.println("2. Réserver un siège ou une cabine");
            System.out.println("3. Payer une réservation");

            int choix = scanner.nextInt();
            switch (choix) {
                case 1 -> client.rechercherVolsItinerairesTrajets();
                case 2 -> client.reserveSiege();
                case 3 -> client.pay();
                default -> System.out.println("Option invalide !");
            }
        }
        */
        // autres..
    
    public static void main (String[]args){
            Menus menus = new Menus();
            while (true) {
                menus.afficherMenuPrincipal();
            }
        }
    }

