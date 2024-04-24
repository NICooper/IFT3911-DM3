import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("5. Creer une séction\n");
        System.out.println("6. Revenir");

        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> gererCompagnies(travelFactory);
            case 2 -> gererPorts(travelFactory);
            case 3 -> gererRoutes(travelFactory);
            case 4 -> gererEntitesDeVoyage(travelFactory);
            case 5 -> whatSection(travelFactory);
            case 6 -> afficherMenuTypeVoyageAdmin();
            default -> System.out.println("Option invalide !");
        }
    }

    private void whatSection(TravelFactory travelFactory) {
        if (travelFactory instanceof AirFactory){
            createPlaneSection();
        } else if (travelFactory instanceof SeaFactory) {
            //////create the section for the boat
        }
        else {
            /////create the section for the train
        }
    }


    private void createPlaneSection() {
        String vehicleId;
        System.out.println("A quel avion vous voulez ajouter la section");
        vehicleId = scanner.nextLine();
        vehicleId = scanner.nextLine();

        Vehicle vehicle = findVehicle(vehicleId, application.getVehicles());

        if (vehicle instanceof Airplane) {
            System.out.println("Combien de rangees?");
            int rows = scanner.nextInt();

            System.out.println("Repartition?\n");
            System.out.println("1.S\n");
            System.out.println("2.C\n");
            System.out.println("3.M\n");
            System.out.println("4.L\n");

            int rep = scanner.nextInt();
            Repartition repartition = null;
            switch (rep){
                case 1 -> repartition = Repartition.S;
                case 2 -> repartition = Repartition.C;
                case 3 -> repartition = Repartition.M;
                case 4 -> repartition = Repartition.L;
                default -> {
                    System.out.println("Erreur, entree non valide");
                    createPlaneSection();
                }
            }

            System.out.println("Section Type?\n");
            System.out.println("1.F\n");
            System.out.println("2.A\n");
            System.out.println("3.P\n");
            System.out.println("4.E\n");

            int st = scanner.nextInt();
            PlaneSectionType sectionType = null;
            switch (st){
                case 1 -> sectionType = PlaneSectionType.F;
                case 2 -> sectionType = PlaneSectionType.A;
                case 3 -> sectionType = PlaneSectionType.P;
                case 4 -> sectionType = PlaneSectionType.E;
                default -> {
                    System.out.println("Erreur, entree non valide");
                    createPlaneSection();
                }
            }

            admin.setCommand(new CreatePlaneSectionCommand((Airplane) vehicle, rows, repartition, sectionType));
            admin.exec();
        }else {
            System.out.println("Ce n'est pas un airplane");
            createPlaneSection();
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
        String routeId;

        System.out.println("Quel route vous voulez modifier (id)");
        routeId = scanner.nextLine();
        routeId = scanner.nextLine();

        Route route = findRoute(routeId, application.getRoutes());
        if(route != null){
            List<Port> initial = route.getPorts();
            System.out.println("Quel vehicle vous voullez");
            String vehicleId = scanner.nextLine();

            System.out.println("Quelle compagnie vous voullez");
            String companyId = scanner.nextLine();

            Vehicle vehicle = findVehicle(vehicleId, application.getVehicles());
            Company company = findCompany(companyId, application.getCompanies());

            if(vehicle != null && company != null){
                System.out.println("Quel port (ordre dans la liste) vous voulez modifier ?");
                int index = scanner.nextInt();

                System.out.println("Quel port vous voullez mettre a la place");
                String portId = scanner.nextLine();

                Port port = findPort(portId, application.getPorts());

                if(port != null){
                    initial.set(index, port);

                    System.out.print("Temps de depart (format: yyyy-MM-dd HH:mm:ss): ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String input_d = scanner.nextLine();
                    LocalDateTime departureTime = LocalDateTime.parse(input_d, formatter);
                    System.out.print("Temps d'arrivee (format: yyyy-MM-dd HH:mm:ss): ");
                    String input_a = scanner.nextLine();
                    LocalDateTime arrivalTime = LocalDateTime.parse(input_a, formatter);

                    admin.setCommand(new ModifyRouteCommand(application, route, vehicle, company, routeId, initial, arrivalTime, departureTime));
                    admin.exec();
                }
            }
        }
        else{
            System.out.println("Route non dispo");
        }
    }

    private void supprimerRoute(TravelFactory travelFactory) {
        String routeId;
        Route route;

        System.out.println("C'est quoi l'id de la route que vous voulez supprimer?");
        routeId = scanner.nextLine();
        routeId = scanner.nextLine();

        route = findRoute(routeId, application.getRoutes());

        if (route!=null) {
            admin.setCommand(new DeleteRouteCommand(application, route));
            admin.exec();
        }
        else{
            System.out.println("Id de la route n'est pas valide, veuillez choisir une autre route ou en creer une");
            gererPorts(travelFactory);
        }

    }

    private Route findRoute(String routeId, ArrayList<Route> routes) {
        for (int i = 0; i<routes.size(); i++){
            if (routeId.equals(routes.get(i).getId())){
                return routes.get(i);
            }
        }
        return null;
    }

    private void ajouterRoute(TravelFactory travelFactory) {
        String routeId;
        String vehicleId;
        Vehicle vehicle;
        String companyId;
        Company company;
        String portId;
        Port port;
        ArrayList<Port> ports = null;
        LocalDateTime arrivalTime;
        LocalDateTime departureTime;

        System.out.println("Rentrez l'id de la route");
        routeId = scanner.nextLine();
        routeId = scanner.nextLine();

        System.out.println("Rentrez l'id de la vehicule de la route");
        vehicleId = scanner.nextLine();

        vehicle = findVehicle(vehicleId, application.getVehicles());

        if(vehicle != null) {
            System.out.println("Rentrez l'id de la compagnie qui gere la route");
            companyId = scanner.nextLine();

            company = findCompany(companyId, application.getCompanies());

            if(company != null){
                boolean cond = true;
                while (cond) {
                    System.out.println("Rentrez le port id dans l'ordre");
                    portId = scanner.nextLine();
                    port = findPort(portId, application.getPorts());
                    if (port != null){
                        ports.add(port);
                    }
                    else{
                        System.out.println("Port not found");
                    }
                    System.out.println("Si vous voulez vous arreter, cliquer sur 1");
                    int choice = scanner.nextInt();
                    if(choice == 1){cond = false;}
                }

                System.out.print("Temps de depart (format: yyyy-MM-dd HH:mm:ss): ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String input_d = scanner.nextLine();
                departureTime = LocalDateTime.parse(input_d, formatter);
                System.out.print("Temps d'arrivee (format: yyyy-MM-dd HH:mm:ss): ");
                String input_a = scanner.nextLine();
                arrivalTime = LocalDateTime.parse(input_a, formatter);

                admin.setCommand(new CreateRouteCommand(application, travelFactory, vehicle, company, routeId, ports, arrivalTime, departureTime));
                admin.exec();;
            }else {
                System.out.println("compagnie n'existe pas");
                gererRoutes(travelFactory);
            }
        }
        else{
            System.out.println("Vehicule n'existe pas");
            gererRoutes(travelFactory);
        }
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

        System.out.println("C'est quoi l'id de la compagnie que vous voulez supprimer?");
        companyId = scanner.nextLine();
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

