package fr.gtm.proxibanquesi.dao;

import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD
 * pour la table CONSEILLER de la base de données.
 * @author Alexandre De Bruyn
 *
 */

public interface IConseillerDao {
	
	/**
	 * Méthode de création un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneExistanteException
	 */
	public int create(Conseiller cons) throws LigneExistanteException;
	
	/**
	 * Méthode pour lire les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Conseiller read(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * Méthode pour modifier les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int update(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * Méthode pour supprimer un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int delete(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * Méthode pour lire les informations d'un conseiller à partir de son identifiant.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Conseiller getID(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * Méthode pour vérifier le login et le password du conseiller
	 * @param userTemp
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Conseiller getUser(Conseiller userTemp) throws LigneInexistanteException;


	
}
