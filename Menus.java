import java.util.Scanner;

public class Menus {
    private Administrator admin;
    private Client client;
    private Scanner scanner;

    public Menus() {
        // Initialize instances of Administrator and Client
        admin = new Administrator();
        client = new Client();
        scanner = new Scanner(System.in);
    }

    public void afficherMenuPrincipal() {
        System.out.println("Bienvenue dans le système de gestion de réservation de voyages.");
        System.out.println("1. Volet administratif");
        System.out.println("2. Volet client");
        System.out.println("0. Quitter");
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

    public void afficherMenuAdmin() {
        System.out.println("Menu Administratif :");
        System.out.println("1. Gérer les entités de voyage");
        System.out.println("2. Gérer les prix des sièges ou cabines");
        System.out.println("3. Consulter les vols, itinéraires ou trajets");

        int choix = scanner.nextInt();
        switch (choix) {
            case 1 -> admin.gererEntitesDeVoyage();
            case 2 -> admin.gererPrixDesSiegesOuCabines();
            case 3 -> admin.consulterVolsItinerairesTrajets();
            default -> System.out.println("Option invalide !");
        }
    }

    public void afficherMenuClient() {
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

    public static void main(String[] args) {
        Menus menus = new Menus();
        while (true) {
            menus.afficherMenuPrincipal();
        }
    }
}
