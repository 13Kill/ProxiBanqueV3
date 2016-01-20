package fr.gtm.proxibanquesi.domaine;

 /** Classe représentant un placement boursier.
 * @author Martin Coralie - De Bruyn Alexandre
 */
public class Placement {

	// Propriétés
	
	/**  la bource où est réalisée le placement*/
	private String bourse;
	/**  la somme placée*/
	private double somme;

	// Constructeur
	public Placement(String bourse, double somme) {
		super();
		this.bourse = bourse;
		this.somme = somme;
	}

	// Getters & Setters
	public String getBourse() {
		return bourse;
	}
	public void setBourse(String bourse) {
		this.bourse = bourse;
	}
	public double getSomme() {
		return somme;
	}
	public void setSomme(double somme) {
		this.somme = somme;
	}

	// Affichage
	@Override
	public String toString() {
		return "Placement [bourse=" + bourse + ", somme=" + somme + "]\n";
	}
}