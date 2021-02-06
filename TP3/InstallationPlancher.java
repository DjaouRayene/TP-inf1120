/**
 * InstallationPlancher: ce classe permet d'instancier
 * l'installation d'un plancher.
 *
 * @author Saliou Cisse
 * @version 06-12-2020
 */

public class InstallationPlancher {
    //déclaration des constantes
    public static final String ENTREPRISE_TYPE = "Entreprise";
    public static final String DEBIT = "Débit";
    public static final String CREDIT = "Crédit";
    public static final String CASH = "Cash";
    public static final String RESIDENCE_TYPE = "Résidentiel";
    public static final char GRAND_ENTREPRISE = 'E';
    public static final char GRAND_RESIDENCE = 'R';
    public static final char GRAND_DEBIT = 'D';
    public static final char GRAND_CASH = 'S';
    public static final char GRAND_CREDIT = 'C';
    public static final char PETIT_CASH = 's';
    public static final char PETIT_RESIDENCE = 'r';
    public static final char PETIT_ENTREPRISE = 'e';
    public static final char PETIT_DEBIT = 'd';
    public static final char PETIT_CREDIT = 'c';

    //déclaration des attributs
    private Plancher plancherInstaller;
    private Client client;
    private float surface;
    private char typeBatiment;
    private char modePaiement;

    /**
     * Permet d'initialiser tous les attributs de la classe.
     *
     * @param plancherInstaller le tyoe de plancher à installer.
     * @param client            contient les données sur le client.
     * @param surface           la surface à  couvrir.
     * @param typeBatiment      le type de bâtiment.
     * @param modePaiement      le mode de paiement.
     */

    public InstallationPlancher(Plancher plancherInstaller, Client client,float surface
            , char typeBatiment, char modePaiement) {

        this.plancherInstaller = plancherInstaller;
        this.client = client;
        this.surface = surface;
        this.typeBatiment = typeBatiment;
        this.modePaiement = modePaiement;


    }

    /**
     * Obtenir le type de plancher à installer.
     *
     * @return plancherInstaller;
     */
    public Plancher getPlancherInstaller() {
        return plancherInstaller;
    }

    /**
     * Modifie ou initialise le type de plancher à installer.
     *
     * @param plancherInstaller
     */

    public void setPlancherInstaller(Plancher plancherInstaller) {
        this.plancherInstaller = plancherInstaller;
    }

    /**
     * Obtenir les données sur le client.
     *
     * @return client.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Modifie ou initialise les données sur le client.
     *
     * @param client
     */

    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Obtenir la surface à couvrir
     *
     * @return surface.
     */
    public float getSurface() {
        return surface;
    }

    /**
     * Modifie ou initialise la surface à couvrir.
     *
     * @param surface
     */
    public void setSurface(float surface) {
        this.surface = surface;
    }

    /**
     * Obtenir le type de batiment.
     *
     * @return typeBatiment
     */
    public char getTypeBatiment() {
        return typeBatiment;
    }

    /**
     * Modifie ou initialise le type de bâtiment.
     *
     * @param typeBatiment
     */
    public void setTypeBatiment(char typeBatiment) {
        this.typeBatiment = typeBatiment;
    }

    /**
     * Obtenir le mode de paiement.
     *
     * @return modePaiement
     */
    public char getModePaiement() {
        return modePaiement;
    }

    /**
     * Modifie ou initialise le mode de paiement.
     *
     * @param modePaiement
     */
    public void setModePaiement(char modePaiement) {
        this.modePaiement = modePaiement;
    }

    /**
     * Obtenir la description du type de bâtiment.
     *
     * @param typeBatiment
     * @return description.
     */
    public String obtenirDesciptionTypeBatiment(char typeBatiment) {
        String description = "";
        switch (typeBatiment) {
            case PETIT_ENTREPRISE:
            case GRAND_ENTREPRISE:
                description = ENTREPRISE_TYPE;
                break;
            case PETIT_RESIDENCE:
            case GRAND_RESIDENCE:
                description = RESIDENCE_TYPE;
                break;
        }
        return description;
    }
    /**
     * Obtenir la description du mode de paiement.
     * 
     * @param modePaiement.
     * @return description.
     */

    public String obtenirDescriptionModePaiement(char modePaiement) {
        String description = "";
        switch (modePaiement) {
            case PETIT_CASH:
            case GRAND_CASH:
                description = CASH;
                break;
            case GRAND_DEBIT:
            case PETIT_DEBIT:
                description = DEBIT;
                break;
            case GRAND_CREDIT:
            case PETIT_CREDIT:
                description = CREDIT;
                break;
        }
        return description;
    }


}
