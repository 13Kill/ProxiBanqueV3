package fr.gtm.proxibanquesi.service;

import fr.gtm.proxibanquesi.dao.ClientDao;
import fr.gtm.proxibanquesi.dao.CompteDao;
import fr.gtm.proxibanquesi.dao.IClientDao;
import fr.gtm.proxibanquesi.dao.ICompteDao;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;

public class CompteService implements ICompteService {

	@Override
	public int creerCompte(CompteCourant compte) {
		ICompteDao dao = new CompteDao();
		compte = dao.createCourant(compte);
		return compte.getNumCompte();
	}

	@Override
	public int creerCompte(CompteEpargne compte) {
		ICompteDao dao = new CompteDao();
		compte = dao.createEpargne(compte);
		return compte.getNumCompte();
	}

	@Override
	public CompteCourant consulterCompte(CompteCourant compte) throws LigneInexistanteException {
		ICompteDao dao = new CompteDao();
		compte = dao.readCourant(compte);
		return compte;
	}

	@Override
	public CompteEpargne consulterCompte(CompteEpargne compte) throws LigneInexistanteException {
		// TODO Auto-generated method stub
		ICompteDao dao = new CompteDao();
		compte = dao.readEpargne(compte);
		return compte;
	}

	@Override
	public int modifierCompte(CompteCourant compte) throws LigneInexistanteException {
		// TODO Auto-generated method stub
		ICompteDao dao = new CompteDao();
		int res = 0;
		res = dao.updateCourant(compte);
		return res;
	}

	@Override
	public int modifierCompte(CompteEpargne compte) throws LigneInexistanteException {
		// TODO Auto-generated method stub
		ICompteDao dao = new CompteDao();
		int res = 0;
		res = dao.updateEpargne(compte);
		return res;
	}

	@Override
	public int supprimerCompte(Compte compte) throws LigneInexistanteException {
		ICompteDao dao = new CompteDao();
		return dao.delete(compte);
	}

	@Override
	public int virement(CompteCourant compteDebiteur, CompteCourant compteCrediteur, Double montant)
			throws SoldeInsuffisantException, LigneInexistanteException {
		if ((compteDebiteur.getSolde() + compteDebiteur.getAutorisationDecouvert()) < montant) {
			throw new SoldeInsuffisantException();
		} else {
			compteDebiteur.setSolde(compteDebiteur.getSolde() - montant);
			compteCrediteur.setSolde(compteCrediteur.getSolde() + montant);
			ICompteDao dao = new CompteDao();
			dao.updateCourant(compteDebiteur);
			dao.updateCourant(compteCrediteur);
		}

		return 0;
	}

	@Override
	public int virement(CompteEpargne compteDebiteur, CompteEpargne compteCrediteur, Double montant)
			throws SoldeInsuffisantException, LigneInexistanteException {
		if (compteDebiteur.getSolde() < montant) {
			throw new SoldeInsuffisantException();
		} else {
			compteDebiteur.setSolde(compteDebiteur.getSolde() - montant);
			compteCrediteur.setSolde(compteCrediteur.getSolde() + montant);
			ICompteDao dao = new CompteDao();
			dao.updateEpargne(compteDebiteur);
			dao.updateEpargne(compteCrediteur);
		}

		return 0;
	}

	@Override
	public int virement(CompteEpargne compteDebiteur, CompteCourant compteCrediteur, Double montant)
			throws SoldeInsuffisantException, LigneInexistanteException {
		if (compteDebiteur.getSolde() < montant) {
			throw new SoldeInsuffisantException();
		} else {
			compteDebiteur.setSolde(compteDebiteur.getSolde() - montant);
			compteCrediteur.setSolde(compteCrediteur.getSolde() + montant);
			ICompteDao dao = new CompteDao();
			dao.updateEpargne(compteDebiteur);
			dao.updateCourant(compteCrediteur);
		}

		return 0;
	}

	@Override
	public int virement(CompteCourant compteDebiteur, CompteEpargne compteCrediteur, Double montant)
			throws SoldeInsuffisantException, LigneInexistanteException {
		if ((compteDebiteur.getSolde() + compteDebiteur.getAutorisationDecouvert()) < montant) {
			throw new SoldeInsuffisantException();
		} else {
			compteDebiteur.setSolde(compteDebiteur.getSolde() - montant);
			compteCrediteur.setSolde(compteCrediteur.getSolde() + montant);
			ICompteDao dao = new CompteDao();
			dao.updateCourant(compteDebiteur);
			dao.updateEpargne(compteCrediteur);
		}

		return 0;
	}

	@Override
	public String typeCompte(int id) throws LigneInexistanteException {
		ICompteDao dao = new CompteDao();
		return dao.typeCompte(id);
	}

}
