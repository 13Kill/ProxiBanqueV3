package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD pour la table Compte
 * de la base de données.
 * 
 * @author Alexandre De Bruyn
 *
 */
public interface ICompteDao {

	/**
	 * Méthode de création un compte Epargne.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 */
	public CompteEpargne createEpargne(CompteEpargne comt);

	/**
	 * Méthode de création un compte Courant.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 */
	public CompteCourant createCourant(CompteCourant comt);

	/**
	 * Méthode pour lire les informations d'un compte courant.
	 * 
	 * @param comt
	 *            : le compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public CompteCourant readCourant(CompteCourant comt) throws LigneInexistanteException;
	
	/**
	 * Méthode pour lire les informations d'un compte epargne.
	 * 
	 * @param comt
	 *            : le compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public CompteEpargne readEpargne(CompteEpargne comt) throws LigneInexistanteException;

	/**
	 * Méthode pour supprimer un compte.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int delete(Compte comt) throws LigneInexistanteException;

	/**
	 * Méthode qui récupère la liste des numéros de compte courant d'un client à partir
	 * de son identifiant.
	 * 
	 * @param id
	 *            L'identifiant du client
	 * @return Une liste de numéros de compte
	 */
	public ArrayList<Integer> getListeComptesCourant(int id);
	
	/**
	 * Méthode qui récupère la liste des numéros de compte épargne d'un client à partir
	 * de son identifiant.
	 * 
	 * @param id
	 *            L'identifiant du client
	 * @return Une liste de numéros de compte
	 */
	public ArrayList<Integer> getListeComptesEpargne(int id);
	
	/**
	 * Méthode de modification d'un compte Courant.
	 * @param compte : compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int updateCourant(CompteCourant compte) throws LigneInexistanteException;
	
	/**
	 * Méthode de modification d'un compte Epargne.
	 * @param compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int updateEpargne(CompteEpargne compte) throws LigneInexistanteException;
	
	/**
	 * Méthode pour déterminer le type d'un compte soit Courant soit Epargne.
	 * @param id : l'identifiant du client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public String typeCompte(int id) throws LigneInexistanteException;
	

	

}
