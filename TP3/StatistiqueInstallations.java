import java.io.IOException;
import java.io.PrintWriter;

/**
 * Statistiques Installations: cette classe permet de dresser le rapport concernant
 * toutes les installations de planchers.
 *
 * @author Saliou .
 * @version 06-Decembre-2020
 */

public class StatistiqueInstallations {
    //declaration des constantes
    public static final String LIGNE = "\n----------------------------------------------------------------------------------------------------\n";
    public final static String DETAILS = "   Le type de plancher\tLe nombre de planchers installés\tLe montant total des installations\n";
    public final static String NOM_FICHIER_ECRITURE = "LesStatistiques.txt";

    //declarations des attributs
    private int nombrePlanchersCeramiqueInstaller;
    private int nombrePlanchersTuileDeVinyleInstaller;
    private int nombrePlanchersLinoleumInstaller;
    private int nombrePlanchersBoisFrancInstaller;
    private int nombrePlanchersFlottantInstaller;
    private float montantsInstallationCeramique;
    private float montantsInstallationTuileDeVinyle;
    private float montantsInstallationLinoleum;
    private float montantsInstallationBoisFranc;
    private float montantsInstallationFlottant;

    /**
     * But: cette methode permet d'incrementer le nombre de planchers installés d'un type donné.
     *
     * @param typePlancher
     */
    public void incrementerNombrePlancherInstaller(int typePlancher) {
        switch (typePlancher) {
            case Plancher.CERAMIQUE:
                nombrePlanchersCeramiqueInstaller += 1;
                break;
            case Plancher.TUILESDEVINYLE:
                nombrePlanchersTuileDeVinyleInstaller += 1;
                break;
            case Plancher.LINOLEUM:
                nombrePlanchersLinoleumInstaller += 1;
                break;
            case Plancher.BOISFRANC:
                nombrePlanchersBoisFrancInstaller += 1;
                break;
            case Plancher.FLOTTANT:
                nombrePlanchersFlottantInstaller += 1;
                break;
        }
    }

    /**
     * But: permet d'ajuster le montant des installations des planchers d'un type donné.
     *
     * @param typePlancher
     * @param totalFacture
     */

    public void montantInstallationsTypePlancher(int typePlancher, float totalFacture) {
        switch (typePlancher) {
            case Plancher.CERAMIQUE:
                montantsInstallationCeramique += totalFacture;
                break;
            case Plancher.TUILESDEVINYLE:
                montantsInstallationTuileDeVinyle += totalFacture;
                break;
            case Plancher.LINOLEUM:
                montantsInstallationLinoleum += totalFacture;
                break;
            case Plancher.BOISFRANC:
                montantsInstallationBoisFranc += totalFacture;
                break;
            case Plancher.FLOTTANT:
                montantsInstallationFlottant += totalFacture;
                break;
        }
    }

    /**
     * But : permet d'afficher le nombre de plancher installés par type de plancher et
     * le montant total des installations par type de plancher.
     */

    public void afficherNombresPlanchersEtMontantTotalDesInstallations() {


        int nombreTotal = nombrePlanchersCeramiqueInstaller + nombrePlanchersBoisFrancInstaller + nombrePlanchersFlottantInstaller
                + nombrePlanchersLinoleumInstaller + nombrePlanchersTuileDeVinyleInstaller;
        float montantTotal = montantsInstallationBoisFranc + montantsInstallationFlottant + montantsInstallationLinoleum
                + montantsInstallationTuileDeVinyle + montantsInstallationCeramique;
        String date = Facture.heureDate();
        System.out.println(ConstantesCommunes.LIGNE +ConstantesCommunes.PROPRIETAIRE+"\n" +
                ConstantesCommunes.DATE_HEURE + date
                +ConstantesCommunes.RESIDENCE+"\t\t "+ConstantesCommunes.NUMERO_ENTREPRISE+ ConstantesCommunes.LIGNE);
        System.out.println(" Le type de plancher\t Le nombre de planchers installés \t Le montant total des installations\n");
        System.out.printf(ConstantesCommunes.SPACE + Plancher.CERAMIQUE_DESC + " \t\t\t   %d \t\t\t\t\t %.2f%s\n" +
                        ConstantesCommunes.SPACE + Plancher.TUILESDEVINYLE_DESC + "\t\t   %d \t\t\t\t\t %.2f%s\n"
                        + ConstantesCommunes.SPACE + Plancher.LINOLEUM_DESC + "\t\t\t   %d \t\t\t\t\t %.2f%s\n"
                        + ConstantesCommunes.SPACE + Plancher.BOISFRANC_DESC + "\t\t\t   %d \t\t\t\t\t %.2f%s\n"
                        + ConstantesCommunes.SPACE + Plancher.FLOTTANT_DESC + "\t\t\t   %d \t\t\t\t\t %.2f%s \n\n"
                        + ConstantesCommunes.SPACE + "Total\t\t\t   %d \t\t\t\t\t %.2f%s\n" + ConstantesCommunes.LIGNE
                , nombrePlanchersCeramiqueInstaller, montantsInstallationCeramique, ConstantesCommunes.DOLLARS
                , nombrePlanchersTuileDeVinyleInstaller, montantsInstallationTuileDeVinyle, ConstantesCommunes.DOLLARS
                , nombrePlanchersLinoleumInstaller, montantsInstallationLinoleum, ConstantesCommunes.DOLLARS
                , nombrePlanchersBoisFrancInstaller, montantsInstallationBoisFranc, ConstantesCommunes.DOLLARS
                , nombrePlanchersFlottantInstaller, montantsInstallationFlottant, ConstantesCommunes.DOLLARS
                , nombreTotal, montantTotal, ConstantesCommunes.DOLLARS);

    }

    public String formater() {
        String statistiques = Plancher.CERAMIQUE_DESC + "|" + nombrePlanchersCeramiqueInstaller + "|" + montantsInstallationCeramique
                + "\n" + Plancher.TUILESDEVINYLE_DESC + "|" + nombrePlanchersTuileDeVinyleInstaller + "|" + montantsInstallationTuileDeVinyle
                + "\n" + Plancher.LINOLEUM_DESC + "|" + nombrePlanchersLinoleumInstaller + "|" + montantsInstallationLinoleum
                + "\n" + Plancher.BOISFRANC_DESC + "|" + nombrePlanchersBoisFrancInstaller + "|" + montantsInstallationBoisFranc
                + "\n" + Plancher.FLOTTANT_DESC + "|" + nombrePlanchersFlottantInstaller + "|" + montantsInstallationFlottant;
        return statistiques;
    }

    public void ecrire() {
        //déclaration de la variable.
        PrintWriter editeur;
        String format = formater();
        try {
            editeur = new PrintWriter(NOM_FICHIER_ECRITURE);
            editeur.println(format);

        editeur.close();
        } catch (IOException e) {
            System.out.println("Erreur d'entrée/sortie");
        }

    }


}



