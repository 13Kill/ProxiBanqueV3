package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD pour la table CLIENT
 * de la base de données.
 * 
 * @author Alexandre De Bruyn
 *
 */
public interface IClientDao {

	/**
	 * Méthode de création de client.
	 * 
	 * @param cli
	 *            : le client
	 * @return
	 * @throws LigneExistanteException
	 */
	public int create(Client cli) throws LigneExistanteException;

	/**
	 * Méthode de lecture des informations du client.
	 * 
	 * @param cli
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Client read(Client cli) throws LigneInexistanteException;

	/**
	 * Méthode pour modifier les informations du client.
	 * 
	 * @param cli
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int update(Client cli) throws LigneInexistanteException;

	/**
	 * Méthode pour effacer un client.
	 * 
	 * @param cli
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int delete(Client cli) throws LigneInexistanteException;

	/**
	 * Méthode pour récupérer l'identifiant d'un client à partir de son nom,
	 * prénom et adresse.
	 * 
	 * @param cli
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Client getID(Client cli) throws LigneInexistanteException;

	/**
	 * Méthode qui récupère la liste des identifiants clients à partir de
	 * l'identifiant d'un conseiller.
	 * 
	 * @param idcons
	 *            L'identifiant du conseiller responsable des clients.
	 * @return Une liste d'identifiants client.
	 */
	public ArrayList<Integer> getListeClients(int idcons);

}
