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
            //case 2 -> afficherMenuClient();
            case 0 -> {
                System.out.println("Au revoir !");
                System.exit(0);
            }
            default -> System.out.println("Option invalide !");
        }
    }

    //TODO : Avant d'afficher le menu admin je suggere qu'on fait un menu qui decide le type, genre Sea, Air ou Train
    // comme ca ca serait plus facil, dans l'example que je te donne en bas je suppose qu'on choisit Air
    public void afficherMenuAdmin() {
        System.out.println("Menu Administratif :\n");
        System.out.println("1. Gérer les entités de voyage\n");
        System.out.println("2. Gérer les prix des sièges ou cabines\n");
        System.out.println("3. Consulter les vols, itinéraires ou trajets\n");
        //TODO : Reculer en arriere doit etre possible

        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> gererEntitesDeVoyage();
            //case 2 -> admin.gererPrixDesSiegesOuCabines();
            //case 3 -> admin.consulterVolsItinerairesTrajets();
            default -> System.out.println("Option invalide !");
        }
    }

    private void gererEntitesDeVoyage() {
        System.out.println("Menu de gestion des entites de voyages\n");
        System.out.println("1. Ajouter une vehicule\n");
        System.out.println("2. Delete une vehicule\n");
        System.out.println("3. Modifier une vehicule\n");

        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> passerParametresAvions();

        }
    }

    private void passerParametresAvions() {
        String id;
        String model;
        Company company = null;
        System.out.println("Rentrez l'id que vous vouler\n");
        id = scanner.nextLine();
        id = scanner.nextLine();
        System.out.println("id is" + id);
        System.out.println("Rentrez le model que vous vouler\n");
        model = scanner.nextLine();
        String companyId;
        System.out.println("Rentrez l'id de la compagnie que vous vouler\n");
        companyId = scanner.nextLine();
        boolean found = false;
        for (int i = 0 ; i < application.getCompanies().size(); i++){
            if(application.getCompanies().get(i).getCompanyId().equals(companyId)){
                company = application.getCompanies().get(i);
                found = true;
            }
        }
        if(!found){
            System.out.println("SORRY BYE");
            gererEntitesDeVoyage();
        }
        else{
            admin.setCommand(new CreateVehicleCommand(this.application, AirFactory.getInstance() ,id, model, company));
            admin.exec();
            System.out.println("Ajouter avec succes");
        }

    }



    /*
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
        */
        // autres..

    public static void main (String[]args){
            Menus menus = new Menus();
            while (true) {
                menus.afficherMenuPrincipal();
            }
        }
    }


