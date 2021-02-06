/**
 * Plancher: cette classe contient les informations par rapport aux types
 * de plancher.
 *
 * @author Saliou Cisse
 * @version 05-12-20
 */

public class Plancher {

    //déclaration des constantes
    public static final int CERAMIQUE = 1;
    public static final int TUILESDEVINYLE = 2;
    public static final int LINOLEUM = 3;
    public static final int BOISFRANC = 4;
    public static final int FLOTTANT = 5;
    public static final String CERAMIQUE_DESC = "Céramique";
    public static final String TUILESDEVINYLE_DESC = "Tuiles de vinyle";
    public static final String LINOLEUM_DESC = "Linoléum";
    public static final String BOISFRANC_DESC = "Bois franc";
    public static final String FLOTTANT_DESC = "Flottant";

    //déclaration des attributs
    private int typePlancher;
    private float prixInstallationPiedsCarre;

    /**
     * Permet d'initialiser  tous les attributs.
     *
     * @param typePlancher               le type de plancher à installer.
     * @param prixInstallationPiedsCarre le prix d'installation.
     */

    public Plancher(int typePlancher, float prixInstallationPiedsCarre) {
        this.typePlancher = typePlancher;
        this.prixInstallationPiedsCarre = prixInstallationPiedsCarre;

    }

    /**
     * Obtenir le type de plancher.
     *
     * @return typePlancher.
     */
    public int getTypePlancher() {
        return typePlancher;
    }

    /**
     * Modifie ou initialise le type de plancher.
     *
     * @param typePlancher
     */

    public void setTypePlancher(int typePlancher) {
        this.typePlancher = typePlancher;
    }

    /**
     * Obtenir le prix d'installation.
     *
     * @return prixInstallationPiedsCarre;
     */
    public float getPrixInstallationPiedsCarre() {
        return prixInstallationPiedsCarre;
    }

    /**
     * Modifie ou initialise le prix d'installation.
     *
     * @param prixInstallationPiedsCarre
     */

    public void setPrixInstallationPiedsCarre(float prixInstallationPiedsCarre) {
        this.prixInstallationPiedsCarre = prixInstallationPiedsCarre;
    }

    /**
     * But : permet d'obtenir la description du type de plancher.
     *
     * @return la description
     */
    
    public String obtenirDesription() {
        String description = new String("");
        switch (typePlancher) {
            case CERAMIQUE:
                description = CERAMIQUE_DESC;
                break;
            case TUILESDEVINYLE:
                description = TUILESDEVINYLE_DESC;
                break;
            case LINOLEUM:
                description = LINOLEUM_DESC;
                break;
            case BOISFRANC:
                description = BOISFRANC_DESC;
                break;
            case FLOTTANT:
                description = FLOTTANT_DESC;
        }
        return description;
    }
    
    

}
