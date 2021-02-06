import java.util.Formatter;
import java.util.regex.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * INF1120
 * 
 * Facturation Rénovation-Pour-Tous: permet de calculer la facture de
 * l'installationd'un plancher sur une surface donnée selon le prix par pied
 * carré et le type de plancher
 * 
 * @author Saliou Cisse
 * @version 07-11-2020
 * 
 * CISS010101 
 * cisse.saliou@courrier.uqam.ca
 */ 

public class Tp2Inf1120Grpe21A2020 {

    // déclaration des constantes
    final static double TPS = 0.05;
    final static double TVQ = 0.09975;
    final static String ADDRESSE = " 1800 boulevard java, informatique, QC";
    final static String TELEPHONE = "(450) 281-0011";
    final static String ENTREPRISE = "  Rénovation-Pour-Tous\n";
    final static String DATEHEURE = "   Date et Heure: ";
    final static String LIGNEMEDIUM = "-----------------------------------------------------------------------------";
    final static String LIGNELARGE = "-----------------------------------------------------------------------------------------------------\n";
    final static String LIGNECOURTE = "%n \t---------------------------------------------------------\n";
    final static String DESCRIPTION = " Ce programme permet de calculer la facture de l'installation d'un plancher\n"
        + " sur une surface donnée selon le prix par pied carré et le type de plancher.\n";
    final static String INVITE = " Bienvenue dans le système de facturation de Rénovation-Pour-Tous.";
    final static String RESUME = "\n *** Menu de choix ***\n" + " 1. Facturer l'installation d'un plancher\n"
        + " 2. Afficher le nombre de planchers installés par type de plancher\n"
        + "    et le montant total des installations par type de plancher\n" + " 3. Quitter le programme";
    final static String DETAILS = "   Le type de plancher\tLe nombre de planchers installés\tLe montant total des installations\n";
    final static String CERAMIQUE = "Céramique";
    final static String TUILES = "Tuiles de Vinyle";
    final static String LINOLEUM = "Linoléum";
    final static String BOISFRANC = "Bois franc";
    final static String FLOTTANT = "Flottant";
    final static String SPACE = "     ";
    final static String CHOIX = "\nEntrez votre choix : ";
    final static String MESSAGE = "\nMerci et à la prochaine !";
    final static String NOM = "\nEntrez le nom du client (entre 2 et 25 caractères inclusivement): ";
    final static String PRENOM = "\nEntrez le prénom du client (entre 2 et 25 caractères inclusivement): ";
    final static String ADDRESSECLIENT = "\nEntrez l'addresse du client (entre 10 et 80 caractères inclusivement):  ";
    final static String TELEPHONECLIENT = "\nEntrez le numéro de téléphone du client (format : NNN NNN-NNNN): ";
    final static String TYPEPLANCHER = "\nEntrez le type de plancher (1 pour la céramique,\n"
        + "2 pour les tuiles de vinyle, 3 pour le linoléum,\n"
        + "4 pour le bois franc, 5 pour le plancher flottant) : ";
    final static String SURFACE = "\nEntrez la surface à couvrir en pied carré (supérieur à 0) : ";
    final static String TYPEBATIMENT = "\nEntrez le type de bâtiment (R ou r pour Résidentiel, et E ou e pour Entreprise) : ";
    final static String MODEPAIEMENT = "\nEntrez le mode de paiement (S ou s pour Cash, D ou d pour Débit, et C ou c pour Crédit) : ";
    final static String ERREURNOM = "\nLe nom est invalide!\n";
    final static String ERREURPRENOM = "\nLe prénom  est invalide!\n";
    final static String ERREURTELEPHONE = "\nLe numéro de téléphone est invalide!";
    final static String ERREURADDRESSE = "\nL'addresse   est invalide!\n";
    final static String ERREUROPTION = "\nL'option choisie est invalide!";
    final static String ERREURTYPEPLANCHER = "\nLe type de plancher est invalide!\n";
    final static String ERREURSURFACE = "\nLa surface est invalide!\n";
    final static String ERREURTYPEBATIMENT = "\nLe type de bâtiment est invalide!\n";
    final static String ERREURMODEPAIEMENT = "\nLe mode de paiement est invalide!\n";
    final static String FORMATTELEPHONE =   "^((\\d{3})|\\d{3})[ ]\\d{3}[-]\\d{4}$";
    final static int ZERO = 0;
    final static int UN = 1;
    final static int TROIS = 3;
    final static int QUATRE = 4;
    final static int CINQ = 5;
    final static int VINGTCINQ = 25;
    final static int DEUX = 2;
    final static int SIX = 6;
    final static int DIX = 10;
    final static double ZERODOUBLE = 0.0;
    final static int QUATREVINGT = 80;
    final static double PRIXCERAMIQUE = 3.90;
    final static double PRIXLINOLEUM = 0.75;
    final static double PRIXTUILESVINYLE = 0.50;
    final static double PRIXBOISFRANC = 2.15;
    final static double PRIXFLOTTANT = 1.90;
    final static String DEBIT = "Débit";
    final static String CREDIT = "Crédit";
    final static String CASH = "Cash";
    final static String ENTREPRISETYPE = "Entreprise";
    final static String RESIDENCETYPE = "Résidentiel";
    final static String DOLLARS = "$";
    final static char LETTREGS = 'S';
    final static char LETTREPS = 's';
    final static char LETTREGD = 'D';
    final static char LETTREPD = 'd';
    final static char LETTREGC = 'C';
    final static char LETTREPC = 'c';
    final static char LETTREGR = 'R';
    final static char LETTREPR = 'r'; 
    final static char LETTREGE = 'E';
    final static char LETTREPE = 'e';
    final static boolean TRUE = true;
    final static boolean FALSE = false;

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
        int choix = ZERO;
        boolean valide = FALSE;
        while (!valide) {
            System.out.println(RESUME);
            System.out.print(CHOIX);

            choix = Clavier.lireInt();
            if ((choix > ZERO) && (choix < QUATRE)) {
                valide = TRUE;
            } else {
                System.out.println(ERREUROPTION);
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
            System.out.print(NOM);
            nom = Clavier.lireString();

            if ((nom.length() >= DEUX) && (nom.length() <= VINGTCINQ)) {
                valide = TRUE;
            } else {
                System.out.print(ERREURNOM);
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
            System.out.print(PRENOM);
            prenom = Clavier.lireString();

            if ((prenom.length() >= DEUX) && (prenom.length() <= VINGTCINQ)) {
                valide = TRUE;
            } else {
                System.out.print(ERREURPRENOM);
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
                System.out.println(ERREURTELEPHONE);
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

            if ((addresse.length() >= DIX) && (addresse.length() <= QUATREVINGT)) {
                valide = TRUE;
            } else {
                System.out.print(ERREURADDRESSE);
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
        int plancher = ZERO;
        boolean valide = FALSE;
        while (!valide) {
            System.out.print(TYPEPLANCHER);

            plancher = Clavier.lireInt();

            if ((plancher > ZERO) && (plancher < SIX)) {
                valide = TRUE;
            } else {
                System.out.print(ERREURTYPEPLANCHER);
            }
        }
        return plancher;
    } // saisirTypePlancher

    /**********************************************************************************
     * But : Permet de saisir et valider la surface à couvrir.
     * 
     * @return la surface saisi.
     **********************************************************************************/
    public static double saisirSurface() {
        double surface = ZERODOUBLE;
        boolean valide = FALSE;
        while (!valide) {
            System.out.print(SURFACE);
            surface = Clavier.lireDouble();

            if (surface > ZERO) {
                valide = TRUE;
            } else {
                System.out.print(ERREURSURFACE);
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
        char typeBatiment = LETTREGS;
        char value = LETTREGE;
        boolean valide = FALSE;
        while (!valide) {
            System.out.print(TYPEBATIMENT);
            typeBatiment = Clavier.lireCharLn();
            value = Character.toUpperCase(typeBatiment);
            if ((value == LETTREGR) || (value == LETTREGE)) {
                valide = TRUE;
            } else {
                System.out.print(ERREURTYPEBATIMENT);
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
        char modePaiement = LETTREGD;
        char value = LETTREGS;
        boolean valide = FALSE;
        while (!valide) {
            System.out.print(MODEPAIEMENT);
            modePaiement = Clavier.lireCharLn();
            value = Character.toUpperCase(modePaiement);
            if ((value == LETTREGS) || (value == LETTREGD) || (value == LETTREGC)) {
                valide = TRUE;
            } else {
                System.out.print(ERREURMODEPAIEMENT);
            }
        }

        return value;
    } // saisirModePaiement

    // les methodes de calcul

    /**********************************************************************************
     * But : Permet de déterminer le prix d'installation du plancher par pied carré
     * selon le type de plancher.
     * 
     * @param le type de plancher.
     * @return le prix du plancher par pied carré.
     **********************************************************************************/
    public static double determinerPrixPlancher(int typePlancher) {
        double prixPlancher = ZERODOUBLE;

        switch (typePlancher) {
            case UN:
            prixPlancher = PRIXCERAMIQUE;
            break;
            case DEUX:
            prixPlancher = PRIXTUILESVINYLE;
            break;
            case TROIS:
            prixPlancher = PRIXLINOLEUM;
            break;
            case QUATRE:
            prixPlancher = PRIXBOISFRANC;
            break;
            case CINQ:
            prixPlancher = PRIXFLOTTANT;
            break;
        }

        return prixPlancher;
    } // determinerPrixPlancher

    /**********************************************************************************
     * But : Permet de calculer le sous-total de la facture selon le prix
     * d'installation du plancher par pied carré et la surface à couvrir.
     * 
     * @param le prix du plancher.
     * @param la surface à couvrir.
     * @return le prix du plancher sur toute la surface à couvrir.
     **********************************************************************************/
    public static double calculerSousTotal(double prixPlancher, double surface) {
        double sousTotal;
        sousTotal = prixPlancher * surface;

        return sousTotal;

    } // calculerSousTotal

    /**********************************************************************************
     * But : Permet de calculer le montant de la taxe TPS (5%).
     * 
     * @param le sous total de la facture.
     * @return le montant de la taxe TPS.
     **********************************************************************************/
    public static double calculerTaxeTps(double sousTotal) {
        double tauxTps;
        tauxTps = sousTotal * TPS;

        return tauxTps;
    } // calculerTaxeTps

    /**********************************************************************************
     * But : Permet de calculer le montant de la taxe TVQ (9.975%).
     * 
     * @param le sous total de la facture.
     * @return le montant de la taxe TVQ.
     **********************************************************************************/
    public static double calculerTaxeTvq(double sousTotal) {
        double tauxTvq;
        tauxTvq = sousTotal * TVQ;

        return tauxTvq;
    } // calculerTaxeTvq

    /**********************************************************************************
     * But : Permet de calculer le montant total de la facture.
     * 
     * @param le sous total de la facture.
     * @param le montant de la taxe TPS.
     * @param le montant de la taxe TVQ.
     * @retour le montant total de la facture
     **********************************************************************************/
    public static double calculerMontantTotal(double sousTotal, double tps, double tvq) {

        double montantTotal;
        montantTotal = sousTotal + tps + tvq;

        return montantTotal;
    } // calculerMontantTotal

    /**********************************************************************************
     * But : Permet d'incrémenter le numéro de la facture.
     * 
     * @param le numéro de la facture.
     * @return la nouvelle valeur
     **********************************************************************************/
    public static int incrementerNumFacture(int numFacture) {

        return numFacture += UN;
    } // incrementerNumFacture

    /**********************************************************************************
     * But : Permet d'incrémenter le nombre de planchers installés par type de
     * plancher.
     * 
     * @param le nombre de plancher installés pour un type de plancher.
     * @return la nouvelle valeur.
     **********************************************************************************/
    public static int incrementerNombrePlancher(int nombrePlancher) {

        return nombrePlancher + UN;
    } // incrementerNombrePlancher

    /**********************************************************************************
     * But : Permet de calculer le montant total des installations par type de
     * plancher.
     * 
     * @param le montant totale de la facture courante.
     * @param le montant total des installations d'un type de plancher.
     * @return le montant obtenu à partir de la somme des deux paramètres.
     **********************************************************************************/
    public static double calculerMontantTypePlancher(double montantTotal, double montantTotalPlancher) {

        double montantTotalFinale = ZERODOUBLE;
        montantTotalFinale = montantTotal + montantTotalPlancher;

        return montantTotalFinale;
    } // CalculerMontantTypePlancher

    // affichage de la facture

    /**********************************************************************************
     * But : Permet d'afficher le nombre de planchers installés par type de plancher
     * et du montant total des installations par type de plancher.
     * 
     * @param les 5 nombres de planchers installés.
     * @param les 5 montants totaux correspondants au type de plancher.
     **********************************************************************************/
    public static void afficherNombrePlancher(int plancher1, int plancher2, int plancher3, int plancher4, int plancher5,
    double montantTotal1, double montantTotal2, double montantTotal3, double montantTotal4,
    double montantTotal5) {
        String temps = heureDate();

        System.out.println("\n" + LIGNELARGE + " " + ENTREPRISE + DATEHEURE + temps + "\n  " + ADDRESSE + "\t\t"
            + TELEPHONE + "\n" + LIGNELARGE);

        System.out.println(DETAILS);
        System.out.printf(SPACE + CERAMIQUE + "\t\t\t  %d\t\t\t\t\t  %.2f%s\n" + SPACE + TUILES
            + "\t\t  %d\t\t\t\t\t  %.2f%s\n" + SPACE + LINOLEUM + "\t\t\t  %d\t\t\t\t\t  %.2f%s\n" + SPACE + BOISFRANC
            + "\t\t\t  %d\t\t\t\t\t  %.2f%s\n" + SPACE + FLOTTANT + "\t\t\t  %d\t\t\t\t\t  %.2f%s\n" + LIGNELARGE,
            plancher1, montantTotal1,DOLLARS, plancher2, montantTotal2, DOLLARS, plancher3, montantTotal3,DOLLARS
        , plancher4, montantTotal4 ,DOLLARS,plancher5, montantTotal5, DOLLARS

        );
    } // afficherNombrePlancher

    /**********************************************************************************
     * But: permet d'afficher la facture de l'installation d'un plancher.
     * 
     * @param le numéro de la facture.
     * @param le nom du client.
     * @param le prénom du client.
     * @param le numéro de téléphone.
     * @param l'addresse du client
     * @param la surface à couvrir
     * @param le type de bâtiment
     * @param le type de plancher
     * @param le mode de paiement.
     * @param le prix d'installation par pied carré.
     * @param le sous-total de la facture.
     * @param le montant de la taxe TPS.
     * @param le montant de la taxe TVQ.
     * @param le montant total.
     ***********************************************************************************/
    public static void afficherFacture(int numFacture, String nom, String prenom, String numeroTel,
    String addresseClient, double surface, String typeBatiment, String typePlancher, String modePaiement,
    double prixPlancher, double sousTotal, double montantTps, double montantTvq, double montantTotal) {

        String temps = heureDate();
        numeroTel = formaterNumeroTelephone(numeroTel);

        System.out.println("\n"+LIGNELARGE + ENTREPRISE + "  Facture No: " + numFacture + "\t\t\t\t" + DATEHEURE + temps
            + "\n " + ADDRESSE + "    " + TELEPHONE + "\n" + "\n" + LIGNELARGE + "\n  Nom et prénom : "
            + nom+" "+prenom + "\t\t Téléphone : " + numeroTel + "\n  Addresse du client : " + addresseClient
            + "\n");
        System.out.printf(
            "  La surface à couvrir : %.1f pied carré" + "%n  Le type de bâtiment : %s"
            + "%n  Le type de plancher : %s" + "%n  Le mode de paiement : %s"
            + "%n%n  Prix par pied carré\t\t\t %.2f%s" + "%n  Sous-total\t\t\t\t %.2f%s"
            + "%n  Montant TPS\t\t\t\t %.2f%s" + "%n  Montant TVQ\t\t\t\t %.2f%s"
            + "%n  Montant total\t\t\t\t %.2f%s" + LIGNECOURTE + "\t\t\t Merci pour votre confiance!\n\n",
            surface, typeBatiment, typePlancher, modePaiement, prixPlancher, DOLLARS, sousTotal, DOLLARS, montantTps , DOLLARS
        , montantTvq, DOLLARS ,montantTotal , DOLLARS);

    } // afficherFacture

    /**
     * But : afficher le message de fermeture
     */
    public static void afficherMessageFermeture() {

        System.out.println(MESSAGE);

    } // afficherMessageFermeture

    /** 
     * But : permet de faire afficher la date et l'heure dans le programme;
     * 
     * @return la date et heure locale formaté.
     */
    public static String heureDate(){
        String temps;
        LocalDateTime maDate = LocalDateTime.now();
        DateTimeFormatter maDateFormat = DateTimeFormatter.ofPattern(" dd-MM-yyyy  HH:mm:ss ");
        temps = maDate.format(maDateFormat);

        return temps;
    } //heureDate;

    /**
     * But: Permet de formater le numéro de téléphone du client.
     * 
     * @param le numéro du client.
     * @return le numéro de téléphone formaté.
     */
    public static String formaterNumeroTelephone(String tel){
        tel = tel.substring(ZERO,TROIS).concat(tel.substring(QUATRE));
        tel = tel.replaceFirst("(\\d{3})(\\d+)", "($1) $2");
        return tel;
    } //formaterNumeroTelephone

    public static void main(String[] args) {

        //Déclaration des variables
        int choix = ZERO;
        int nombrePlancher1 = ZERO;
        int nombrePlancher2 = ZERO;
        int nombrePlancher3 = ZERO;
        int nombrePlancher4 = ZERO;
        int nombrePlancher5 = ZERO;
        double montantTotal1 = ZERODOUBLE;
        double montantTotal2 = ZERODOUBLE;
        double montantTotal3 = ZERODOUBLE;
        double montantTotal4 = ZERODOUBLE;
        double montantTotal5 = ZERODOUBLE;
        String nomClient;
        String prenomClient;
        String telephone;
        String addresse;
        int typePlancher;
        double surface;
        char typeBatiment;
        char modePaiement;
        double prixPlancher;
        double sousTotal;
        double montantTps;
        double montantTvq;
        double montantTotal;
        String typeDeBatiment = new String("");
        String typeDePlancher = new String("");
        String modeDePaiement = new String("");
        int numFacture = ZERO;

        //affichage du message de bienvenue et résumé du programme
        afficherMenu();
        afficherResume();

        while (choix != TROIS) {
            choix = saisirChoixUtilisateur();
            if (choix == UN) {
                
                //Incrémentation du numéro de la facture
                numFacture = incrementerNumFacture(numFacture);

                //Saisie et validation des données du client
                nomClient = saisirNomClient();
                prenomClient = saisirPrenomClient();
                telephone = saisirTelephoneClient();
                addresse = saisirAddresseClient();
                typePlancher = saisirTypePlancher();
                surface = saisirSurface();
                typeBatiment = saisirTypeBatiment();
                modePaiement = saisirModePaiement();

                //Calcul de la facture
                prixPlancher = determinerPrixPlancher(typePlancher);
                sousTotal = calculerSousTotal(prixPlancher, surface);
                montantTps = calculerTaxeTps(sousTotal);
                montantTvq = calculerTaxeTvq(sousTotal);
                montantTotal = calculerMontantTotal(sousTotal, montantTps, montantTvq);

                switch (typePlancher) {
                    case UN:
                    typeDePlancher = CERAMIQUE;
                    nombrePlancher1 = incrementerNombrePlancher(nombrePlancher1);
                    montantTotal1 = calculerMontantTypePlancher(montantTotal, montantTotal1);
                    break;
                    case DEUX:
                    typeDePlancher = TUILES;
                    nombrePlancher2 = incrementerNombrePlancher(nombrePlancher2);
                    montantTotal2 = calculerMontantTypePlancher(montantTotal, montantTotal2);
                    break;
                    case TROIS:
                    typeDePlancher = LINOLEUM;
                    nombrePlancher3 = incrementerNombrePlancher(nombrePlancher3);
                    montantTotal3 = calculerMontantTypePlancher(montantTotal, montantTotal3);
                    break;
                    case QUATRE:
                    typeDePlancher = BOISFRANC;
                    nombrePlancher4 = incrementerNombrePlancher(nombrePlancher4);
                    montantTotal4 = calculerMontantTypePlancher(montantTotal, montantTotal4);
                    break;
                    case CINQ:
                    typeDePlancher = FLOTTANT;
                    nombrePlancher5 = incrementerNombrePlancher(nombrePlancher5);
                    montantTotal5 = calculerMontantTypePlancher(montantTotal, montantTotal5);
                    break;

                }

                switch (modePaiement) {
                    case LETTREPS:
                    case LETTREGS:
                    modeDePaiement = CASH;
                    break;
                    case LETTREPD:
                    case LETTREGD:
                    modeDePaiement = DEBIT;
                    break;
                    case LETTREPC:
                    case LETTREGC:
                    modeDePaiement = CREDIT;
                    break;

                }

                switch (typeBatiment) {
                    case LETTREPE:
                    case LETTREGE:
                    typeDeBatiment = ENTREPRISETYPE;
                    case LETTREPR:
                    case LETTREGR:
                    typeDeBatiment = RESIDENCETYPE;

                }

                //affichage de la facture de l'installation d'un plancher
                afficherFacture(numFacture, nomClient, prenomClient, telephone, addresse, surface, typeDeBatiment,
                    typeDePlancher, modeDePaiement, prixPlancher, sousTotal, montantTps, montantTvq, montantTotal);

            } else if (choix == 2) {

                //affichage du nombre de planchers installés par type de plancher et du montant total des installations
                afficherNombrePlancher(nombrePlancher1, nombrePlancher2, nombrePlancher3, nombrePlancher4,
                    nombrePlancher5, montantTotal1, montantTotal2, montantTotal3, montantTotal4,
                    montantTotal5);
            }
        }

        //affichage du message de fermeture
        afficherMessageFermeture();
    } // main

} 
