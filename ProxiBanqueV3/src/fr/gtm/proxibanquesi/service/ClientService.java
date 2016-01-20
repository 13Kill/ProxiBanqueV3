package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.dao.ClientDao;
import fr.gtm.proxibanquesi.dao.CompteDao;
import fr.gtm.proxibanquesi.dao.IClientDao;
import fr.gtm.proxibanquesi.dao.ICompteDao;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

public class ClientService implements IClientService {

	@Override
	public Client createClient(Client cli) throws LigneExistanteException, LigneInexistanteException {
		IClientDao dao = new ClientDao();
		dao.create(cli);
		cli = dao.getID(cli);
		return cli;
	}

	@Override
	public Client getListeComptesCourant(Client cli) {
		ICompteDao dao = new CompteDao();
		cli.setListeComptesCourant(dao.getListeComptesCourant(cli.getId()));
		return cli;
	}

	@Override
	public Client getListeComptesEpargne(Client cli) {
		ICompteDao dao = new CompteDao();
		cli.setListeComptesEpargne(dao.getListeComptesEpargne(cli.getId()));
		return cli;
	}
	
	@Override
	public ArrayList<CompteCourant> getComptesCourant(Client cli) throws LigneInexistanteException {
		ICompteDao dao = new CompteDao();
		ArrayList<Integer> listeIndex = cli.getListeComptesCourant();
		if (listeIndex != null) {
			ArrayList<CompteCourant> listeComptes = new ArrayList<CompteCourant>();
			for(int i = 0; i < listeIndex.size(); i++) {
				CompteCourant co = new CompteCourant();
				co.setNumCompte(listeIndex.get(i));
				co = dao.readCourant(co);
				listeComptes.add(co);
				}
			return listeComptes;
		} else return null;
	}
	
	@Override
	public ArrayList<CompteEpargne> getComptesEpargne(Client cli) throws LigneInexistanteException {
		ICompteDao dao = new CompteDao();
		ArrayList<Integer> listeIndex = cli.getListeComptesEpargne();
		if (listeIndex != null) {
			ArrayList<CompteEpargne> listeComptes = new ArrayList<CompteEpargne>();
			for(int i = 0; i < listeIndex.size(); i++) {
				CompteEpargne co = new CompteEpargne();
				co.setNumCompte(listeIndex.get(i));
				co = dao.readEpargne(co);
				listeComptes.add(co);
				}
			return listeComptes;
		} else return null;
	}

	@Override
	public Client consulterClient(Client cli) throws LigneInexistanteException {
		IClientDao dao = new ClientDao();
		cli = dao.read(cli);
		return cli;
	}

	@Override
	public int modifierClient(Client cli) throws LigneInexistanteException {
		int res = 0;
		IClientDao dao = new ClientDao();
		res = dao.update(cli);
		return res;
	}

	@Override
	public int supprimerClient(Client cli) throws LigneInexistanteException {
		int res = 0;
		IClientDao dao = new ClientDao();
		res = dao.delete(cli);
		return res;
	}
	
	

}
