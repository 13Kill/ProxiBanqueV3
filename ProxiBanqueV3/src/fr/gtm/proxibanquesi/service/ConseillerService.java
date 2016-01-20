package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.dao.ClientDao;
import fr.gtm.proxibanquesi.dao.ConseillerDao;
import fr.gtm.proxibanquesi.dao.IClientDao;
import fr.gtm.proxibanquesi.dao.IConseillerDao;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

public class ConseillerService implements IConseillerService {

	// TODO: create Conseiller
	public Conseiller createConseiller(Conseiller cons) throws LigneExistanteException, LigneInexistanteException {
		IConseillerDao dao = new ConseillerDao();
		dao.create(cons);
		cons = dao.getID(cons);
		return cons;
	}

	@Override
	public Conseiller checkUser(Conseiller userTemp) throws LigneInexistanteException {
		IConseillerDao dao = new ConseillerDao();
		userTemp = dao.getUser(userTemp);
		return dao.read(userTemp);
	}

	@Override
	public Conseiller getListeClients(Conseiller cons) {
		IClientDao dao = new ClientDao();
		cons.setListeClient(dao.getListeClients(cons.getIdcons()));
		return cons;
	}

	@Override
	public ArrayList<Client> getClients(Conseiller cons) throws LigneInexistanteException {
		// TODO Auto-generated method stub
		IClientDao dao = new ClientDao();
		ArrayList<Integer> listeIndex = cons.getListeClient();
		if (listeIndex.size() > 0) {
			ArrayList<Client> listeClients = new ArrayList<Client>();
			for(int i = 0; i < listeIndex.size(); i++) {
				Client cli = new Client();
				cli.setId(listeIndex.get(i));
				cli = dao.read(cli);
				listeClients.add(cli);
			}
			return listeClients;
		} else return null;
	}
}
