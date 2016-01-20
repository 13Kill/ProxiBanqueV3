package fr.gtm.proxibanquesi.domaine;

import java.util.ArrayList;

 /** Cette classe représente une agence de la société ProxiBanque.
 * @author Martin Coralie - De Bruyn Alexandre
 */
public class Agence {
	
	// Propriétés
	/** Instance de la classe Gerant, représentant le conseiller gérant l'agence */
//	Gerant gerant;
	/** Numéro d'itenfication de l'agence */
	private int numID;
	/** Date de création de l'agence */
	private String dateCreation;
	/** Liste des conseillers de l'agence */
	private ArrayList<Conseiller> listeConseillers;

	// Constructeurs
	public Agence(Integer id) {
		super();
		numID = id;
		listeConseillers = new ArrayList<Conseiller>();
		
	}
	
	public Agence(Integer id, String dateCreation) {
		this(id);
		this.dateCreation = dateCreation;
	}

//	public Agence(Integer id, String dateCreation, Gerant gerant) {
//		this(id);
//		this.gerant = gerant;
//		this.dateCreation = dateCreation;
//	}

	
	// Getters & Setters
	public int getNumID() {
		return this.numID;
	}
	public void setNumID(int numID) {
		this.numID = numID;
	}
//	public Gerant getGerant() {
//		return gerant;
//	}
//	public void setGerant(Gerant gerant) {
//		this.gerant = gerant;
//	}
	/**
	 * Déterminer la date de création de l'agence
	 * @return
	 */
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public ArrayList<Conseiller> getListeConseillers() {
		return listeConseillers;
	}
	/**
	 * Méthode pour lister les conseillers d'une agence.
	 * @param listeConseillers
	 */
	public void setListeConseillers(ArrayList<Conseiller> listeConseillers) {
		this.listeConseillers = listeConseillers;
	}

	// Affichage
	@Override
	public String toString() {
		return "Agence [numID=" + numID
				+ ", dateCreation=" + dateCreation + "]";
	}

}