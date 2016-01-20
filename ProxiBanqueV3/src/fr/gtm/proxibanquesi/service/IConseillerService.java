package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Interface de la couche Service du Conseiller
 * Elle liste les méthodes de CRUD d'un conseiller, et la méthode pour lister ses clients.
 * @author Alexandre et Coralie
 *
 */
public interface IConseillerService {
	
	/**
	 * Methode pour créer un conseiller.
	 * @param cons : le conseiller
	 * @return
	 * @throws LigneExistanteException
	 * @throws LigneInexistanteException
	 */
	public Conseiller createConseiller(Conseiller cons) throws LigneExistanteException, LigneInexistanteException;

	/**
	 * Methode pour vérifier les identifiants d'un conseiller.
	 * @param userTemp : le conseiller
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Conseiller checkUser(Conseiller userTemp) throws LigneInexistanteException;
	
	/**
	 * Methode pour lister les clients d'un conseiller.
	 * @param cons : le conseiller
	 * @return
	 */
	public Conseiller getListeClients(Conseiller cons);
	
	public ArrayList<Client> getClients(Conseiller cons) throws LigneInexistanteException;

}
