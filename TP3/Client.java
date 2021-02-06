/**
 * Addresse: Cette classe gère les données des clients.
 *
 * @author Amel Yalaoui.
 * 
 * @version 05-12-20.
 */
public class Client {
    //declaration des attributs
    private String nom;
    private String prenom;
    private String addresse;
    private String numeroTelephone;

    /**
     * Permet d'initialiser les attributs  le nom, le prenom, l'addresse et le numéro
     * de téléphone du client.
     *
     * @param nom             le mom du client.
     * @param prenom          le prenom du client.
     * @param addresse        l'addresse du client.
     * @param numeroTelephone le numéro de téléphone du client.
     */

    public Client(String nom, String prenom, String addresse, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.addresse = addresse;
        this.numeroTelephone = numeroTelephone;


    }

    /**
     * Obtenir le nom du client.
     *
     * @return le nom du client.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie ou initialise  le nom du client.
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtenir le prenom du client.
     *
     * @return prenom.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie ou initialise le prenom du client.
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Obtenir l'addresse du client.
     *
     * @return addresse.
     */
    public String getAddresse() {
        return addresse;
    }

    /**
     * Modifie ou initialise l'addresse du client.
     *
     * @param addresse
     */
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    /**
     * Obtenir le numéro de téléphone du client.
     *
     * @return numeroTelephone.
     */
    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    /**
     * Modifie ou initialise le numéro de téléphone.
     *
     * @param numeroTelephone
     */
    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
}
