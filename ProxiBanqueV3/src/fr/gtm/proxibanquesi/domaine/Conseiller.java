package fr.gtm.proxibanquesi.domaine;

import java.util.ArrayList;

/** Cette classe représente un conseiller d'une agence ProxiBanque.
 * @author Martin Coralie - De Bruyn Alexandre
 *
 */
public class Conseiller {
	// Prorpiétés
	/** Prenom du conseiller. */
	private String prenom;
	/** Nom du conseiller. */
	private String nom;
	/** Numéro d'identification du conseiller. */
	private int idcons;
	/** Numéro d'identification de l'agence. */
	private int idagence;
	/** True si le conseiller est également le gérant de l'agence. */
	private boolean gerant = false;
	/** Liste des numéros d'identification des clients à la charge du conseiller. */
	private ArrayList<Integer> listeClient = new ArrayList<Integer>();
	
	private String login;
	private String mdp;

	// Constructeurs
	public Conseiller() {
	}
	public Conseiller(String nom, String prenom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.idagence = 1;
		this.gerant = false;
	}	
	public Conseiller(String nom, String prenom, boolean gerant) {
		this(nom, prenom);
		this.gerant = true;		
	}
	public Conseiller(String nom, String prenom, String login, String mdp) {
		this(nom, prenom);
		this.login = login;
		this.mdp = mdp;
	}
	public Conseiller(String nom, String prenom, String login, String mdp, boolean gerant) {
		this(nom, prenom, gerant);
		this.login = login;
		this.mdp = mdp;
	}
	
	// Getters & Setters
	public String getPrenom() {
		return this.prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdcons() {
		return idcons;
	}
	public void setIdcons(int idcons) {
		this.idcons = idcons;
	}
	public int getIdagence() {
		return idagence;
	}
	public void setIdagence(int idagence) {
		this.idagence = idagence;
	}
	public boolean isGerant() {
		return gerant;
	}
	public void setGerant(boolean gerant) {
		this.gerant = gerant;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public ArrayList<Integer> getListeClient() {
		// TODO: acceder au dao pour donnees clients (nom, prenom)
		return this.listeClient;
	}
	public void setListeClient(ArrayList<Integer> listeClient) {
		this.listeClient = listeClient;
	}
	@Override
	public String toString() {
		return "Conseiller [prenom=" + prenom + ", nom=" + nom + ", idcons=" + idcons + ", idagence=" + idagence
				+ ", gerant=" + gerant + ", listeClient=" + listeClient + ", login=" + login + ", mdp=" + mdp + "]";
	}




}
