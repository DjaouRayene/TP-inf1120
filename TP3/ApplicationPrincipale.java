import java.util.regex.*;
/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF1120 - 021 - Automne 2020
 *
 * Classe ApplicationPrincipale contient les méthodes d'affichage de menus,
 * de saisies et de validations également elle contient la méthode "main".
 * Cette classe permet de tester toutes les autres classes en créant des
 * objets et en appelant leurs méthodes lors de l'application des règles
 * d'affaires liées aux différentes options du menu principal.
 *
 * @author Saliou Cisse & Amel Yalaoui.
 * 
 * 
 *   
 * 
 * @version 10 Decembre 2020
 *
 */
public class ApplicationPrincipale {

    // D�claration des constantes
    public static final float ZERO         = 0;
    public static final int   DEUX         = 2;
    public static final int   DIX          = 10;
    public static final int   VINGT_CINQ   = 25;
    public static final int   QUATRE_VINGT = 80;    
    public static final String LIGNEMEDIUM = "-----------------------------------------------------------------------------";
    public static final String DESCRIPTION = " Ce programme permet de calculer la facture de l'installation d'un plancher\n"
        + " sur une surface donnée selon le prix par pied carré et le type de plancher.\n";
    public static final String INVITE = " Bienvenue dans le système de facturation de Rénovation-Pour-Tous.";
    public static final String MESSAGE = "\nMerci et à la prochaine !";
    public static final String CHOIX = "  Entrez votre choix : ";
    public static final String MSG_SOLL_NOM = "\nEntrez le nom du client (entre 2 et 25 caractères inclusivement): ";
    public static final String MSG_SOLL_PRENOM = "\nEntrez le prénom du client (entre 2 et 25 caractères inclusivement): ";
    public static final String ADDRESSECLIENT = "\nEntrez l'addresse du client (entre 10 et 80 caractères inclusivement):  ";
    public static final String TELEPHONECLIENT = "\nEntrez le numéro de téléphone du client (format : NNN NNN-NNNN): ";
    public static final String TYPEPLANCHER = "\nEntrez le type de plancher (1 pour la céramique,\n"
        + "2 pour les tuiles de vinyle, 3 pour le linoléum,\n"
        + "4 pour le bois franc, 5 pour le plancher flottant) : ";
    public static final String MSG_SOLL_SURFACE = "\nEntrez la surface à couvrir en pied carré (supérieur à 0) : ";
    public static final String MSG_SOLL_TYPEBATIMENT = "\nEntrez le type de bâtiment (R ou r pour Résidentiel, et E ou e pour Entreprise) : ";
    public static final String MSG_SOLL_MODEPAIEMENT = "\nEntrez le mode de paiement (S ou s pour Cash, D ou d pour Débit, et C ou c pour Crédit) : ";
    public static final String MSG_ERR_NOM = "\nLe nom est invalide!\n";
    public static final String MSG_ERR_PRENOM = "\nLe prénom  est invalide!\n";
    public static final String MSG_ERR_TEL = "\nLe numéro de téléphone est invalide!";
    public static final String MSG_ERR_ADDRESSE = "\nL'addresse   est invalide!\n";
    public static final String MSG_ERR_OPTION = "\n   L'option choisie est invalide!";
    public static final String MSG_ERR_PLANCHER = "\nLe type de plancher est invalide!\n";
    public static final String MSG_ERR_MSG_SOLL_SURFACE = "\nLa surface est invalide!\n";
    public static final String MSG_ERR_BATIMENT = "\nLe type de bâtiment est invalide!\n";
    public static final String MSG_ERR_PAIEMENT = "\nLe mode de paiement est invalide!\n";
    public static final String FORMATTELEPHONE =   "^((\\d{3})|\\d{3})[ ]\\d{3}[-]\\d{4}$";
    public static final int ZERO_INT = 0;
    public static final int UN = 1;
    public static final int TROIS = 3;
    public static final int QUATRE = 4;
    public static final int CINQ = 5;
    public static final  int SIX = 6;
    public static final  boolean TRUE = true;
    public static final  boolean FALSE = false;

    public static final int CHOIX_MIN = 1;
    public static final int CHOIX_MAX = 4;

    public static final String MENU = "\n\n  *** Menu de choix ***\n" + "  1. Facturer l'installation d'un plancher\n"
        + "  2. Afficher le nombre de planchers installés par type de plancher \n     et le montant total des installations par type de plancher\n"
        + "  3. Afficher les prix d'installation des planchers par pied carré\n"
        + "  4. Quitter le programme\n\n";

    /****************************************************************************************************
     *   Ajoutez toutes les méthodes "public" et "static" définies dans
     *   le travail pratique 2 pour l'affichage des menus, les saisies et
     *   les validations données.
    1)  Affichage du message de bienvenue
    2)  Affichage du résumé du programme
    3)  Saisie et validation de l'option choisie par l'utilisateur.
    4)  Saisie et validation du nom du client
    5)  Saisie et validation du prénom du client
    6)  Saisie et validation du numéro de téléphone du client
    7)  Saisie et validation de l'adresse du client
    8)  Saisie et validation du type de plancher
    9)  Saisie et validation de la surface à couvrir    
    10) Saisie et validation du type de bâtiment
    11) Saisie et validation du mode de paiement
     *********************************************************************************************************/

    /**********************************************************************************
     * But : Permet d'afficher le message de bienvenue.
     **********************************************************************************/
    public static void afficherMenu() {

        System.out.println(LIGNEMEDIUM + "\n" + INVITE + "\n" + LIGNEMEDIUM + "\n");

    } // afficherMenu

    /**********************************************************************************
     * But : Permet d'afficher le resumé du programme.
     **********************************************************************************/
    public static void afficherResume() {

        System.out.println(LIGNEMEDIUM + "\n" + DESCRIPTION + LIGNEMEDIUM);

    } // afficherResume

    /**********************************************************************************
     * But : Permet de saisir et valider l'option choisie par l'utilisateur.
     * 
     * @return l'option choisie.
     **********************************************************************************/
    public static int saisirChoixUtilisateur() {
        int choix = ZERO_INT;
        boolean valide = FALSE;
        while (!valide) {
            try{
                System.out.println(MENU);
                System.out.print(CHOIX);

                choix = Clavier.lireInt();
                if ((choix > ZERO) && (choix < CINQ)) {
                    valide = TRUE;
                } else {
                    System.out.println(MSG_ERR_OPTION);
                }
            } catch(NumberFormatException e){
                System.out.println(MSG_ERR_OPTION);
                valide = FALSE;
            }

        }

        return choix;
    } // saisirChoixUtilisateur

    /**********************************************************************************
     * But : Permet de saisir et valider le nom du client.
     * 
     * @return le nom
     **********************************************************************************/
    public static String saisirNomClient() {
        String nom = new String("");
        boolean valide = FALSE;
        while (!valide) {
            System.out.print(MSG_SOLL_NOM);
            nom = Clavier.lireString();

            if ((nom.length() >= DEUX) && (nom.length() <= VINGT_CINQ)) {
                valide = TRUE;
            } else {
                System.out.print(MSG_ERR_NOM);
            }
        }

        return nom;
    } // saisirNom

    /**********************************************************************************
     * But : Permet de saisir et valider le prénom du client.
     * 
     * @return le prénom.
     **********************************************************************************/
    public static String saisirPrenomClient() {
        String prenom = new String("");
        boolean valide = FALSE;
        while (!valide) {
            System.out.print(MSG_SOLL_PRENOM);
            prenom = Clavier.lireString();

            if ((prenom.length() >= DEUX) && (prenom.length() <= VINGT_CINQ)) {
                valide = TRUE;
            } else {
                System.out.print(MSG_ERR_PRENOM);
            }
        }

        return prenom;
    } // saisirPrenomClient

    
    /**********************************************************************************
     * But : Permet de saisir et valider le numéro de téléphone du client.
     * 
     * @return le numéro de téléphone.
     **********************************************************************************/
    public static String saisirTelephoneClient() {
        String numTel = new String("");
        boolean valide = FALSE;
        String formatTelephone = FORMATTELEPHONE;
        boolean format = FALSE;

        while (!valide) {

            System.out.print(TELEPHONECLIENT);
            numTel = Clavier.lireString();

            Pattern pattern = Pattern.compile(formatTelephone);
            format = pattern.matcher(numTel).matches();

            if (format) {
                valide = TRUE;
            } else {
                System.out.println(MSG_ERR_TEL);
                format = FALSE;
            }

        }

        return numTel;
    } // saisirTelephoneClient
    /**********************************************************************************
     * But : Permet de saisir et valider l'addresse du client.
     * 
     * @return l'addresse du client.
     **********************************************************************************/
    public static String saisirAddresseClient() {
        String addresse = new String("");
        boolean valide = FALSE;
        while (!valide) {
            System.out.print(ADDRESSECLIENT);
            addresse = Clavier.lireString();

            if ((addresse.length() >= DIX) && (addresse.length() <= QUATRE_VINGT)) {
                valide = TRUE;
            } else {
                System.out.print(MSG_ERR_ADDRESSE);
            }
        }

        return addresse;
    } // saisirAddresseClient

    /**********************************************************************************
     * But : Permet de saisir et valider le type de plancher.
     * 
     * @return le type de plancher saisi.
     **********************************************************************************/
    public static int saisirTypePlancher() {
        int plancher = ZERO_INT;
        boolean valide = FALSE;
        while (!valide) {
            try{
                System.out.print(TYPEPLANCHER);

                plancher = Clavier.lireInt();

                if ((plancher > ZERO) && (plancher < SIX)) {
                    valide = TRUE;
                } else {
                    System.out.print(MSG_ERR_PLANCHER);
                }
            } catch(NumberFormatException e ){
                System.out.print(MSG_ERR_PLANCHER);
                valide = FALSE;
            }

        }
        return plancher;
    } // saisirTypePlancher

    /**********************************************************************************
     * But : Permet de saisir et valider la surface à couvrir.
     * 
     * @return la surface saisi.
     **********************************************************************************/
    public static float saisirSurface() {
        float surface = ZERO;
        boolean valide = FALSE;
        while (!valide) {

            try{
                System.out.print(MSG_SOLL_SURFACE);
                surface = Clavier.lireFloat();

                if (surface > ZERO) {
                    valide = TRUE;
                } else {
                    System.out.print(MSG_ERR_MSG_SOLL_SURFACE);
                }
            }catch(NumberFormatException e) {
                System.out.print(MSG_ERR_MSG_SOLL_SURFACE);
                valide = FALSE;
            }
        }
        return surface;
    } // saisirSurface

    /**********************************************************************************
     * But : Permet de saisir et valider le type de bâtiment.
     * 
     * @return le type de bâtiment saisi.
     **********************************************************************************/
    public static char saisirTypeBatiment() {
        char typeBatiment = InstallationPlancher.GRAND_ENTREPRISE;
        char value = InstallationPlancher.GRAND_DEBIT;
        boolean valide = FALSE;
        while (!valide) {
            System.out.print(MSG_SOLL_TYPEBATIMENT);
            typeBatiment = Clavier.lireCharLn();
            value = Character.toUpperCase(typeBatiment);
            if ((value == InstallationPlancher.GRAND_RESIDENCE) || (value == InstallationPlancher.GRAND_ENTREPRISE)) {
                valide = TRUE;
            } else {
                System.out.print(MSG_ERR_BATIMENT);
            }
        }

        return value;
    } // saisirTypeBatiment

    /**********************************************************************************
     * But : Permet de saisir et valider le mode de paiement.
     * 
     * @return le mode de paiement saisi.
     **********************************************************************************/
    public static char saisirModePaiement() {
        char modePaiement = InstallationPlancher.GRAND_CASH ;
        char value = InstallationPlancher.GRAND_RESIDENCE;
        boolean valide = FALSE;
        while (!valide) {

            System.out.print(MSG_SOLL_MODEPAIEMENT);
            modePaiement = Clavier.lireCharLn();
            value = Character.toUpperCase(modePaiement);
            if ((value == InstallationPlancher.GRAND_CASH) || (value == InstallationPlancher.GRAND_DEBIT ) || (value ==InstallationPlancher.GRAND_CREDIT )) {
                valide = TRUE;
            } else {
                System.out.print(MSG_ERR_PAIEMENT);
            }
        }

        return value;
    } // saisirModePaiement

    /**
     * But : afficher le message de fermeture
     */
    public static void afficherMessageFermeture() {

        System.out.println(MESSAGE);

    } // afficherMessageFermeture

    
    // Le point d'entrée pour l'exécution
    public static void main(String[] args) {

        // Déclaration des variables
        String nomClient;
        String prenomClient ;
        String numeroTelephoneClient;
        String adresseClient;
        int typePlancher = 0;
        float surfaceACouvrir;
        char typeBatiment;
        char modePaiement;
        float prixPiedCarre;
        boolean sortie = false;
        int choixMenu = 0;

        // Création des objets
        StatistiqueInstallations statistiqueInstallations;
        Client client;
        Plancher plancher;
        InstallationPlancher installationPlancher;
        Facture facture;

        // Lecture du prix d'installation des placnhers par pied carré
        InventairePlanchers.lire();

        // Création d'un objet de type StatistiqueInstallations.
        statistiqueInstallations = new StatistiqueInstallations();

        // message de Bienvenue
        afficherMenu();
        //résumé du programme
        afficherResume();

        do {
            //choixUtilisateur
            choixMenu = saisirChoixUtilisateur();

            switch (choixMenu) {

                case 1:

                //saisie et validation des données du clients
                nomClient = saisirNomClient(); 
                prenomClient = saisirPrenomClient();
                numeroTelephoneClient = saisirTelephoneClient();
                adresseClient = saisirAddresseClient();
                typePlancher = saisirTypePlancher();
                surfaceACouvrir = saisirSurface();
                typeBatiment = saisirTypeBatiment();
                modePaiement = saisirModePaiement();


                // APPEL DE LA MÉTHODE POUR DETERMINER LE PRIX D'INSTALLATION PAR PIED CARRE
                prixPiedCarre = InventairePlanchers.obtenirPrixInstallationPiedCarre(typePlancher);


                // Création des objets: client, plancher, installationPlancher, facture
                client = new Client(nomClient, prenomClient,adresseClient, numeroTelephoneClient );
                prixPiedCarre = InventairePlanchers.obtenirPrixInstallationPiedCarre(typePlancher);
                plancher = new Plancher (typePlancher, prixPiedCarre  );
                installationPlancher = new InstallationPlancher(plancher, client, surfaceACouvrir, typeBatiment, modePaiement);
                facture = new Facture(installationPlancher);


                // calcul du (sous-total, montantTPS, montantTVQ) de l'objet facture
                facture.calculerSousTotal();
                facture.calculerMontantTps();
                facture.calculerMontantTvq();

                //affichage de la facture
                facture.afficherFacture();

                //utilisation de l'objet statistiqueInstallations pour appeler la méthode 
                //d'incrementation du nombre de planchers par type de plancher
                statistiqueInstallations.incrementerNombrePlancherInstaller(typePlancher);

                //utilisation de l'objet statistiqueInstallations pour appeler la methode qui ajuste 
                //le montant total d'installation d'un type de plancher installé
                statistiqueInstallations.montantInstallationsTypePlancher(typePlancher, facture.getTotalFacture());

                break;

                case 2:
                // utilisation de l'objet statistiqueInstallations pour appeler la méthode 
                //  qui affiche le nombre de planchers installés par type et 
                //  le montant total des installations par type de plancher
                statistiqueInstallations.afficherNombresPlanchersEtMontantTotalDesInstallations();

                break;
                case 3:
                //utilisation de la classe InventairePlanchers pour appeler la méthode 
                //qui affiche le prix des installations par pied carré.
                InventairePlanchers.afficherLesPrixParTypePlancher();

                break;
                case 4:
                //utilisation de l'objet statistiquesInstallations pour appeler la 
                // méthode qui écrit les données des statisques d'installation des 
                // planchers dans le fichier "LesStatistiques.txt".
                statistiqueInstallations.ecrire();

                //affichage du message de rémerciement
                afficherMessageFermeture();

                sortie = true;

            }

        } while (!sortie);

    }


}
