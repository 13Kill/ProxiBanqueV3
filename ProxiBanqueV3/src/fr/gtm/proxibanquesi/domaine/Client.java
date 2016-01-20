package fr.gtm.proxibanquesi.domaine;

import java.util.ArrayList;

/** Classe représentant un client de la banque.
 * Toutes les informations personnelles hormis le numéro d'identification sont de type String.
 * @author Martin Coralie - De Bruyn Alexandre
 */
public class Client {
	
	
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	/** Numéro d'identification du client */
	private int id;
	private int cons;
	private ArrayList<Integer> listeComptesCourant;
	private ArrayList<Integer> listeComptesEpargne;
	private CompteCourant cptcrt;
	private CompteEpargne cptepg;
//	/** Liste des placements effectués pour ce client */
//	private ArrayList<Placement> patrimoine;

	// Constructeurs
	public Client() {
		super();
//		listeComptes = new HashMap<Integer, CompteBancaire>();
//		patrimoine = new ArrayList<Placement>();
		}
	
	/**
	 * Construteur d'un Client avec
	 * @param nom : son nom
	 * @param prenom : son prenom
	 * @param adresse : son adresse
	 * @param codePostal : son code postal
	 * @param ville : sa ville
	 * @param telephone : son numéro de téléphone
	 * @param idcons : l'identification de son conseiller
	 */
	public Client(String nom, String prenom, String adresse, String codePostal,
			String ville, String telephone, int idcons) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.cons = idcons;
	}

	// Getters & Setters
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return this.adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return this.codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return this.ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
//	public HashMap<Integer, CompteBancaire> getListeComptes() {
//		return listeComptes;
//	}
//	public void setListeComptes(HashMap<Integer, CompteBancaire> listeComptes) {
//		this.listeComptes = listeComptes;
//	}
//	public ArrayList<Placement> getPatrimoine() {
//		return patrimoine;
//	}
//	public void setPatrimoine(ArrayList<Placement> patrimoine) {
//		this.patrimoine = patrimoine;
//	}

	public CompteCourant getCptcrt() {
		return cptcrt;
	}

	public void setCptcrt(CompteCourant cptcrt) {
		this.cptcrt = cptcrt;
	}

	public CompteEpargne getCptepg() {
		return cptepg;
	}

	public void setCptepg(CompteEpargne cptepg) {
		this.cptepg = cptepg;
	}

	public int getCons() {
		return cons;
	}

	public void setCons(int cons) {
		this.cons = cons;
	}

	public ArrayList<Integer> getListeComptesCourant() {
		return listeComptesCourant;
	}

	public void setListeComptesCourant(ArrayList<Integer> listeComptesCourant) {
		this.listeComptesCourant = listeComptesCourant;
	}

	public ArrayList<Integer> getListeComptesEpargne() {
		return listeComptesEpargne;
	}

	public void setListeComptesEpargne(ArrayList<Integer> listeComptesEpargne) {
		this.listeComptesEpargne = listeComptesEpargne;
	}

	// Affichage
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", telephone=" + telephone + ", id=" + id + ", cons=" + cons + "]";
	}




}