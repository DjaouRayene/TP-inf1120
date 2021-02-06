import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Universit du Quebec à Montreal (UQAM)
 * Cours : INF1120 - 021 - Automne 2020
 *
 * InventairePlanchers : Cette classe contient les données sur les differentes
 * sortes de plancher et leurs prix d'installation par pied carré.
 *
 * @author Amel Yalaoui.
 * @since 08 Decembre 2020
 */
public class InventairePlanchers {

    // Déclaration des constantes
    private static final String NOM_FICHIER = "LesPlanchers.txt";
    

    // Déclaration des variables
    private static Plancher tableauPrixPiedCarre[] = new Plancher[5];


    /**
     * Lire les prix d'installation des planchers par pied carré à partir
     * du fichier "LesPlanchers.txt". Ces prix seront transférés du fichier
     * vers le tableau.
     */
    public static void lire() {

        // Déclarations des variables
        FileReader lecteur = null;
        BufferedReader connecteur = null;
        String ligne = "";
        String[] champ;
        try {
            lecteur = new FileReader(NOM_FICHIER);
            connecteur = new BufferedReader(lecteur);
            int compteur = 0;
            while (connecteur.ready()) {
                ligne = connecteur.readLine();
                   
                champ = ligne.split("\\|");
       
       
                if (champ.length == 2) {
                    int typePlancher = Integer.parseInt(champ[0].trim());
                    float prixPiedCarre = Float.parseFloat(champ[1].trim());
                     
                    Plancher plancher = new Plancher(typePlancher, prixPiedCarre);
                    tableauPrixPiedCarre[compteur] = plancher ;
                    compteur++;
                }
            
            }
            lecteur.close();
            connecteur.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            System.out.println("Erreur d'entrée et sortie.");
        }
    }


    /**
     * obtenir le prix d'installation par pied carré d'un type de plancher.
     *
     * @param typePlancher le type de plancher
     * @return le prix d'installation par pied carré
     */
   public static float obtenirPrixInstallationPiedCarre(int typePlancher) {
        
        float prixInstallationParPiedCarre = 0f;
        lire();
        if (typePlancher > 0 && typePlancher < 6 ){
        for(int i = 0; i <= 1; i++){
         prixInstallationParPiedCarre =   tableauPrixPiedCarre[typePlancher-1].getPrixInstallationPiedsCarre();
        }
         }

        return prixInstallationParPiedCarre;
    }

    /**
     * Afficher les prix d'installation des planchers par pied carré
     */
    public static void afficherLesPrixParTypePlancher() {
         lire();
        String date = Facture.heureDate();
        float prixCeramique = tableauPrixPiedCarre[0].getPrixInstallationPiedsCarre();
        float prixTuilesDeVinyle = tableauPrixPiedCarre[1].getPrixInstallationPiedsCarre();
        float prixLinoleum = tableauPrixPiedCarre[2].getPrixInstallationPiedsCarre();
        float prixBoisFranc = tableauPrixPiedCarre[3].getPrixInstallationPiedsCarre();
        float prixFlottant = tableauPrixPiedCarre[4].getPrixInstallationPiedsCarre();
        System.out.println(ConstantesCommunes.LIGNE+ConstantesCommunes.PROPRIETAIRE+"\n"
            +ConstantesCommunes.DATE_HEURE+date
    +ConstantesCommunes.RESIDENCE+"\t\t"+ConstantesCommunes.NUMERO_ENTREPRISE+ConstantesCommunes.LIGNE);

    System.out.printf(" Le Type de plancher\tLe prix d'installation par pied carré\n\n"
    +ConstantesCommunes.SPACE+Plancher.CERAMIQUE_DESC+"\t\t\t\t %.2f%s\n"
    +ConstantesCommunes.SPACE+Plancher.TUILESDEVINYLE_DESC+"\t\t\t %.2f%s\n"
    +ConstantesCommunes.SPACE+Plancher.LINOLEUM_DESC+"\t\t\t\t %.2f%s\n"
    +ConstantesCommunes.SPACE+Plancher.BOISFRANC_DESC+"\t\t\t\t %.2f%s\n"
    +ConstantesCommunes.SPACE+Plancher.FLOTTANT_DESC+"\t\t\t\t %.2f%s\n"
    +ConstantesCommunes.LIGNE,prixCeramique, ConstantesCommunes.DOLLARS, prixTuilesDeVinyle, ConstantesCommunes.DOLLARS, prixLinoleum
    , ConstantesCommunes.DOLLARS
    ,prixBoisFranc, ConstantesCommunes.DOLLARS, prixFlottant, ConstantesCommunes.DOLLARS);


        //

    }


}
