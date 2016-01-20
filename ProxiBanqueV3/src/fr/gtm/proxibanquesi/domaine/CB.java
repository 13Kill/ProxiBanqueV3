package fr.gtm.proxibanquesi.domaine;

/**
 * Classe abstraite représentant une carte bancaire générique.
 * 
 * @author Martin Coralie - De Bruyn Alexandre
 */
public abstract class CB {

	// Propriétés
	/** Numéro de la carte */
	private int nCB;
	/** Compte bancaire associé à la carte */
//	private CompteBancaire compteAssocie;
	/** Type de la carte: Electron ou Premier. */
	private String type;
	
	// Getters & Setters
	public int getnCB() {
		return nCB;
	}
	public void setnCB(int nCB) {
		this.nCB = nCB;
	}
//	public CompteBancaire getCompteAssocie() {
//		return compteAssocie;
//	}
//	public void setCompteAssocie(CompteBancaire compteAssocie) {
//		this.compteAssocie = compteAssocie;
//	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}