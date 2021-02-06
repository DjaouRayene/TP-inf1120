import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

/**
 * INF1120
 *
 * Facturation Renovation-Pour-Tous: permet de calculer la facture de
 * l'installation d'un plancher sur une surface donnée selon le prix par pied
 * carré et le type de plancher
 *
 * @author Saliou Cisse
 * @version 12-10-2020
 * 
 * CISS0101010 
 * cisse.saliou@courrier.uqam.ca
 */

public class Tp1Gr21 {

    public static void main(String[] params) {

        // Déclaration des constantes
        final double TPS = 0.05;
        final double TVQ = 0.09975;
        final String DESCRIPTION = " Bienvenue dans le système de facturation de Rénovation-Pour-Tous.\n"
                + " Ce programme permet de calculer la facture de l'installation d'un plancher\n"
                + " sur une surface donnée selon le prix par pied carré et le type de plancher.";
        final String MENU = " 1. Facturer l'installation d'un plancher \n"
                + " 2. Afficher le nombre de planchers installés et le montant total de toutes les installations \n"
                + " 3. Quitter le programme";

        // Déclaration des variables
        String messageU;
        int choix = 1;
        boolean valide;
        boolean validePremier;
        String nomClient;
        String prenomClient;
        String numeroTel;
        String address;
        int plancher = 1;
        double surface = 1.0;
        char typeBatiment = 'a';
        char modePaiement = 'k';
        double prixPiedsCarre = 1.0;
        double sousTotal;
        double tauxTps;
        double tauxTvq;
        double montantTotal;
        LocalDateTime maDate = LocalDateTime.now();
        DateTimeFormatter maDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String batimentStand = "";
        String paiementStand = "";
        String plancherStand = "";
        String temps;
        int numFacture = 0;
        double montantTotalGlobal = 0.0;

        // affichage du message de présentation du programme
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(DESCRIPTION);
        System.out.println("-------------------------------------------------------------------------");
        choix = 1;
        for (int i = 0; choix != 3; i++) {
            validePremier = false;
            // affichage et validation du menu de selection
            while (!validePremier) {
                System.out.println("\n\n*** Menu de choix ***");
                System.out.println(MENU);

                // affichage du message d'invite
                messageU = "\n\nEntrez votre choix:";
                System.out.println(messageU);

                // saisir une donnée pour le programme
                choix = Clavier.lireInt();

                if ((choix > 0) && (choix < 4)) {
                    validePremier = true;
                } else {
                    System.out.println("\nEntrée invalide !");
                }

            }

            // menu des options
            if (choix == 1) {
                // générateur du numéro de la facture
                numFacture += 1;

                // saisir les informations personnels du client
                System.out.print("\nEntrez le nom du client : ");
                nomClient = Clavier.lireString();

                System.out.print("\nEntrez le prénom du client : ");
                prenomClient = Clavier.lireString();

                System.out.print("\nEntrez le numéro de téléphone du client : ");
                numeroTel = Clavier.lireString();

                System.out.print("\nEntrez l'adresse du client : ");
                address = Clavier.lireString();

                // initialisation de la validation
                valide = false;
                // saisir et valider le type de plancher à installer
                while (!valide) {
                    System.out.println("\nEntrez le type de plancher (1 pour la céramique,");
                    System.out.println("  " + "2 pour les tuiles de vinyle, 3 pour le linoléum,");
                    System.out.print("  " + "4 pour le bois franc, et 5 pour le plancher flottant) : ");
                    plancher = Clavier.lireInt();

                    if (plancher > 0 && plancher < 6) {
                        valide = true;
                    } else {
                        System.out.println("\nEntrée invalide !");
                    }
                }

                // initialisation de la validation
                valide = false;
                // saisir et valider la surface à couvrir en pieds carré
                while (!valide) {
                    System.out.print("\nEntrez la surface à couvrir en pied carré (supérieur à 0) : ");
                    surface = Clavier.lireDouble();

                    if (surface > 0) {
                        valide = true;
                    } else {
                        System.out.println("\nEntrée invalide !");
                    }
                }

                // initialisation de la validation
                valide = false;
                // saisir et valider le type de bâtiment
                while (!valide) {
                    System.out.print(
                            "\nEntrez le type de Bâtiment (R ou r pour résidentiel, et E ou e pour Entreprise) : ");
                    typeBatiment = Clavier.lireCharLn();
                    if ((typeBatiment == 'R') || (typeBatiment == 'r') || (typeBatiment == 'E')
                            || (typeBatiment == 'e')) {
                        valide = true;
                    } else {
                        System.out.println("\nEntrée invalide !");
                    }
                }

                // initialisation de la validation
                valide = false;
                // saisir et valider le mode de paiement
                while (!valide) {
                    System.out.print("\nEntrez le mode de paiement (S pour Cash, D pour Débit, et C pour Crédit) : ");
                    modePaiement = Clavier.lireCharLn();
                    if ((modePaiement == 'S') || (modePaiement == 'D') || (modePaiement == 'C')) {
                        valide = true;
                    } else {
                        System.out.println("\nEntrée invalide !");
                    }
                }

                // prix d'installation par pieds carré selon le type de plancher
                if (plancher == 1) {
                    prixPiedsCarre = 3.90;
                } else if (plancher == 2) {
                    prixPiedsCarre = 0.50;
                } else if (plancher == 3) {
                    prixPiedsCarre = 0.75;
                } else if (plancher == 4) {
                    prixPiedsCarre = 2.15;
                } else if (plancher == 5) {
                    prixPiedsCarre = 1.90;
                }

                // determination du sous total en fonction du prix par pieds carré
                sousTotal = prixPiedsCarre * surface;

                // calcul des taxes TPS et TVQ selon le sous-total de la facture.
                tauxTps = sousTotal * TPS;
                tauxTvq = sousTotal * TVQ;

                // determination du montant total de la facture en additionnant le sous-total
                montantTotal = sousTotal + tauxTps + tauxTvq;

                // determination du montant total de toutes les installations
                montantTotalGlobal += montantTotal;

                // selection sur le type de plancher
                switch (plancher) {
                    case 1:
                        plancherStand = "Céramique";
                        break;
                    case 2:
                        plancherStand = "Tuiles de vinyle";
                        break;
                    case 3:
                        plancherStand = "Linoléum";
                        break;
                    case 4:
                        plancherStand = "Bois Franc";
                        break;
                    case 5:
                        plancherStand = "Flottant";
                }

                // selection sur le type de bâtiment
                switch (typeBatiment) {
                    case 'e':
                    case 'E':
                        batimentStand = "Entreprise";
                        break;
                    case 'r':
                    case 'R':
                        batimentStand = "Résidentiel";
                        break;
                }

                // selection sur le mode de paiement
                switch (modePaiement) {
                    case 'S':
                        paiementStand = "Cash";
                        break;
                    case 'D':
                        paiementStand = "Débit";
                        break;
                    case 'C':
                        paiementStand = "Crédit";
                        break;
                }

                // initialisation et formatage de la date et heure à partir du système
                maDate = LocalDateTime.now();
                temps = maDate.format(maDateFormat);

                // affichage de la facture
                System.out.println(
                        "\n--------------------------------------------------------------------------------------------------");
                System.out.println("   Rénovation-Pour-Tous");
                System.out.println("   Facture No: " + numFacture + "\t\t\tDate et Heure: " + temps);
                System.out.println(
                        "--------------------------------------------------------------------------------------------------");

                System.out.println(
                        "\n  " + "Nom et prénom : " + nomClient + " " + prenomClient + "\t\tTéléphone : " + numeroTel);

                System.out.println("  Addresse du client : " + address);

                System.out.printf("\n  " + "La surface à couvrir : %.1f pieds carré ", surface);
                System.out.printf("\n  " + "Le type de bâtiment : %s", batimentStand);
                System.out.printf("\n  " + "Le type de plancher : %s", plancherStand);
                System.out.printf("\n  " + "Le mode de paiement : %s", paiementStand);

                System.out.printf("\n  " + "prix par pieds carré\t\t %.2f$", prixPiedsCarre);
                System.out.printf("\n  " + "Sous-total\t\t\t %.2f$", sousTotal);
                System.out.printf("\n  " + "Montant TPS\t\t\t %.2f$", tauxTps);
                System.out.printf("\n  " + "Montant TVQ\t\t\t %.2f$", tauxTvq);
                System.out.printf("\n  " + "Montant total\t\t\t %.2f$", montantTotal);
                System.out.println("\n\t--------------------------------------------------");
                System.out.println("\t\t Merci pour votre confiance!");

                // deuxième option du menu
            } else if (choix == 2) {
                // initialisation de l'heure du système
                maDate = LocalDateTime.now();
                temps = maDate.format(maDateFormat);

                // affichage du nom de l'entreprise et la date et heure en temps réel
                System.out.println("\n-------------------------------------------------------------------------");
                System.out.println("  " + "Rénovation-Pour-Tous: ");
                System.out.println("  " + "Date et Heure: " + temps);
                System.out.println("\n-------------------------------------------------------------------------");

                // affichage du nombre de plancher installés et le montant de toutes les
                // installations
                System.out.println("\n   " + "Le nombre de planchers installés\t\t: " + numFacture);
                System.out.printf("   " + "Le montant total de toutes les installations\t%.2f$\n", montantTotalGlobal);
                System.out.println("\n-------------------------------------------------------------------------");

            }

        }

        if (choix == 3) {
            // affichage du message de sortie
            System.out.println("\n  Merci et à la prochaine !");
        }

    } // main
} // Tp1Gr21