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
            case 1 -> afficherMenuAdmin();
            case 2 -> afficherMenuClient();
            case 0 -> {
                System.out.println("Au revoir !");
                System.exit(0);
            }
            default -> System.out.println("Option invalide !");
        }
    }
    public void afficherMenuTypeVoyage() {
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

    //TODO : Avant d'afficher le menu admin je suggere qu'on fait un menu qui decide le type, genre Sea, Air ou Train
    // comme ca ca serait plus facil, dans l'example que je te donne en bas je suppose qu'on choisit Air
    public void afficherMenuAdmin(TravelFactory travelFactory) {
        System.out.println("Menu Administratif :\n");
        System.out.println("1. Gérer les entités de voyage\n");
        System.out.println("2. Gérer les prix des sièges ou cabines\n");
        System.out.println("3. Consulter les vols, itinéraires ou trajets\n");
        //TODO : Reculer en arriere doit etre possible
    
        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> gererEntitesDeVoyage(travelFactory);
            case 2 -> admin.gererPrixDesSiegesOuCabines();
            case 3 -> admin.consulterVolsItinerairesTrajets();
            default -> System.out.println("Option invalide !");
        }
    }
    
    private void ajouterVehicule(TravelFactory travelFactory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ajouter un véhicule :\n");
    
        System.out.print("Entrez l'ID du véhicule : ");
        String id = scanner.nextLine();
    
        System.out.print("Entrez le modèle du véhicule : ");
        String model = scanner.nextLine();
    
        System.out.print("Entrez l'ID de la compagnie associée : ");
        String companyId = scanner.nextLine();
    
        Company company_to_get_vehicle = null;
        boolean found = false;
        for (int i = 0; i < application.getCompanies().size(); i++) {
            if (application.getCompanies().get(i).getCompanyId().equals(companyId)) {
                company_to_get_vehicle = application.getCompanies().get(i);
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("La compagnie avec l'ID fourni n'existe pas.");
            return;
        }
    
        // Création du véhicule en utilisant le TravelFactory
        Vehicle vehicle = travelFactory.createVehicle(id, model, company_to_get_vehicle);
        if (vehicle != null) {
            System.out.println("Véhicule ajouté avec succès !");
        } else {
            System.out.println("Échec de l'ajout du véhicule.");
        }
    }
    
    private void supprimerVehicule(TravelFactory travelFactory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Supprimer un véhicule :\n");
    
        System.out.print("Entrez l'ID du véhicule à supprimer : ");
        String id = scanner.nextLine();
    
        // Recherche du véhicule dans la liste des véhicules
        Vehicle vehicleToDelete = null;
        for (Vehicle vehicle : travelFactory.getVehicle()) {
            if (vehicle.getVehicleId().equals(id)) {
                vehicleToDelete = vehicle;
                break;
            }
        }
    
        if (vehicleToDelete == null) {
            System.out.println("Le véhicule avec l'ID fourni n'existe pas.");
            return;
        }
    
        // Création de la commande pour supprimer le véhicule
        Command deleteCommand = new DeleteVehicleCommand(application, vehicleToDelete);
    
        // Affectation de la commande à l'administrateur et exécution
        admin.setCommand(deleteCommand);
        admin.exec();
    }
    
    
    
    
    private void gererEntitesDeVoyage(TravelFactory travelFactory) {
        System.out.println("Menu de gestion des entites de voyages\n");
        System.out.println("1. Ajouter un véhicule\n");
        System.out.println("2. Supprimer un véhicule\n");
        System.out.println("3. Modifier un véhicule\n");

        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> passerParametresVehicule(travelFactory);
            case 2 -> supprimerVehicule(travelFactory);
            case 3 -> modifierVehicule(travelFactory);
            default -> System.out.println("Option invalide !");
        }
    }

   



    public void afficherMenuClient () {
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

        // autres..

    public static void main (String[]args){
            Menus menus = new Menus();
            while (true) {
                menus.afficherMenuPrincipal();
            }
        }
    }

