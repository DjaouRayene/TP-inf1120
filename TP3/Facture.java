import java.util.Formatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Facture: cette classe permet de gennerer la facture.
 *
 * @author Amel Yalaoui.
 * @version 12 Decembre 2020.
 */


public class Facture {
    //Declaration des constantes
    public static final float TPS = 0.05f;
    public static final float TVQ = 0.09975f;
    

    //Declaration des attributs
    private static int numeroFacture = 0;
    private InstallationPlancher plancherInstaller;
    private float sousTotal ;
    private float montantTps;
    private float montantTvq;
    private float totalFacture;

    /**
     * Initialise l'attribut l'installation plancher.
     *
     * @param plancherInstaller le plancher à installer.
     */

    public Facture(InstallationPlancher plancherInstaller) {
        this.plancherInstaller = plancherInstaller;
    }

    /**
     * But:  permet incrementer le numero de la facture.
     *
     * @return numeroFacture.
     */
    public static int incrementerFacture() {
        numeroFacture = numeroFacture + 1;
        return numeroFacture;
    }

    /**
     * But : permet de faire afficher la date et l'heure dans le programme;
     *
     * @return la date et heure locale formaté.
     */
    public static String heureDate() {
        String temps;
        LocalDateTime maDate = LocalDateTime.now();
        DateTimeFormatter maDateFormat = DateTimeFormatter.ofPattern(" dd-MM-yyyy  HH:mm:ss ");
        temps = maDate.format(maDateFormat);

        return temps;
    } //heureDate;

    /**
     * But: Permet de formater le numéro de téléphone du client.
     *
     * @param tel numéro du client.
     * @return le numéro de téléphone formaté.
     */
    public static String formaterNumeroTelephone(String tel) {
        tel = tel.substring(0, 3).concat(tel.substring(4));
        tel = tel.replaceFirst("(\\d{3})(\\d+)", "($1) $2");
        return tel;
    }

    /**
     * Obtenir le total de la facture.
     *
     * @return totalFacture.
     */
    public float getTotalFacture() {
        return totalFacture;
    }

    /**
     * But: permet de calculer le sous_total de la facture.
     */
    public void calculerSousTotal() {
        float surface = plancherInstaller.getSurface();
        float prixInstallationPiedCarre = plancherInstaller.getPlancherInstaller().getPrixInstallationPiedsCarre();
        sousTotal = surface * prixInstallationPiedCarre;

    }

    /**
     * But: permet d'afficher la facture de l'installation d'un plancher.
     */

    /**
     * But: permet de calculer le montant TPS de la facture.
     */

    public void calculerMontantTps() {
        montantTps = sousTotal * TPS;
    }

    /**
     * But: permet de calculer le montant TVQ  de la facture.
     */

    public void calculerMontantTvq() {
        montantTvq = sousTotal * TVQ;
    }

    /**
     * But: permet de calculer le total de la facture.
     */
    public void calculerMontantTotalFacture() {
        totalFacture = sousTotal + montantTps + montantTvq;
    }

    public void afficherFacture() {
        calculerSousTotal();
        calculerMontantTps();
        calculerMontantTvq();
        calculerMontantTotalFacture();
        String nom = plancherInstaller.getClient().getNom();
        String prenom = plancherInstaller.getClient().getPrenom();
        String telephone = formaterNumeroTelephone(plancherInstaller.getClient().getNumeroTelephone());
        String addresse = plancherInstaller.getClient().getAddresse();
        String date = heureDate();
        int numeroFacture = incrementerFacture();
        float surface = plancherInstaller.getSurface();
        String typeBatiment = plancherInstaller.obtenirDesciptionTypeBatiment(plancherInstaller.getTypeBatiment());
        String typePlancher = plancherInstaller.getPlancherInstaller().obtenirDesription();
        String modePaiement = plancherInstaller.obtenirDescriptionModePaiement(plancherInstaller.getModePaiement());
        float prixPiedsCarre = plancherInstaller.getPlancherInstaller().getPrixInstallationPiedsCarre();

        System.out.println(ConstantesCommunes.LIGNE +ConstantesCommunes.PROPRIETAIRE +ConstantesCommunes.NUMERO_FACTURE
                + numeroFacture + "\t\t\t\t "+ConstantesCommunes.DATE_HEURE + date
                +  ConstantesCommunes.RESIDENCE+"\t "+ConstantesCommunes.NUMERO_ENTREPRISE+"\n"
                + ConstantesCommunes.LIGNE + ConstantesCommunes.NOM_PRENOM  + nom + " " + prenom + "\t\tTéléphone : " + telephone
                + ConstantesCommunes.ADDRESSE_CLIENT + addresse);


        System.out.printf("%n La surface à couvrir: %.1f pied carré%n"
                        + " Le type de bâtiment: %s %n"
                        + " Le type de plancher : %s %n"
                        + " Le mode de paiement : %s %n%n"
                        + " Prix par pied carré\t\t\t %.2f$ %n"
                        + " Sous-total\t\t\t\t %.2f$ %n"
                        + " Montant TPS\t\t\t\t %.2f$ %n"
                        + " Montant TVQ\t\t\t\t %.2f$ %n"
                        + " Montant total\t\t\t\t %.2f$ %n"
                        + "\t\t ------------------------------------------------------ %n"
                        + "\t\t\t Merci pour votre confiance! %n%n", surface
                , typeBatiment, typePlancher, modePaiement, prixPiedsCarre
                , sousTotal, montantTps, montantTvq, totalFacture

        );

    }


}
