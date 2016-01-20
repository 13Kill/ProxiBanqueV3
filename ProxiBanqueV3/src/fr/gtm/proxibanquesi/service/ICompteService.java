package fr.gtm.proxibanquesi.service;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;

/**
 * Interface de la couche Service du COmpte
 * Elle liste les méthodes de CRUD d'un compte.
 * @author Alexandre et Coralie
 *
 */
public interface ICompteService {
	
	/**
	 * Méthode pour créer un compte courant
	 * @param compte : compte courant
	 * @return
	 */
	public int creerCompte(CompteCourant compte);
	
	/**
	 * Méthode pour créer un compte épargne
	 * @param compte : compte épargne
	 * @return
	 */
	public int creerCompte(CompteEpargne compte);
	
	/**
	 * Méthode pour lire les informations d'un compte courant.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public CompteCourant consulterCompte(CompteCourant compte) throws LigneInexistanteException;
	
	/**
	 * Méthode pour lire les informations d'un compte épargne.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public CompteEpargne consulterCompte(CompteEpargne compte) throws LigneInexistanteException;
	
	/**
	 * Méthode pour modifier le solde d'un compte courant.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int modifierCompte(CompteCourant compte) throws LigneInexistanteException;
	
	/**
	 * Méthode pour modifier le solde d'un compte épargne.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int modifierCompte(CompteEpargne compte) throws LigneInexistanteException;
	
	/**
	 * Méthode pour supprimer un compte.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int supprimerCompte(Compte compte) throws LigneInexistanteException;
	
	/**
	 * Méthode de virement d'un compte courant vers un compte courant.
	 * @param compteDebiteur : compte courant
	 * @param compteCrediteur : compte courant
	 * @param montant
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	public int virement(CompteCourant compteDebiteur, CompteCourant compteCrediteur, Double montant) throws SoldeInsuffisantException, LigneInexistanteException;
	
	/**
	 * Méthode de virement d'un compte épargne vers un compte épargne.
	 * @param compteDebiteur : compte épargne
	 * @param compteCrediteur : compte épargne
	 * @param montant
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	public int virement(CompteEpargne compteDebiteur, CompteEpargne compteCrediteur, Double montant) throws SoldeInsuffisantException, LigneInexistanteException;
	
	/**
	 * Méthode de virement d'un compte courant vers un compte épargne.
	 * @param compteDebiteur : compte courant
	 * @param compteCrediteur : compte épargne
	 * @param montant
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	public int virement(CompteCourant compteDebiteur, CompteEpargne compteCrediteur, Double montant) throws SoldeInsuffisantException, LigneInexistanteException;
	
	/**
	 * Méthode de virement d'un compte épargne vers un compte courant.
	 * @param compteDebiteur : compte épargne
	 * @param compteCrediteur : compte courant
	 * @param montant
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	public int virement(CompteEpargne compteDebiteur, CompteCourant compteCrediteur, Double montant) throws SoldeInsuffisantException, LigneInexistanteException;
	
	/**
	 * Méthode pour déterminer le type d'un compte soit Courant, soit Epargne.
	 * @param id
	 * @return
	 * @throws LigneInexistanteException
	 */
	public String typeCompte(int id) throws LigneInexistanteException;
	
}
